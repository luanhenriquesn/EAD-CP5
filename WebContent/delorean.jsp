<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <%@include file="head.jsp" %>
    <title>DeLorean</title>
    <link rel="stylesheet" href="css/styleEinstein_Delorean.css">
  </head>
  <body>

    <div class="principal">

      <%@include file="header.jsp" %>

      <main>

        <section class="apresentacao">
          <h1><fmt:message key="apresentacao.informacoes"/></h1>
          <div class="container">
            <img src="img/delorean.png" alt="DeLorean">
            <div class="atributos">
              <h2><fmt:message key="atributos.titulo"/></h2>
              <ul>
                <li><fmt:message key="carro.nomeFabricante"/> ${carro.nomeFabricante}</li>
                <li><fmt:message key="carro.nomeModelo"/> ${carro.nomeModelo}</li>
                <li><fmt:message key="carro.anoFabricacao"/> ${carro.anoFabricacao}</li>
                <li><fmt:message key="carro.cor"/> ${carro.cor}</li>
                <li><fmt:message key="carro.dono"/> ${pessoa.nome}</li>
              </ul>
            </div>
          </div>
        </section>

        <section class="viagem">
          <h2><fmt:message key="delorean.titulo"/></h2>

          <div class="container">
            <img src="img/delorean_viagem.gif" alt="DeLorean">
            <div class="paragrafo">
              <p><fmt:message key="delorean.p1"/></p>
              <p><fmt:message key="delorean.p2"/></p>
              <p><fmt:message key="delorean.p3"/></p>
            </div>
          </div>

        </section>

      </main>

      <%@include file="footer.jsp" %>

    </div>
  </body>
</html>