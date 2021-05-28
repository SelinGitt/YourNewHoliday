<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="commandeCMD00">
    <spring:message code="listeCommande.titre.text" />
</h2>
<h5 class="commandeCMD00">
    <spring:message code="listeCommande.soustitre.text" />
</h5>
<c:choose>
    <c:when test="${listCommande.size() == 0}">
        <div class="commandeVideCMD00">
            <spring:message code="listeCommande.vide.text" />
        </div>
    </c:when>
    <c:otherwise>
        <div class="commandeWrapperCMD00">
            <c:forEach items="${listCommande}" var="commande">
                <div class="commandeLineCMD00">
                    <div class="commandeReferenceCMD00">
                        <spring:message code="listeCommande.reference.text" />${commande.reference}</div>
                    <div class="commandePrixTotalCMD00">
                        <spring:message code="listeCommande.prixTotal.text" />${commande.prixTotal}</div>
                    <div class="commandeDateCMD00">
                        <spring:message code="listeCommande.date.text" />${commande.date}</div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
