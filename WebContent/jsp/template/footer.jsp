<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />
<%-- conteneur pour le footer --%>
<div class="footer-container">
    <%-- lien de redirection vers la page contact vide pour l'instant "contact.do" quand le controlleur sera cr�� --%>
    <div>
        <a href=""> <span class="text-responsive"><spring:message code="glb.footer.lien.con" /></span>
        </a>
    </div>
    <%-- lien de redirection vers la page mentions l�gales vide pour l'instant 
         "mentions_legales.do" quand le controlleur sera cr�� --%>
    <div>
        <a href=""> <span class="text-responsive"><spring:message code="glb.footer.lien.mlg" /></span>
        </a>
    </div>
    <%-- langues --%>
    <div>
        <%-- texte indiquant les drapeaux permettant de changer de langue --%>
        <span class="text-responsive"><spring:message code="glb.footer.texte.langue" /></span>
        <%-- image du drapeau fran�ais permettant de basculer le site en fran�ais. --%>
        <a href="?language=fr"><img class="footer-lang footer-responsive" src="img/template/footer/france.svg"
            alt="drapeau fran�ais" /></a>
        <%-- image du drapeau anglais permettant de basculer le site en anglais.--%>
        <a href="?language=en"> <img class="footer-lang footer-responsive"
            src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /></a>
    </div>
</div>