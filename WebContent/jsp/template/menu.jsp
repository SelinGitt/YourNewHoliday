<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="sidebar">
    <div class="link-container underline">
        <a href="#home"> <i class="fa fa-globe"></i>
            <p>
                <spring:message code="menu.lien.catalogue" />
            </p>
        </a>
    </div>
    <div class="link-container">
        <a href="#clients"> <i class="fa fa-fw fa-user"></i>
            <p>
                <spring:message code="menu.lien.profil" />
            </p>
        </a>
    </div>
    <div class="link-container">
        <a href="#contact"> <i class="fa fa-history"></i>
            <p>
                <spring:message code="menu.lien.commandes" />
            </p>
        </a>
    </div>

    <div class="link-container admin">
        <p>
            <spring:message code="menu.administration" />
        </p>
    </div>

    <div class="link-container">
        <a href="#contact"> <i class="fa fa-cart-plus"></i>
            <p>
                <spring:message code="menu.lien.gestion.produits" />
            </p>
        </a>
    </div>

    <div class="link-container">
        <a href="#contact"> <i class="fa fa-address-card-o"></i>
            <p>
                <spring:message code="menu.lien.gestion.clients" />
            </p>
        </a>
    </div>

</div>