<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1><spring:message code="usr05.titre" /></h1>
<form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do">
<table>
            <tr>
                <td><spring:message code="usr05.creer.nom" /></td>
                <td><form:input path="nom" /></td>
            </tr>
            <tr>
                <td><spring:message code="usr05.creer.prenom" /></td>
                <td><form:input path="prenom" /></td>
            </tr>
            
            <tr>
                <td><spring:message code="usr05.creer.adresse" /></td>
                <td><form:input path="adresse" /></td>
            </tr>
            <tr>
                <td><spring:message code="usr05.creer.dateNaissance" /></td>
                <td><form:input path="dateNaissance" /></td>
            </tr>
            <tr>
                <td><spring:message code="usr05.creer.email" /></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td><spring:message code="usr05.creer.password" /></td>
                <td><form:input path="password" /></td>
            </tr>
            
            <tr>
                <td><spring:message code="usr05.creer.confirmPassword" /></td>
                <td><form:input path="confirmPassword" /></td>
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
                        <form:button value="submit">
                            <spring:message code="usr05.creer.reset" />
                        </form:button>
                    </div>
                </td>
            </tr>
            </table>
</form:form>