<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer un produit</title>
</head>
<body>

<!-- Formulaire de modification d'un produit -->
			<form:form modelAttribute="${pageContext.request.contextPath}/editProd?idProd=${prod.idProduit}" method="post"  >
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
						<td><form:input type="file" path="photo"/> Choisir photo</td>
					</tr>					
					<tr>
						<td colspan="2" > <input type="submit" value="post">Enregistrer</td>
					</tr>
				</table>
			</form:form>
		</div>
		


</body>
</html>