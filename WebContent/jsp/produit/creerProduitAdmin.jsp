<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="conteneur-ascenseur">

    <h1>
        <spring:message code="pdt03.titre" />
    </h1>
    <a href="listerProduitsAdmin.do"><spring:message code="pdt03.retour" /></a>
    <form:form method="POST" modelAttribute="produitDto" action="creerProduitAdmin.do">
        <div class="pdt03Grid-container">
            <div class="pdt03Grid-item pdt03FormlaireCreerProduit">

                <table class="pdt03FormulaireProduit" aria-label="Formulaire de création d'un produit">
                    <tr>
                        <th><form:hidden path="version" value="1" /> <form:hidden path="cheminImage"
                                value="D:/Test" /></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.nom" /></td>
                        <td><form:input path="nom" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.reference" /></td>
                        <td><form:input path="reference" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.hebergement" /></td>
                        <td><form:input path="hebergement" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.destination" /></td>
                        <td><form:input path="destination" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.prix" /></td>
                        <td><form:input path="prixUnitaire" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.miseEnVente" /></td>
                        <td class="pdt03FormPDT03Radio display-flex">
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="true" />
                                <spring:message code="form.pdt03.oui" />
                            </div>
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="false" />
                                <spring:message code="form.pdt03.non" />
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.description" /></td>
                        <td class=pdt03TextAreaPDT03><form:textarea path="description" rows="4" cols="100" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="pdt03ButtonsPdt03 display-flex">
                            <div>
                                <form:button value="submit" class="background-color-green">
                                    <spring:message code="form.pdt03.valider" />
                                </form:button>
                            </div>
                            <div>

                                <form:button type="reset" class="background-color-rouge">
                                    <spring:message code="form.pdt03.reset" />
                                </form:button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
            <div class="pdt03Grid-item pdt03ImageProduit">
                <table class="pdt03ImageCreationProduit" aria-label="ajout image produit">
                    <tr>
                        <th><spring:message code="form.pdt03.image" /></th>
                    </tr>
                    <tr>
                        <td><img src="" alt="Image du produit à ajouter" class="pdt03Form-imageProduit" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageUpload"
                            value="<spring:message code="form.pdt03.parcourir" />"></td>
                    </tr>
                </table>
            </div>
            <div class="pdt03Grid-item pdt03LogoService">
                <form:hidden path="services" value="4" />
                <table class="pdt03ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt03.service" /></th>
                    </tr>
                    <tr>
                        <td><em class="fa fa-glass"></em></td>
                        <td><em class="fa fa-bath"></em></td>
                        <td><em class="fa fa-paw"></em></td>
                    </tr>
                    <tr>
                        <td><em class="fa fa-gamepad"></em></td>
                        <td><em class="fa fa-wifi"></em></td>
                        <td><em class="fa fa-cutlery"></em></td>
                    </tr>
                    <tr>
                        <td><em class="fa fa-wheelchair"></em></td>
                        <td><em class="fa fa-snowflake-o"></em></td>
                        <td><em class="fa fa-tv"></em></td>
                    </tr>
                </table>
            </div>
        </div>
    </form:form>
</div>
