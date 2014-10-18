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
	        	<h3 class="text-muted"><strong>Sistema de acasalamento dirigido para caprinos e ovinos</strong></h3>
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
					<div class="panel panel-default" style="height: 492px;">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Descrição do Processo</h3>
		  				</div>
		  				<div class="panel-body" style="text-align: justify;">
					    	<p style="text-indent: 2.5em;">Os acasalamentos dirigidos consistem em realizar os emparelhamentos 
					    	reprodutivos entre reprodutores e matrizes, visando à maximização do ganho genético, porém buscando 
					    	o controle da endogamia (procriação entre membros do mesmo grupo) do rebanho.</p>
					    	
		    				<p style="text-indent: 2.5em;">Esta ferramenta automatiza o processo de seleção dos melhores acasalamentos de acordo o seguinte
		    				processo:</p>
		    	
					    	<ul>
					    		<li>1. Coleta do dados</li>
					    		<li>2. Aplicação de um <strong>Algoritmo Genético</strong> para seleção dos melhores animais</li>
					    		<li>3. Execução do <strong>Ant System Multiobjetivo</strong> para seleção dos acasalamentos</li>
					    		<ul>
						    		<li>3.1. Maximizar: Ganho Genético</li>
						    		<li>3.2. Minimizar Endogamia</li>
					    		</ul>
					    		<li>4. Apresentação dos Resultados</li>
					    	</ul>
					    	<p class="text-center">
						    	<img class="img-thumbnail" alt="140x140" src="${pageContext.request.contextPath}/img/criacao-caprinos-corte.jpg" style="height: 142px;width: 180px;">
						    	<img class="img-thumbnail" alt="140x140" src="${pageContext.request.contextPath}/img/1272994050.jpg" style="height: 142px;width: 180px;margin-left: 10px;">
					    	</p>
					  	</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="panel panel-default" style="height: 492px;">
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
								    	<input type="text" class="form-control" id="idadeAcasalamentoMacho" name="idadeAcasalamentoMacho" placeholder="Idada mínima p/ acasalamento dos machos em meses">
								  	</div>
							  	</div>
							  	<div class="col-lg-6">
							  		<div class="form-group">
								    	<label for="idadeAcasalamentoFemea">Idada p/ acasalamento (F)</label>
								    	<input type="text" class="form-control" id="idadeAcasalamentoFemea" name="idadeAcasalamentoFemea" placeholder="Idada mínima p/ acasalamento das fêmeas em meses">
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
			<div id="resultsPanel" class="row" style="display: none;">
				<div class="col-lg-12">
					<div class="panel panel-primary" style="">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Resultados do Processamento</h3>
		  				</div>
		  				<div class="panel-body" style="text-align: justify;">
		  					<table class="table table-bordered table-striped">
		  						<caption><h4>Seleção dos melhores machos/fêmeas para acasalamento</h4></caption>
						      	<thead>
							        <tr>
						          		<th class="">#</th>
							          	<th class="col-lg-2 text-center">Ganho Genético</th>
							          	<th class="col-lg-4">Machos selecionados</th>
							          	<th class="col-lg-6">Fêmeas selecionados</th>
						        	</tr>
						      	</thead>
						      	<tbody>
						      		<tr>
						      			<td>1</td>
						      			<td class="text-center">30,023 g</td>
						      			<td>949, 984</td>
						      			<td>523, 524, 529, 531, 532, 536, 537, 538, 541, 828</td>
						      		</tr>
						      		<tr>
						      			<td>2</td>
						      			<td class="text-center">30,00 g</td>
						      			<td>949, 1008</td>
						      			<td>523, 524, 531, 532, 534, 536, 537, 538, 541, 721</td>
						      		</tr>
						      		<tr>
						      			<td>3</td>
						      			<td class="text-center">29,189 g</td>
						      			<td>984, 1008</td>
						      			<td>523, 524, 529, 531, 534, 536, 537, 538, 791, 828</td>
						      		</tr>
						      	</tbody>
						    </table>
						    <table class="table table-bordered table-striped">
		  						<caption><h4>Seleção dos melhores acasalamentos</h4></caption>
						      	<thead>
							        <tr>
						          		<th class="">#</th>
							          	<th class="col-lg-3">Macho</th>
							          	<th class="col-lg-3">Fêmea</th>
							          	<th class="col-lg-3">F1</th>
							          	<th class="col-lg-3">Endogamia de F1</th>
						        	</tr>
						      	</thead>
						      	<tbody>
						      		<tr>
						      			<td>1</td>
						      			<td>984</td>
						      			<td>541</td>
						      			<td>23,10</td>
						      			<td>1,25</td>
						      		</tr>
						      		<tr>
						      			<td>2</td>
						      			<td>984</td>
						      			<td>828</td>
						      			<td>21,75</td>
						      			<td>1,125</td>
						      		</tr>
						      		<tr>
						      			<td>3</td>
						      			<td>984</td>
						      			<td>532</td>
						      			<td>21,21</td>
						      			<td>1,0</td>
						      		</tr>
						      		<tr>
						      			<td>4</td>
						      			<td>984</td>
						      			<td>538</td>
						      			<td>21,60</td>
						      			<td>1,0</td>
						      		</tr>
						      		<tr>
						      			<td>5</td>
						      			<td>949</td>
						      			<td>523</td>
						      			<td>21,3</td>
						      			<td>1,5</td>
						      		</tr>
						      		<tr>
						      			<td>6</td>
						      			<td>984</td>
						      			<td>536</td>
						      			<td>20,73</td>
						      			<td>1,0</td>
						      		</tr>
						      		<tr>
						      			<td>7</td>
						      			<td>949</td>
						      			<td>524</td>
						      			<td>20,625</td>
						      			<td>1,0</td>
						      		</tr>
						      		<tr>
						      			<td>8</td>
						      			<td>949</td>
						      			<td>537</td>
						      			<td>16,35</td>
						      			<td>1,1</td>
						      		</tr>
						      		<tr>
						      			<td>9</td>
						      			<td>949</td>
						      			<td>531</td>
						      			<td>19,26</td>
						      			<td>1,23</td>
						      		</tr>
						      		<tr>
						      			<td>10</td>
						      			<td>949</td>
						      			<td>529</td>
						      			<td>18,75</td>
						      			<td>1,0</td>
						      		</tr>
						      	</tbody>
						    </table>
		  				</div>
		  			</div>
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