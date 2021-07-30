<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-global">
    <%-- Dans le headeur, on affiche le logo, cliquable, qui renvoie � la page PDT_00 --%>
    <div class="headerCell headerLogo">
        <a href="/Projet_YNH/listerProduits.do"> <img src="img/template/header/logoYNH.png" class="logoHeader-ynh"
            alt="logo">
        </a>
    </div>
    <%--     suivi du nom de l'agence de voyage --%>
    <div class="headerCell headerNom">
        <h2>
            <spring:message code="header.nom" />
        </h2>
    </div>
    <%--     de l'identit� de l'utilisateur s'il est connect� --%>
    <div class="headerCell headerStatut">
        <div>
            <strong><spring:message code="header.id" /></strong> ${utilisateur.prenom } ${utilisateur.nom }
        </div>
        <%--         de son statut (visiteur, client, administrateur) --%>
        <div>
            <strong><spring:message code="header.statut" /></strong> ${utilisateur.role.libelle }
        </div>
    </div>

    <%--     d'une ic�ne cliquable pour se connecter ou se d�connecter suivant son statut --%>
    <%--  suivi du texte "Connexion" ou "D�connexion" en fonction --%>
    <div class="headerCell headerConnexion">
        <c:if test="${!empty sessionScope.utilisateur}">
            <div class="headerSousCell ">
                <img onclick="chargerlienDeconnexion()" src="img/template/header/deconnexion.png" class="logoHeader"
                    alt="ic�ne d�connexion">
            </div>
            <div class="headerSousCell">
                <h3 onclick="chargerlienDeconnexion()">
                    <spring:message code="header.deconnexion" />
                </h3>
            </div>
        </c:if>

        <c:if test="${empty sessionScope.utilisateur}">
            <div class="headerSousCell">
                <img onclick="chargerlienConnexion()" src="img/template/header/connexion.png" class="logoHeader"
                    alt="ic�ne connexion">
            </div>
            <div class="headerSousCell">
                <h3 onclick="chargerlienConnexion()">
                    <spring:message code="header.connexion" />
                </h3>
            </div>
        </c:if>
    </div>
    <%--  et enfin d'une ic�ne cliquable pour cr�er un compte si on n'est pas connect� --%>
    <%--  ou pour acc�der au panier si on est connect� --%>

    <c:if test="${!empty sessionScope.utilisateur}">

        <div class="headerCell headerPanier ">
            <div class="headerSousCell" onclick="chargerlienPanier()">
                <c:if test="${sessionScope.panierDto.nombreDeReferences < 1}">
                    <img onclick="chargerlienPanier()" src="img/template/header/panierVide.png" class="logoHeader"
                        alt="ic�ne panier vide">

                </c:if>
                <c:if test="${sessionScope.panierDto.nombreDeReferences > 0 }">
                    <div onclick="chargerlienPanier()">
                        <img onclick="chargerlienPanier()" src="img/template/header/panierRempli.png" class="logoHeader"
                            alt="ic�ne panier rempli">

                        <div class="headerSousCellNbrPdtContainer">
                            <a class="headerSousCellNbrPdt"> ${sessionScope.panierDto.nombreDeReferences }</a>
                        </div>
                    </div>
                </c:if>
            </div>
            <%--"Panier" --%>
            <div class="headerSousCell" onclick="chargerlienPanier()">
                <h3>
                    <spring:message code="header.panier" />
                </h3>
            </div>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.utilisateur}">
        <div class="headerCell headerPanier" onclick="chargerlienCreerUtilisateur()">
            <div class="headerSousCell">
                <a class="text-decoration-none"> <img src="img/template/header/creerCompte.png" class="logoHeader"
                    alt="ic�ne cr�er compte">
                </a>
            </div>
            <%--"Cr�er un compte"--%>
            <div class="headerSousCell">
                <h3>
                    <spring:message code="header.creer.compte" />
                </h3>
            </div>
        </div>
    </c:if>
</div>
<hr />