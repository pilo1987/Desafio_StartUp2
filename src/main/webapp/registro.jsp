<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Startup</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

    <div class="container p-3">
		<form method="post" action="RegistroController">
		<h2>Registro</h2>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					</label> <input type="email" name="correo" class="form-control"
					required>
				<div id="emailHelp" class="form-text"></div>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nick</label> <input
					type="text" name="nick" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nombre</label> <input
					type="text" name="nombre" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputNumber1" class="form-label">Peso</label> <input
					type="number" name="peso" class="form-control" required>
			</div>

			<h2>Dirección</h2>
			<div class="mb-3">
				<label for="exampleInputText1" class="form-label">Nombre</label> <input
					type="text" name="direccion" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputText2" class="form-label">Numeración</label>
				<input type="text" name="numeracion" class="form-control" required>
			</div>
			
			<h2>Rol</h2>
			<div class="mb-3">
            <label for="exampleSelect" class="form-label"></label>
            <select id="exampleSelect" class="form-select">
                <option selected>Selecciona...</option>
                <option value="${roles.getId()}">Id</option>
                <option value="${roles.getNombre()}">Nombre</option>
            </select>
        </div>
		</form>
		<button type="submit" class="btn btn-primary">Submit</button>
<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
</body>
</html>
