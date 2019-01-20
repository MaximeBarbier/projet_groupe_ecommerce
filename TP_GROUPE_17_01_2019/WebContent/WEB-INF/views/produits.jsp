<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>

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
			<li style="margin-bottom:15px; border: 1px; color: brown; font-size: larger;">Menu</li>
			<li style="margin-bottom:15px;" ><a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/listProd">Produits</a></li>
			<li style="margin-bottom:15px;"><a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/listCat">Categories</a></li>
		</ul>
	</div>
	
	<div style="width: 15%; text-align: center; float: right;">
	<s:authorize access="......">
				<a href='<c:url value="/logout"/>'>Logout</a>
			</s:authorize>
	
	</div>

	<section style="border: 1px black;">
	
		<!-- Division formulaire -->
		<div style="border: 1px black; width: 45%; text-align: left; float: left; margin-left: 120px;">	
		
			<!-- Formulaire d'ajout de produit -->
			<form:form method="post" modelAttribute="prodVide">
				<table>
					<tr>
						<td> ID Produit :</td>
						<td><form:hidden  path="idProduit" /></td>
					</tr>
					<tr>
						<td>Categories</td>			
						<td> 
							<form:select path="categorie" >
								<!--<form:option value="NONE" label="-------- Select --------"/>-->
								<form:options items="${listCategories}" itemValue="idCategorie" itemLabel="nomCategorie"/>
							</form:select> 
						</td>
					</tr>					
					<tr>
						<td>Designation :</td>
						<td><form:input path="designation"/></td>
					</tr>					
					<tr>
						<td>Description :</td>
						<td><form:textarea path="description"/></td>
					</tr>					
					<tr>
						<td>Prix :</td>
						<td><form:input path="prix"/> </td>
					</tr>
					<tr>
						<td>Quantité :</td>
						<td><form:input path="quantite"/></td>
					</tr>
					<tr>
						<td>Photo :</td>
						<td><form:input type="file" path="photo"/></td>
					</tr>					
					<tr>
						<td style="text-align: center;" colspan="2" height="10"> <input type="submit" value="Enregistrer"></td>
						
					</tr>
				</table>
			</form:form>
		</div>
		
	
		
		<!-- Affichage des produits -->
		<div  style="width: 50%; margin-left: 50px;">
	
			<table cellspacing="0" cellpadding="6" border="1" width="50%" class="table table-striped">
				<tr  >
					<th>ID</th>
					<th>Designation</th>
					<th>Prix</th>
					<th>Selectionné</th>
					<th>Quantité</th>
					<th>Photo</th>
					<th>Suppression</th>
					<th>Edition</th>
		
					
				</tr>
				
				<c:forEach items="${produitsAttribute}" var="prod">
					<tr>
						<td>${prod.idProduit}</td>
						<td>${prod.designation}</td>
						<td>${prod.prix}</td>
						<td>${prod.selectionne}</td>
						<td>${prod.quantite}</td>
						<td>${prod.photo}</td>
						<td>
							<a href="${pageContext.request.contextPath}/deleteProd?idProd=${prod.idProduit}">Supprimer</a>
						</td>
						<td>
						 	<a rel="editProduit.jsp" href="${pageContext.request.contextPath}/editProd?idProd=${prod.idProduit}">Editer</a>
						</td>	
					</tr>
				</c:forEach>	
			</table>
		</div>
		
		
	</section>

	<footer>
		
	</footer>




</body>
</html>