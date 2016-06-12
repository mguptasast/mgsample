<%@page import="com.beans.RegistrationBean;"%>

<html>
	<body>
		<h1>
			<%= "Hi " + ((RegistrationBean)request.getAttribute("registrationBean")).getName() %>
		</h1>
	</body>
</html>