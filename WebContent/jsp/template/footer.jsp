<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />
<%-- conteneur pour le footer --%>
<div class="footer-container">
    <%-- lien de redirection vers la page contact vide pour l'instant "contact.do" quand le controlleur sera créé --%>
    <div>
        <a href=""> <span class="text-responsive"><spring:message code="glb.footer.lien.con" /></span>
        </a>
    </div>
    <%-- lien de redirection vers la page mentions légales vide pour l'instant 
         "mentions_legales.do" quand le controlleur sera créé --%>
    <div>
        <a href=""> <span class="text-responsive"><spring:message code="glb.footer.lien.mlg" /></span>
        </a>
    </div>
    <%-- langues --%>
    <div>
        <%-- texte indiquant les drapeaux permettant de changer de langue --%>
        <span class="text-responsive"><spring:message code="glb.footer.texte.langue" /></span>
        <%-- image du drapeau français permettant de basculer le site en français. --%>
        <a href="?language=fr"><img class="footer-lang footer-responsive" src="img/template/footer/france.svg"
            alt="drapeau français" /></a>
        <%-- image du drapeau anglais permettant de basculer le site en anglais.--%>
        <a href="?language=en"> <img class="footer-lang footer-responsive"
            src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /></a>
    </div>
</div>