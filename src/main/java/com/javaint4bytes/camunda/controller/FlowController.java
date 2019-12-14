package com.javaint4bytes.camunda.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.javaint4bytes.camunda.smartinspector.utility.JasonParser;

@Controller
@EnableWebMvc
public class FlowController {
	
	@Autowired
	  private RuntimeService runtimeService;
	
	
	
	@Autowired
	  private  TaskService taskService;
	
	 	     
	    @GetMapping("/startprocess")
	    public ModelAndView startProcess(ModelMap model) {
	    	 
	    	//String processKey = jp.getProcessKeyFromJson(inspectionId, category, type);
	        ProcessInstance pi = runtimeService.startProcessInstanceByKey("customerDataProcess");
	        model.addAttribute("processInstanceId", pi.getProcessInstanceId());
	        
	        String result = null;
			Task task;
			
			try {
			task = taskService.createTaskQuery().initializeFormKeys().processInstanceId(pi.getProcessInstanceId()).singleResult();
			
			//return task.getFormKey();
			
			if (task!=null)
				result= task.getName()+"id :" +task.getId()+"formkey"+task.getFormKey();
			model.addAttribute("taskName", task.getName());
			model.addAttribute("taskId", task.getId());
			model.addAttribute("formkey", task.getFormKey());
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", model.addAttribute("error", e.getMessage()));
			}
	        
			
			String redirectedUrl = task.getFormKey().substring(task.getFormKey().lastIndexOf("/"));
	        return new ModelAndView("forward:"+redirectedUrl, model);
	    }
	    
	    
	    @GetMapping("/process-completed")
	    public ModelAndView endProcess(ModelMap model, @RequestParam(value="processInstanceId") String processInstanceId) {
	    	
	    	try {
	    	//ProcessInstance pi = runtimeService.startProcessInstanceByKey("loanApproval");
	    	runtimeService.deleteProcessInstance(processInstanceId, "process completed");
	        
	        
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", model.addAttribute("error", e.getMessage()));
			}
	        
	    	model.addAttribute("processInstanceId", processInstanceId);
	        return new ModelAndView("completed", model);
	    }
	    
	    @RequestMapping("/complete-tasks")
		public ModelAndView executeCurrentTask(ModelMap model, @RequestParam(value="processInstanceId") String processInstanceId,@RequestParam(value="taskId") String taskId,@RequestParam(value="answer") String answer) {
			
			
	    	//business logic
	    	//task name = taskservice.getTask(taskId).getTaskName();
	    	//if(task name = "task1") , call a method1 and pass form param(whole request body or request param)
	    	//else if (task name = "task2"), do something
	    	
	    	Map<String, Object> m = new HashMap<String, Object>();
	    	m.put("answer", answer);
			taskService.complete(taskId, m);
			String result = null;
			Task nextTask;
			
			try {
			nextTask = taskService.createTaskQuery().initializeFormKeys().processInstanceId(processInstanceId).singleResult();
			
			//return task.getFormKey();
			model.addAttribute("processInstanceId", processInstanceId);
			if (nextTask!=null) {
				result= nextTask.getName()+"id :" +nextTask.getId();}
			else {
				return new ModelAndView("completed", model);
			}
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", model.addAttribute("error", e.getMessage()));
			}

			model.addAttribute("processInstanceId", processInstanceId);
			model.addAttribute("taskName", nextTask.getName());
			model.addAttribute("taskId", nextTask.getId());
			model.addAttribute("formkey", nextTask.getFormKey());
			String redirectedUrl = nextTask.getFormKey().substring(nextTask.getFormKey().lastIndexOf("/"));
	        return new ModelAndView("forward:"+redirectedUrl, model);
			
			
		}
	
	

}
