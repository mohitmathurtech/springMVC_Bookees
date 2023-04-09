<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>bookees</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <style>
    p{
        color: white;
        background-color: black;
        padding: 10px;
    }

    .heading {
        padding: 15px;
        font-size: 50px;
        background-color: #f2f2f2  ;
        color:black;
    }
    </style>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
        	    <a class="navbar-brand" href="#">TMS</a>
        		<button class="navbar-toggler" type="button"
        		    data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        			aria-controls="navbarSupportedContent" aria-expanded="false"
        			aria-label="Toggle navigation">
        			<span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
        		    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        			<li class="nav-item"><a class="nav-link active"
        			        aria-current="page" href="index.jsp">Home</a></li>
                        <%
        					String id = (String) session.getAttribute("email");
        					if(id == null) {
        				%>
        					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
        					<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
        				<% } else { %>
        					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
        					</li>
        				<% } %>
        				</ul>
                </div>
        	</div>
        </nav>

            <h1 class='text-center heading'>Bookees</h1>

        <div class="container">

        		<table class="table">
        			<thead>
        				<tr>
        					<th scope="col">Book Name</th>
        					<th scope="col">Book Genre</th>
        					<th scope="col">Author</th>
        				</tr>
        			</thead>
        			<tbody>
        				<c:forEach items="${books }" var="book">
        					<tr>
        						<td>${book.b_name }</td>
        						<td>${book.genre }</td>
        						<td>${book.author }</td>
        					</tr>
        				</c:forEach>


        			</tbody>
        		</table>
        	</div>
    </body>
</html>
