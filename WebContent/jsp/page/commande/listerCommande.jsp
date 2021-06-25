<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="CMD_00-commande">
    <spring:message code="listeCommande.titre.text" />
</h2>
<fieldset class="CMD_00-commandeFieldset conteneur-ascenseur">
    <legend class="CMD_00-commandeLegend">
        <spring:message code="listeCommande.soustitre.text" />
    </legend>
    <div class="CMD_00-commandeGrille">
        <c:choose>
            <c:when test="${listCommande.size() == 0}">
                <div class="CMD_00-commandeVide CMD_00-colorText">
                    <spring:message code="listeCommande.vide.text" />
                </div>
            </c:when>
            <c:otherwise>
                <div class="CMD_00-commandeWrapper CMD_00-colorText">
                    <c:forEach items="${listCommande}" var="commande">
                        <div class="CMD_00-commandeLine">
                            <div class="CMD_00-commandeReference">
                                <a href="#"><spring:message code="listeCommande.ref.text" />${commande.reference}</a>
                            </div>
                            <div class="CMD_00-commandeQuantiteTotale">
                                <div class="CMD_00-commandeQuantiteTotaleText">
                                    <spring:message code="listeCommande.qTotal.text" />
                                </div>
                                <div class="CMD_00-commandeQuantiteTotaleValue">${commande.quantiteTotale}</div>
                            </div>
                            <div class="CMD_00-commandePrixTotal">
                                <div class="CMD_00-commandePrixTotalText">
                                    <spring:message code="listeCommande.prixTotal.text" />
                                </div>
                                <div class="CMD_00-commandePrixTotalValue">
                                    ${commande.prixTotal}
                                    <spring:message code="glb.devise" />
                                </div>
                            </div>
                            <div class="CMD_00-commandeDate">
                                <spring:message code="listeCommande.date.text" />${commande.date}</div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</fieldset>