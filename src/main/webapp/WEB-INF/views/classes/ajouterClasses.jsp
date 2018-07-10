<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>

<body>

	<h1 style="text-align: center;">Bienvenue sur la page d'ajout d'une classe.</h1>
	<br/><br/>
	<div class="row">
		<form id="formulaireClasse" name="formulaireClasse" class="col-12 col-sm-8 offset-sm-2">
			<div>
				<fieldset style="margin-bottom: 15px; padding: 10px;border: 3px dotted #999;">
					<legend style="text-align: center;">Nom de la classe</legend>
					<label id="labelName" name="labelName">Veuillez entrer le nom de votre classe : </label>
					<input id="inputName" name="inputName" placeholder="Nom de la classe" required class="col-12 col-sm-4 offset-sm-4">			
				</fieldset>
			</div>
		
	</div>
	<div class="row">
			<div class="col-12 col-sm-8 offset-sm-2">
				<fieldset style="margin-bottom: 15px; padding: 10px;border: 3px dotted #999;">
					<legend style="text-align: center;">Liste des stagiaires</legend>
					<label id="labelStagiaire" name="labelStagiaire">Veuillez sélectionner les stagiaires qui constituent cette classe : </label>
				</fieldset>
			</div>
		</form>
	</div>

	<!-- jQuery first, then poper, then Bootstrap JS. -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>

</html>