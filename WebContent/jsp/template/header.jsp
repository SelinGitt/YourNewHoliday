<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-global">
    <%-- Dans le headeur, on affiche le logo, cliquable, qui renvoie à la page PDT_00 --%>
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
    <%--     de l'identité de l'utilisateur s'il est connecté --%>
    <div class="headerCell headerStatut">
        <div>
            <strong><spring:message code="header.id" /></strong>${utilisateur.prenom } ${utilisateur.nom }
        </div>
        <%--         de son statut (visiteur, client, administrateur) --%>
        <div>
            <strong><spring:message code="header.statut" /></strong> ${utilisateur.nomRole }
        </div>
    </div>

    <%--     d'une icône cliquable pour se connecter ou se déconnecter suivant son statut --%>
    <div class="headerCell headerConnexion">
        <div class="headerSousCell">

            <c:if test="${!empty sessionScope.utilisateur}">
                <a href="deconnecter.do"> <img src="img/template/header/deconnexion.png" class="logoHeader"
                    alt="icône déconnexion">
                </a>
            </c:if>

            <c:if test="${empty sessionScope.utilisateur}">
                <a href="connecter.do"> <img src="img/template/header/connexion.png" class="logoHeader"
                    alt="icône connexion">
                </a>
            </c:if>
        </div>
        <%--  suivi du texte "Connexion" ou "Déconnexion" en fonction --%>
        <div class="headerSousCell">
            <h3>
                <c:if test="${!empty sessionScope.utilisateur}">
                    <spring:message code="header.deconnexion" />

                </c:if>
                <c:if test="${empty sessionScope.utilisateur}">
                    <spring:message code="header.connexion" />
                </c:if>

            </h3>
        </div>
    </div>
    <%--  et enfin d'une icône cliquable pour créer un compte si on n'est pas connecté --%>
    <%--  ou pour accéder au panier si on est connecté --%>

    <c:if test="${!empty sessionScope.utilisateur}">

        <div class="headerCell headerPanier">
            <div class="headerSousCell">
                <c:if test="${sessionScope.panierDto.nombreDeReferences < 1}">
                    <a href="listerPanierProduits.do"> <img src="img/template/header/panierVide.png"
                        class="logoHeader" alt="icône panier vide">
                    </a>
                </c:if>
                <c:if test="${sessionScope.panierDto.nombreDeReferences > 0 }">
                    <a href="listerPanierProduits.do"> <img src="img/template/header/panierRempli.png"
                        class="logoHeader" alt="icône panier rempli">
                    </a>
                    <div class="headerSousCellNbrPdtContainer">
                        <a href="listerPanierProduits.do" class="headerSousCellNbrPdt">
                            ${sessionScope.panierDto.nombreDeReferences } </a>
                    </div>
                </c:if>
            </div>
            <%--"Panier" --%>
            <div class="headerSousCell">
                <h3>
                    <spring:message code="header.panier" />
                </h3>
            </div>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.utilisateur}">
        <div class="headerCell headerPanier">
            <div class="headerSousCell">
                <a href=""> <img src="img/template/header/creerCompte.png" class="logoHeader"
                    alt="icône créer compte">
                </a>
            </div>
            <%--"Créer un compte"--%>
            <div class="headerSousCell">
                <h3>
                    <spring:message code="header.creer.compte" />
                </h3>
            </div>
        </div>
    </c:if>
</div>
<hr />