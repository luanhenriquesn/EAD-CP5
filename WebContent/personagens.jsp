<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<li>
  <select class="personagens" name="personagens" id="idPersonagens">
  	<option disabled selected><fmt:message key="menu.personagens" /></option>
 	<c:forEach var="p" items="${pessoas}">
 		<option value="servletController?acao=pessoa&codigo=${p.codigo }">${p.nome}</option>
	</c:forEach>
  </select>
</li>

<script src="js/script.js"></script>