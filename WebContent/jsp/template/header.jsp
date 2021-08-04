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
            <strong><spring:message code="header.id" /></strong> ${utilisateur.prenom } ${utilisateur.nom }
        </div>
        <%--         de son statut (visiteur, client, administrateur) --%>
        <div>
            <strong><spring:message code="header.statut" /></strong> ${utilisateur.role.libelle }
        </div>
    </div>

    <%--     d'une icône cliquable pour se connecter ou se déconnecter suivant son statut --%>
    <%--  suivi du texte "Connexion" ou "Déconnexion" en fonction --%>
    <div class="headerCell headerConnexion">
        <c:if test="${!empty sessionScope.utilisateur}">
            <div class="headerSousCell">

                <h3>
                    <a onclick="chargerlienDeconnexion()"><span class="fa fa-sign-out header-fa-fa"> </span> <span>
                            <spring:message code="header.deconnexion" />
                    </span> </a>
                </h3>

            </div>
        </c:if>

        <c:if test="${empty sessionScope.utilisateur}">
            <div class="headerSousCell">

                <h3>
                    <a onclick="chargerlienConnexion()"> <span class="fa fa-sign-in header-fa-fa"> </span> <span>
                            <spring:message code="header.connexion" />
                    </span>
                    </a>
                </h3>

            </div>
        </c:if>
    </div>
    <%--  et enfin d'une icône cliquable pour créer un compte si on n'est pas connecté --%>
    <%--  ou pour accéder au panier si on est connecté --%>

    <c:if test="${!empty sessionScope.utilisateur}">

        <div class="headerCell headerPanier ">
            <div class="headerSousCell" onclick="chargerlienPanier()">
                <h3>
                    <a onclick="chargerlienPanier()"><span class="fa fa-shopping-cart header-fa-fa"> </span> <c:if
                            test="${sessionScope.panierDto.nombreDeReferences > 0 }">
                            <div class="headerSousCellNbrPdtContainer">
                                <div class="headerSousCellNbrPdt">${sessionScope.panierDto.nombreDeReferences }</div>
                            </div>
                        </c:if> <span><spring:message code="header.panier" /></span></a>
                </h3>
            </div>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.utilisateur}">
        <div class="headerCell headerPanier">
            <%--"Créer un compte"--%>
            <div class="headerSousCell">
                <h3>
                    <a onclick="chargerlienCreerUtilisateur()"> <span class="fa fa-user-plus header-fa-fa"> </span>
                        <span> <spring:message code="header.creer.compte" />
                    </span></a>
                </h3>
            </div>
        </div>
    </c:if>
</div>
<hr />