 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Comment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
            <div>
                <a href="https://www.sts.net" class="navbar-brand"> Emp Management Application </a>
            </div>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">Add Comment</h3>
            <hr>
            <form method="post" action="comment">
                <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                <div class="form-group">
                    <label for="comment">Comment:</label>
                    <textarea name="comment" id="comment" rows="4" cols="50"></textarea>
                </div>
                <div class="form-group form-button">
                    <input type="submit" name="submit" id="submit" class="form-submit btn btn-primary" value="Submit" />
                </div>
            </form>
        </div>
    </div>

</body>
</html>
