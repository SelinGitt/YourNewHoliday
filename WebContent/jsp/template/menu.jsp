<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="sidebar">
    <div class="link-container underline">
        <a href="#home"> <span class="fa fa-globe"></span>
            <p>
                <spring:message code="menu.lien.catalogue" />
            </p>
        </a>
    </div>
    <div class="link-container">
        <a href="#clients"> <span class="fa fa-fw fa-user"></span>
            <p>
                <spring:message code="menu.lien.profil" />
            </p>
        </a>
    </div>
    <div class="link-container">
        <a href="#contact"> <span class="fa fa-history"></span>
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
        <a href="#contact"> <span class="fa fa-cart-plus"></span>
            <p>
                <spring:message code="menu.lien.gestion.produits" />
            </p>
        </a>
    </div>

    <div class="link-container">
        <a href="#contact"> <span class="fa fa-address-card-o"></span>
            <p>
                <spring:message code="menu.lien.gestion.clients" />
            </p>
        </a>
    </div>

</div>