<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Per Nazioni</title>
</head>
<body>
	<a href="/home"> <input type="button" value="torna alla home">
	</a>
	<a href="/searchByContinents"> <input type="button" value="torna indietro">
	</a>
	<div><p>utente loggato: ${username}</p></div>
	<h1>Hai selezionato ${selectedContinent}</h1>
	<table>
		<tr>
			<td>Nome</td>
			<td>Popolazione</td>
		</tr>
		<c:forEach items="${countriesList}" var="country">
			<tr>
				<td><a href="/${country.code}/cities">${country.name}</a></td>
				<td>${country.population}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>