const cgvButton = document.getElementById("CGV-button");
const cguButton = document.getElementById("CGU-button");
const cgvFile = document.getElementById("CGV-file");
const cguFile = document.getElementById("CGU-file");
function selectMLG(n) {
						switch (n) {
						// le cas 1 se produit quand on clique sur la div-onglet CGV
						case 1:
							// on éclaire l'onglet CGV
							cgvButton.classList.add('CG-button-clicked-background');
							cgvButton.classList.remove('CG-button-background');

							// on fonce l'onglet CGU
							cguButton.classList.add('CG-button-background');
							cguButton.classList.remove('CG-button-clicked-background');


							// on fait apparaitre la div contenant le fichier CGV
							cgvFile.classList.add('display-block');
							cgvFile.classList.remove('display-none');

							// on fait disparaitre la div contenant le fichier CGU
							cguFile.classList.add('display-none');
							cguFile.classList.remove('display-block');

							break;
						// le cas 2 se produit quand on clique sur la div-onglet CGU
						case 2:
							// on fonce l'onglet CGV
							cgvButton.classList.add('CG-button-background');
							cgvButton.classList.remove('CG-button-clicked-background');


							// on éclaire l'onglet CGU
							cguButton.classList.add('CG-button-clicked-background');
							cguButton.classList.remove('CG-button-background');


							// on fait disparaitre la div contenant le ficher CGV
							cgvFile.classList.add('display-none');
							cgvFile.classList.remove('display-block');

							// on fait apparaitre la div contenant le fichier CGU
							cguFile.classList.add('display-block');
							cguFile.classList.remove('display-none');

							break;
						default:
							break;
						}
					}