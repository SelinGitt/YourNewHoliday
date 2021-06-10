<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>
    <spring:message code="pdt03.titre" />
</h1>

<div class="grid-container">
    <div class="grid-item formlaireCreerProduit">
        <form:form method="POST" modelAttribute="produitDto" action="creerProduitAdmin.do">
            <table class="formulaireProduit" aria-label="Formulaire de création d'un produit">
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.nom" /></td>
                    <td><form:input path="nom" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.reference" /></td>
                    <td><form:input path="reference" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.hebergement" /></td>
                    <td><form:input path="hebergement" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.destination" /></td>
                    <td><form:input path="destination" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.prix" /></td>
                    <td><form:input path="nom" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.miseEnVente" /></td>
                    <td><form:radiobutton path="miseEnVente" value="true" /> <spring:message code="form.pdt03.oui" />
                        <form:radiobutton path="miseEnVente" value="false" /> <spring:message code="form.pdt03.non" /></td>
                </tr>
                <tr>
                    <td><spring:message code="form.pdt03.description" /></td>
                    <td><form:textarea path="description" /></td>
                </tr>
                <tr>
                    <td><form:button value="submit">Submit</form:button></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div class="grid-item imageProduit">
        <table class="imageCreationProduit" aria-label="ajout image produit">
            <tr>
                <th><spring:message code="form.pdt03.image" /></th>
            </tr>
            <tr>
                <td><img src="https://www.voyage-prive.com/s/images/visual/login/backgrounds/2048x1463-maroc.jpg"
                    alt="Maroc" class="img" /></td>
            </tr>
            <tr>
                <td><spring:message code="form.pdt03.parcourir" /></td>
            </tr>
        </table>
    </div>
    <div class="grid-item logoService">
        <table class="listeService" aria-label="liste des services disponibles">
            <tr>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
                <td>9</td>
            </tr>
        </table>
    </div>
</div>