<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Votre adresse de livraison</title>
</head>
<body>
    <%-- Titre de la Page --%>
    <h1>
        <spring:message code="pan08.titre" />
    </h1>

    <%-- lien Retour --%>
    <%--remplire le lien pour renvoyer vers Pan00--%>
    <a class="retour" href="#"><spring:message code="pan08.lien.retour" /></a>


    <%-- container de facturation + livraison--%>
    <div class="containerAdressePan08">
        <%-- formulaire Adresse de livraison--%>
        <div class="fieldSetPan08">
            <%-- il faudra ajouter un modelAttribute--%>
            <form:form method="POST" action="listerPanierAdresses.do">
                <fieldset class="fieldSetPan08">
                    <legend>
                        <spring:message code="pan08.fieldSet.livraison" />
                    </legend>
                    <div class="formPan08">
                        <div>
                            <%-- mettre les path="exemple" par la suite --%>
                            <label for="nom"><spring:message code="pan08.label.nom" /></label> <input type="text"
                                name="nom" id="nom">
                        </div>
                        <div>
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input type="text"
                                id="prenom" name="prenom">
                        </div>
                        <div>
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <textarea id="adresse" name="adresse" rows="12"></textarea>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <%-- formulaire Adresse de facturation--%>
        <div class="fieldSetPan08">
            <%-- il faudra ajouter un modelAttribute--%>
            <form:form method="POST" action="listerPanierAdresses.do" class="espacePan08">
                <fieldset class="fieldSetPan08">
                    <legend>
                        <spring:message code="pan08.fieldSet.facturation" />
                    </legend>
                    <div class="formPan08">
                        <div>
                            <%-- mettre les path="exemple" par la suite --%>
                            <label for="nom"><spring:message code="pan08.label.nom" /></label> <input type="text"
                                name="nom" id="nom">
                        </div>
                        <div>
                            <label for="prenom"><spring:message code="pan08.label.prenom" /></label> <input type="text"
                                id="prenom" name="prenom">
                        </div>
                        <div>
                            <label for="adresse"><spring:message code="pan08.label.adresse" /></label>
                            <textarea id="adresse" name="adresse" rows="12"></textarea>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</body>
</html>