<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="list-group">
	<c:forEach items="${listeDuels}" var="duel">
		<a href="edit?id=${duel.id}"
			class="list-group-item list-group-item-action"> ${duel.id} -
			${duel.stagiaireA.nom} vs. ${duel.stagiaireB.nom} dans
			"${duel.quizz.titre}" </a>
		<br />
	</c:forEach>
</div>