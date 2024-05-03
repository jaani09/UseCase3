<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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

<jsp:useBean id="dto" class="in.co.rays.product.ProductDTO"
		scope="request"></jsp:useBean>
	<form action="ProductListCtl" method="post">
		<h1 align="center">Product List</h1>
		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
			int index = 1;
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
		<h3 align="center" style="color: red"><%=msg%></h3>
		<%
			}
		%>
		&nbsp;&nbsp;&nbsp;
		<table align="center">

			<tr>
				<td> Name :
				</th>
				<td><input type="text" name="name"> <input
					type="submit" name="operation" value="search"></td>
			</tr>

			<%-- <tr>
				<th>Reportingdate</th>
				<td><select name="id">
						<option>--------select---------</option>
						<%
							Iterator it1 = list.iterator();
							while (it1.hasNext()) {
								ProgressDTO d = (ProgressDTO) it1.next();
						%>
						<option value="<%=d.getId()%>"><%=d.getReportingDate()%></option>
						<%
							}
						%> --%>
				</select></td>
				<!-- <td><input type="submit" name="operation" value="Search"></td> -->
			</tr>

		</table>
		&nbsp;
		<table align="center" width="100%" cellpadding=7px border="2">
			<tr align="center" bgcolor="gray">
				<th>Select</th>
				<th>S.NO</th>
				<th>Name</th>
				<th>Date</th>
				<th>Prize</th>
				<th>Address</th>
				<th>Edit</th>

			</tr>
			<%
				while (it.hasNext()) {
				  dto = (ProductDTO)it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getDate()%></td>
				<td><%=dto.getPrize()%></td>
				<td><%=dto.getAddress()%></td>
				<td><a href="ProductCtl?id=<%=dto.getId()%>">[edit]</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table align="center">
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="delete"></td>
				<th></th>
				<!-- <td><input type="submit" name="operation" value="new"></td>
				<td><input type="reset"></td> -->
			</tr>
		</table>

	</form>

</body>
</html>