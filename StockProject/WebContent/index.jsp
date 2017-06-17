<%@page import="java.util.ArrayList"%>
<%@page import="privateOrder.domain.Good"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stock</title>
<style>
   <%@include file='/css/bootstrap.css' %>
</style>

</head>
<body>
	<div class="header">
		<div id="logo">
			<a href="index.jsp"><h2>STOCK</h2></a>
		</div>
		
		
		<div id="reg-or-auth">
			<ul class="nav nav-list">
				<li><a class="input-btn" href="/StockProject/jsp/registration.jsp">registration</a></li>
				<li><a class="input-btn" href="/StockProject/jsp/authorisation.jsp">authorisation</a></li>
			</ul>
		</div>
	</div>

	<div class="panel">
		<div id="filter-block">
			<form action="/StockProject/goods" method = "POST" class="form-inline">
				<input class="input-small" type="text" name="group" placeholder="Group of goods">
				<input size="30"class="input-small" type="text" name="maker" placeholder="Choose maker">
				<input class="input-small" type="text" name="code" placeholder="Color">
				<input size="10" class="input-small" type="text" name="sizel" placeholder="Size L">
				<input size="10" class="input-small" type="text" name="sizeh" placeholder="Size H">
				<input size="10" class="input-small" type="text" name="sizew" placeholder="Size W">
				<input size="15" class="input-small" type="text" name="minprice" placeholder="Lower price">
				<input size="15" class="input-small" type="text" name="maxprice" placeholder="Higher price">
				<button type="submit" class="btn">Find goods</button>
			</form>
		</div>
		
		
		<jsp:useBean id="goodsListBean" scope="request" class="privateOrder.beans.GoodsListBean" />
		<% 
		String filtr = (String)session.getAttribute("filtr");
		ArrayList<Good> goods = new ArrayList();
		
		if(filtr != null & !filtr.isEmpty()){
			goods = goodsListBean.getGoodsWithFiltr(filtr);
		} else{
			goods = goodsListBean.getGoodsForStartPage();
		}
		
		%>
		
		<div id="goods-list">
			<table class="table table-bordered">
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

				
				
				<%
				for(Good good: goods){
					%>
					<tr>
					<td><%=good.name%></td>
					<td><%=good.group%></td>
					<td><%=good.maker%></td>
					<td><%=good.code%></td>
					<td><%=good.price%></td>
					<td><%=good.sizeL%></td>
					<td><%=good.sizeH%></td>
					<td><%=good.sizeW%></td>
					<td><%=good.description%></td>
					<td><a href="#"><%=good.accOwner%></a></td>
					</tr>
					<%
				}	
				%>
				
			</table>
		</div>
	</div>




</body>
</html>