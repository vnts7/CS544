<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Book</title>
</head>

<body>

	<form method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" value="${en.title}" /> </td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><input type="text" name="ISBN" value="${en.ISBN}" /> </td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><input type="text" name="author" value="${en.author}" /> </td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" value="${en.price}" /> </td>
			</tr>
		</table>
		<input type="submit" />
	</form>
	<c:if test="${msg == 'Update'}">
		<form action="../delete?id=${en.id}" method="post">
			<button type="submit">Delete</button>
		</form>
	</c:if>
</body>

</html>