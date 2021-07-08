function decrement() {
	quantite = Math.max(parseInt(document.getElementById("quantite").value), 1);
	document.getElementById("quantite").value = quantite - 1;
}
function increment() {
		quantite = Math.min(parseInt(document.getElementById("quantite").value), 99);
		document.getElementById("quantite").value = quantite + 1;
}