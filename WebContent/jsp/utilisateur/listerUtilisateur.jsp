<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${listeUtilisateur}" var="utilisateurDto">
    <p>${utilisateurDto.email}</p>
    <p>${utilisateurDto.reference}</p>
    <p>${utilisateurDto.nom}</p>
    <p>${utilisateurDto.prenom}</p>
</c:forEach>