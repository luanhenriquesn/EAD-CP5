<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <%@include file="head.jsp" %>
    <title>Marty McFly</title>
    <link rel="stylesheet" href="css/stylePersonagem.css">
    <link rel="stylesheet" href="css/styleCronologia.css">
  </head>
  <body>

    <div class="principal">

      <%@include file="header.jsp" %>

      <main>

        <%@include file="apresentacao.jsp" %>

        <section class="cronologia">
          <h2><fmt:message key="cronologia.titulo"/></h2>

          <div class="divisao">
            <h3>Biff Tannen</h3>
            <div class="container">
              <img src="img/marty_biff.png" alt="Marty e Biff">
              <div class="paragrafo">
                <p><fmt:message key="marty.p1"/></p>
                <p><fmt:message key="marty.p2"/></p>
              </div>
            </div>
          </div>

          <div class="divisao">
            <h3>George McFly</h3>
            <div class="container">
              <img src="img/marty_george.png" alt="Marty e George">
              <div class="paragrafo">
                <p><fmt:message key="marty.p3"/></p>
                <p><fmt:message key="marty.p4"/></p>
              </div>
            </div>
          </div>

          <div class="divisao">
            <h3>Lorraine Baines</h3>
            <div class="container">
              <img src="img/marty_lorraine.png" alt="Marty e Lorraine">
              <div class="paragrafo">
                <p><fmt:message key="marty.p5"/></p>
                <p><fmt:message key="marty.p6"/></p>
              </div>
            </div>
          </div>

          <div class="divisao">
            <h3>Dr. Emmett Brown</h3>
            <div class="container">
              <img src="img/marty_emmett.png" alt="Marty e Emmett">
              <div class="paragrafo">
                <p><fmt:message key="marty.p7"/></p>
                <p><fmt:message key="marty.p8"/></p>
              </div>
            </div>
          </div>
          
        </section>

      </main>

      <%@include file="footer.jsp" %>

    </div>
  </body>
</html>