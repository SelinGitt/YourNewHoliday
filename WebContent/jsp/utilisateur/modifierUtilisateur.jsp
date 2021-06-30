<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user02-body-general">
        <div class="user02-form display-flex">
            <form:form methode="POST" modelAttribute="utilisateurDto" action="modifierUtilsateur.do">

                <div class="user02-title">
                    <h1>
                        <spring:message code="usr02.titre" />
                    </h1>
                </div>


                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.nom" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="nom" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.prenom" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="prenom" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.adresse" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:textarea path="adresse" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.dateNaissance" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="dateNaissance" />
                    </div>
                </div>

                <div class="user02-lib-champ display-flex">
                    <span><spring:message code="usr02.edit.email" /></span>
                    <div class="user02-lib-champ-taille">
                        <form:input path="email" />
                    </div>
                </div>

                <div>
                    <details>
                        <summary>Modification mot de passe</summary>
                        <div class="user02-lib-champ display-flex">
                            <span><spring:message code="usr02.edit.password" /></span>
                            <div class="user02-lib-champ-taille">
                                <form:password path="password" />
                            </div>
                        </div>

                        <div class="user02-lib-champ display-flex">
                            <span><spring:message code="usr02.edit.confirmPassword" /></span>
                            <div class="user02-lib-champ-taille">
                                <form:password path="confirmPassword" />
                            </div>
                        </div>
                    </details>
                </div>

                <div class="user05-buttons display-flex">
                    <button class="user02-editValider" onclick="submit">
                        <spring:message code="usr02.edit.valider" />
                    </button>
                    <button class="user02-editReset" type="reset">
                        <spring:message code="usr02.edit.reset" />
                    </button>
                </div>
            </form:form>

            <div class="user05-rightSide">
                <p>Section avatar And co</p>
            </div>

        </div>
    </div>
</div>
