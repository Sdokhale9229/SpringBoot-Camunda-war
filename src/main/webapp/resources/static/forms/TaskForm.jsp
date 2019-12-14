<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<strong>Task Form 1</strong>

<form role="form" class="form-horizontal">
  <div class="control-group">
    <label class="control-label">Is there electrical power to the unit?</label>
    <div class="controls">
      <input type="text" class="form-control" 
        cam-variable-name="Status"
        cam-variable-type="Boolean"
        required  
        ng-pattern="/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/"
        />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label">Content</label>
    <div class="controls">
      <input type="text" class="form-control"
		cam-variable-name="content"
        cam-variable-type="String"        
        required
        />
    </div>
  </div>  
</form>

</body>
</html>