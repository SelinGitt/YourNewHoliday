<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user05-body-general">
        <div class="user05-form display-flex">
            <form:form methode="POST" modelAttribute="utilisateurDto" enctype="multipart/form-data"
                action="creerUtilsateur.do">

                <div class="user05-title">
                    <h1 class="text-align-center">
                        <spring:message code="usr05.titre" />
                    </h1>
                </div>


                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.nom" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="nom" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.prenom" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="prenom" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.adresse" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="adresse" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.dateNaissance" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="dateNaissance" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.email" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="email" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.password" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:password path="password" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.confirmPassword" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:password path="confirmPassword" />
                    </div>
                </div>

                <div class="user05-buttons display-flex">
                    <button class="user05-creer" onclick="submit">
                        <spring:message code="usr05.creer.valider" />
                    </button>
                    <button class="user05-reset" type="reset">
                        <spring:message code="usr05.creer.reset" />
                    </button>
                </div>


                <div class="user05-rightSide">
                    <img src="#" width="25%" height="25%" hidden="true" /> <br /> <input type="file"
                        name="fichier" accept=".jpeg, .jpg, .png, .bmp" onchange="readURL(this)"
                        value="<spring:message code="usr05.parcourir" />" />
                </div>
            </form:form>
        </div>
    </div>

</div>
