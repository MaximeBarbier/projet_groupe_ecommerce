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

	<header>
		<h1>HEADER</h1>
	</header>


	<section style="border: 1px black;" >
	
		<div style="border: 1px black; width: 20%; text-align: center; float: left;">
			<nav>
               <ul>
                   <li>Menu</li>
                   <li><a href="produits....">Produits</a></li>
                   <li><a href="categories...">Categories</a></li>
               </ul>
            </nav>
		</div>
	
		<div style="border: 1px black; width: 75%; text-align: center; float: left;">
			<form:form method="post" modelAttribute="">
				<table>
					<tr>
						<td> ID Categorie :</td>
						<td><form:hidden  path="" /></td>
					</tr>					
					<tr>
						<td>Nom Categorie :</td>
						<td><form:input path=""/></td>
					</tr>					
					<tr>
						<td>Description :</td>
						<td><form:textarea path=""/></td>
					</tr>					
					<tr>
						<td>Photo :</td>
						<td><input type="file"/> Choisir photo</td>
					</tr>					
					<tr>
						<td colspan="2" > <input type="submit" value="post">Enregistrer</td>
					</tr>
				</table>
			</form:form>
		</div>
		
		<div>
			<table cellspacing="0" cellpadding="6" border="1" width="50%">
				<tr>
					<th>ID</th>
					<th>NOM CAT</th>
					<th>Description</th>
					<th>Photo</th>
					<th></th>
					<th></th>
				</tr>
				
				<c:forEach items="${........}" var="cat">
					<tr>
						<td>${cat. }</td>
						<td>${ }</td>
						<td>${ }</td>
						<td>${ }</td>
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
		
		
	</section>

	<footer>
		<h1>FOOTER</h1>
	</footer>





</body>
</html>