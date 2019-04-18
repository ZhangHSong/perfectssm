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
<style>
html, body, #container {
	height: 100%;
	width: 100%;
}

.amap-icon img {
	width: 25px;
	height: 34px;
}
</style>
</head>
<body>
	<div id="container"></div>

	<script type="text/javascript"
		src="https://webapi.amap.com/maps?v=1.4.14&key=59f8184c1ace09d8dfa3e2fc9cadf12c"></script>
	<script type="text/javascript">
		var map = new AMap.Map('container', {
			resizeEnable : true,
			center : [ 116.397428, 39.90923 ],
			zoom : 13
		});

		map.clearMap(); // 清除地图覆盖物

		var markers = [
				{
					icon : '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-1.png',
					position : [ 116.205467, 39.907761 ]
				},
				{
					icon : '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-2.png',
					position : [ 116.368904, 39.913423 ]
				},
				{
					icon : '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-3.png',
					position : [ 116.305467, 39.807761 ]
				} ];

		// 添加一些分布不均的点到地图上,地图上添加三个点标记，作为参照
		markers.forEach(function(marker) {
			new AMap.Marker({
				map : map,
				icon : marker.icon,
				position : [ marker.position[0], marker.position[1] ],
				offset : new AMap.Pixel(-13, -30)
			});
		});

		// 设置鼠标划过点标记显示的文字提示
		marker.setTitle('我是marker的title');
	</script>
</body>
</html>