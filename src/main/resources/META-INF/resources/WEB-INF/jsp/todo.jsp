<%@include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <br>
    <c:choose>
        <c:when test="${request == 'delete'}"><h3>Update Todo to the List</h3></c:when>
        <c:otherwise><h3>Add New Todo to the List</h3></c:otherwise>
    </c:choose>
    <hr>
    <%--@elvariable id="todo" type="Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <form:input type="number" name="id" hidden="true" path="id" />
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" name="description" required="required"  path="description"/>
            <br>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" name="targetDate" required="required"  path="targetDate"/>
            <br>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="text" name="done" hidden="true" path="done"/>

        <input type="submit" class="btn btn-success">
    </form:form>
</div>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        startDate: '-3d'
    });
</script>