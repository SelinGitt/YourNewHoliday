function decrement() {
	quantite = parseInt(document.getElementById("quantite").value) - 1;
	document.getElementById("quantite").value = Math.max(quantite, 1);
}
function increment() {
	quantite = parseInt(document.getElementById("quantite").value) + 1;
	document.getElementById("quantite").value = Math.min(quantite, 99);
}