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
    	
    	<meta name="author" content="Pedro Almir & Natanael">
    	<meta name="description" content="Seleção de cruzamentos para otimização genética em bovinos">
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
	        	<h3 class="text-muted"><strong>Seleção de cruzamentos para otimização genética em bovinos</strong></h3>
        		<ul class="nav nav-justified">
          			<li><a href="${pageContext.request.contextPath}/">Início</a></li>
		          	<li class="active"><a href="${pageContext.request.contextPath}/services">Serviços</a></li>
		          	<li><a href="#">Como Funciona</a></li>
		          	<li><a href="#">Downloads</a></li>
		          	<li><a href="#">Sobre</a></li>
		          	<li><a href="#">Contato</a></li>
        		</ul>
      		</div>
			<div class="row" style="padding-top: 48px;">
				<div class="col-lg-6">
					<div class="panel panel-default" style="height: 413px;">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Descrição do Processo</h3>
		  				</div>
		  				<div class="panel-body" style="text-align: justify;">
					    	<p style="text-indent: 2.5em;">With the rapid development of modern computing technology, fuzzy logic control
					    	and its implementations have received increasing attention in the control community.
					    	The main advantage of the fuzzy logic controller is that it can be applied to problems
					    	that are difficult to model mathematically, and the controller can be designed by
					    	applying heuristic rules that reflect the experience of human experts.</p>
					    	
		    				<p>The Figure 1 presents details of how this approach works:</p>
		    	
					    	<ul>
					    		<li>1. Initialization</li>
					    		<li>2. Search solutions in graph</li>
					    		<li>3. Evaluate the quality of solutions</li>
					    		<ul>
						    		<li>3.1. Evaluate the quality of solutions</li>
						    		<li>3.2. Create a set of questions to expert users</li>
						    		<li>3.3. Compare users's answers with the results of Fuzzy System</li>
					    		</ul>
					    		<li>4. Pheromone update</li>
					    		<li>5. Evaluate Stopping Condition</li>
					    		<li>6. Get the best solution (the new rule base)</li>
					    	</ul>
					  	</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="panel panel-default" style="">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Informe os dados</h3>
		  				</div>
		  				<div class="panel-body" style="text-align: justify;">
		  					<form action="${pageContext.request.contextPath}/services" method="post" enctype="multipart/form-data">
		  						<div class="col-lg-12">
		  							<div class="form-group">
								    	<label for="inputFile">Dados dos animais</label>
								    	<input type="file" id="inputFile" name="inputFile">
								    	<p class="help-block">Envie o arquivo com os dados dos animais</p>
								  	</div>
		  						</div>
	  							<div class="col-lg-6">
		  							<div class="form-group">
								    	<label for="percentualMacho">Percentual de machos</label>
								    	<input type="text" class="form-control" id="percentualMacho" name="percentualMacho" placeholder="Percentual de machos. Ex.: 0.2">
								  	</div>
							  	</div>
							  	<div class="col-lg-6">
							  		<div class="form-group">
								    	<label for="percentualFemea">Percentual de fêmeas</label>
								    	<input type="text" class="form-control" id="percentualFemea" name="percentualFemea" placeholder="Percentual de fêmeas. Ex.: 0.6">
								  	</div>
							  	</div>
							  	<div class="col-lg-6">
		  							<div class="form-group">
								    	<label for="idadeAcasalamentoMacho">Idada p/ acasalamento (M)</label>
								    	<input type="text" class="form-control" id="idadeAcasalamentoMacho" name="idadeAcasalamentoMacho" placeholder="Idada p/ acasalamento machos">
								  	</div>
							  	</div>
							  	<div class="col-lg-6">
							  		<div class="form-group">
								    	<label for="idadeAcasalamentoFemea">Idada p/ acasalamento (F)</label>
								    	<input type="text" class="form-control" id="idadeAcasalamentoFemea" name="idadeAcasalamentoFemea" placeholder="Idada p/ acasalamento fêmeas">
								  	</div>
							  	</div>
							  	<div class="col-lg-6">
		  							<div class="form-group">
								    	<label for="proporcaoMachoFemea">Proporção de machos p/ fêmeas</label>
								    	<input type="text" class="form-control" id="proporcaoMachoFemea" name="proporcaoMachoFemea" placeholder="Machos p/ fêmeas. Ex.: 0.05">
								  	</div>
		  						</div>
		  						<div class="col-lg-6">
		  							<div class="form-group">
								    	<label for="herdabilidade">Herdabilidade</label>
								    	<input type="text" class="form-control" id="herdabilidade" name="herdabilidade" placeholder="Informe o valor da herdabilidade">
								  	</div>
		  						</div>
		  						<!--
		  						<div class="col-lg-12">
		  							<div class="form-group">
								    	<label for="grupoContemporaneos">Grupo de Contemporâneos</label>
				  						<select class="form-control" multiple="multiple" name="grupoContemporaneos">
										  	<option value="ano">Ano da última coleta</option>
										  	<option value="sexo">Sexo do animal</option>
										</select>
								  	</div>
		  						</div>
		  						-->
		  						<div class="col-lg-12">
		  							<div class="form-group">
								    	<label for="caracteristica">Característica</label>
				  						<select class="form-control" name="caracteristica">
				  							<option value="null">Informe a característica a ser considerada</option>
										  	<option value="peso">Peso</option>
										</select>
								  	</div>
		  						</div>
		  						<div class="col-lg-12">
		  							<div class="form-group text-right" style="margin-bottom: 0px;">
								    	<button id="execute" type="submit" class="btn btn-primary" style="width: 50%;">Executar</button>
								  	</div>
		  						</div>
		  					</form>
		  				</div>
		  			</div>
				</div>
			</div>
			<div id="resultsPanel" class="row" style="display: none">
				<div class="col-lg-12">
					<div class="panel panel-primary" style="height: 413px;">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Resultados</h3>
		  				</div>
		  				<div class="panel-body" style="text-align: justify;">
		  				</div>
		  			</div>
	  			</div>
			</div>

      		<!-- Site footer -->
      		<div class="footer text-center">
      			<p>
	      			<a href="http://ufpi.br"><img src="${pageContext.request.contextPath}/img/ufpi.png" style="width: 180px;"></a>
        		</p>
      		</div>
    	</div> <!-- /container -->
	
	    <script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-38495958-2', 'knapsackproblemtool.appspot.com');
		  ga('send', 'pageview');
		</script>
	</body>
</html>