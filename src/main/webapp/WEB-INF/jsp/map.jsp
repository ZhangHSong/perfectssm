<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="initial-scale=1.0, user-scalable=no, width=device-width">
<title>自适应显示多个点标记</title>
<link rel="stylesheet"
	href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<style>
html, body, #container {
	height: 100%;
	width: 100%;
}

.amap-icon img {
	width: 25px;
	height: 34px;
}

#container {
	width: 70%;
	height: 75%;
	margin: 0 auto;
	margin-top: 10px;
}

.custom-content-marker {
	position: relative;
	width: 25px;
	height: 34px;
}

.custom-content-marker img {
	width: 100%;
	height: 100%;
}

.custom-content-marker .close-btn {
	position: absolute;
	top: -6px;
	right: -8px;
	width: 15px;
	height: 15px;
	font-size: 12px;
	background: #ccc;
	border-radius: 50%;
	color: #fff;
	text-align: center;
	line-height: 15px;
	box-shadow: -1px 1px 1px rgba(10, 10, 10, .2);
}

.custom-content-marker .close-btn:hover {
	background: #666;
}

.b {
	position: absolute;
	z-index: 2;
	left: 5px;
	top: 2px
}

.custom-content-marker {
	position: relative;
}
</style>
<base target="_blank">
</head>
<body>
		<div id="container"></div>
		<div
			style="margin: 10px auto; width: 900px; height: 50px; text-align: center">
			<a
				href="${pageContext.request.contextPath }/mainPage?city=${requestScope.city}&location=${requestScope.location}&currentPage=1&rentWay=${requestScope.rentWay}">
				<button type="button" class="btn btn-default">数据表格</button>
			</a> <a href="${pageContext.request.contextPath }/welcomePro">
				<button type="button" class="btn btn-default">返回首页</button>
			</a>
		</div>
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script
			src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="https://webapi.amap.com/maps?v=1.4.14&key=59f8184c1ace09d8dfa3e2fc9cadf12c"></script>
		<script type="text/javascript">
					var markers = ${requestScope.jsonData};
					var self = ${requestScope.jsonSelf};
					var map = new AMap.Map('container', {
						resizeEnable : true,
						center: [self[0], self[1] ],//中心点
						zoom : 13
					});
					map.clearMap(); // 清除地图覆盖物
				    // 创建一个 Icon
				    var startIcon = new AMap.Icon({
				        // 图标尺寸
				        size: new AMap.Size(25, 34),
				        // 图标的取图地址
				        image: '//a.amap.com/jsapi_demos/static/demo-center/icons/dir-marker.png',
				        // 图标所用图片大小
				        imageSize: new AMap.Size(135, 40),
				        // 图标取图偏移量
				        imageOffset: new AMap.Pixel(-9, -3)
				    });
					 var markerSelf = new AMap.Marker({
							map : map,
							// 将 html 传给 content
					       // content: markerContentSelf,
					        icon: startIcon,
							position : [ self[0], self[1] ],
							offset : new AMap.Pixel(-13, -30)
						});
					map.add(markerSelf);
					for(var i =0;i<markers.length;i++){
						var row = markers[i].position[0];
						var col = markers[i].position[1];
						// 点标记显示内容，HTML要素字符串
				        var markerContent=
				        	'' +
				        '<div class="custom-content-marker"  onclick="javascript:window.open(\''+markers[i].url+'\',\'_blank\');">' +																		
				        '   <img  src= "//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png" >'+
				        '   <div class="b" >'+markers[i].score+'</div>' +
				        '</div>';
				        var marker = new AMap.Marker({
							map : map,
							// 将 html 传给 content
					        content: markerContent,
							position : [ row, col ],
							offset : new AMap.Pixel(-13, -30)
						});
				       map.add(marker);
					}
		</script>
</body>
</html>