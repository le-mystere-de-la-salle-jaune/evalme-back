<%-- pas besoin de définir une action, celle par défaut convient --%>
<form:form method="post" modelAttribute="client">
    <table>
        <tr>
            <td>Nom</td>
            <td><form:input path="nom" /></td>
        </tr>
        <tr>
            <td>Prenom</td>
            <td><form:input path="prenom" /></td>
        </tr>
    </table>
</form:form>