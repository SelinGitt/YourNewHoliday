<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
    <%-- Dans le headeur, on affiche le logo, cliquable, qui renvoie � la page PDT_00 --%>
    <div id="headerLogo" class="headerCell">
        <a href="/Projet_YNH/listerProduits.do"> <img src="img/template/header/logoYNH.png" class="logoHeader-ynh"
            alt="logo">
        </a>
    </div>
    <%--     suivi du nom de l'agence de voyage --%>
    <div id="headerNom" class="headerCell">
        <h2>
            <spring:message code="header.nom" />
        </h2>
    </div>
    <%--     de l'identit� de l'utilisateur s'il est connect� --%>
    <div id="headerStatut" class="headerCell">
        <div>
            <strong><spring:message code="header.id" /></strong>${utilisateur.prenom } ${utilisateur.nom }
        </div>
        <%--         de son statut (visiteur, client, administrateur) --%>
        <div>
            <strong><spring:message code="header.statut" /></strong> ${utilisateur.nomRole }
        </div>
    </div>

    <%--     d'une ic�ne cliquable pour se connecter ou se d�connecter suivant son statut --%>
    <div id="headerConnexion" class="headerCell">
        <div class="headerSousCell">

            <c:if test="${!empty sessionScope.utilisateur}">
                <a href="deconnecter.do"> <img src="img/template/header/deconnexion.png" class="logoHeader"
                    alt="ic�ne d�connexion">
                </a>
            </c:if>

            <c:if test="${empty sessionScope.utilisateur}">
                <a href="connecter.do"> <img src="img/template/header/connexion.png" class="logoHeader"
                    alt="ic�ne connexion">
                </a>
            </c:if>
        </div>
        <%--  suivi du texte "Connexion" ou "D�connexion" en fonction --%>
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
    <%--  et enfin d'une ic�ne cliquable pour cr�er un compte si on n'est pas connect� --%>
    <%--  ou pour acc�der au panier si on est connect� --%>

    <c:if test="${!empty sessionScope.utilisateur}">

        <div id="headerPanier" class="headerCell">
            <div class="headerSousCell">
                <c:if test="${sessionScope.panierDto.nombreDeReferences < 1}">
                    <a href=""> <img src="img/template/header/panierVide.png" class="logoHeader"
                        alt="ic�ne panier vide">
                    </a>
                </c:if>
                <c:if test="${sessionScope.panierDto.nombreDeReferences > 0 }">
                    <a href=""> <img src="img/template/header/panierRempli.png" class="logoHeader"
                        alt="ic�ne panier rempli">
                    </a>
                    <div class="headerSousCellNbrPdt">${sessionScope.panierDto.nombreDeReferences }</div>
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
        <div id="headerPanier" class="headerCell">
            <div class="headerSousCell">
                <a href=""> <img src="img/template/header/creerCompte.png" class="logoHeader"
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