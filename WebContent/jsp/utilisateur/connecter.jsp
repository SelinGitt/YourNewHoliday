<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="form">
    <form:form methode="POST" modelAttribute="utilisateurDto" action="connecter.do">
        <div>
            <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
        </div>

        <div class="title">
            <h1>
                <span><spring:message code="usr07.titre" /></span>
            </h1>
        </div>

        <div class="lib-champ">
            <span><spring:message code="usr07.label.email" /></span>
            <div class="lib-champ-email">
                <form:input path="email" />
                <div class="error">
                    <form:errors path="email" cssClass="error" />
                </div>
            </div>
        </div>

        <div class="lib-champ">
            <span><spring:message code="usr07.label.password" /></span>
            <div class="lib-champ-password">
                <form:input path="password" />
                <div class="error">
                    <form:errors path="password" cssClass="error" />
                </div>
            </div>
        </div>

        <div class="button">
            <button class="boutonValiderUSR07" onclick="submit">
                <spring:message code="usr07.label.valider" />
            </button>
            <button class="boutonResetUSR07" type="reset">
                <spring:message code="usr07.label.reset" />
            </button>
        </div>
    </form:form>
</div>