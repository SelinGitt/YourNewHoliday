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
                        <td><div>
                                <form:input path="nom" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="nom" cssClass="text-color-rouge" />
                            </div></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.reference" /></td>
                        <td><div>
                                <form:input path="reference" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="reference" cssClass="text-color-rouge" />
                            </div></td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.hebergement" /></td>
                        <td>
                            <div>
                                <form:input path="hebergement" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="hebergement" cssClass="text-color-rouge" />
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.destination" /></td>
                        <td><div>
                                <form:input path="destination" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="destination" cssClass="text-color-rouge" />
                            </div></td>

                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.prix" /></td>
                        <td><div>
                                <form:input path="prixUnitaire" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="prixUnitaire" cssClass="text-color-rouge" />
                            </div></td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.miseEnVente" /></td>
                        <td class="pdt03FormPDT03Radio display-flex">
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="true" />
                                <spring:message code="form.pdt03.oui" />
                            </div>
                            <div class="display-flex">
                                <form:radiobutton path="miseEnVente" value="false" checked="checked" />
                                <spring:message code="form.pdt03.non" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="form.pdt03.description" /></td>
                        <td class="pdt03TextAreaPDT03"><div>
                                <form:textarea class="textarea" path="description" rows="4" cols="70" />
                            </div>
                            <div class="pdt03formError">
                                <form:errors path="description" cssClass="text-color-rouge" />
                            </div></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="justify-content-space-around display-flex">
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
                        <td class="pdt03Form-imageProduit"><img src="img/produit/DefaultProductImage.png"
                            alt="Image du produit à ajouter" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageUpload"
                            value="<spring:message code="form.pdt03.parcourir" />"></td>
                    </tr>
                </table>
            </div>
            <div class="pdt03Grid-item pdt03LogoService">
<%--                 <form:hidden path="services" value="4" /> --%>
                <table class="pdt03ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt03.service" /></th>
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
    <form:form action="uploadImageProduit.do" enctype="multipart/form-data" method="post"
        class="display-flex justify-content-space-around">

        <label for="file"><spring:message code="form.pdt03.image"></spring:message></label>

        <input type="file" name="file" accept=".jpeg, .jpg, .png, .bmp" />
        <input type="submit" value="submit" />
        <c:if test="${not empty image}">
                        ${cheminImage}
                        </c:if>
        <c:if test="${not empty imgError}">
            <div class="text-color-rouge">
                <spring:message code="${imgError}" />
            </div>
        </c:if>

    </form:form>
</div>
