<%-- pas besoin de d�finir une action, celle par d�faut convient --%>
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