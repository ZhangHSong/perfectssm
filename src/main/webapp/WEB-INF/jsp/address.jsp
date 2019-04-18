<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>地理编码(地址->经纬度)</title>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <style>
        html,body,#container{
            height:100%;
            width:100%;
        }
        .btn{
            width:10rem;
            margin-left:6.8rem;   
        }
    </style>
</head>
<body>
<div id="container"></div>


<div class="input-card" style='width:28rem;'>
    <label style='color:grey'>地理编码，根据地址获取经纬度坐标</label>
    <div class="input-item">
            <div class="input-item-prepend"><span class="input-item-text" >地址</span></div>
            <input id='address' type="text" value='北京市朝阳区阜荣街10号' >
    </div>
    <div class="input-item">
            <div class="input-item-prepend"><span class="input-item-text">经纬度</span></div>
            <input id='lnglat' disabled type="text">
    </div>
    <input id="geo" type="button" class="btn" value="地址 -> 经纬度" />
</div>


<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.14&key=您申请的key值&plugin=AMap.Geocoder"></script>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true
    });
    
    var geocoder,marker;
    function geoCode() {
        if(!geocoder){
            geocoder = new AMap.Geocoder({
                city: "010", //城市设为北京，默认：“全国”
            });
        }
        var address  = document.getElementById('address').value;
        geocoder.getLocation(address, function(status, result) {
            if (status === 'complete'&&result.geocodes.length) {
                var lnglat = result.geocodes[0].location
                document.getElementById('lnglat').value = lnglat;
                if(!marker){
                    marker = new AMap.Marker();
                    map.add(marker);
                }
                marker.setPosition(lnglat);
                map.setFitView(marker);
            }else{alert(JSON.stringify(result))}
        });
    }
   
</script>
</body>
</html>