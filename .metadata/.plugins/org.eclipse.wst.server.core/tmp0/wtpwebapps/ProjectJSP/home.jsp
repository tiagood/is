<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo <%=session.getAttribute("name")%></title>
</head>
<body>
	<%
	    if (session.getAttribute("name") == null) {
	%>
	Você não está logado<br/>
	<a href="index.jsp">Faça Login</a>
	<%} else {
	%>
	<h3>Login aceito</h3>
    <p>Bem Vindo,<%=session.getAttribute("name")%></p>
	<a href="insert.jsp">Insert</a>
	<br>
	<a href="cadastraUsuarioServlet?action=lista">Listar</a>
	<br>
	<a href='logout.jsp'>Log out</a>
	<%
	}
	%>
</body>
</html>