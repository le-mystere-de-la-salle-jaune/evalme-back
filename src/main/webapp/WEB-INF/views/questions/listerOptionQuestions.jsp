<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
	<title>Test</title>
		<link rel="stylesheet" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">
	</head>
	<body>
		<ul>
		<c:forEach items="${ listeOptionQuestions}" var="oq">
			<li>${ oq.libelle } -> ${oq.ok} </li>
		</c:forEach>
		</ul>
	</body>
</html>