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
                <table class="pdt03ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt03.service" /></th>
                    </tr>

                    <c:forEach items="${produitDto.services}" var="service" varStatus="loop">
                        <%-- Permet d'afficher 3 elements par lignes --%>
                        <c:if test="${loop.index == 0}">
                            <tr>
                        </c:if>

                        <%-- Permet de fermer la balise tr et en ouvrir une autre après 3 elements --%>
                        <c:if test="${loop.index != 0 && loop.index % 3 == 0}">
                            </tr>
                            <tr>
                        </c:if>


                        <c:choose>
                            <%-- Si le produit est actif --%>
                            <c:when test="${produitDto.services[loop.index]}">
                                <form:checkbox path="services[${loop.index}]"
                                    onchange="changeServiceStatus(this, ${produitDto.services[loop.index]}, 3)"
                                    class="pdt03Checkbox" />
                                <td><label for="services${loop.index}1" class="firstTime pdt03ServiceActif "
                                    id="${loop.index}"></label></td>
                            </c:when>

                            <%-- Sinon --%>
                            <c:otherwise>
                                <form:checkbox path="services[${loop.index}]"
                                    onchange="changeServiceStatus(this, ${produitDto.services[loop.index]}, 3)"
                                    class="pdt03Checkbox" />
                                <td><label for="services${loop.index}1" class="firstTime pdt03ServiceInactif "
                                    id="${loop.index}"></label></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </table>
            </div>
        </div>
    </form:form>
</div>

<script>
    loadServices()
</script>