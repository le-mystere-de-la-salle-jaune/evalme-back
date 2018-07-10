<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${ listeQuestions}" var="qu">
			<li>${ qu.titre }
			<c:forEach items="${ qu.options }" var="rep">
			<br>-${ rep.libelle }
			</c:forEach></li>
		</c:forEach>
		</ul>
	</body>
</html>