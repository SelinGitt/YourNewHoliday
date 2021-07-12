/**
 * JS pour le choix de la langue
 */
const lang = document.getElementById("localeCode").value;
const frButton = document.getElementById("FR-button");
const enButton = document.getElementById("EN-button");
const lienFr = document.getElementById("lienLangueFr");
const lienEn = document.getElementById("lienLangueEn");
function selectLG() {
	if (lang === "fr") {
		frButton.className += " langue-button-clicked";
		lienFr.className = "langue-pointer"
	} else if (lang === "en") {
		enButton.className += " langue-button-clicked";
		lienEn.className = "langue-pointer"
	}
}