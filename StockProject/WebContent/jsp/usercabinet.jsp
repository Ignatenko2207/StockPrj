<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorisation</title>
<style>
 <%@include file='/css/indexStyle.css' %>
</style>

</head>
<body>
	<div id="header">
		<div id="logo">
			<a href="/StockProject/index.jsp"><h2>STOCK</h2></a>
		</div>
		<div id="logBtn">
			<a class="input-btn" href="/StockProject/index.jsp">Log out</a>
		</div>
	</div>

	<div id="content">
		<div id="filter-block">
			<h2>Congratulation!!! You are logged in!</h2>
			<!-- 
			<form action="/StockProject/authorisation" method="post" enctype="application/x-www-form-urlencoded">
				<input type="text" name="login" required placeholder="input login">
				<input type="password" name="pass" required placeholder="input pass">
				
				<input class="input-btn" type="submit" value="submit">
			</form>
			 -->

		</div>
	</div>
</body>
</html>