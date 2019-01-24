<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

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

	<a class="btn btn-dark" style="float: right; margin-right: 30px" href="${pageContext.request.contextPath}/index.jsp">Page d'accueil</a>

	<div
		style="border: 1px black; width: 45%; text-align: left; margin-left: 600px;">

		<!-- affichage du message de déconnexion -->
		<c:if test="${not empty param.logout_message}">
			<font color="red"> Déconnexion réussie <br />
			</font>
		</c:if>

		<!-- affichage des erreurs de connexion avec l'attribut de session de spring security SPRING_SECURITY_LAST_EXCEPTION  -->
		<c:if test="${not empty param.error}">
			<font color="red"> Login error. <br /> Reason:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</font>
			
		</c:if>


		<!-- L'url effectuant l'authentification -->
		<c:url value="login" var="loginUrl" />

		<!-- formulaire -->
		<form action="${loginUrl}" method="post">

			<table>
				<tr>
					<td align="right">Username:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						name="Login" /> <input type="reset" name="Reset" /></td>
				</tr>

			</table>

		</form>
	
		<c:if test="${not empty param.logout_message}">
			<font color="red">
			</font>
		</c:if>

	</div>

	<jsp:include page="/footer.jsp" />

</body>
</html>