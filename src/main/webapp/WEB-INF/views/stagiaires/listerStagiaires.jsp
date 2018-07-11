<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="/webjars/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Evalme App</title>
</head>
<body>

	<div class="container-fluid">
		<h1>Liste des stagiaires</h1>
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">Email</th>
					<th scope="col">Photo</th>
				</tr>
			</thead>
			
			<!-- JSTL itération sur la liste des stagiaires-->
			<c:forEach items="${listeStagiaires}" var="st">
				<tbody>
					<tr>
						<th>${st.nom}</th>
						<td>${st.prenom}</td>
						<td>${st.email}</td>
						<td><img src="${st.photoUrl}" alt="photo de profil" width="13%"></td>
						<td><button type="submit" class="btn-create btn btn-primary" onclick="window.location.href='<c:url value="/stagiaires/editer?id=${st.id}"/>'">Editer</button></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>

</html>