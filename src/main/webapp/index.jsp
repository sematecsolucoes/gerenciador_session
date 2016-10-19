<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<c:if test="${not empty usuarioLogado}">
		<br />
      Voc� est� logado como ${usuarioLogado.email}<br />
	</c:if>

	<form action="fazTudo?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" />
		<br />
		<input type="submit" value="Enviar" />
	</form>


	<form action="login" method="post">
		Email: <input type="text" name="email" />
		<br />
		Senha: <input type="password" name="senha" />
		<br />
		<input type="submit" value="Login" />
	</form>

	<form action="fazTudo?tarefa=Logout" method="post">
		<input type="submit" value="Logout" />
	</form>

</body>
</html>
