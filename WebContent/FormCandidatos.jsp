<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Elecciones UFPS</title>
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Elecciones UFPS</a>
			</div>
			<ul class="navbar-nav">
				<li> <a href="<%=request.getContextPath() %>/list" class="nav-link">Candidatos</a></li>
				<li> <a href="<%=request.getContextPath() %>/list" class="nav-link">Eleccion</a></li>
			</ul>
		</nav>	
	</header>
	
	<br/>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de candidatos</h3>	
			<br>
			
			<div class="container text-left">
			 	<a href="<%=request.getContextPath() %>/new" class="btn btn-success">Agregar Nuevo candidato</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr> 
						<th>ID</th>
						<th>Nombre </th>
						<th>Apellido</th>
						<th>Documento</th>
						<th>Numero</th>
					</tr>
				</thead>
			    <tbody>
                   <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="candidato" items="${listCandidatos}">
                                <tr>
                                    <td>
                                        <c:out value="${candidato.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.apellido}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.documento}" />
                                    </td>
                                    
                                    <td>
                                        <c:out value="${candidato.numero}" />
                                    </td>
                                    
                                    <td><a href="edit?id=<c:out value='${candidato.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${candidato.id}' />">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>
			</table>	
		</div>
	</div>
</body>
</html>