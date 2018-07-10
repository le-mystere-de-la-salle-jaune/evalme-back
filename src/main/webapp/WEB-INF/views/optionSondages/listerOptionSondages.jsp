<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${listeOptionSondage}" var="optionSondage">
			<li>${optionSondage.libelle}</li>
		</c:forEach>
		</ul>
	</body>
</html>