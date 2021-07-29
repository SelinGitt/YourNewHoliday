<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user05-body-general">

        <c:if test="${not empty error}">
            <div class="background-error-block block-message-commun">
                <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
            </div>
        </c:if>

        <div class="display-flex align-item-center">
            <c:if test="${utilisateur.role.id == '3'}">
                <a href="listerUtilisateur.do" class="lien-retour"><spring:message code="usr02.retour" /></a>
            </c:if>
            <h1 class="user05-titre">
                <spring:message code="usr05.titre" />
            </h1>
        </div>

        <form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do"
            class="display-flex justify-content-space-around">

            <div class="user05-leftSide">

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="nom"><spring:message code="usr05.creer.nom" /></label>
                    <div class="user05-form-inputs">
                        <form:input path="nom" class="user05-inputs" />
                        <form:errors path="nom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="prenom"><spring:message code="usr05.creer.prenom" /></label>
                    <div class="user05-form-inputs">
                        <form:input path="prenom" class="user05-inputs" />
                        <form:errors path="prenom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="adresse"><spring:message code="usr05.creer.adresse" /></label>
                    <div class="user05-form-inputs">
                        <form:textarea path="adresse" class="user05-inputs user05-textarea textarea" />
                        <form:errors path="adresse" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="dateNaissance"><spring:message code="usr05.creer.dateNaissance" /></label>
                    <div class="user05-form-inputs">
                        <form:input path="dateNaissance" class="user05-inputs" value="${dateNaissance}" />
                        <form:errors path="dateNaissance" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="email"><spring:message code="usr05.creer.email" /></label>
                    <div class="user05-form-inputs">
                        <%-- Le readonly pemet le blocage de l'autocompletion 
                        par le navigateur si des identifiants sont enregister --%>
                        <form:input path="email" class="user05-inputs" readonly="true"
                            onfocus="this.removeAttribute('readonly')" />
                        <form:errors path="email" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="password"><spring:message code="usr05.creer.password" /></label>
                    <div class="user05-form-inputs">
                        <form:password path="password" class="user05-inputs" />
                        <form:errors path="password" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user05-form-field display-flex justify-content-space-between">
                    <label for="confirmPassword"><spring:message code="usr05.creer.confirmPassword" /></label>
                    <div class="user05-form-inputs">
                        <form:password path="confirmPassword" class="user05-inputs" />
                        <form:errors path="confirmPassword" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="display-flex justify-content-space-around user05-buttons">
                    <button class="user05-creer background-color-green" type="submit">
                        <spring:message code="usr05.creer.valider" />
                    </button>
                    <button class="user05-reset background-color-rouge" type="reset">
                        <spring:message code="usr05.creer.reset" />
                    </button>
                </div>

                <div class="display-flex justify-content-space-around">
                    <c:choose>
                        <c:when test="${utilisateur.role.id == '3'}">
                            <div>
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

            </div>
            <c:if test="${not empty avatar}">
                <div class="display-flex justify-content-space-between">
                    <div>
                        <spring:message code="usr05.label.avatarChosen" />
                        : ${avatar}
                    </div>
                </div>
                <form:hidden path="cheminAvatar" value="${avatar}" />
            </c:if>
            <%-- On ne peut pas placer ce formulaire dans le form d'inscription, c'est invalide.--%>
            <%-- Je le mets en dessous, je n'ai pas trop le choix, pas à ma connaissence du moins --%>
            <%-- cf : https://imgur.com/a/KoUx67i --%>
            <%-- Preparation du code pour la partie image, pour eviter tout pb et refaire tout le css --%>
        </form:form>
        <form:form action="uploadImageUser.do" enctype="multipart/form-data" method="post"
            class="display-flex justify-content-space-around">
            <div class="user05-leftSide">
                <div class="display-flex justify-content-space-around">
                    <label for="file"><spring:message code="usr05.label.avatar"></spring:message></label>
                    <div class="user05-form-inputs">
                        <input type="file" name="file" accept=".jpeg, .jpg, .png, .bmp" /> <input type="submit"
                            value="submit" />
                        <c:if test="${not empty imgError}">
                            <div class="text-color-rouge">
                                <spring:message code="${imgError}" />
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

