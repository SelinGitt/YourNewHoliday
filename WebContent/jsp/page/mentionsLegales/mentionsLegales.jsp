<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- div container --%>
<div class="body scroll">
    <%-- titre --%>
    <h1>
        <spring:message code="mlg.titre" />
    </h1>

    <div class="mlg-boutons">
        <div id="CGV-button" class="mlg-bouton CG-button-clicked-background" onclick="selectMLG(1)">
            <p>
                <spring:message code="mlg.CGV" />
            </p>
        </div>
        <div id="CGU-button" class="mlg-bouton CG-button-background" onclick="selectMLG(2)">
            <p>
                <spring:message code="mlg.CGU" />
            </p>
        </div>
    </div>
    <div id="CGV-file" class="mlg-file CGV-file">
        <p>${fichierCGV}</p>
    </div>
    <div id="CGU-file" class="mlg-file CGU-file">
        <p>${fichierCGU}</p>
    </div>


</div>
<script type="text/javascript" src="js/mentionLegales/mentionLegales.js"></script>