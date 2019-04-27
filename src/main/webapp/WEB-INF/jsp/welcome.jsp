<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<title>SearchRight</title>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.jumbotron {
	position: absolute;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	margin-bottom: 0;
	padding-top: 200px;
}

.search_text {
	width: 100px;
	height: 30px;
	padding: 0px 0px 0px 5px;
	font-size: 16px;
}

.search_location {
	width: 250px;
	height: 30px;
	padding: 0px 0px 0px 5px;
	font-size: 16px;
}
</style>

</head>

<body>
	<div class="jumbotron">
		<div class="container" align="center">
			<h1>欢迎来到SearchRight</h1>
			<p>是否厌倦了百度的广告，来试试我们吧!</p>
			<div style="margin:0 auto;width:100%;height:50px;padding-left:260px">
				<form class="navbar-form navbar-left searchform" action="main" method="post" >
				
				<!-- 来源下拉框 -->
				 <div class="col-lg-2"  style="padding-right:35px">
				            <select class="form-control"   name="site"  onchange="selectOnchang(this)">
				                <option>安居客</option>
				                <option>链家</option>
				                <option>综合</option>
				            </select>
				 </div>
				
				
				<!-- 城市下拉框 -->
		        <div class="col-lg-2"  style="padding-left:22px">
		            <select class="form-control"   name="city"  onchange="selectOnchang(this)">
		                <option>合肥</option>
		                <option>北京</option>
		                <option>上海</option>
		                <option>广州</option>
		                <option>深圳</option>
		                <option>成都</option>
		                <option>南京</option>
		                <option>天津</option>
		                <option>杭州</option>
		                <option>武汉</option>
		            </select>
		        </div>

				<!-- 租赁方式下拉框 -->
				<div class="col-lg-2"  style="padding:0">
				            <select class="form-control"   name="rentWay" onchange="selectOnchang(this)">
				                <option>整租</option>
				                <option>合租</option>
				                <option>均可</option>
				            </select>
				 </div>
					   
			   <div class="col-lg-4"  style="padding:0">
   			    	<input type="text" class="form-control" placeholder="location"   name="location"  aria-describedby="basic-addon1">
			   </div>
			   
				<input type="hidden" name="currentPage" value="1"/>
				
				<div class="col-lg-1"  style="padding-left:10px">
					<button type="submit" class="btn btn-primary"  id="searchright">GO!</button>
				</div>
				
				</form>
			</div>
			
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>