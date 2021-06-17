<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="sidebar">
    <div class="link-container underline">
        <a href="listerProduits.do"> <span class="fa fa-globe"></span> <span> <spring:message
                    code="menu.lien.catalogue" />
        </span>
        </a>
    </div>

    <div class="link-container">
        <a href="#"> <span class="fa fa-user"></span> <span> <spring:message code="menu.lien.profil" />
        </span>
        </a>
    </div>

    <div class="link-container">
        <a href="listerCommande.do"> <span class="fa fa-history"></span> <span> <spring:message
                    code="menu.lien.commandes" />
        </span>
        </a>
    </div>

    <div class="link-container admin">
        <span> <spring:message code="menu.administration" />
        </span>
    </div>

    <div class="link-container">
        <a href="listerProduitsAdmin.do"> <span class="fa fa-cart-plus"></span> <span> <spring:message
                    code="menu.lien.gestion.produits" />
        </span>
        </a>
    </div>

    <div class="link-container">
        <a href="listerUtilisateur.do"> <span class="fa fa-address-card-o"></span> <span> <spring:message
                    code="menu.lien.gestion.clients" />
        </span>
        </a>
    </div>

</div>