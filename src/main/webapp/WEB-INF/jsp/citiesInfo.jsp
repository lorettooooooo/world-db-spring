<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info città nella nazione</title>
</head>
<body>
	<a href="/home"> <input type="button" value="torna alla home">
	</a>
	<a href="/${selectedContinent}/countries"> <input type="button" value="torna indietro">
	</a>
	<div><p>utente loggato: ${username}</p></div>
	<table>
		<tr>
			<td>Nome</td>
			<td>Popolazione</td>
		</tr>
		<c:forEach items="${citiesList}" var="city">
			<tr>
				<td>${city.name}</td>
				<td>${city.population}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>