<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Permet de Gerer l'internationalisation du titre de la page --%>
<p id="titrePage">
    <spring:message code="glb.titre.page.modifierUtilisateur" />
</p>

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
                    <a href="listerUtilisateur.do" class="lien-retour"><spring:message code="usr02.retour" /></a>
                    <h1 class="user02-title">
                        <spring:message code="usr02.titre.admin" />
                    </h1>
                </div>
            </c:when>
            <c:otherwise>
                <div class="display-flex align-item-center">
                    <h1 class="user02-title">
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

                <div class="user02-infos">
                    <label for="nom"><spring:message code="usr02.edit.nom" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="nom" class="user02-inputs" maxlength="50" />
                        <form:errors path="nom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-infos">
                    <label for="prenom"><spring:message code="usr02.edit.prenom" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="prenom" class="user02-inputs" maxlength="50" />
                        <form:errors path="prenom" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-infos">
                    <label for="adresse"><spring:message code="usr02.edit.adresse" /></label>
                    <div class="user02-form-inputs">
                        <form:textarea path="adresse" class="user02-inputs user02-textarea textarea" maxlength="255" />
                        <form:errors path="adresse" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-infos">
                    <label for="dateNaissance"><spring:message code="usr02.edit.dateNaissance" /></label>
                    <div class="user02-form-inputs">
                        <form:input path="dateNaissance" class="user02-inputs" maxlength="10" />
                        <form:errors path="dateNaissance" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div class="user02-infos">
                    <label for="email"><spring:message code="usr02.edit.email" /></label>
                    <div class="user02-form-inputs">
                        <%-- Le readonly pemet le blocage de l'autocompletion 
                        par le navigateur si des identifiants sont enregister --%>
                        <form:input path="email" class="user02-inputs" readonly="true"
                            onfocus="this.removeAttribute('readonly')" maxlength="320" />
                        <form:errors path="email" cssClass="text-color-rouge" />
                    </div>
                </div>

                <div>
                    <details class="user02-infos">
                        <summary>
                            <spring:message code="usr02.details" />
                        </summary>

                        <div class="user02-form-field display-flex justify-content-space-between">
                            <label for="password"><spring:message code="usr02.edit.password" /></label>
                            <div class="user02-form-inputs">
                                <form:password path="password" class="user02-inputs" readonly="true"
                                    onfocus="this.removeAttribute('readonly')" maxlength="255" />
                                <form:errors path="password" cssClass="text-color-rouge" />
                            </div>
                        </div>

                        <div class="user02-form-field display-flex justify-content-space-between">
                            <label for="confirmPassword"><spring:message code="usr02.edit.confirmPassword" /></label>
                            <div class="user02-form-inputs">
                                <form:password path="confirmPassword" class="user02-inputs" readonly="true"
                                    onfocus="this.removeAttribute('readonly')" maxlength="255" />
                                <form:errors path="confirmPassword" cssClass="text-color-rouge" />
                            </div>
                        </div>
                    </details>
                </div>

                <div class="display-flex justify-content-space-around">
                    <div class="user02-buttons">
                        <button class="bouton-impact-BD" onclick="submit">
                            <spring:message code="usr02.edit.valider" />
                        </button>
                        <button class="bouton-rouge" type="reset">
                            <spring:message code="usr02.edit.reset" />
                        </button>
                    </div>
                </div>
            </div>

            <div class="user02-rightSide">

                <%-- Preparation du code pour la partie image, pour eviter tout pb et refaire tout le css --%>
                <div class="user02-rightSide-avatar">
                    <img alt="" src="displayImage.do?id=${utilisateurDto.id}&type=usr" class="user02-avatar">
                </div>

                <c:choose>
                    <c:when test="${utilisateur.role.id == '3'}">
                        <div
                            class="display-flex align-item-center
                        flex-direction-column user02-admin-options">
                            <div class="user02-admin-button">
                                <a href="listerCommande.do?id=${utilisateurDto.id}">
                                    <button type="button" class="user02-admin-button-commande">
                                        <spring:message code="usr02.bouton.commandes" />
                                    </button>
                                </a>
                            </div>

                            <div class="display-flex justify-content-space-between user02-admin-roles">
                                <div>
                                    <form:radiobutton path="role.idRole" value="2" />
                                    <label for="role.idRole1"><spring:message code="usr02.label.client" /></label>
                                </div>

                                <div>
                                    <form:radiobutton path="role.idRole" value="3" />
                                    <label for="role.idRole2"><spring:message code="usr02.label.admin" /></label>
                                </div>
                            </div>

                            <div class="display-flex align-item-center">
                                <spring:message code="usr02.client.active" />

                                <form:checkbox path="estDesactive"
                                    onchange="changeStatusImg(document.getElementById('usr02.status.img'), this)"
                                    cssClass="user02-status-checkbox" />
                                <label for="estDesactive1"> <span class="fa fa-square-o" id="usr02.status.img"></span>
                                </label>

                                <script>
                                	const img = document.getElementById('usr02.status.img');
                                	                             
                                	<%-- Obliger car sinon le js peut inverser les valeurs et tout mettre KO --%>
                                	if (${utilisateurDto.estDesactive}) {
                                		setImg('desactive', img);
                                	} else {
                                		setImg('active', img);
                                	}
                                	
                                	document.getElementById('estDesactive1').value = ${utilisateurDto.estDesactive};
                                </script>
                            </div>

                            <div class="user02-admin-ref">
                                <spring:message code="usr02.reference" />
                                <c:out value="${utilisateurDto.reference}" />
                            </div>
                        </div>
                    </c:when>

                    <c:otherwise>
                        <form:hidden path="role.idRole" value="2" />
                        <form:hidden path="estDesactive" value="${estDesactive}" />
                    </c:otherwise>
                </c:choose>

            </div>
        </form:form>
    </div>
</div>