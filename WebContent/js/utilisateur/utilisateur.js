// Pemet de changer la valeur de estDesactive et affiche l'icone correspondant
function changeStatusImg(img, estDesactive) {
	if (estDesactive.value === 'false') {
		estDesactive.value = 'true';
		setImg('desactive', img);
	} else {
		estDesactive.value = 'false';
		setImg('active', img);
	}
}

// Permet de changer l'image affichee
function setImg(status, img) {
	if (status === 'active') {
		img.src = "img/commun/checkboxVert.jpg";
		img.className = "checkboxVert user01-image";
	} else {
		img.src = "img/commun/checkboxVide.png";
		img.className = "user01-imageNonActive checkboxVide";
	}
}