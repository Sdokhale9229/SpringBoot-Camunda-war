<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>camunda</title>

  <!-- Font Awesome Icons -->
  <link href="<spring:url value="/resources/static/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>

  <!-- Plugin CSS -->

  <!-- Theme CSS - Includes Bootstrap -->
  <link href="<spring:url value="/resources/static/css/creative.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">camunda</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        
      </div>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead">
    <div class="container h-100">
      <div class="row h-100 align-items-center justify-content-center text-center">
        <div class="col-lg-10 align-self-end">
          <h1 class="text-uppercase text-white font-weight-bold">camunda</h1><h6 style="color:white";>@Camunda BPM</h6>
          <hr class="divider my-4">
		  </div>
		  
        <div class="col-lg-8 align-self-baseline">
          <form action="startprocess">
		  <p class="text-white-75 font-weight-light mb-5"></p>
          <button class="btn btn-primary btn-xl js-scroll-trigger" type="submit" href="/">Start Process</button>
          </form>
        </div>
      </div>
    </div>
  </header>

 

  <!-- Bootstrap core JavaScript -->
  <script src="<spring:url value="/resources/static/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<spring:url value="/resources/static/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Plugin JavaScript -->
  <script src="<spring:url value="/resources/static/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
  <script src="<spring:url value="/resources/static/vendor/magnific-popup/jquery.magnific-popup.min.js"/>"></script>

  <!-- Custom scripts for this template -->
  <script src="<spring:url value="/resources/static/js/creative.min.js"/>"></script>

</body>

</html>
