<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />


<!-- conteneur pour le footer -->
<div id="footer-container">

    <!-- lien de redirection vers la page contact -->
    <div>
        <a href="/Projet_YNH/contact"> 
        <spring:message code="glb.footer.lien.con" />
        </a>
    </div>
    <!-- lien de redirection vers la page mentions l�gales -->
    <div>
        <a href="/Projet_YNH/mentionsL�gales"> 
        <spring:message code="glb.footer.lien.mlg" />
        </a>
    </div>
    <!-- langues -->
    <div>
        <!-- texte indiquant les drapeaux permettant de changer de langue -->
        <span><spring:message code="glb.footer.texte.langue" /></span>
        <!-- regroupement des images sous la balise picture -->
        <picture> 
            <!-- image du drapeau fran�ais permettant de basculer le site en fran�ais --> 
            <img class="footer-lang" src="img/template/footer/france.svg" alt="drapeau fran�ais" />
            <!-- image du drapeau anglais permettant de basculer le site en anglais -->
            <img class="footer-lang" src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /> 
        </picture>
    </div>
</div>






