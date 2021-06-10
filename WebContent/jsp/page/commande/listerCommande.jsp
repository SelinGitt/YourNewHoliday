<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="commandeCMD00">
    <spring:message code="listeCommande.titre.text" />
</h2>
<fieldset class="commandeFieldsetCMD00 conteneur-ascenseur">
    <legend class="commandeLegendCMD00">
        <spring:message code="listeCommande.soustitre.text" />
    </legend>
    <div class="commandeCMD00GRille">
        <c:choose>
            <c:when test="${listCommande.size() == 0}">
                <div class="commandeVideCMD00 colorTextCMD00">
                    <spring:message code="listeCommande.vide.text" />
                </div>
            </c:when>
            <c:otherwise>
                <div class="commandeWrapperCMD00 colorTextCMD00">
                    <c:forEach items="${listCommande}" var="commande">
                        <div class="commandeLineCMD00">
                            <div class="commandeReferenceCMD00">
                                <a href="#"><spring:message code="listeCommande.ref.text" />${commande.reference}</a>
                            </div>
                            <div class="commandePrixTotalCMD00">
                                <div class="commandePrixTotalTextCMD00">
                                    <spring:message code="listeCommande.prixTotal.text" />
                                </div>
                                <div class="commandePrixTotalValueCMD00">
                                    ${commande.prixTotal}
                                    <spring:message code="glb.devise" />
                                </div>
                            </div>
                            <div class="commandeDateCMD00">
                                <spring:message code="listeCommande.date.text" />${commande.date}</div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</fieldset>