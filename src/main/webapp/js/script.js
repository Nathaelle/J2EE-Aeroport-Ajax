"use strict";

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

var request = getRequest();
console.log(request);
request.overrideMimeType("text/json");

// 1. Première étape : Initialisation de la requête
request.open("GET", "aeroport?data=airports");
// 2. Deuxième étape : Ajout des ent-têtes HTTP
request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
// 3. Troisième et dernière étape : Envoi de la requête
request.send();

request.onreadystatechange = () => {
	
	if(request.readyState == 4 && request.status == 200) {
		printAirports(request.responseText);
	}
};


function printAirports(jsonString) {
	
	var json = JSON.parse(jsonString);
	
	var html = "";
	for(let aeroport of json) {
		html += "<h2>" + aeroport.nom + "</h2>";
		html += "<h3>Vols du jour</h3>";
	}
	
	document.getElementById("airports").innerHTML = html;
}



