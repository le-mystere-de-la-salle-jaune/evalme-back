<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	
	</head>
	<body>
		<ul>
		<c:forEach items="${listeQuizz}" var="quizz">
			<li>${quizz.titre}</li>
		</c:forEach>
		</ul>
	</body>
</html>