<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <%@include file="head.jsp" %>
    <title>Einstein</title>
    <link rel="stylesheet" href="css/styleEinstein_Delorean.css">
  </head>
  <body>

    <div class="principal">

      <%@include file="header.jsp" %>

      <main>

        <section class="apresentacao">
          <h1><fmt:message key="apresentacao.informacoes"/></h1>
          <div class="container">
            <img src="img/einstein.jpg" alt="Einstein">
            <div class="atributos">
              <h2><fmt:message key="atributos.titulo"/></h2>
              <ul>
                <li><fmt:message key="atributos.nome"/> ${cachorro.nome}</li>
                <li><fmt:message key="atributos.anoNascimento"/> ${cachorro.anoNascimento}</li>
                <c:if test="${cachorro.sexo.toString() == 'M'}"><li><fmt:message key="atributos.sexo"/> <fmt:message key="atributos.sexoMasculino"/></li></c:if>
                <c:if test="${cachorro.sexo.toString() == 'F'}"><li><fmt:message key="atributos.sexo"/> <fmt:message key="atributos.sexoFeminino"/></li></c:if>
                <li><fmt:message key="atributos.corOlhos"/> ${cachorro.corOlho}</li>
                <li><fmt:message key="cachorro.corPelo"/> ${cachorro.corPelo}</li>
                <li><fmt:message key="cachorro.raca"/> ${cachorro.raca}</li>
                <li><fmt:message key="cachorro.dono"/> ${pessoa.nome}</li>
              </ul>
            </div>
          </div>
        </section>

        <section class="viagem">
          <h2><fmt:message key="einstein.titulo"/></h2>

          <div class="container">
            <img src="img/einstein_viagem.png" alt="Einstein no DeLorean">
            <div class="paragrafo">
              <p><fmt:message key="einstein.p1"/></p>
              <p><fmt:message key="einstein.p2"/></p>
            </div>
          </div>

        </section>

      </main>

      <%@include file="footer.jsp" %>
      
    </div>
  </body>
</html>