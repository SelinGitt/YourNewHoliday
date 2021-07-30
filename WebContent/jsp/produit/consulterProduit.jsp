<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.consulterProduit" />
</p>

<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive text-align-center">${consulterProduitDto.nom}</h1>
    </div>
    <a href="${retour}" class="lien-retour"><spring:message code="pdt04.retour"></spring:message></a>

    <%-- Pour toute la vue --%>
    <div class="display-flex pdt04Flex-container justify-content-space-around">

        <%-- Pour la partie gauche de la vue --%>
        <div>

            <%--  formulaire pour ajouter un produit au panier --%>
            <form:form class="pdt04-form" action="ajouterProduitPanier.do" modelAttribute="beanQuantite" method="POST">

                <%-- Pour la partie gauche du côté gauche de la vue - Image+Hebergement --%>
                <div class="pdt04-left-side">

                    <div class="pdt04Hebergement">${consulterProduitDto.hebergement}</div>

                    <%--  location prend la valeur consulter pour AjouterProduitPanier--%>
                    <input type="hidden" name="location" value="consulter" /> <input type="hidden" name="id"
                        value="${consulterProduitDto.idProduitOriginal}" />

                    <div>
                        <img src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                            alt="${consulterProduitDto.destination}" class="pdt04Image" />
                    </div>

                </div>

                <%-- Pour la partie droite du côté gauche de la vue - Prix etc --%>
                <div class="pdt04-right-side">
                    <div class="pdt04-reference">
                        <spring:message code="pdt04.reference" />${consulterProduitDto.reference}
                    </div>
                    <div class="pdt04-prix">
                        <spring:message code="pdt04.prix" />${consulterProduitDto.prixUnitaire}&nbsp€
                    </div>
                    <%-- conformement au sfd afficher les elements suivant seulement si un utilisateur est creer  --%>
                    <c:if test="${isAchetable}">
                        <div class="display-flex pdt04-quantite">
                            <%--  bouton - > 0 --%>
                            <a onclick="decrement('${consulterProduitDto.idProduitOriginal}')">
                                <button type="button">-</button>
                            </a>

                            <%--  saisie valeur produit  --%>
                            <input class="pdt00-pan-quantite text-align-center" type="text" readonly="readonly"
                                id="quantite${consulterProduitDto.idProduitOriginal}" name="quantite" value="1" size="1">

                            <%--  bouton + < 100 --%>
                            <a onclick="increment('${consulterProduitDto.idProduitOriginal}')">
                                <button type="button">+</button>
                            </a>
                        </div>

                        <%--  Bouton ajouter au panier --%>
                        <div class="pdt04-ajouter">
                            <button value="submit" class="background-color-green pdt04-bouton">
                                <spring:message code="pdt.addCart" />
                            </button>
                        </div>
                    </c:if>
                </div>
            </form:form>

            <%-- Pour les services --%>
            <div class="display-flex">
                <table aria-label="descriptionServices">
                    <tr>
                        <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.services">
                            </spring:message></th>
                    </tr>
                    <tr class="pdt04IconeServices">
                        <c:forEach items="${consulterProduitDto.services}" var="service" varStatus="loop">
                            <td><c:if test="${consulterProduitDto.services[loop.index]}">
                                    <em class="" id="${loop.index}"></em>
                                </c:if></td>
                        </c:forEach>
                    </tr>
                </table>
            </div>
        </div>

        <%-- Pour la partie droite de la vue - description du produit --%>
        <table aria-label="descriptionProduit">
            <tr>
                <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.description"></spring:message></th>
            </tr>
            <tr>
                <td><textarea maxlength="250" rows="20" cols="60" readonly="readonly"
                        class="pdt04TextArea textarea">${consulterProduitDto.description}</textarea></td>
            </tr>
        </table>

    </div>
</div>
<script>
	loadServices()
</script>
