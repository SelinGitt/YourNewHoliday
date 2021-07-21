<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="conteneur-ascenseur">

    <c:choose>
        <c:when test="${origin=='2'}">
            <div class="user02-title">
                <h1>
                    <spring:message code="usr02.titre.admin" />
                </h1>
            </div>
            <a href="listerUtilisateur.do" class="user02-retour">&lt; <spring:message code="usr02.retour" />
            </a>
        </c:when>
        <c:otherwise>
            <div class="user02-title">
                <h1>
                    <spring:message code="usr02.titre.client" />
                </h1>
            </div>
        </c:otherwise>
    </c:choose>

    <div class="user02-body-general">
        <c:if test="${not empty error}">
            <div class="background-error-block block-message-commun">
                <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
            </div>
        </c:if>

        <div class="user02-form display-flex">
            <form:form methode="POST" modelAttribute="utilisateurDto" action="modifierUtilisateur.do?origin=${origin}">
                <form:hidden path="dateInscription" value="${dateInscription}" />
                <form:hidden path="reference" value="${reference}" />
                <form:hidden path="id" value="${id}" />
                <form:hidden path="emailBase" value="${emailBase}" />

                <%-- Role hidden temporaire, a supprimer quand les roles seront geres --%>
                <form:hidden path="role.idRole" />
                <form:hidden path="role.libelle" />

                <%-- Temporaire --%>
                <form:hidden path="estDesactive" value="${estDesactive}" />

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.nom" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="nom" />
                        <form:errors path="nom" cssClass="text-color-rouge" />
                    </div>
                </div>
                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.prenom" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="prenom" />
                        <form:errors path="prenom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.adresse" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:textarea path="adresse" />
                        <form:errors path="adresse" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.dateNaissance" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="dateNaissance" />
                        <form:errors path="dateNaissance" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.email" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="email" />
                        <form:errors path="email" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div>
                    <details>
                        <summary>
                            <spring:message code="usr02.details" />
                        </summary>
                        <div class="user02-lib-champ display-flex">
                            <span><spring:message code="usr02.edit.password" /></span>
                            <div class="user02-lib-champ-taille">
                                <form:password path="password" />
                                <form:errors path="password" cssClass="text-color-rouge" />
                            </div>
                        </div>

                        <div class="user02-lib-champ display-flex">
                            <span><spring:message code="usr02.edit.confirmPassword" /></span>
                            <div class="user02-lib-champ-taille">
                                <form:password path="confirmPassword" />
                                <form:errors path="confirmPassword" cssClass="text-color-rouge" />
                            </div>
                        </div>
                    </details>
                </div>

                <div class="user02-buttons display-flex">
                    <button class="user02-editValider" onclick="submit">
                        <spring:message code="usr02.edit.valider" />
                    </button>
                    <button class="user02-editReset" type="reset">
                        <spring:message code="usr02.edit.reset" />
                    </button>
                </div>
            </form:form>

            <div class="user02-rightSide">
                <p>Section avatar And co</p>
            </div>

        </div>
    </div>
</div>
