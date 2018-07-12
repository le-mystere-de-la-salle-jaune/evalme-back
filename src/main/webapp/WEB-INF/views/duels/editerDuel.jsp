<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty erreurDoublons}">
	<c:set var="isInvalidClass" value="is-invalid" />
</c:if>

<!doctype html>
<html>
<head>
<title>Duels - Editer</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>Editer un duel</h1>
		<form:form method="post" modelAttribute="duel">
			<div class="form-row">
				<div class="col">
					<label for="stagiaireASelect">Stagiaire A</label>
					<form:select id="stagiaireASelect" class="form-control ${isInvalidClass}"
						path="stagiaireA.id" items="${listeStagiaires}" itemLabel="nom"
						itemValue="id" required="required" />
					<c:if test="${not empty erreurDoublons}">
						<div class="invalid-feedback">Les participants doivent être des
							stagiaires différents.</div>
					</c:if>
				</div>
				<div class="col">
					<label for="stagiaireBSelect">Stagiaire B</label>
					<form:select id="stagiaireBSelect" class="form-control ${isInvalidClass}"
						path="stagiaireB.id" items="${listeStagiaires}" itemLabel="nom"
						itemValue="id" required="required" />
				</div>
			</div>
			<br />
			<div class="form-row">
				<div class="col">
					<label for="quizzSelect">Quizz</label>
					<form:select id="quizzSelect" class="form-control" path="quizz.id"
						items="${listeQuizzes}" itemLabel="titre" itemValue="id"
						required="required" />
				</div>
			</div>
			<br />
			<button type="submit" class="btn btn-primary mr-2">Mettre à jour</button>
			<a href='<c:url value="/duels/lister" />' class="btn btn-secondary mr-2">Retour
				à la liste</a>
		</form:form>
		<form action="/duels/supprimer" method="post" id="supprimerDuelForm">
			<button type="submit" class="btn btn-danger float-right">Supprimer</button>
		</form>



	</div>
</body>
</html>