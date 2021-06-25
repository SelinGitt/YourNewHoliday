<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- div container --%>
<div class="contact-container">
    <%-- titre --%>
    <h1 class="contact-titre text-align-center">
        <spring:message code="con.titre" />
    </h1>
    <%-- insertion du fichier html --%>
    <p>${fichierHtml}</p>
</div>