<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>HTTP Status 403 - Access denied</h1>

	<s:authorize access="hasRole('ROLE_USER')">
		<h2>
			You do not have permission to perform this action
		</h2>
		
		<h4>
			Please login as an admin : <a href="<c:url value="/login.jsp"/>">Login</a>
		</h4>
		
	</s:authorize>

</body>
</html>