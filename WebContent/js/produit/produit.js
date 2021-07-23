function decrement(type) {
	quantite = parseInt(document.getElementById("quantite" + type).value) - 1;
	document.getElementById("quantite" + type).value = Math.max(quantite, 1);
}
function increment(type) {
	quantite = parseInt(document.getElementById("quantite" + type).value) + 1;
	document.getElementById("quantite" + type).value = Math.min(quantite, 99);
}