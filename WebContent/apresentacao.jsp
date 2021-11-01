<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section class="apresentacao">
  <h1><fmt:message key="apresentacao.titulo"/></h1>
  <div class="container">
    <img src="img/${nome}.jpg" alt="${pessoa.nome}">
    <div class="atributos">
      <h2><fmt:message key="atributos.titulo"/></h2>
      <ul>
        <li><fmt:message key="atributos.nome"/> ${pessoa.nome}</li>
        <li><fmt:message key="atributos.anoNascimento"/> ${pessoa.anoNascimento}</li>
        <c:if test="${pessoa.sexo.toString() == 'M'}"><li><fmt:message key="atributos.sexo"/> <fmt:message key="atributos.sexoMasculino"/></li></c:if>
        <c:if test="${pessoa.sexo.toString() == 'F'}"><li><fmt:message key="atributos.sexo"/> <fmt:message key="atributos.sexoFeminino"/></li></c:if>
        <li><fmt:message key="atributos.corOlhos"/> ${pessoa.corOlho}</li>
        <li><fmt:message key="atributos.corPele"/> ${pessoa.corPele}</li>
        <li><fmt:message key="atributos.corCabelo"/> ${pessoa.corCabelo}</li>
      </ul>
    </div>
    <div class="endereco">
      <h2><fmt:message key="endereco.titulo"/></h2>
      <ul>
        <li><fmt:message key="endereco.siglaEstado"/> ${endereco.siglaEstado}</li>
        <li><fmt:message key="endereco.nomeCidade"/> ${endereco.nomeCidade}</li>
        <li><fmt:message key="endereco.nomeBairro"/> ${endereco.nomeBairro}</li>
        <li><fmt:message key="endereco.logradouro"/> ${endereco.logradouro}</li>
        <li><fmt:message key="endereco.numeroResidencia"/> ${endereco.numeroResidencia}</li>
      </ul>
    </div>
  </div>
</section>