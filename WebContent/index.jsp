<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <%@include file="head.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" href="css/styleIndex.css">
  </head>
  <body>
	
    <c:if test="${pessoas == null}">
		<% response.sendRedirect("servletController?acao=index"); %>
	</c:if>
	
    <div class="principal">

      <header>
        <div class="capa">
          <img src="img/capa.jpg" alt="Capa">	 
        </div>
         
        <nav>
          <ul>

            <%@include file="personagens.jsp" %>

            <li><a href="servletController?acao=delorean">DeLorean</a></li>

            <li><a href="servletController?acao=primeiro_viajante"><fmt:message key="menu.einstein" /></a></li>

            <li>
              <select class="links" name="links" id="idLinks">
                <option disabled selected>Links</option>
                <option value="https://github.com/luanhenriquesn/DEVOPS-CP6">GitHub</option>
                <option value="https://www.youtube.com/channel/UC8E8oK3FON4V0bGH68_TOEg/videos">Youtube</option>
              </select>
            </li>
            
			<li class="bandeiras">
				<a href='servletLingua?lingua=pt-br'><img src="img/br.png"/></a>
				<a href='servletLingua?lingua=en'><img src="img/us.png"/></a>
				<a href='servletLingua?lingua=es'><img src="img/es.jpg"/></a>
			</li>
			
		 </ul>
        </nav>
      </header>

      <main>

        <section class="introducao">
          <h1><fmt:message key="introducao.titulo"/></h1>
          <p><fmt:message key="introducao.p1"/></p>
          <p><fmt:message key="introducao.p2"/></p>

        </section>

        <section class="lista-personagens">
          <h2><fmt:message key="listaPersonagens.titulo"/></h2>
          <ul>
            <li>
              <h3>Marty McFly</h3>
              <a href="servletController?acao=pessoa&codigo=1"><img src="img/marty.jpg" alt="Marty McFly"></a>
            </li>
            <li>
              <h3>Emmett Brown</h3>
              <a href="servletController?acao=pessoa&codigo=2"><img src="img/emmett.jpg" alt="Emmett Brown"></a>
            </li>
            <li>
              <h3>George McFly</h3>
              <a href="servletController?acao=pessoa&codigo=3"><img src="img/george.jpg" alt="George McFly"></a>
            </li>
            <li>
              <h3>Lorraine Baines</h3>
              <a href="servletController?acao=pessoa&codigo=4"><img src="img/lorraine.jpg" alt="Lorraine Baines"></a>
            </li>
            <li>
              <h3>Biff Tannen</h3>
              <a href="servletController?acao=pessoa&codigo=5"><img src="img/biff.jpg" alt="Biff Tannen"></a>
            </li>
          </ul>
        </section>

      </main>

      <%@include file="footer.jsp" %>

    </div>
    
    <script src="js/script.js"></script>
  </body>
</html>
