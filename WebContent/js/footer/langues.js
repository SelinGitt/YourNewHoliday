/**
 * JS pour le choix de la langue
 */
//const lang = document.getElementById("lang");
//const frButton = document.getElementById("FR-button");
//const enButton = document.getElementById("EN-button");
//console.log(lang);
//function selectLG() {
//	if (lang.getAttribute == "fr") {
//		frButton.className += " langue-button-clicked";
//	} else {
//		enButton.className += " langue-button-clicked";
//	}
const lang = document.getElementById("lang");
const frButton = document.getElementById("FR-button");
const enButton = document.getElementById("EN-button");
console.log(lang);
function selectLG() {
	if (lang === "fr") {
		frButton.className += " langue-button-clicked";
	} else if(lang === "en") {
		enButton.className += " langue-button-clicked";
	}
}