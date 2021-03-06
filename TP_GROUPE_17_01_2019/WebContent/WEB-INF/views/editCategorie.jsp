<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'une catégorie</title>
</head>
<body>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

</head>
<body style="background-color: #FFFFF0;">

	<jsp:include page="/header.jsp" />

	<div
		style="border: 1px black solid; width: 15%; text-align: center; float: left;">
		<ul style="text-align: left; list-style: none; padding-bottom: 100px; padding-top: 80px;">
			<li style="margin-bottom:15px;">Menu</li>
			<li style="margin-bottom:15px;" ><a style="text-decoration: none; color: black;" href="/listeProduits">Produits</a></li>
			<li style="margin-bottom:15px;"><a style="text-decoration: none; color: black;" href="/listCategories">Categories</a></li>
		</ul>
	</div>

	<div
		style="border: 1px black; width: 45%; text-align: left; float: left; margin-left: 120px;">
		<form:form method="post" modelAttribute="categorieUpCommand">
			<table class="table table-sm">
				<tr>
					<td>ID Categorie :</td>
					<td><input type="text" name="idCategorie" value="${categorieUpCommand.idCategorie}"  disabled="disabled"/></td>
					<td><form:hidden path="idCategorie"/><td/>
				</tr>
				<tr>
					<td>Nom Categorie :</td>
					<td><form:input path="nomCategorie" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><form:textarea path="description" /></td>
				</tr>
				<tr>
					<td>Photo :</td>
					<td><input type="file" /></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="2"><input type="submit" value="Modifier"></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>