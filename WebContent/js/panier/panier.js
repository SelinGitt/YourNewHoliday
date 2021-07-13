
//js pour listerPanierAdresses

// reset le formulaire adresse de livraison
function informationsLivraison() {
	document.getElementById("livraisonNom").value = document.getElementById("defaultNom").value;
	document.getElementById("livraisonPrenom").value = document.getElementById("defaultPrenom").value;
	document.getElementById("livraisonAdresse").value = document.getElementById("defaultAdresse").value;
}

//reset le formulaire adresse de facturation
function informationsFacturation() {
	document.getElementById("facturationNom").value = document.getElementById("defaultNom").value;
	document.getElementById("facturationPrenom").value = document.getElementById("defaultPrenom").value;
	document.getElementById("facturationAdresse").value = document.getElementById("defaultAdresse").value;
}