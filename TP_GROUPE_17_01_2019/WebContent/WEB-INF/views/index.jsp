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


	<section style="border: 1px black;">
	
		<div style="border: 1px black; width: 20%; text-align: center; float: left;">
			<nav>
               <ul>
                   <li>Menu</li>
                   <li><a href="produits....">Produits</a></li>
                   <li><a href="categories...">Categories</a></li>
               </ul>
            </nav>
		</div>
	
		<!-- formulaire -->
		<div style="border: 1px black;">
			<form action="${loginUrl}" method="post">
			
				<table>
					<tr>
						<td align="right"> Login : </td>
						<td> <input type="text" name="userName"> </td>
					</tr>
					<tr>
						<td align="right"> Pass word : </td>
						<td> <input type="text" name="password"> </td>
					</tr>
					<tr>
						<td colspan="2" align="right"> 
						<input type="submit" name="Login">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</section>

	<footer>
		<h1>FOOTER</h1>
	</footer>




</body>
</html>