<%@page import="in.co.rays.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductDTO dto = (ProductDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update Product</h1>
	<%
		} else {
	%>
	<h1 align="center">Add Product</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
	<form action="ProductCtl" method="post">
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
				&nbsp;	
			<tr>
				<th>Name :</th>
				<td><input type="text" name="name"
					value="<%=(dto != null) ? dto.getName() : ""%>"></td>
			</tr>
				&nbsp;
			<tr>
				<th>DATE :</th>
				<td><input type="text" name="date"
					value="<%=(dto != null) ? dto.getDate() : ""%>"></td>
			</tr>
				&nbsp;
			<tr>
				<th>Prize :</th>
				<td><input type="text" name="prize"
					value="<%=(dto != null) ? dto.getPrize(): ""%>"></td>
			</tr>
			
			&nbsp;
						<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=(dto != null) ? dto.getAddress() : ""%>"></td>
			</tr>
					<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>



</body>
</html>