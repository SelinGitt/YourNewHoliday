<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="header">
    <%-- Dans le headeur, on affiche le logo, cliquable, qui renvoie à la page PDT_00 --%>
    <div id="headerLogo" class="headerCell">
        <a href=""> <img src="img/template/header/logoYNH.png" class="logoHeader-ynh" alt="logo">
        </a>
    </div>
    <%--     suivi du nom de l'agence de voyage --%>
    <div id="headerNom" class="headerCell">
        <h1>
            <spring:message code="header.nom" />
        </h1>
    </div>
    <%--     de l'identité de l'utilisateur s'il est connecté --%>
    <div id="headerStatut" class="headerCell">
        <div>
            <strong><spring:message code="header.id" /></strong>${utilisateur.prenom } ${utilisateur.nom }
        </div>
        <%--         de son statut (visiteur, client, administrateur) --%>
        <div>
            <strong><spring:message code="header.statut" /></strong> ${utilisateur.nomRole }
        </div>

    </div>
    <%--     d'une icône cliquable pour se connecter ou se déconnecter suivant son statut --%>
    <div id="headerConnexion" class="headerCell">
        <div class="headerSousCell">
            <a href="deconnecter.do"> <img src="img/template/header/deconnexion.png" 
            class="logoHeader" alt="icône déconnexion">
            </a>
        </div>
        <%--  suivi du texte "Connexion" ou "Déconnexion" en fonction --%>
        <div class="headerSousCell">
            <h3>
                <spring:message code="header.deconnexion" />
            </h3>
        </div>
    </div>
    <%--  et enfin d'une icône cliquable pour créer un compte si on n'est pas connecté --%>
    <%--  ou pour accéder au panier si on est connecté --%>
    <div id="headerPanier" class="headerCell">
        <div class="headerSousCell">
            <a href=""> <img src="img/template/header/panierVide.png" class="logoHeader" alt="icône panier vide">
            </a>
        </div>
        <%--         suivi du texte "Panier" ou "Créer un compte" en fonction --%>
        <div class="headerSousCell">
            <h3>
                <spring:message code="header.panier" />
            </h3>
        </div>
    </div>
</div>
<hr />