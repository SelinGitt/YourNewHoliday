<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />
<!-- conteneur pour le footer -->
<div id="footer-container">
    <!-- lien de redirection vers la page contact vide pour l'instant "contact.do" quand le controlleur sera créé -->
    <div>
        <a href=> <spring:message code="glb.footer.lien.con" />
        </a>
    </div>
    <!-- lien de redirection vers la page mentions légales vide pour l'instant "mentions_legales.do" quand le controlleur sera créé -->
    <div>
        <a href=> <spring:message code="glb.footer.lien.mlg" />
        </a>
    </div>
    <!-- langues -->
    <div>
        <!-- texte indiquant les drapeaux permettant de changer de langue -->
        <span><spring:message code="glb.footer.texte.langue" /></span>
        <!-- image du drapeau français permettant de basculer le site en français. -->
        <img class="footer-lang" src="img/template/footer/france.svg" alt="drapeau français" />
        <!-- image du drapeau anglais permettant de basculer le site en anglais.-->
        <img class="footer-lang" src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" />
    </div>
</div>