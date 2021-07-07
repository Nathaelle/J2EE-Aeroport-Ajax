<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Aéroports de MetroCity</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="menu"> 
		<h1>Aéroports de MetroCity : Vue d'ensemble</h1>
		<a id="button" href="#cible">Aéroport 1</a>
	</div>
	
	<p id="content"></p>
	
	<section id="airports">
		
	</section>
	
	<form id="form-airport" action="dataIn" method="POST">
		
		<div>
			<label for="nom">Nom de l'aéroport</label>
			<input type="text" id="nom" name="nom">
		</div>
		<div>
			<label for="adresse">Adresse de l'aéroport</label>
			<input type="text" id="adresse" name="adresse">
		</div>
		<div>
			<label for="gps">Coordonnées GPS</label>
			<input type="text" id="gps" name="gps">
		</div>
		<div>
			<label for="nb_avions">Capacité parc avions</label>
			<input type="text" id="nb_avions" name="nb_avions">
		</div>
		<div>
			<label for="nb_personnes">Capacité visiteurs</label>
			<input type="text" id="nb_personnes" name="nb_personnes">
		</div>
		<div>
			<input type="submit" value="Ajouter l'aéroport">
		</div>
		
	</form>

	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>