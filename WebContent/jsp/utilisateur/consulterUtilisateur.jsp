<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user00-body-general">

        <div class="display-flex align-item-center">
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
                <div class="display-flex justify-content-space-between">
                    <label for="nom"><spring:message code="usr00.consulter.nom" /></label>
                    <div>${utilisateurDto.nom}</div>
                </div>
                <div class="display-flex justify-content-space-between">
                    <label><spring:message code="usr00.consulter.prenom" /></label>
                    <div>${utilisateurDto.prenom}</div>
                </div>
                <div class="display-flex justify-content-space-between">
                    <label><spring:message code="usr00.consulter.adresse" /></label>
                    <div>${utilisateurDto.adresse}</div>
                </div>
                <div class="display-flex justify-content-space-between">
                    <label><spring:message code="usr00.consulter.dateNaissance" /></label>
                    <div>${utilisateurDto.dateNaissance}</div>
                </div>
                <div class="display-flex justify-content-space-between">
                    <label><spring:message code="usr00.consulter.email" /></label>
                    <div>${utilisateurDto.email}</div>
                </div>
                <div class="display-flex justify-content-space-between">
                    <label><spring:message code="usr00.consulter.password" /></label>
                    <div>**********</div>
                </div>

                    <td class="buttonsUser00">
                        <div>
                            <a href="#">
                                <button class="modifierUser00">
                                    <spring:message code="usr00.consulter.modifier" />
                                </button>
                            </a>
                        </div>
                        <div>
                            <a href="supprimerUtilisateur.do"
                                onclick="return confirm('<spring:message code="usr00.consulter.confirmer_suppression" />')">
                                <button class="supprimerUser00">
                                    <spring:message code="usr00.consulter.supprimer" />
                                </button>
                            </a>
                        </div>
                    </td>
                </tr>


            </div>
            <div class="rightSideUser00">
                <p>Section avatar And co</p>
            </div>
        </div>
    </div>
</div>