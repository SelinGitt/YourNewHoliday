<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>
    <spring:message code="usr05.titre" />
</h1>

<div class="user05">
    <div class="leftSideUser05">
        <form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do">
            <table aria-describedby="CreerUtilisateur">
                <tr>
                    <th><spring:message code="usr05.creer.nom" /></th>
                    <td><form:input path="nom" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr05.creer.prenom" /></th>
                    <td><form:input path="prenom" /></td>
                </tr>

                <tr>
                    <th><spring:message code="usr05.creer.adresse" /></th>
                    <td><form:input path="adresse" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr05.creer.dateNaissance" /></th>
                    <td><form:input path="dateNaissance" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr05.creer.email" /></th>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr05.creer.password" /></th>
                    <td><form:password path="password" /></td>
                </tr>

                <tr>
                    <th><spring:message code="usr05.creer.confirmPassword" /></th>
                    <td><form:password path="confirmPassword" /></td>
                </tr>

                <tr>
                    <td></td>

                    <td class="buttonsUser05">
                        <div>
                            <form:button value="submit" class="creerUser05">
                                <spring:message code="usr05.creer.valider" />
                            </form:button>
                        </div>
                        <div>
                            <form:button type="reset" class="resetUser05">
                                <spring:message code="usr05.creer.reset" />
                            </form:button>
                        </div>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <div class="rightSideUser05">
        <p>Section avatar & co</p>
    </div>
</div>
