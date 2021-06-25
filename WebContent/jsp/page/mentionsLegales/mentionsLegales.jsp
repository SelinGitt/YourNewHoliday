<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- div container --%>
<div class="body">
    <%-- titre --%>
    <h1>
        <spring:message code="mlg.titre" />
    </h1>

    <div class="mlg-boutons">
        <div class="mlg-bouton CGV-button" onclick="selectMLG(1)">
            <p>
                <spring:message code="mlg.CGV" />
            </p>
        </div>
        <div class="mlg-bouton CGU-button" onclick="selectMLG(2)">
            <p>
                <spring:message code="mlg.CGU" />
            </p>
        </div>
    </div>
    <div class="mlg-file CGV-file">
        <p>${fichierCGV}</p>
    </div>
    <div class="mlg-file CGU-file">
        <p>${fichierCGU}</p>
    </div>

    <script>
					function selectMLG(n) {
						switch (n) {
						// le cas 1 se produit quand on clique sur la div-onglet CGV
						case 1:
							// on éclaire l'onglet CGV
							document.getElementById("CGV-button").setAttribute(
									"style", "background: #F0F0F0;");
							// on fonce l'onglet CGU
							document.getElementById("CGU-button").setAttribute(
									"style", "background: #615b63;");
							// on fait apparaitre la div contenant le fichier CGV
							document.getElementById("CGV-file").setAttribute(
									"style", "display: block;");
							// on fait disparaitre la div contenant le fichier CGU
							document.getElementById("CGU-file").setAttribute(
									"style", "display: none;");
							break;
						// le cas 2 se produit quand on clique sur la div-onglet CGU
						case 2:
							// on fonce l'onglet CGV
							document.getElementById("CGV-button").setAttribute(
									"style", "background: #615b63;");
							// on éclaire l'onglet CGU
							document.getElementById("CGU-button").setAttribute(
									"style", "background: #F0F0F0;");
							// on fait disparaitre la div contenant le ficher CGV
							document.getElementById("CGV-file").setAttribute(
									"style", "display: none;");
							// on fait apparaitre la div contenant le fichier CGU
							document.getElementById("CGU-file").setAttribute(
									"style", "display: block;");
							break;
						default:
							break;
						}
					}
				</script>

</div>