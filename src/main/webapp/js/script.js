"use strict";

// --------- Variables globales contenant les fonctions --------------

var printAirport = (jsonString) => {
	
	var json = JSON.parse(jsonString);
	
	var html = "";
	for(let aeroport of json) {
		html += "<h2>" + aeroport.nom + "</h2>";
		html += "<h3>Vols du jour</h3>";
	}
	
	document.getElementById("airports").innerHTML = html;
}

var showMessage = (jsonString) => {
	console.log("Tout est OK !!!");
	sendRequest("GET", "aeroport?data=airports", printAirport);
};

// -------------------- REQUETE XHR ----------------------

function sendRequest(method, url, action, param = "") {
	
	var request = getRequest();
	console.log(request);
	request.overrideMimeType("text/json");

	// 1. Première étape : Initialisation de la requête
	request.open(method, url);
	// 2. Deuxième étape : Ajout des ent-têtes HTTP
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	// 3. Troisième et dernière étape : Envoi de la requête
	request.send(param);

	request.onreadystatechange = () => {
	
		if(request.readyState == 4 && request.status == 200) {
			action(request.responseText);
		}
	};
}

function getRequest() {
    //Récupère la connexion au serveur http
    var request;
    if (window.XMLHttpRequest) {
    request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
          request = new ActiveXObject("Msxml2.XMLHTTP"); // IE version > 5
        } catch (e) {
          request = new ActiveXObject("Microsoft.XMLHTTP");
        }
    } else {
        request = false;
    }
    return request;
}

// ------------ LISTENERS ------------------

document.getElementById("form-airport").addEventListener("submit", (e) => {
	
	var nom = document.getElementById("nom").value;
	var adresse = document.getElementById("adresse").value;
	var gps = document.getElementById("gps").value;
	var nbavions = document.getElementById("nb_avions").value;
	var nbpersonnes = document.getElementById("nb_personnes").value;
	
	var param = "nom=" + nom + "&adresse=" + adresse + "&gps=" + gps + "&nba=" + nbavions + "&nbp=" + nbpersonnes;
	
	sendRequest("POST", "datasIn", showMessage, param);
});



// --- Initialisation -----
sendRequest("GET", "aeroport?data=airports", printAirport);

