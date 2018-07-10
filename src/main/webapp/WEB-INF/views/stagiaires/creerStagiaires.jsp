<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Evalme App</title>
</head>

<body>
	<div class="container-fluid">
		<h1>Nouveau stagiaire</h1>
		<form:form modelAttribute="stagiaire">
			<div class="form-group row justify-center">
				<label for="inputName" class="col-md-3 col-form-label">Nom</label>
				<div class="col-sm-8">
					<form:input path="nom" />
					<form:errors path="nom">Le nom est obligatoire</form:errors>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputFirstname" class="col-md-3 col-form-label">Prénom</label>
				<div class="col-sm-8">
					<form:input path="prenom" />
					<form:errors path="prenom">Le prénom est obligatoire</form:errors>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputBd" class="col-md-3 col-form-label">Email</label>
				<div class="col-sm-8">
					<form:input path="email" />
					<form:errors path="email">L'email est obligatoire</form:errors>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputNumber" class="col-md-3 col-form-label">Photo</label>
				<div class="col-sm-8">
					<form:input path="photoUrl" />
					<form:errors path="photoUrl">La photo est obligatoire</form:errors>
				</div>
			</div>
			<div class="row justify-content-end">
				<div class="col-2">
					<button type="submit" class="btn-create btn-primary">Créer</button>
				</div>
			</div>
		</form:form>

	</div>


</body>
	</html>