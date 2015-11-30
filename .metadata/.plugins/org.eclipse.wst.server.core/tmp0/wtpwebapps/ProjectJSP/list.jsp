<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de todos os usuários</title>
</head>
<body>
<table border=1>
   <thead>
       <tr>
           <th>Id</th>
           <th>Nome</th>
           <th>Email</th>
           <th>Login</th>
           <th>Senha</th>
           <th colspan=2>Action</th>
       </tr>
   </thead>
   <tbody>
       <c:forEach items="${users}" var="user">
           <tr>
               <td><c:out value="${user.id}" /></td>
               <td><c:out value="${user.nome}" /></td>
               <td><c:out value="${user.email}" /></td>
               <td><c:out value="${user.login}" /></td>
               <td><c:out value="${user.senha}" /></td>
               <td><a href="cadastraUsuarioServlet?action=edit&id=<c:out value="${user.id}"/>">Update</a></td>
               <td><a href="cadastraUsuarioServlet?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<a href="home.jsp">Voltar</a>
</body>
</html>