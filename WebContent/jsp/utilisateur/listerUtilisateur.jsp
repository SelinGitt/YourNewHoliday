<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 id="titreGestion">GESTION CLIENTS</h2>

<table aria-describedby="titreGestion">
    <thead>
        <tr>
            <th>
                <spring:message code="usr01.th.ref" />
            </th>

            <th>
                <spring:message code="usr01.th.nom" />
            </th>

            <th>
                <spring:message code="usr01.th.date" />
            </th>

            <th>
                <spring:message code="usr01.th.profil" />
            </th>

            <th>
                <spring:message code="usr01.th.actif" />
            </th>

            <th>
                <spring:message code="usr01.th.editer" />
            </th>

            <th>
                <spring:message code="usr01.th.supprimer" />
            </th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
            <tr>
                <td>${utilisateurDto.reference}</td>

                <td>${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                <td>${utilisateurDto.dateInscription}</td>

                <td></td>

                <td>${utilisateurDto.estActif}</td>

                <td></td>

                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>