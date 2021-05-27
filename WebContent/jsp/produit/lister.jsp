<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des séjours</title>
</head>
<body>
    <p>
        <spring:message code="pdt00.titre" />
    </p>
     <br />
    <table>
        <thead>
            <tr>
                <th><spring:message code="lister.id" /></th>
                <th><spring:message code="lister.description" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listeProduitDto}" var="produitDto">
                <tr>
                    <td>${produitDto.nom}</td>
                    <td><a href="consulter.do?id=${produitDto.id}">${produitDto.description}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br/>
</body>
</html>