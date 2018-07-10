<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${listeClasse}" var="classe">
			<li>${classe.nom}</li>
		</c:forEach>
		</ul>
	</body>
</html>