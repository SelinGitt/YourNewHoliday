<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link href="css-ext/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>
    <!--     regrouper aside et section afin de facilité la manipulation et d'avoir le rendu souhaité sans détours  -->
    <div id="content">
        <aside>
            <tiles:insertAttribute name="menu" />
        </aside>
        <section>
            <tiles:insertAttribute name="body" />
        </section>
    </div>
    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>
