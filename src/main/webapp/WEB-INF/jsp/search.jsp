<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<title>SerachRight</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: rgb(238, 238, 238);
}
</style>
</head>

<body>
	<div id="magictable"
		style="width: 500px; margin: 0px auto;  text-align: center">
		 <c:if test="${empty requestScope.pagemsg}">
			没有任何用户信息！
		</c:if>
		<c:if test="${!empty requestScope.pagemsg}">
			<table border="1" cellpadding="10" cellspacing="0" class="table1">
			<thead>
				<tr>
					<td>名称</td>
					<td>面积</td>
					<td>房屋类型</td>
					<td>租售方式</td>
					<td>价格</td>
					<td>支付方式</td>
					<td>地址</td>
					<td>评分</td>
				</tr>
			</thead>
			<c:forEach items="${requestScope.pagemsg.lists}" var="c">
				<tr>
					<td>${c.name}</td>
					<td>${c.area}</td>
					<td>${c.houseType}</td>
					<td>${c.rentWay}</td>
					<td>${c.price}</td>
					<td>${c.paymentMethod}</td>
					<td>${c.address}</td>
					<td>${c.score}</td>
				</tr>
			</c:forEach>		
		</table>	
	</c:if>
	<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
		<tr>
			<td class="td2">
			
			   <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
			   <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
			   <span>
			       <c:if test="${requestScope.pagemsg.currPage != 1}">
			           <a href="${pageContext.request.contextPath }/main?city=${requestScope.city}&currentPage=1">[首页]</a>&nbsp;&nbsp;
			           <a href="${pageContext.request.contextPath }/main?city=${requestScope.city}&currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
			       </c:if>
			       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
			           <a href="${pageContext.request.contextPath }/main?city=${requestScope.city}&currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
			           <a href="${pageContext.request.contextPath }/main?city=${requestScope.city}&currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
			       </c:if>
			   </span>
			</td>
		</tr>
	</table>
</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>