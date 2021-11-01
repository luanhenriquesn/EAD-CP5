<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<%@include file="head.jsp" %>
	<title><fmt:message key="erro.tituloPagina"/></title>
    <link rel="stylesheet" href="css/styleErro.css">
</head>
<body>
	
	<c:if test="${pessoas == null}">
		<% response.sendRedirect("servletController?acao=erro"); %>
	</c:if>
	
 	<div class="principal">
	
		<%@include file="header.jsp" %>
		
		<main>
			<h1><fmt:message key="erro.titulo"/></h1>
		</main>
		
		<%@include file="footer.jsp" %>
	
	</div>
	
</body>
</html>