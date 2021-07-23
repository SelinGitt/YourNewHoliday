<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="conteneur-ascenseur">

    <div class="user02-body-general">
        <c:if test="${not empty error}">
            <div class="background-error-block block-message-commun">
                <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
            </div>
        </c:if>

        <c:choose>
            <c:when test="${origin=='2'}">
                <div class="display-flex align-item-center">
                    <a href="listerUtilisateur.do" class="user02-retour">&lt; <spring:message code="usr02.retour" /></a>
                    <h1 class="user02-title">
                        <spring:message code="usr02.titre.admin" />
                    </h1>
                </div>
            </c:when>
            <c:otherwise>
                <div class="user02-title">
                    <h1>
                        <spring:message code="usr02.titre.client" />
                    </h1>
                </div>
            </c:otherwise>
        </c:choose>

        <form:form methode="POST" modelAttribute="utilisateurDto" action="modifierUtilisateur.do?origin=${origin}"
            class="display-flex justify-content-space-around">

            <div class="user02-leftSide">
                <form:hidden path="dateInscription" value="${dateInscription}" />
                <form:hidden path="reference" value="${reference}" />
                <form:hidden path="id" value="${id}" />
                <form:hidden path="cheminAvatar" value="${cheminAvatar}" />

                <%-- Role hidden temporaire, a supprimer quand les roles seront geres --%>
                <form:hidden path="role.idRole" />
                <form:hidden path="role.libelle" />

                <%-- Temporaire --%>
                <form:hidden path="estDesactive" value="${estDesactive}" />

                <div class="user02-form-field display-flex justify-content-space-between">
                    <label for="nom"><spring:message code="usr02.edit.nom" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="nom" class="user02-inputs" />
                        <form:errors path="nom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-form-field display-flex justify-content-space-between">
                    <label for="prenom"><spring:message code="usr02.edit.prenom" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="prenom" class="user02-inputs" />
                        <form:errors path="prenom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-form-field display-flex justify-content-space-between">
                    <label for="adresse"><spring:message code="usr02.edit.adresse" /></label>
                    <div class="user02-form-inputs">
                        <form:textarea class="textarea" path="adresse" class="user02-inputs user02-textarea" />
                        <form:errors path="adresse" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-form-field display-flex justify-content-space-between">
                    <label for="dateNaissance"><spring:message code="usr02.edit.dateNaissance" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="dateNaissance" class="user02-inputs" />
                        <form:errors path="dateNaissance" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-form-field display-flex justify-content-space-between">
                    <label for="email"><spring:message code="usr02.edit.email" /></label>
                    <div class="user02-form-inputs">
                        <%-- Le readonly pemet le blocage de l'autocompletion 
                        par le navigateur si des identifiants sont enregister --%>
                        <form:input path="email" class="user02-inputs" readonly="true"
                            onfocus="this.removeAttribute('readonly')" />
                        <form:errors path="email" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div>
                    <details>
                        <summary>
                            <spring:message code="usr02.details" />
                        </summary>

                        <div class="user02-form-field display-flex justify-content-space-between">
                            <label for="password"><spring:message code="usr02.edit.password" /></label>
                            <div class="user02-form-inputs">
                                <form:password path="password" class="user02-inputs" readonly="true"
                                    onfocus="this.removeAttribute('readonly')" />
                                <form:errors path="password" cssClass="text-color-rouge" />
                            </div>
                        </div>

                        <div class="user02-form-field display-flex justify-content-space-between">
                            <label for="confirmPassword"><spring:message code="usr02.edit.confirmPassword" /></label>
                            <div class="user02-form-inputs">
                                <form:password path="confirmPassword" class="user02-inputs" />
                                <form:errors path="confirmPassword" cssClass="text-color-rouge" />
                            </div>
                        </div>
                    </details>
                </div>

                <div class="display-flex justify-content-space-around user05-buttons">
                    <button class="user02-valider background-color-green" onclick="submit">
                        <spring:message code="usr02.edit.valider" />
                    </button>
                    <button class="user02-reset background-color-rouge" type="reset">
                        <spring:message code="usr02.edit.reset" />
                    </button>
                </div>
            </div>


            <div class="user02-rightSide">
                <p>Section avatar And co</p>
            </div>
        </form:form>
    </div>
</div>