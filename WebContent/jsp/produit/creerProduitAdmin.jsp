<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.creerProduitAdmin" />
</p>

<div class="conteneur-ascenseur">

    <c:if test="${not empty error}">
        <div class="background-error-block block-message-commun">
            <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
        </div>
    </c:if>

    <h1 class="title title-responsive text-align-center">
        <spring:message code="pdt03.titre" />
    </h1>
    <a href="listerProduitsAdmin.do" class="lien-retour"><spring:message code="pdt03.retour" /></a>
    <form:form method="POST" modelAttribute="produitDto" action="creerProduitAdmin.do">
        <div class="pdt03Grid-container">
            <div class="pdt03Grid-item pdt03FormlaireCreerProduit">

                <table class="pdt03FormulaireProduit" aria-label="Formulaire de création d'un produit">
                    <tr>
                        <th><form:hidden path="version" value="1" /></th>
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
                                <form:button value="submit" class="bouton-impact-BD">
                                    <spring:message code="form.pdt03.valider" />
                                </form:button>
                            </div>
                            <div>

                                <form:button type="reset" class="bouton-rouge">
                                    <spring:message code="form.pdt03.reset" />
                                </form:button>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>

            <div class="pdt03Grid-item pdt03LogoService">
                <table class="pdt03ListeService" aria-label="liste des services disponibles">
                    <tr>
                        <th colspan="3"><spring:message code="form.pdt03.service" /></th>
                    </tr>

                    <%-- Boucle pour tout les services --%>
                    <c:forEach items="${produitDto.services}" var="service" varStatus="loop" step="3">
                        <tr>
                            <%-- Boucle qui affiche 3 services --%>
                            <c:forEach begin="${loop.index}" end="${loop.index + 2}" step="1" varStatus="cpt">
                                <c:choose>
                                    <%-- Si le produit est actif --%>
                                    <c:when test="${produitDto.services[cpt.index]}">
                                        <form:checkbox path="services[${cpt.index}]"
                                            onchange="changeServiceStatus(this, ${produitDto.services[cpt.index]}, 3)"
                                            class="pdt03Checkbox" />
                                        <td><label for="services${cpt.index}1" class="firstTime pdt03ServiceActif "
                                            id="${cpt.index}"></label></td>
                                    </c:when>

                                    <%-- Sinon --%>
                                    <c:otherwise>
                                        <form:checkbox path="services[${cpt.index}]"
                                            onchange="changeServiceStatus(this, ${produitDto.services[cpt.index]}, 3)"
                                            class="pdt03Checkbox" />
                                        <td><label for="services${cpt.index}1"
                                            class="firstTime pdt03ServiceInactif " id="${cpt.index}"></label></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <c:if test="${not empty image}">
                <div>-> ${image}</div>
                <form:hidden path="cheminImage" value="${image}" />
            </c:if>
        </div>
    </form:form>

    <form:form action="uploadImageProduit.do" enctype="multipart/form-data" method="post"
        class="display-flex justify-content-space-around">
        <div class="display-flex justify-content-space-around">
            <label for="file"><spring:message code="form.pdt03.image" /></label> <input type="file" name="file"
                accept=".jpeg, .jpg, .png, .bmp" /> <input type="submit" value="submit" />
            <c:if test="${not empty imgError}">
                <div class="text-color-rouge">
                    <spring:message code="${imgError}" />
                </div>
            </c:if>
        </div>
    </form:form>

</div>

<script>
    loadServices()
</script>