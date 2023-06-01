<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recebendo Dados do HTML</title>
</head>
	<body>  
		<%= "Bem vindo "+request.getParameter("uname") %>  
	</body>  

</html>