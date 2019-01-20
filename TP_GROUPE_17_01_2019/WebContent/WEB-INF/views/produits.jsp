<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
		<!-- Division Menu -->
		<div style="border: 1px black; width: 20%; text-align: center; float: left;">
               <ul>
                   <li>Menu</li>
                   <li><a href="produits....">Produits</a></li>
                   <li><a href="categories...">Categories</a></li>
               </ul>
		</div>
	
		<!-- Division formulaire -->
		<div style="border: 1px black; width: 75%; text-align: center; float: left;">
		
		
			<!-- Formulaire d'ajout de produit -->
			<form:form method="post"  action="${pageContext.request.contextPath}/save">
				<table>
					<tr>
						<td> ID Produit :</td>
						<td><form:hidden  path="idProduit" /></td>
					</tr>
					<tr>
						<td>Categories</td>			
						<td> 
							<form:select path="categorie">
								<form:option value="NONE" label="-------- Select --------"/>
								<form:options items="${ListeCategorie}"/>
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
						<td>Selectionné :</td>
						<td><form:input path="selectionne"/></td>
					</tr>
					<tr>
						<td>Quantité :</td>
						<td><form:input path="quantite"/></td>
					</tr>
					<tr>
						<td>Photo :</td>
						<td><form:input type="file" path="photo"/> Choisir photo</td>
					</tr>					
					<tr>
						<td colspan="2" > <input type="submit" value="post">Enregistrer</td>
					</tr>
				</table>
			</form:form>
		</div>
		
		
		<!-- Affichage des produits -->
		<div>
			<table cellspacing="0" cellpadding="6" border="1" width="50%">
				<tr>
					<th>ID</th>
					<th>Designation</th>
					<th>Prix</th>
					<th>Selectionnée</th>
					<th>Quantité</th>
					<th>Photo</th>
					<th></th>
					<th></th>
					
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
							<a href="${pageContext.request.contextPath}/......./delete${fonct.id}">Supprimer</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/....../edit/${fonct.id}">Editer</a>
						</td>	
					</tr>
				</c:forEach>	
			</table>
		</div>
		




</body>
</html>