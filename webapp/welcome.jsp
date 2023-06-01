<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recebendo Dados do HTML</title>
</head>
<body>
	<% String nome = request.getParameter("uname"); 
	out.print("Bem vindo"+nome);%>
</body>
</html>