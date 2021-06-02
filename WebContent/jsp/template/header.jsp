<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="header">
    <div id="headerLogo" class="headerCell">
        <a href=""> <img src="img/template/header/logoYNH.png" class="logoHeader" alt="logo">
        </a>
    </div>
    <div id="headerNom" class="headerCell">
        <h1>
            <spring:message code="header.nom" />
        </h1>
    </div>
    <div id="headerStatut" class="headerCell">
        <strong><spring:message code="header.id" /></strong> ${utilisateur.prenom } ${utilisateur.nom } <br /> <strong><spring:message
                code="header.statut" /></strong> ${utilisateur.nomRole }

    </div>
    <div id="headerConnexion" class="headerCell">
        <div class="headerSousCell">
            <a href=""> <img src="img/template/header/deconnexion.png" class="logoHeader" alt="icône déconnexion">
            </a>
        </div>
        <div class="headerSousCell">
            <h3>
                <spring:message code="header.deconnexion" />
            </h3>
        </div>
    </div>
    <div id="headerPanier" class="headerCell">
        <div class="headerSousCell">
            <a href=""> <img src="img/template/header/panierVide.png" class="logoHeader" alt="icône panier vide">
            </a>
        </div>
        <div class="headerSousCell">
            <h3>
                <spring:message code="header.panier" />
            </h3>
        </div>
    </div>
</div>
<hr />