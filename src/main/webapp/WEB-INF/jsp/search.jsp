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
		style="width: 900px; margin: 0px auto;  text-align: center;margin-top:30px">
		 <c:if test="${empty requestScope.pagemsg}">
			没有任何用户信息！
		</c:if>
		<c:if test="${!empty requestScope.pagemsg}">
		
		<table class="table table-striped table-bordered table-hover  table-condensed" style="width:900px;background-color:white;margin-bottom:0">
			  <thead style="background-color:#00CCFF">
							<tr>
								<td style="width:200px;text-align:center;vertical-align:middle">名称</td>
								<td style="width:200px;text-align:center;vertical-align:middle">面积</td>
								<td style="width:200px;text-align:center;vertical-align:middle">房屋类型</td>
								<td style="width:200px;text-align:center;vertical-align:middle">租售方式</td>
								<td style="width:200px;text-align:center;vertical-align:middle">价格</td>
								<td style="width:200px;text-align:center;vertical-align:middle">支付方式</td>
								<td style="width:200px;text-align:center;vertical-align:middle">地址</td>
								<td style="width:200px;text-align:center;vertical-align:middle">距离</td>
								<td style="width:200px;text-align:center;vertical-align:middle">评分</td>
							</tr>
			</thead>
			<c:forEach items="${requestScope.pagemsg.lists}" var="c">
							<tr>
								<td style="width:200px;text-align:center;vertical-align:middle"><a href="${c.url}" target="_blank" style="text-decoration:none;color:black">${c.name}</a></td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.area}平</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.houseType}</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.rentWay}</td>
								<td style="width:200px;text-align:center;vertical-align:middle">￥${c.price}</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.paymentMethod}</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.address}</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.distance}千米</td>
								<td style="width:200px;text-align:center;vertical-align:middle">${c.score}</td>
							</tr>
			</c:forEach>		
		</table>	
	</c:if>
	
	<div style="margin:0 auto;width:900px;height:50px;text-align:center">
		<div style="float:left;height:50px;text-align:center;padding-top:17px">
			<span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
			<span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
		</div>
		<div style="float:right;margin-top:0;width:500px;height:50px;">
			<nav aria-label="Page navigation" style="height:50px;float:right">
				  <ul class="pagination" style="margin:8px 0">
					    <li>
						      <c:if test="${requestScope.pagemsg.currPage != 1}">
							      	<a href="${pageContext.request.contextPath }/mainPage?city=${requestScope.city}&currentPage=1&rentWay=${requestScope.rentWay}" aria-label="Previous">
								        <span aria-hidden="true">首页</span> </a>
							   </c:if>
					    </li>
					    <li>
					   		 <c:if test="${requestScope.pagemsg.currPage != 1}">
					   				 <a href="${pageContext.request.contextPath }/mainPage?city=${requestScope.city}&currentPage=${requestScope.pagemsg.currPage-1}&rentWay=${requestScope.rentWay}">上一页</a>
					   		</c:if>
					    </li>
					    <li>
							    <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
							  		  <a href="${pageContext.request.contextPath }/mainPage?city=${requestScope.city}&currentPage=${requestScope.pagemsg.currPage+1}&rentWay=${requestScope.rentWay}">下一页</a>
							    </c:if>
					    </li>
					    <li>
					    		<c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
								      <a href="${pageContext.request.contextPath }/mainPage?city=${requestScope.city}&currentPage=${requestScope.pagemsg.totalPage}&rentWay=${requestScope.rentWay}" aria-label="Next">
								        <span aria-hidden="true">尾页</span> </a>
						      </c:if>
					    </li>
				  </ul>
			</nav>
		</div>
	</div>
	
	<div style="margin:0 auto;width:900px;height:50px;text-align:center">
	
		<a href="${pageContext.request.contextPath }/showMap?rentWay=${requestScope.rentWay}">
			<button type="button" class="btn btn-default">高德地图</button>
		</a>
		<a href="${pageContext.request.contextPath }/welcomePro">
			<button type="button" class="btn btn-default">返回首页</button>
		</a>
	</div>
	
</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>