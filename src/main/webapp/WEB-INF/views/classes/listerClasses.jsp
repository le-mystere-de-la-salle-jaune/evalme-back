<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${listeClasses}" var="c">
			<li>${c.nom}</li>
			<li>${c.stagiaires}</li>
		</c:forEach>
		</ul>
	</body>
</html>