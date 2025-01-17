<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="border rounded p-4 shadow">
			<h2 class="text-center mb-4">Login</h2>
			<form action="LoginController" method="POST">
				<div class="mb-3 row">
					<label for="correo" class="col-sm-3 col-form-label">E-mail</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="correo"
							name="correo" placeholder="example@example.com" required>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="password" class="col-sm-3 col-form-label">Password</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="password"
						name= "password"
							placeholder="Enter your password" required>
					</div>
				</div>
				<button type="submit" class="btn btn-primary w-100">Login</button>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>