<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">

    <h1>
        <spring:message code="pdt03.titre" />
    </h1>
    <form:form method="POST" modelAttribute="produitDto" action="creerProduitAdmin.do">
        <div class="grid-container">
            <div class="grid-item formlaireCreerProduit">

                <table class="formulaireProduit" aria-label="Formulaire de création d'un produit">
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
                        <td class="formPDT03Radio">
                            <div>
                                <form:radiobutton path="miseEnVente" value="true" />
                                <spring:message code="form.pdt03.oui" />
                            </div>



                        </td>
                        <td><form:radiobutton path="miseEnVente" value="false" /> <spring:message
                                code="form.pdt03.non" /></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.description" /></td>
                        <td><form:textarea path="description" rows="4" cols="100" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="buttonsPdt03">
                            <div>
                                <form:button value="submit" class="boutonCreerPDT03">
                                    <spring:message code="form.pdt03.valider" />
                                </form:button>
                            </div>
                            <div>

                                <form:button type="reset" class="boutonResetPDT03">
                                    <spring:message code="form.pdt03.reset" />
                                </form:button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
            <div class="grid-item imageProduit">
                <table class="imageCreationProduit" aria-label="ajout image produit">
                    <tr>
                        <th><spring:message code="form.pdt03.image" /></th>
                    </tr>
                    <tr>
                        <td><img
                            src="https://www.voyage-prive.com/s/images/visual/login/backgrounds/2048x1463-maroc.jpg"
                            alt="Maroc" class="img" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageUpload"
                            value="<spring:message code="form.pdt03.parcourir" />"></td>
                    </tr>
                </table>
            </div>
            <div class="grid-item logoService">
                <table class="listeService" aria-label="liste des services disponibles">
                    <tr>
                        <th><form:hidden path="services" value="4" /></th>
                        <th></th>
                        <th></th>
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
