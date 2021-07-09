/**
 * JS pour le choix de la langue
 */
const frButton = document.getElementById("FR-button");
const enButton = document.getElementById("EN-button");
function selectLG(n) {
	switch (n) {
		// le cas 1 se produit quand on clique sur la langue FR
		case 1:
			// on entoure la langue selectionnée
			frButton.className = "langue-button-clicked";
			console.log("coucou case 1");
			console.log(frButton);
			enButton.className = '';

			// on rend le bouton selectionné non cliquable
			frButton.classList.remove(frButton);

			break;
		// le cas 2 se produit quand on clique sur la langue EN
		case 2:
			// on entoure la langue selectionnée
			enButton.className = "langue-button-clicked";
			console.log("coucou case 2")
			frButton.className = '';

			// on rend le bouton selectionné non cliquable
			frButton.classList.remove(enButton);

			break;
		default:
			break;
	}
}