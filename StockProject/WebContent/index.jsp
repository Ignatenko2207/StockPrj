<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stock</title>
<style>
   <%@include file='/css/indexStyle.css' %>
</style>

</head>
<body>
	<div id="header">
		<div id="logo">
			<a href="index.jsp"><h2>STOCK</h2></a>
		</div>
		<div id="regBtn">
			<a class="input-btn" href="/StockProject/jsp/registration.jsp">registration</a>
		</div>
		<div id="logBtn">
			<a class="input-btn" href="/StockProject/jsp/authorisation.jsp">authorisation</a>
		</div>
	</div>

	<div id="content">
		<div id="filter-block">
			<form >
				<input type="text" name="group">
				<input type="text" name="maker">
				<input type="text" name="code" placeholder="Choose maker before">
				<input type="text" name="sizel">
				<input type="text" name="sizeh">
				<input type="text" name="sizew">
				<input type="text" name="minprice">
				<input type="text" name="maxprice">
				<input class="input-btn" type="submit" value="find goods">
			</form>
		</div>
		
		
		
		
		
		<div id="goods-list">
			<table>
				<tr>
					<th>name</th>
					<th>group</th>
					<th>maker</th>
					<th>code</th>
					<th>price</th>
					<th>size L</th>
					<th>size H</th>
					<th>size W</th>
					<th>discription</th>
					<th>owner</th>
				</tr>

				<tr>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>name</td>
					<td>
						<a href="#"></a>
					
					
					</td>
				</tr>
			
			</table>
		</div>
	</div>




</body>
</html>