function decrement(type) {
	quantite = parseInt(document.getElementById("quantite" + type).value) - 1;
	document.getElementById("quantite" + type).value = Math.max(quantite, 1);
}
function increment(type) {
	quantite = parseInt(document.getElementById("quantite" + type).value) + 1;
	document.getElementById("quantite" + type).value = Math.min(quantite, 99);
}
function loadServices() {
	var classes = ["fa fa-glass pdt04IconeSpace",
		"fa fa-bath pdt04IconeSpace", "fa fa-paw pdt04IconeSpace",
		"fa fa-gamepad pdt04IconeSpace", "fa fa-wifi pdt04IconeSpace",
		"fa fa-cutlery pdt04IconeSpace",
		"fa fa-wheelchair pdt04IconeSpace",
		"fa fa-snowflake-o pdt04IconeSpace", "fa fa-tv pdt04IconeSpace"];

	for (var i = 0; i < 9; i++) {
		if (document.getElementById(i)) {
			document.getElementById(i).className += classes[i];
		}
	}
}

// Permet de changer le status d'un service
function changeServiceStatus(el, status, page) {
	// Id genere : serviceX1, on souhaite récupérer la valeur de X, donc l'element a l'index 8
	// Amelioration possible dans le futur
	var label = document.getElementById(el.id[8]);

	// La classe firstTime permet de syncro les valeurs du tableau avec l'input
	if (label.classList.contains("firstTime")) {
		el.value = status;
		label.classList.remove("firstTime");
	}

	console.log(page);

	// Change le service en actif ou inactif et la valeur de l'input
	if (label.classList.contains("pdt0" + page + "ServiceActif")) {
		label.classList.replace("pdt0" + page + "ServiceActif", "pdt0" + page + "ServiceInactif");
		el.value = 'false';
	} else {
		label.classList.replace("pdt0" + page + "ServiceInactif", "pdt0" + page + "ServiceActif");
		el.value = 'true';
	}
}