<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>
    <spring:message code="usr02.titre" />
</h1>

<div class="user05">
    <div class="leftSideUser05">
        <form:form method="POST" modelAttribute="utilisateurDto" action="modifierUtilisateur.do">
            <table aria-describedby="ModifierUtilisateur">
                <tr>
                    <th><spring:message code="usr02.edit.nom" /></th>
                    <td><form:input path="nom" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr02.edit.prenom" /></th>
                    <td><form:input path="prenom" /></td>
                </tr>

                <tr>
                    <th><spring:message code="usr02.edit.adresse" /></th>
                    <td><form:input path="adresse" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr02.edit.dateNaissance" /></th>
                    <td><form:input path="dateNaissance" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr02.edit.email" /></th>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <th><spring:message code="usr02.edit.password" /></th>
                    <td><form:password path="password" /></td>
                </tr>

                <tr>
                    <th><spring:message code="usr02.edit.confirmPassword" /></th>
                    <td><form:password path="confirmPassword" /></td>
                </tr>

                <tr>
                    <td></td>

                    <td class="buttonsUser02">
                        <div>
                            <form:button value="submit" class="editUser02">
                                <spring:message code="usr02.edit.valider" />
                            </form:button>
                        </div>
                        <div>
                            <form:button type="reset" class="resetUser02">
                                <spring:message code="usr02.edit.reset" />
                            </form:button>
                        </div>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <div class="rightSideUser05">
        <p>Section avatar And co</p>
    </div>
</div>
