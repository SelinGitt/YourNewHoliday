<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:forEach items="${ListeProduits}" var="produitDto">
        <img src="displayImage.do?id=${produitDto.idProduitOriginal}&type=pdt" alt="test"/>
    </c:forEach>