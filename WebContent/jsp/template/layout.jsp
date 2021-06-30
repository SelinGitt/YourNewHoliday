<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link href="css/commande.css" rel="stylesheet">
<link href="css/produit.css" rel="stylesheet">
<link href="css/panier.css" rel="stylesheet">
<link href="css/user.css" rel="stylesheet">
<link href="css/external_files.css" rel="stylesheet">
<link href="css-ext/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="css/flex.css" rel="stylesheet">
<link href="css/general.css" rel="stylesheet">
<link href="css/template.css" rel="stylesheet">
<script type="text/javascript" src="js/commande/commande.js"></script>
<script type="text/javascript" src="js/panier/panier.js"></script>
<script type="text/javascript" src="js/produit/produit.js"></script>
<script type="text/javascript" src="js/utilisateur/utilisateur.js"></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>
    <%--regrouper aside et section afin de facilité la manipulation et d'avoir le rendu souhaité sans détours --%>
    <div class="content">
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
