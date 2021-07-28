<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.connecter" />
</p>

<div class="user07-body-general">

    <c:if test="${not empty error}">
        <div class="background-error-block block-message-commun">
            <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
        </div>
    </c:if>

    <div class="user07-form display-flex">
        <form:form methode="POST" modelAttribute="utilisateurDto" action="connecter.do" autocomplete="one-time-code">

            <div class="user07-title">
                <h1>
                    <span><spring:message code="usr07.titre" /></span>
                </h1>
            </div>

            <div class="user07-lib-champ display-flex">
                <span><spring:message code="usr07.label.email" /></span>
                <div class="user07-lib-champ-email">
                    <form:input path="email" />
                    <div>
                        <form:errors path="email" cssClass="text-color-rouge" />
                    </div>
                </div>
            </div>

            <div class="user07-lib-champ display-flex">
                <span><spring:message code="usr07.label.password" /></span>
                <div class="user07-lib-champ-password">
                    <form:password path="password" />
                    <div>
                        <form:errors path="password" cssClass="text-color-rouge" />
                    </div>
                </div>
            </div>

            <div class="user07-button display-flex">
                <button class="user07-boutonValider" onclick="submit">
                    <spring:message code="usr07.label.valider" />
                </button>
                <button class="user07-boutonReset" type="reset">
                    <spring:message code="usr07.label.reset" />
                </button>
            </div>
        </form:form>
    </div>
</div>
<script>
    document.title = document.getElementById('titrePage').textContent;
    document.getElementById('titrePage').remove();
</script>