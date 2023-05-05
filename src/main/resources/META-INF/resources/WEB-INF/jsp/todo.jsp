<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Add Todo</title>
</head>

<body>
<div class="container">
    <br>
    <h3>Welcome ${name}</h3>
    <div>Add New Todo to List</div>
    <%--@elvariable id="todo" type="Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <form:input type="number" name="id" hidden="true" path="id" />
        Description: <form:input type="text" name="description" required="required"  path="description"/>
        <form:input type="text" name="done" hidden="true" path="done"/>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>