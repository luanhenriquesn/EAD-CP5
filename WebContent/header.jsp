<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header>
  <div class="capa">
    <img src="img/capa.jpg" alt="Capa">
  </div>
  <nav>
    <ul>

      <li><a href="servletController?acao=index">Home</a></li>

      <%@include file="personagens.jsp" %>

      <li><a href="servletController?acao=delorean">DeLorean</a></li>

      <li><a href="servletController?acao=primeiro_viajante"><fmt:message key="menu.einstein" /></a></li>

    </ul>
  </nav>
</header>