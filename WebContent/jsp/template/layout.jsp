<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title><spring:message code="layout.titre" /></title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>
    <aside>
        <tiles:insertAttribute name="menu" />
    </aside>
    <section>
        <tiles:insertAttribute name="body" />
    </section>
    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>
