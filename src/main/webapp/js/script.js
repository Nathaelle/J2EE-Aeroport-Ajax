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

request.open("GET", "aeroport");
request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
request.send();

request.onreadystatechange = () => {
	
	if(request.readyState == 4 && request.status == 200) {
		document.getElementById("content").innerHTML = request.responseText;
		
	}
};


