<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr />
<p>
    <!-- Les urls doivent être validées !!! -->
<div id="footer-container">

    <!-- contact -->
    <div class="footer-item">
        <a href="/Projet_YNH/contact"> <spring:message code="glb.footer.lien.con" />
        </a>
    </div>
    <!-- lien -->
    <div class="footer-item">
        <a href="/Projet_YNH/mentionsLégales"> <spring:message code="glb.footer.lien.mlg" />
        </a>
    </div>
    <!-- langues -->
    <div id="footer-lang">       
            <span><spring:message code="glb.footer.texte.langue" /></span>       
       
            <picture> <img class="footer-lang footer-item" src="img/template/footer/france.svg"
                alt="drapeau français" /> <img class="footer-lang footer-item"
                src="img/template/footer/united-kingdom.svg" alt="drapeau anglais" /> </picture>
    
    </div>
</div>

</div>




</p>