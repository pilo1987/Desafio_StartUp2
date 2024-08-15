<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link
	href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css"
	rel="stylesheet">
	
</head>
<body>


	<div class="container mt-4">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="display-4">Bienvenido !</h1>
			<a href="registro.jsp" class="btn btn-primary ms-auto"> Nuevo
				registro</a>
		</div>
		<table class="table" id="tblUsu">
			<thead class="table-dark ">
				<tr>
					<th>Id</th>
					<th>Email</th>
					<th>Nick</th>
					<th>Nombre</th>
					<th>Password</th>
					<th>Peso</th>
					<th>Creado</th>
					<th>Modificado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuarios" items="${usuarios}">
					<tr>
						<td><c:out value="${usuarios.getId()}"></c:out></td>
						<td><c:out value="${usuarios.getCorreo()}"></c:out></td>
						<td><c:out value="${usuarios.getNick()}"></c:out></td>
						<td><c:out value="${usuarios.getNombre()}"></c:out></td>
						<td><c:out value="${usuarios.getPassword()}"></c:out></td>
						<td><c:out value="${usuarios.getPeso()}"></c:out></td>
						<td><c:out value="${usuarios.getCreate_at()}"></c:out></td>
						<td><c:out value="${usuarios.getUpdate_at()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
		
	<script src="https://cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>
	
	<script>
		$(document).ready(()=>{
			$('#tblUsu').DataTable();
		})
	</script>
	
	<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>
</body>
</html>