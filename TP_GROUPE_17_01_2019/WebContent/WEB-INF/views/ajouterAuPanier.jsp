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



	<header style="">
		
		<div>
			<img src="/images/panier.jpg">
			
				<form:form action="${pageContext.request.contextPath}/....." >
					<form:input path=""/>
					<input type="submit" name="Rechercher">
				</form:form>
				
				
		</div>
		
		<div>
			<img src="/images/panier.jpg">
			<table>
				<tr>
					<td>Nombre de produit</td>
					<td><form:outputText path=""/></td>
				</tr>
				<tr>
					<td>Total</td>
					<td><form:outputText path=""/></td>
				</tr>
			</table>
		</div>



	</header>


	<section style="border: 1px black;">
	
		<!-- Division Menu -->
		<div style="border: 1px black; width: 20%; text-align: center; float: left;">
			<nav>
               <ul>
                   <li>Menu</li>
                   <li><a href="produits....">Ordinateurs</a></li>
                   <li><a href="categories...">Imprimantes</a></li>
                   <li><a href="categories...">Téléphones</a></li>
               </ul>
            </nav>
		</div>


			<!-- table produits -->
		<div style="border: 1px black; width: 75%; float: left;">
			<table cellspacing="0" cellpadding="6" border="1" width="50%">
				<tr>
					<th>ID</th>
					<th>Designation</th>
					<th>Prix</th>
					<th>Quantité</th>
					<th>Montant</th>
					<th></th>	
				</tr>
				
				<c:forEach items="${........}" var="prod">
					<tr>
						<td>${prod. }</td>
						<td>${ }</td>
						<td>${ }</td>
						<td>${ }</td>
						<td>${ }</td>
						<td>Total</td>	
					</tr>
				</c:forEach>
				
				<tr>
					<td rowspan=5> Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>${ }</td>
				</tr>		
			</table>
		</div>
		
		
		<!-- Affichage des produits -->
		
		<c:forEach items="${........}" var="prod">
			<div style="border: 1px black; width: 30%; float: left;">
				<img src="image du produit">
				<table>
					<tr>
						<td>Désigation :</td>
						<td><form:outputText path=""/></td>
					</tr>
					<tr>
						<td>Prix :</td>
						<td><form:outputText path=""/></td>
					</tr>
					<tr>
						<td><input type="text" name="quantité"></td>
						<td><input type="submit" name="ajouterAuPanier"></td>
					</tr>
				</table>
			</div>
		</c:forEach>
		
	</section>

	<footer>
		<h1>FOOTER</h1>
	</footer>




</body>
</html>