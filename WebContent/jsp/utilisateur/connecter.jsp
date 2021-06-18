<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="form">
    <form:form methode="POST" modelAttribute="utilisateurDto" action="connecter.do">
       <!-- TODO le titre ne doit pas etre dans le formulaire -->
        <h1>
            <span><spring:message code="usr07.titre" /></span>
        </h1>
        <!-- TODO SUPPRIMER LES BR  mettre le titre dans une div et donner a la div un margin-bottom -->
        <br></br>
        
        <div class="form-group">
          <span><spring:message code="usr07.label.email" /></span>
          <form:input path="email" />
        </div>

        <div class="form-group">
          <span><spring:message code="usr07.label.password" /></span>
          <form:input path="password" />
        </div>
        <div id="button">
            <button class="boutonValiderUSR07" onclick="submit">
                <spring:message code="usr07.label.valider" />
            </button>
            <button class="boutonResetUSR07" type="reset">
                <spring:message code="usr07.label.reset" />
            </button>
        </div>
    </form:form>
</div>