<%@ page import="java.util.*, com.simtekgamedevelopment.jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bigfoot Hunter App</title>
</head>

<%
  List<Hunter> hList = (List<Hunter>)request.getAttribute("HUNTER_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header" >
	        <h2 align="center">Bigfoot Hunters</h2>
		</div>
		<div id="container">
			<div id="content">
				<table border="2" align="center">
				<tr><th>First Name</th><th>Last Name</th><th>Email</th></tr>
				<% for (Hunter h : hList) { %>
					<tr>
						<td><%= h.getfName() %></td>
						<td><%= h.getlName() %></td>
						<td><%= h.getEmail() %></td>
					</tr>
				<% } %>		
				</table>
			</div>
		</div>
	
	</div> 

</body>

</html>