<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user00-body-general">

        <div class="align-item-center justify-content-center">
            <c:if test="${not empty error}">
                <div class="background-error-block block-message-commun">
                    <span class="fa fa-exclamation"></span> <span class="message"><spring:message code="${error}" /></span>
                </div>
            </c:if>
            <div class="user00-title">
                <h1>
                    <c:choose>
                        <c:when test="${utilisateurDto.role.idRole=='2'}">
                            <spring:message code="usr00.titre.client" />
                        </c:when>
                        <c:otherwise>
                            <spring:message code="usr00.titre.admin" />
                        </c:otherwise>
                    </c:choose>
                </h1>
            </div>
        </div>

        <div class="display-flex justify-content-space-around">
            <div class="user00-leftSide">

                <div class="user00-infos">
                    <label for="nom"><spring:message code="usr00.consulter.nom" /></label> <input
                        class="user00-infos-input" value="${utilisateurDto.nom}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="prenom"> <spring:message code="usr00.consulter.prenom" /></label> <input
                        class="user00-infos-input" value="${utilisateurDto.prenom}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="adresse"> <spring:message code="usr00.consulter.adresse" /></label>
                    <textarea class="user00-infos-input user00-textarea" disabled="disabled">${utilisateurDto.adresse}</textarea>
                </div>

                <div class="user00-infos">
                    <label for="dateNaissance"> <spring:message code="usr00.consulter.dateNaissance" /></label> <input
                        class="user00-infos-input" value="${utilisateurDto.dateNaissance}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="email"> <spring:message code="usr00.consulter.email" /></label> <input
                        class="user00-infos-input" value="${utilisateurDto.email}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="password"> <spring:message code="usr00.consulter.password" /></label> <input
                        class="user00-infos-input" value="**********" disabled="disabled">
                </div>

                <div class="user00-buttons">
                    <div>
                        <a href="modifierUtilisateur.do?origin=1&ref=${utilisateurDto.reference}">
                            <button class="user00-modifier">
                                <spring:message code="usr00.consulter.modifier" />
                            </button>
                        </a>
                    </div>
                    <div>
                        <a href="supprimerUtilisateur.do?origin=1&ref=${utilisateurDto.reference}"
                            onclick="return confirm('<spring:message code="usr00.consulter.confirmer_suppression" />')">
                            <button class="user00-supprimer">
                                <spring:message code="usr00.consulter.supprimer" />
                            </button>
                        </a>
                    </div>
                </div>

            </div>
            <div>
                <%-- Preparation du code pour la partie image, pour eviter tout pb et refaire tout le css --%>
                <div>
                    <%-- Sonar releve un code smell mineur, on peut ignorer il sera retire a la gestion de l'image --%>
                    <div style="width: 15em; height: 15em; background-color: red;"></div>
                </div>
            </div>
        </div>
    </div>
</div>