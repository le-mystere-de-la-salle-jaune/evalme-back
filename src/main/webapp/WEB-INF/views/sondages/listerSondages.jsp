<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${listeSondages}" var="sondage">
			<li>${sondage.titre}</li>
		</c:forEach>
		</ul>
	</body>
</html>