<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="sidebar">
    <div class="link-container underline">
      <a href="#"> <span class="fa fa-globe"></span>
        <span>
          <spring:message code="menu.lien.catalogue" />
        </span>
      </a>
    </div>

  <!-- a ajouter si connecter -->
    <c:if test="${!empty sessionScope.utilisateur}">
        <div class="link-container">
          <a href="#">
            <span class="fa fa-user"></span>
            <span>
              <spring:message code="menu.lien.profil" />
            </span>
          </a>
        </div>
    
        <div class="link-container">
          <a href="#">
            <span class="fa fa-history"></span>
            <span>
              <spring:message code="menu.lien.commandes" />
            </span>
          </a>
        </div>
       </c:if>
    
    <!-- a ajouter pour l'administateur le role 3 corespond a admin : Le changer si l'id du role admin change -->
    <c:if test="${sessionScope.utilisateur.idRole =='3'}">
        <div class="link-container admin">
          <span>
            <spring:message code="menu.administration" />
          </span>
        </div>

        <div class="link-container">
          <a href="#">
            <span class="fa fa-cart-plus"></span>
            <span>
              <spring:message code="menu.lien.gestion.produits" />
            </span>
          </a>
        </div>

        <div class="link-container">
          <a href="#">
            <span class="fa fa-address-card-o"></span>
            <span>
              <spring:message code="menu.lien.gestion.clients" />
            </span>
          </a>
        </div>
    </c:if>
  </div>