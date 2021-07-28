//permet de modifier le contenu d'une page
//cette function est appeler dans le footer pour que l'element .remove() puisse fonctionner
function modifierTitre(document){
	//on moodifie le titre de la page
	document.title = document.getElementById('titrePage').textContent;
	//on suprime le paragraphe contenant le titre transmis a la page
	document.getElementById('titrePage').remove();
}