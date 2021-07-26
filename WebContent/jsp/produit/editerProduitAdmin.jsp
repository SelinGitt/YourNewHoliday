<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">

    <c:if test="${not empty error}">
        <div class="background-error-block block-message-commun">
            <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
        </div>
    </c:if>

    <h1 class="title title-responsive text-align-center">
        <spring:message code="pdt02.titre" />
    </h1>
    <a href="editerProduitAdmin.do"><spring:message code="pdt02.retour" /></a>
    <form:form method="POST" modelAttribute="produitDto" action="editerProduitAdmin.do">
        <div class="pdt02Grid-container">
            <div class="pdt02Grid-item text-align-center pdt02FormlaireCreerProduit">

                <form:hidden path="version" value="${version}" />
                <form:hidden path="cheminImage" value="${cheminImage}" />
                <form:hidden path="idProduitOriginal" value="${idProduitOriginal}" />
                <table class="pdt02FormulaireProduit" aria-label="Formulaire de création d'un produit">
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.nom" /></td>
                        <td><div>
                                <form:input path="nom" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="nom" cssClass="text-color-rouge" />
                            </div></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.reference" /></td>
                        <td><div>
                                <form:input path="reference" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="reference" cssClass="text-color-rouge" />
                            </div></td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.hebergement" /></td>
                        <td>
                            <div>
                                <form:input path="hebergement" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="hebergement" cssClass="text-color-rouge" />
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.destination" /></td>
                        <td><div>
                                <form:input path="destination" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="destination" cssClass="text-color-rouge" />
                            </div></td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.prix" /></td>
                        <td><div>
                                <form:input path="prixUnitaire" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="prixUnitaire" cssClass="text-color-rouge" />
                            </div></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.miseEnVente" /></td>
                        <td class="pdt02Formpdt02Radio display-flex justify-content-space-around">
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="true" />
                                <spring:message code="form.pdt02.oui" />
                            </div>
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="false" />
                                <spring:message code="form.pdt02.non" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt02.description" /></td>
                        <td class="pdt02TextAreapdt02"><div>
                                <form:textarea class="textarea" path="description" rows="4" cols="70" />
                            </div>
                            <div class="pdt02formError">
                                <form:errors path="description" cssClass="text-color-rouge" />
                            </div></td>
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
                                    <spring:message code="form.pdt02.reset" />
                                </form:button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
            <div class="pdt02Grid-item text-align-center pdt02ImageProduit">
                <table class="pdt02ImageCreationProduit" aria-label="ajout image produit">
                    <tr>
                        <th><spring:message code="form.pdt02.image" /></th>
                    </tr>
                    <tr>
                        <td><img src="" alt="<spring:message code="form.pdt02.altImage" />"
                            class="pdt02Form-imageProduit" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageUpload"
                            value="<spring:message code="form.pdt02.parcourir" />"></td>
                    </tr>
                </table>
            </div>
            <div class="pdt02Grid-item text-align-center pdt02LogoService">
                <form:hidden path="services" value="4" />
                <table class="pdt02ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt02.service" /></th>
                    </tr>
                    <tr>
                        <td><em class="fa fa-glass fa-2x"></em></td>
                        <td><em class="fa fa-bath fa-2x"></em></td>
                        <td><em class="fa fa-paw fa-2x"></em></td>
                    </tr>
                    <tr>
                        <td><em class="fa fa-gamepad fa-2x"></em></td>
                        <td><em class="fa fa-wifi fa-2x"></em></td>
                        <td><em class="fa fa-cutlery fa-2x"></em></td>
                    </tr>
                    <tr>
                        <td><em class="fa fa-wheelchair fa-2x"></em></td>
                        <td><em class="fa fa-snowflake-o fa-2x"></em></td>
                        <td><em class="fa fa-tv fa-2x"></em></td>
                    </tr>
                </table>
            </div>
        </div>
    </form:form>
</div>
