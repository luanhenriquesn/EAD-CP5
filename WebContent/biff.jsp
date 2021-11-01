<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <%@include file="head.jsp" %>
    <title>Biff Tannen</title>
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
            <h3>George McFly</h3>
            <div class="container">
              <img src="img/george_biff.png" alt="Biff e George">
              <div class="paragrafo">
                <p><fmt:message key="biff.p1"/></p>
                <p><fmt:message key="biff.p2"/></p>
              </div>
            </div>
          </div>

          <div class="divisao">
            <h3>Marty McFly</h3>
            <div class="container">
              <img src="img/marty_biff.png" alt="Biff e Marty">
              <div class="paragrafo">
                <p><fmt:message key="biff.p3"/></p>
              </div>
            </div>
          </div>

          <div class="divisao">
            <h3>Lorraine Baines</h3>
            <div class="container">
              <img src="img/lorraine_biff.png" alt="Biff e Lorraine">
              <div class="paragrafo">
                <p><fmt:message key="biff.p4"/></p>
                <p><fmt:message key="biff.p5"/></p>
              </div>
            </div>
          </div>

        </section>

      </main>

      <%@include file="footer.jsp" %>

    </div>
  </body>
</html>