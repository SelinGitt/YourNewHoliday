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