<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Per Continenti</title>
</head>
<body>
		<a href="/home"> <input type="button" value="torna alla home">
	</a>
	<div><p>utente loggato: ${username}</p></div>
	<table>
	<tr>
		<td>
		Nome
		</td>
	</tr>
	<c:forEach items="${continentsList}" var="continent">
		<tr>
		<td>
			<a href="/${continent}/countries">${continent}</a>
		</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>