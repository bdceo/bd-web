<%@ page import="java.util.*"%>
<%@ page import="com.bdsoft.web2p0.ch18.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<script type="text/javascript" language="javascript" src="js/ajax.js"></script>
		<script type="text/javascript" language="javascript" src="js/cart.js"></script>
		<title>JSP Ajax实例</title>
	</head>
	<body>
		<div style="float: left;">
			<h2>
				目录
			</h2>
			<table border="1">
				<thead>
					<th>
						商品
					</th>
					<th>
						描述
					</th>
					<th>
						价格
					</th>
					<th>
						数量
					</th>
					<th></th>
				</thead>
				<tbody>
					<%
						for (Iterator I = new Catalog().getAllItems().iterator(); I
								.hasNext();) {
							Item item = (Item) I.next();
					%>
					<tr>
						<td><%=item.getName()%></td>
						<td><%=item.getDescription()%></td>
						<td><%=item.getFormattedPrice()%></td>
						<td>
							<input type="text" style="width: 30px;" value="1"
								id='<%=item.getCode()%>' />
						</td>
						<td>
							<button onclick="addToCart('<%=item.getCode()%>')">
								添加到购物车
							</button>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div style="width: 30px; float: left;">
			&nbsp;
		</div>
		<div style="float: left;">
			<h2>
				购物车
			</h2>
			<table border="1">
				<thead>
					<th>
						商品
					</th>
					<th>
						数量
					</th>
					<th></th>
				</thead>
				<tbody id="cartTbody">
				</tbody>
			</table>
			总价格:
			<span id="total">￥0</span>
		</div>
	</body>
</html>
