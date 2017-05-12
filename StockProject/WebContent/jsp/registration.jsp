<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style>
   <%@include file='/css/indexStyle.css' %>
</style>

</head>
<body>
	<div id="header">
		<div id="logo">
			<a href="/StockProject/index.jsp"><h2>STOCK</h2></a>
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
			<form action="/StockProject/accounts" method="post" enctype="application/x-www-form-urlencoded">
				<input type="text" name="login" required placeholder="input login">
				</br>
				<input type="text" name="email" required placeholder="input E-mail">
				</br>
				<input type="password" name="pass" required placeholder="input pass">
				</br>
				<input type="text" name="phone" required placeholder="input Your phone">
				</br>
				<input type="text" name="address" placeholder="input Your address">
				</br>
				<input type="hidden" name="action" value="createAcc">
				<input class="input-btn" type="submit" value="submit">
			</form>
		</div>

</body>
</html>