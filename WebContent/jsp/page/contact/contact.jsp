<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- div container --%>
<div class="body conteneur-ascenseur">
    <%-- titre --%>
    <h1>
        <spring:message code="con.titre" />
    </h1>
    <%-- insertion du fichier html --%>
    <p>${fichierHtml}</p>
</div>