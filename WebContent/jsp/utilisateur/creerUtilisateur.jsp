<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>
    <spring:message code="usr05.titre" />
</h1>

<form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do">
    <table aria-describedby="CreerUtilisateur">
        <tr>
            <th><spring:message code="usr05.creer.nom" /></th>
            <td><form:input path="nom" /></td>
        </tr>
        <tr>
            <th><spring:message code="usr05.creer.prenom" /></th>
            <td><form:input path="prenom" /></td>
        </tr>

        <tr>
            <th><spring:message code="usr05.creer.adresse" /></th>
            <td><form:input path="adresse" /></td>
        </tr>
        <tr>
            <th><spring:message code="usr05.creer.dateNaissance" /></th>
            <td><form:input type="date" path="dateNaissance" required /></td>
        </tr>
        <tr>
            <th><spring:message code="usr05.creer.email" /></th>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <th><spring:message code="usr05.creer.password" /></th>
            <td><form:password path="password" /></td>
        </tr>

        <tr>
            <th><spring:message code="usr05.creer.confirmPassword" /></th>
            <td><form:password path="confirmPassword" /></td>
        </tr>

        <tr>
            <td colspan="3">
                <div>
                    <form:button value="submit">
                        <spring:message code="usr05.creer.valider" />
                    </form:button>
                </div>
            </td>

            <td colspan="3">
                <div>
                    <form:button type="reset">
                        <spring:message code="usr05.creer.reset" />
                    </form:button>
                </div>
            </td>
        </tr>
    </table>
</form:form>
