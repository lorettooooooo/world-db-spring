
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Benvenuto ${username}</h1>
	<p>scegli un'opzione</p>
	<a href="cityInfo"> <input type="button" value="Cerca una città">
	</a>
	<a href="countryInfo"> <input type="button" value="Cerca una nazione">
	</a>
	<a href="searchByContinents">
	<input type="button" value="Seleziona da continente" />
	</a>
</body>
</html>