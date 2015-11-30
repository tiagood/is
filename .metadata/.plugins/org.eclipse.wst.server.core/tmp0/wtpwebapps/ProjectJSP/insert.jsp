<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Usuário</title>
</head>
<body>
	<form action="cadastraUsuarioServlet" method="POST">
  		Nome:<br>
  		<input type="text" name="nome">
  		<br>
  		Email:<br>
  		<input type="text" name="email">
  		<br>
  		Login:<br>
  		<input type="text" name="login">
  		<br>
  		Senha:<br>
  		<input type="password" name="senha">
  		<br>
  		<input type="submit" value="Submit">
	</form>
	<br>
	<a href="home.jsp">Voltar</a>
</body>
</html>