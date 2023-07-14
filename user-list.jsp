<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
  .space {
    margin-left: 10px; 
  }
</style>
<script>
function confirmDelete() {
    return confirm("Are you sure you want to delete this emp?");
}
</script>
</head>
<body>

<%
  Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
  if (loggedIn == null || !loggedIn) {
    response.sendRedirect("user-list.jsp");
   
  }
%>

<header>
		<nav class="navbar navbar-expand-md navbar-dark"                       
			style="background-color: blue">
			<div>
				<a href="https://www.sts.net" class="navbar-brand"> Emp   
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Emps</a></li>
			</ul>
			 <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                <a href="login.jsp" class="nav-link">Sign Out</a>
            </li>
        </ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Age</th>
						<th>Comment</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.mobile}" /></td>
							<td><c:out value="${user.age}" /></td>
							<td><c:out value="${user.comment}" /></td>
							
							<td><a href="edit?id=<c:out value= '${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								
								 <a href="javascript:void(0);" onclick="if(confirmDelete()) window.location.href='delete?id=<c:out value='${user.id}' />';">Delete</a>
                            <span class="space"></span>	

					      <a href="comment.jsp?id=<c:out value='${user.id}' />">comment</a> 
					               &nbsp; 
					               
								 </td>
						</tr>
					</c:forEach>  
		
				</tbody>

			</table>
		</div>
	</div>
	

</body>
</html>
