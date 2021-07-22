<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="conteneur-ascenseur">
    <div>
        <h1 class="title title-responsive text-align-center">${consulterProduitDto.nom}</h1>
    </div>
    <a href="${retour}"><spring:message code="pdt04.retour"></spring:message></a>
    <div class="display-flex pdt04Flex-container flex-wrap-wrap justify-content-space-around">
        <div>
            <%--  formulaire pour ajouter un produit au panier --%>
            <form:form action="ajouterProduitPanier.do" modelAttribute="beanQuantite" method="POST">
                <%--  location prend la valeur consulter pour AjouterProduitPanier--%>
                <input type="hidden" name="location" value="consulter" />
                <input type="hidden" name="id" value="${consulterProduitDto.idProduitOriginal}" />
                <table aria-label="consulterProduit">
                    <tr>
                        <th colspan="2" class="pdt04Hebergement">${consulterProduitDto.hebergement}</th>
                    </tr>
                    <tr>
                        <td rowspan="5"><img
                            src="displayImage.do?id=${consulterProduitDto.idProduitOriginal}&type=pdt"
                            alt="${consulterProduitDto.destination}" class="pdt04Image" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="pdt04.reference"></spring:message>
                            ${consulterProduitDto.reference}</td>
                    </tr>
                    <tr>
                        <td><spring:message code="pdt04.prix">
                            </spring:message>${consulterProduitDto.prixUnitaire}&nbsp€</td>
                    </tr>
                    <%-- conformement au sfd afficher les elements suivant seulement si un utilisateur est creer  --%>
                    <c:if test="${not empty utilisateur}">
                        <tr>
                            <td>
                                <div class="display-flex">
                                    <%--  bouton - > 0 --%>
                                    <a onclick="decrement('${consulterProduitDto.idProduitOriginal}')">
                                        <button type="button">-</button>
                                    </a>

                                    <%--  saisie valeur produit  --%>
                                    <input class="pdt00-pan-quantite text-align-center" type="text" readonly="readonly"
                                        id="quantite${consulterProduitDto.idProduitOriginal}" name="quantite" value="1"
                                        size="1">

                                    <%--  bouton + < 100 --%>
                                    <a onclick="increment('${consulterProduitDto.idProduitOriginal}')">
                                        <button type="button">+</button>
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%--  Bouton ajouter au panier --%>
                                <button value="submit"
                                    class="background-color-green display-flex 
                                               justify-content-flex-end pdt00Bouton">
                                    <spring:message code="pdt.addCart" />
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </table>

            </form:form>
            <div class="display-flex">
                <div>
                    <table aria-label="descriptionServices">
                        <tr>
                            <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.services">
                                </spring:message></th>
                        </tr>
                        <tr class="pdt04IconeServices">
                            <c:if test="${consulterProduitDto.services[0]}">
                                <td><em class="" id="0"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[1]}">
                                <td><em class="" id="1"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[2]}">
                                <td><em class="" id="2"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[3]}">
                                <td><em class="" id="3"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[4]}">
                                <td><em class="" id="4"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[5]}">
                                <td><em class="" id="5"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[6]}">
                                <td><em class="" id="6"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[7]}">
                                <td><em class="" id="7"></em></td>
                            </c:if>
                            <c:if test="${consulterProduitDto.services[8]}">
                                <td><em class="" id="8"></em></td>
                            </c:if>

                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <table aria-label="descriptionProduit">
            <tr>
                <th colspan="9" class="pdt04SousTitre"><spring:message code="pdt04.description"></spring:message></th>
            </tr>
            <tr>
                <td><textarea maxlength="250" rows="20" cols="60" readonly="readonly" class="pdt04TextArea">
                ${consulterProduitDto.description}</textarea></td>
            </tr>
        </table>

    </div>
</div>
<script>
	var classes = [ "fa fa-glass pdt04IconeSpace",
			"fa fa-bath pdt04IconeSpace", "fa fa-paw pdt04IconeSpace",
			"fa fa-gamepad pdt04IconeSpace", "fa fa-wifi pdt04IconeSpace",
			"fa fa-cutlery pdt04IconeSpace",
			"fa fa-wheelchair pdt04IconeSpace",
			"fa fa-snowflake-o pdt04IconeSpace", "fa fa-tv pdt04IconeSpace" ];

	for (var i = 0; i < 9; i++) {
		if (document.getElementById(i)) {
			document.getElementById(i).className += classes[i];
		}
	}
</script>