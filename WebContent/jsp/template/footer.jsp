<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />
<%-- Permet de récupérer la locale en session --%>
<input id="localeCode" type="hidden"
    value='${sessionScope["org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"]}' />
<%-- conteneur pour le footer --%>
<div class="footer-container">
    <%-- lien de redirection vers la page contact vide pour l'instant "contact.do" quand le controlleur sera créé --%>
    <div>
        <a href="contact.do"> <span class="text-responsive"><spring:message code="glb.footer.lien.con" /></span>
        </a>
    </div>
    <%-- lien de redirection vers la page mentions légales vide pour l'instant 
         "mentions_legales.do" quand le controlleur sera créé --%>
    <div>
        <a href="mentionsLegales.do"> <span class="text-responsive"><spring:message
                    code="glb.footer.lien.mlg" /></span>
        </a>
    </div>
    <%-- langues --%>
    <div>
        <%-- texte indiquant les drapeaux permettant de changer de langue --%>
        <span class="text-responsive"><spring:message code="glb.footer.texte.langue" /></span>
        <%-- image du drapeau français permettant de basculer le site en français. --%>
        <a id="lienLangueFr" href="${requestScope.urlLanguage}language=fr"><img id="FR-button"
            class="footer-lang footer-responsive"
            src="img/template/footer/france.svg" alt="drapeau français" /></a>
        <%-- image du drapeau anglais permettant de basculer le site en anglais.--%>
        <a id="lienLangueEn" href="${requestScope.urlLanguage}language=en"><img id="EN-button"
            class="footer-lang footer-responsive"
            src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /></a>
    </div>
</div>
<script type="text/javascript" src="js/footer/langues.js"></script>
<script>
	//appelle la function ce trouvant dans global.js 
	//permet de modifier le titre de la page(pour l'internationalisation)
	//et de suprimer les paragraphes contenant les properties avec les titres des pages
	modifierTitre(document);
	selectLG();
</script>