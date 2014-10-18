<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
    	
    	<meta name="author" content="Pedro Almir">
    	<meta name="description" content="Seleção de cruzamentos para otimização genética">
    	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    	
		<!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom styles for this template -->
    	<link href="${pageContext.request.contextPath}/css/justified-nav.css" rel="stylesheet">
	
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	    <!-- ========================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
	    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/docs.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	    <script src="${pageContext.request.contextPath}/js/main.js"></script>
	</head>
	<body style="background-image: url('img/xbg.jpg');">
		<div class="container">
      		<div class="masthead">
	        	<h3 class="text-muted"><strong>Sistema de acasalamento dirigido</strong></h3>
        		<ul class="nav nav-justified">
          			<li class="active"><a href="${pageContext.request.contextPath}/">Início</a></li>
		          	<li><a href="${pageContext.request.contextPath}/services">Serviços</a></li>
		          	<li><a href="#">Como Funciona</a></li>
		          	<li><a href="#">Downloads</a></li>
		          	<li><a href="#">Sobre</a></li>
		          	<li><a href="#">Contato</a></li>
        		</ul>
      		</div>

      		<!-- Jumbotron -->
      		<div class="jumbotron">
        		<h1>Cruzamentos Otimizados!</h1>
        		<p class="lead">Otimize a utilização dos recursos genéticos disponíveis no seu rebanho, visando à maximização do ganho genético, porém buscando o controle da endogamia. </p>
        		<p><a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/services" role="button">Iniciar Agora</a></p>
      		</div>

      		<!-- Example row of columns -->
      		<div class="row text-center">
        		<div class="col-lg-4" style="min-height: 320px;">
        			<img class="img-thumbnail" alt="140x140" src="${pageContext.request.contextPath}/img/criacao-caprinos-corte.jpg" style="height: 142px;width: 180px;">
          			<h2>Safari bug warning!</h2>
          			<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          			<p><a class="btn btn-primary" href="#" role="button">Mais Detalhes &raquo;</a></p>
        		</div>
        		<div class="col-lg-4" style="min-height: 320px;">
        			<img class="img-thumbnail" alt="140x140" src="${pageContext.request.contextPath}/img/ovinos4.jpg" style="height: 142px;width: 180px;">
          			<h2>Heading</h2>
          			<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          			<p><a class="btn btn-primary" href="#" role="button">Mais Detalhes &raquo;</a></p>
       			</div>
        		<div class="col-lg-4" style="min-height: 320px;">
        			<img class="img-thumbnail" alt="140x140" src="${pageContext.request.contextPath}/img/1272994050.jpg" style="height: 142px;width: 180px;">
          			<h2>Heading</h2>
          			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
          			<p><a class="btn btn-primary" href="#" role="button">Mais Detalhes &raquo;</a></p>
        		</div>
      		</div>

      		<!-- Site footer -->
      		<div class="footer">
      			<div class="row">
      				<div class="col-lg-4">
      					<p class="text-muted">Developed by <a href="mailto:petrus.cc@gmail.com">Pedro Almir</a> at the EaSII Lab.</p>
      				</div>
      				<div class="col-lg-4 text-center">
		      			<p><a href="http://ufpi.br"><img src="${pageContext.request.contextPath}/img/ufpi.png" style="width: 180px;"></a></p>
      				</div>
      			</div>
      		</div>
    	</div> <!-- /container -->
	</body>
</html>