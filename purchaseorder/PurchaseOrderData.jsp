<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Order Details</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr {
	height: 30px;
}

a {
	color: blue;
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body>
	<h2 style="color: red; text-align: center">Purchase Orders Data Page</h2>
	<br>
	<center>
		<a href="#">Excel Export</a>|<a href="#">Pdf Export</a>
	</center>
	<table border="1" align="center" width="80%">
		<tr style="color: #ff4d4d;">
			<th>ID</th>
			<th>OrderCode</th>
			<th>Shipment Id</th>
			<th>VendorId</th>
			<th>Reference No</th>
			<th>Quantity Check</th>
			<th>status</th>
			<th>Description</th>
			<th colspan="2">Operations</th>
		</tr>
		<c:forEach items="${purchaseOrders}" var="po">
			<tr align="center">
				<td><c:out value="${po.poId}" /></td>
				<td><c:out value="${po.ordCode}" /></td>
				<td><c:out value="${po.shipment.id}" /></td>
				<td><c:out value="${po.vendor.id}" /></td>
				<td><c:out value="${po.refNo}" /></td>
				<td><c:out value="${po.qtyCheck}" /></td>
				<td><c:out value="${po.status}" /></td>
				<td><c:out value="${po.dsc}" /></td>
				<td><a href="delete?id=${po.poId}">Delete</a>
		<td><a href="edit?id=${po.poId}">Update</a>
		</tr>
		</c:forEach>

	</table>
	<br><br><center>${message}</center>
</body>
</html>