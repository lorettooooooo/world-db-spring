<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Nazione</title>
</head>
<body>
	<a href="home"> <input type="button" value="torna alla home">
	</a>
	<div><p>utente loggato: ${username}</p></div>
	<form action="countryInfo" method="post">
		cerca una nazione: 
		<input type="text" name="countryName" placeHolder="Nome nazione">
		<input type="text" name="continentName" placeHolder="Nome continente">
		 <input type="submit" value="Cerca">
	</form>
	${errorMessage}
	<table>
		<c:forEach items="${countriesList}" var="country">
			<tr>
				<td>${country.code}</td>
				<td>${country.name}</td>
				<td>${country.continent}</td>
				<td>${country.population}</td>
				<td>${country.area}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>