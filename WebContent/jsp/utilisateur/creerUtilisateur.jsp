<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.creerUtilisateur" />
</p>

<div class="conteneur-ascenseur">

    <div class="user05-body-general">
        <c:if test="${not empty error}">
            <div class="background-error-block block-message-commun">
                <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
            </div>
        </c:if>

        <div class="display-flex align-item-center">
            <h1 class="user05-titre">
                <spring:message code="usr05.titre" />
            </h1>
        </div>

        <c:if test="${utilisateur.role.id == '3'}">
            <a href="listerUtilisateur.do" class="lien-retour"><spring:message code="usr05.retour" /></a>
        </c:if>
        <div class="display-flex justify-content-space-around">

            <div class="user02-leftSide">

                <form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do">

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="nom"><spring:message code="usr05.creer.nom" /></label>
                        <div class="user05-form-inputs">
                            <form:input path="nom" class="user05-inputs" maxlength="50" />
                            <form:errors path="nom" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="prenom"><spring:message code="usr05.creer.prenom" /></label>
                        <div class="user05-form-inputs">
                            <form:input path="prenom" class="user05-inputs" maxlength="50" />
                            <form:errors path="prenom" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="adresse"><spring:message code="usr05.creer.adresse" /></label>
                        <div class="user05-form-inputs">
                            <form:textarea path="adresse" class="user05-inputs user05-textarea textarea" maxlength="255" />
                            <form:errors path="adresse" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="dateNaissance"><spring:message code="usr05.creer.dateNaissance" /></label>
                        <div class="user05-form-inputs">
                            <form:input path="dateNaissance" class="user05-inputs" value="${dateNaissance}"
                                maxlength="10" />
                            <form:errors path="dateNaissance" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="email"><spring:message code="usr05.creer.email" /></label>
                        <div class="user05-form-inputs">
                            <%-- Le readonly pemet le blocage de l'autocompletion 
                        par le navigateur si des identifiants sont enregister --%>
                            <form:input path="email" class="user05-inputs" readonly="true"
                                onfocus="this.removeAttribute('readonly')" maxlength="320" />
                            <form:errors path="email" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="password"><spring:message code="usr05.creer.password" /></label>
                        <div class="user05-form-inputs">
                            <form:password path="password" class="user05-inputs" maxlength="255" />
                            <form:errors path="password" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="user05-form-field display-flex justify-content-space-between">
                        <label for="confirmPassword"><spring:message code="usr05.creer.confirmPassword" /></label>
                        <div class="user05-form-inputs">
                            <form:password path="confirmPassword" class="user05-inputs" maxlength="255" />
                            <form:errors path="confirmPassword" cssClass="text-color-rouge" />
                        </div>
                    </div>

                    <div class="display-flex justify-content-space-evenly">
                        <c:choose>
                            <c:when test="${utilisateur.role.id == '3'}">
                                <div class="margin-left-usr05">
                                    <form:radiobutton path="role.idRole" value="2" />
                                    <label for="role.idRole1"><spring:message code="usr05.label.client" /></label>
                                </div>

                                <div>
                                    <form:radiobutton path="role.idRole" value="3" />
                                    <label for="role.idRole2"><spring:message code="usr05.label.admin" /></label>
                                </div>
                            </c:when>

                            <c:otherwise>
                                <form:hidden path="role.idRole" value="2" />
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="display-flex justify-content-space-evenly margin-left-usr05 margin-top-usr05">
                        <button class="bouton-impact-BD" type="submit">
                            <spring:message code="usr05.creer.valider" />
                        </button>
                        <button class="bouton-rouge" type="reset">
                            <spring:message code="usr05.creer.reset" />
                        </button>
                    </div>

                    <c:if test="${not empty avatar}">
                        <form:hidden path="cheminAvatar" value="${avatar}" />
                    </c:if>

                </form:form>

            </div>

            <div class="user05-rightSide">
                <c:if test="${not empty avatar}">
                    <div>
                        <div>
                            <img src="displayImage.do?imageToShow=${avatar}&type=usr" alt="Image Utilisateur"
                                class="user05-avatar">
                        </div>
                    </div>
                </c:if>
                <c:if test="${empty avatar}">
                    <div>
                        <div>
                            <spring:message code="usr05.label.avatarChosen" />
                        </div>
                    </div>
                </c:if>

                <form:form action="uploadImageUser.do" enctype="multipart/form-data" method="post">
                    <div class="user05-label-image">
                        <span><label for="file"><spring:message code="usr05.label.avatar"></spring:message></label></span>
                    </div>
                    <div>
                        <div>
                            <input type="file" name="file" accept=".jpeg, .jpg, .png, .bmp" />
                        </div>
                        <div class="user05-submit-image">
                            <input type="submit" value="submit" />
                        </div>
                    </div>

                    <c:if test="${not empty imgError}">
                        <div class="text-color-rouge user05-ErrorMessage">
                            <spring:message code="${imgError}" />
                        </div>
                    </c:if>
                </form:form>


                <%-- On ne peut pas placer ce formulaire dans le form d'inscription, c'est invalide.--%>
                <%-- Je le mets en dessous, je n'ai pas trop le choix, pas à ma connaissence du moins --%>
                <%-- cf : https://imgur.com/a/KoUx67i --%>
                <%-- Preparation du code pour la partie image, pour eviter tout pb et refaire tout le css --%>

            </div>
        </div>
    </div>
</div>