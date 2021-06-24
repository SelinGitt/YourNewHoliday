<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- div container --%>
<div class="mlg-container">
    <%-- titre --%>
    <h1 class="mlg-titre">
        <spring:message code="mlg.titre" />
    </h1>

    <div class="mlg-container-boutons">
        <div class="mlg-container-bouton">
            <h4 onclick="changeToCGV(MLG)">
                <spring:message code="mlg.CGV" />
            </h4>
        </div>
        <div class="mlg-container-bouton">
            <h4 onclick="changeToCGU(MLG)">
                <spring:message code="mlg.CGU" />
            </h4>
        </div>
    </div>
    <p id="MLG"></p>

    <script>
					function changeToCGV(id) {
						id.innerHTML = "${fichierCGV}";
					}

					function changeToCGU(id) {
						id.innerHTML = "${fichierCGU}";
					}
				</script>

</div>