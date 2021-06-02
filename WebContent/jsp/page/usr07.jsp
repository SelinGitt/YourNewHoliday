<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="usr07.titre" /></title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.bouttonValider {
	background-color: #008000;
	Color: white;
}

.bouttonReset {
	background-color: #FF0000;
	Color: white;
}
</style>
</head>
<body>

    <h1>
        <spring:message code="usr07.titre" />
    </h1>

    <form:form methode="POST" modelAttribute="utilisateurDto" action="usr07.do">
        <table>
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
        <button class="boutonValider" onclick="submit">
            <spring:message code="usr07.label.valider" />
        </button>
        <button class="boutonReset" type="reset">
            <spring:message code="usr07.label.reset" />
        </button>
    </form:form>
    ${utilisateur.nom} ${utilisateur.prenom}
</body>
</html>