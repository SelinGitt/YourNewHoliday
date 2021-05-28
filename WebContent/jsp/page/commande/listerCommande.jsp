<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>
	<spring:message code="listeCommande.titre.text" />
</h2>
<h5>
	<spring:message code="listeCommande.soustitre.text" />
</h5>
<c:choose>
	<c:when test="${listCommande.size() == 0}">
		<spring:message code="listeCommande.vide.text" />
	</c:when>
	<c:otherwise>
		<table>
			<tr>
				<c:forEach items="${listCommande}" var="commande">
					<th><spring:message code="listeCommande.reference.text" />${commande.reference}</th>
					<th><spring:message code="listeCommande.prixTotal.text" />${commande.prixTotal}</th>
					<th><spring:message code="listeCommande.date.text" />${commande.date}</th>
				</c:forEach>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
