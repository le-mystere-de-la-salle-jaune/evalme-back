<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/4.1.1/css/bootstrap.css" />
</head>
<body>
	<table class="table">
		<thead class="thead-dark">
		<tr>
		<th>Libelle</th>
		<th>description</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeOptionSondage}" var="optionSondage">
			<tr>
				<td>${optionSondage.libelle}</td>
				<td>${optionSondage.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>