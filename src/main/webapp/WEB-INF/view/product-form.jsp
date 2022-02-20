<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="add-forms" modelAttribute="product">
    <br>
    <br>
    Product id: <form:input path="id" />
    <br>
    <br>
    Product Name: <form:input path="title" />
    <br>
    <br>
    Product Cost: <form:input path="cost" />
    <br>
    <br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>