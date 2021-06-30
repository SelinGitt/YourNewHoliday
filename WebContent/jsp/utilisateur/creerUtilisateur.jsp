<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="conteneur-ascenseur">
    <div class="user05-body-general">
        <div class="user05-form display-flex">
            <form:form methode="POST" modelAttribute="utilisateurDto" action="creerUtilsateur.do">

                <div class="user05-title">
                    <h1>
                        <spring:message code="usr05.titre" />
                    </h1>
                </div>


                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.nom" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="nom" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.prenom" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="prenom" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.adresse" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="adresse" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.dateNaissance" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="dateNaissance" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.email" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:input path="email" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.password" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:password path="password" />
                    </div>
                </div>

                <div class="user05-lib-champ display-flex">
                    <span><spring:message code="usr05.creer.confirmPassword" /></span>
                    <div class="user05-lib-champ-taille">
                        <form:password path="confirmPassword" />
                    </div>
                </div>

                <div class="user05-buttons display-flex">
                    <button class="user05-creer" onclick="submit" >
                        <spring:message code="usr05.creer.valider" />
                    </button>
                    <button class="user05-reset" type="reset" >
                        <spring:message code="usr05.creer.reset" />
                    </button>
                </div>
            </form:form>
            
            <div class="user05-rightSide">
                <p>Section avatar And co</p>
            </div>

        </div>
    </div>
</div>


<!-- <h1> -->
<%--     <spring:message code="usr05.titre" /> --%>
<!-- </h1> -->

<!-- <div class="user05 display-flex"> -->
<!--     <div class="leftSideUser05"> -->
<%--         <form:form method="POST" modelAttribute="utilisateurDto" action="creerUtilisateur.do"> --%>
<!--             <table aria-describedby="CreerUtilisateur"> -->
<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.nom" /></th> --%>
<%--                     <td><form:input path="nom" /></td> --%>
<!--                 </tr> -->
<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.prenom" /></th> --%>
<%--                     <td><form:input path="prenom" /></td> --%>
<!--                 </tr> -->

<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.adresse" /></th> --%>
<%--                     <td><form:input path="adresse" /></td> --%>
<!--                 </tr> -->
<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.dateNaissance" /></th> --%>
<%--                     <td><form:input path="dateNaissance" /></td> --%>
<!--                 </tr> -->
<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.email" /></th> --%>
<%--                     <td><form:input path="email" /></td> --%>
<!--                 </tr> -->
<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.password" /></th> --%>
<%--                     <td><form:password path="password" /></td> --%>
<!--                 </tr> -->

<!--                 <tr> -->
<%--                     <th><spring:message code="usr05.creer.confirmPassword" /></th> --%>
<%--                     <td><form:password path="confirmPassword" /></td> --%>
<!--                 </tr> -->

<!--                 <tr> -->
<!--                     <td></td> -->

<!--                     <td class="buttonsUser05 display-flex"> -->
<!--                         <div> -->
<%--                             <form:button value="submit" class="creerUser05"> --%>
<%--                                 <spring:message code="usr05.creer.valider" /> --%>
<%--                             </form:button> --%>
<!--                         </div> -->
<!--                         <div> -->
<%--                             <form:button type="reset" class="resetUser05"> --%>
<%--                                 <spring:message code="usr05.creer.reset" /> --%>
<%--                             </form:button> --%>
<!--                         </div> -->
<!--                     </td> -->
<!--                 </tr> -->
<!--             </table> -->
<%--         </form:form> --%>
<!--     </div> -->

<!--     <div class="rightSideUser05"> -->
<!--         <p>Section avatar And co</p> -->
<!--     </div> -->
<!-- </div> -->
