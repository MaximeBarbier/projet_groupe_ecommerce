<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
		<ul
			style="text-align: left; list-style: none; padding-bottom: 100px; padding-top: 80px;">
			<li style="margin-bottom: 15px;"><a
					style="text-decoration: none; color: black;"
					href="${pageContext.request.contextPath}/listListe">Tous produits</a>
			</li>
			<c:forEach items="${categorieAttribute}" var="cat">
				<li style="margin-bottom: 15px;"><a
					style="text-decoration: none; color: black;"
					href="${pageContext.request.contextPath}/afficherProduitParCategorie?idcat=${cat.idCategorie}">${cat.nomCategorie}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<div
		style="border: 1px black; width: 45%; text-align: left; float: left; margin-left: 120px;">
		<form:form method="get" action="${pageContext.request.contextPath}/recherche">
			<table class="table table-sm">
				<tr>
					<td>Recherche par mot cle :</td>
					<td><input name="motclef" type="text" /></td>
				</tr>


				<tr>
					<td style="text-align: center;" colspan="2"><input type="submit" value="Rechercher"></td>
				</tr>


			</table>
		</form:form>
	</div>


	<div style="width: 50%; margin-left: 350px;">
		<table cellspacing="0" cellpadding="6" border="1" width="50%"
			class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Designation</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Photo</th>
			</tr>

			<c:forEach items="${produitsAttribute}" var="prod">
				<tr>
					<td>${prod.idProduit}</td>
					<td>${prod.designation}</td>
					<td>${prod.description}</td>
					<td>${prod.prix}</td>
					<td>${prod.photo}</td>
				</tr>
			</c:forEach>
		</table>
	</div>




	<jsp:include page="/footer.jsp" />



</body>
</html>