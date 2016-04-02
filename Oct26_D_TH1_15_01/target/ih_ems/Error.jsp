<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function errorAlert() {
		var message = $('#message').val();
		alert(message);
		window.location = "Home.html";
	}
</script>
</head>
<body>
	<%@ include file="Registration.html"%>
	<%String message = (String)request.getAttribute("message");%>
	<input type="hidden" value="<%=message%>" id="message"/>
	<script type="text/javascript">
		window.onload = errorAlert;
	</script>
</body>
</html>