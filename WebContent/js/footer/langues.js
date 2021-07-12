/**
 * JS pour le choix de la langue
 */
const lang = document.getElementById("localeCode").value;
const frButton = document.getElementById("FR-button");
const enButton = document.getElementById("EN-button");
function selectLG() {
	if (lang === "fr") {
		frButton.className += " langue-button-clicked";
	} else if (lang === "en") {
		enButton.className += " langue-button-clicked";
	}
}