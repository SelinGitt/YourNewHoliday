<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
    <thead>
        <tr>
            <th>Réf. Client</th>

            <th>Nom/Prénom</th>

            <th>Date d'inscriptio</th>

            <th>Type de profil</th>

            <th>Actif</th>

            <th>Editer</th>

            <th>Supprimer</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${listeUtilisateur}" var="utilisateurDto">
            <tr>
                <td>${utilisateurDto.reference}</td>

                <td>${utilisateurDto.nom}/${utilisateurDto.prenom}</td>

                <td>${utilisateurDto.dateInscription}</td>

                <td>RANG</td>

                <td>${utilisateurDto.estActif}</td>

                <td>EDITER_IMG</td>

                <td>SPPRIMER_IMG</td>
            </tr>
        </c:forEach>
    </tbody>
</table>