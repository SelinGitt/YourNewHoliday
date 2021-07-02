
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="conteneur-ascenseur">

    <h1 class="title title-responsive text-align-center">
        <spring:message code="pdt02.titre" />
    </h1>
    <a href="editerProduitAdmin.do"><spring:message code="pdt0203.retour" /></a>
    <form:form method="POST" modelAttribute="produitDto" action="editerProduitAdmin.do">
        <div class="pdt0203Grid-container">
            <div class="pdt0203Grid-item text-align-center pdt0203FormlaireCreerProduit">

                <form:hidden path="version" value="${version}" />
                <form:hidden path="cheminImage" value="${cheminImage}" />
                <form:hidden path="idProduitOriginal" value="${idProduitOriginal}" />
                <table class="pdt0203FormulaireProduit" aria-label="Formulaire de création d'un produit">
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.nom" /></td>
                        <td><form:input path="nom" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.reference" /></td>
                        <td><form:input path="reference" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.hebergement" /></td>
                        <td><form:input path="hebergement" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.destination" /></td>
                        <td><form:input path="destination" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.prix" /></td>
                        <td><form:input path="prixUnitaire" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.miseEnVente" /></td>
                        <td class="pdt0203Formpdt0203Radio display-flex justify-content-space-around">
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="true" />
                                <spring:message code="form.pdt0203.oui" />
                            </div>
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="false" />
                                <spring:message code="form.pdt0203.non" />
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt0203.description" /></td>
                        <td class=pdt0203TextAreapdt0203><form:textarea path="description" rows="4" cols="100" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="justify-content-space-around display-flex">
                            <div>
                                <form:button value="submit" class="background-color-green">
                                    <spring:message code="form.pdt02.valider" />
                                </form:button>
                            </div>
                            <div>

                                <form:button type="reset" class="background-color-rouge">
                                    <spring:message code="form.pdt0203.reset" />
                                </form:button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
            <div class="pdt0203Grid-item text-align-center pdt0203ImageProduit">
                <table class="pdt0203ImageCreationProduit" aria-label="ajout image produit">
                    <tr>
                        <th><spring:message code="form.pdt0203.image" /></th>
                    </tr>
                    <tr>
                        <td><img src="" alt="<spring:message code="form.pdt0203.altImage" />"
                            class="pdt0203Form-imageProduit" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageUpload"
                            value="<spring:message code="form.pdt0203.parcourir" />"></td>
                    </tr>
                </table>
            </div>
            <div class="pdt0203Grid-item text-align-center pdt0203LogoService">
                <form:hidden path="services" value="4" />
                <table class="pdt0203ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt0203.service" /></th>
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
