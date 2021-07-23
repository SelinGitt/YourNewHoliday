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
		img.className = "fa fa-check-square-o user02-admin-active";
	} else {
		img.className = "fa fa-square-o user02-admin-desactive";
	}
}