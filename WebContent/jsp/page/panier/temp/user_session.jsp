<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
Utilisateur en session :
<ul>
    <li>ID Role : ${utilisateur.idRole}</li>
    <li>Nom Role : ${utilisateur.nomRole}</li>
    <li>ID Utilisateur : ${utilisateur.idUtilisateur}</li>
    <li>Nom : ${utilisateur.nom}</li>
    <li>Prenom : ${utilisateur.prenom}</li>
    <li>Nombre de produit dans le panier : ${utilisateur.nbProduitPanier}</li>
</ul>
<div>
    <a href="/Projet_YNH/user_session.do?action=create_client_panier"> <spring:message code="usr.session.creer.clientPanier" />
    </a>
    <a href="/Projet_YNH/panierProduits.do"> <spring:message code="usr.session.redirectionPanier" />
    </a>
</div>
<a href="/Projet_YNH/user_session.do?action=create_client"> <spring:message code="usr.session.creer.client" />
</a>
<br>
<a href="/Projet_YNH/user_session.do?action=create_admin"> <spring:message code="usr.session.creer.admin" />
</a>
<br>
<a href="/Projet_YNH/user_session.do?action=supprimer"> <spring:message code="usr.session.supprimer" />
</a>