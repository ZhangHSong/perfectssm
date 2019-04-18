<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<title>SerachRight</title>

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
	width: 300px;
	height: 30px;
	padding: 0px 0px 0px 5px;
	font-size: 16px;
}
</style>

</head>

<body>
	<div class="jumbotron">
		<div class="container" align="center">
			<h1>欢迎来到SerachRight</h1>
			<p>是否厌倦了百度的广告，来试试我们吧!</p>
			<div>
				<form class="navbar-form navbar-left searchform" action="main" method="post">
					<input type="text" class="search_text" name="city"	placeholder="请输入城市...">
					<input type="hidden" name="currentPage" value="1"/>
					<button type="submit" class="btn11" id="searchright">GO!</button>
				</form>
			</div>
			
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>