<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    Utilisateur en session : 
    <ul>
        <li>ID Role : ${utilisateur.idRole}</li>
        <li>ID Utilisateur : ${utilisateur.idUtilisateur}</li>
        <li>Nom : ${utilisateur.nom}</li>
        <li>Prenom : ${utilisateur.prenom}</li>
        <li>Nombre de produit dans le panier : ${utilisateur.nbProduitPanier}</li>
    </ul>
    
    <a href="/Projet_YNH/user_session.do/create">
        <spring:message code="usr.session.creer"/>
    </a>
  
    <a href="/Projet_YNH/user_session.do/supprimer">
        <spring:message code="usr.session.supprimer"/>
    </a>
    