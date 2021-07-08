<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user00-body-general">

        <div class="display-flex align-item-center justify-content-center">
            <c:if test="${not empty error}">
                <span class="errorblock"><spring:message code="${error}" /></span>
            </c:if>
            <h1 class="user00-titre">
                <spring:message code="usr00.titre" />
                - ${fn:toUpperCase(utilisateurDto.role.libelle)}
            </h1>
        </div>

        <div class="display-flex justify-content-space-around">
            <div class="user00-leftSide">

                <div class="user00-infos">
                    <label for="nom"><spring:message code="usr00.consulter.nom" /></label> <input
                        value="${utilisateurDto.nom}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="prenom"> <spring:message code="usr00.consulter.prenom" /></label> <input
                        value="${utilisateurDto.prenom}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="adresse"> <spring:message code="usr00.consulter.adresse" /></label>
                    <textarea rows="5" cols="52">${utilisateurDto.adresse}</textarea>
                </div>

                <div class="user00-infos">
                    <label for="dateNaissance"> <spring:message code="usr00.consulter.dateNaissance" /></label> <input
                        value="${utilisateurDto.dateNaissance}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="email"> <spring:message code="usr00.consulter.email" /></label> <input
                        value="${utilisateurDto.email}" disabled="disabled">
                </div>

                <div class="user00-infos">
                    <label for="password"> <spring:message code="usr00.consulter.password" /></label> <input
                        value="**********" disabled="disabled">
                </div>

                <div class="display-flex justify-content-space-between user00-buttons">
                    <div>
                        <a href="#">
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
            <div class="rightSideUser00">
                <p>Section avatar And co</p>
            </div>
        </div>
    </div>
</div>