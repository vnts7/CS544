<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>

<f:form modelAttribute="book">
    <table>
        <tr>
            <td>Title:</td>
            <td><f:input path="title"/></td>
            <td><f:errors path="title"/></td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td><f:input path="ISBN"/></td>
            <td><f:errors path="ISBN"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><f:input path="author"/></td>
            <td><f:errors path="author"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><f:input path="price"/></td>
            <td><f:errors path="price"/></td>
        </tr>

    </table>
    <input type="submit"/>
</f:form>
<c:if test="${msg == 'Update'}">
    <form action="../delete?id=${en.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</c:if>
</body>

</html>