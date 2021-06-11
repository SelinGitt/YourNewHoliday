<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty error}">
    <spring:message code="${error}" />
</c:if>
<h1>
    <spring:message code="usr07.titre" />
</h1>
<form:form methode="POST" modelAttribute="utilisateurDto" action="connecter.do">
    <table>
        <caption></caption>
        <tr>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td><spring:message code="usr07.label.email" /></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td><spring:message code="usr07.label.password" /></td>
            <td><form:input path="password" /></td>
            <td><form:errors path="password" cssClass="error" /></td>
        </tr>
    </table>
    <button class="boutonValiderUSR07" onclick="submit">
        <spring:message code="usr07.label.valider" />
    </button>
    <button class="boutonResetUSR07" type="reset">
        <spring:message code="usr07.label.reset" />
    </button>
</form:form>