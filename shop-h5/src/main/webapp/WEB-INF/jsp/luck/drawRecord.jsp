<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">
<title></title>
<link rel="stylesheet" href="/prizeluck/css/bootstrap.min.css">
<link rel="stylesheet" href="/prizeluck/css/style-cj.css">

</head>
<body>
<div class="main">
  <div class="banner"><img src="/prizeluck/images/banner-cj.jpg"/></div>

       <div class="title2">抽奖记录</div>
       <div class="list1">
    	   <!-- <div class="l1">
             <p>暂无记录</p>
            </div>
           <div class="l1">
                <div class="p1">300M省内流量</div>
                <div class="p2">2016.9.10 15：00</div>   
            </div>
         	<div class="l1">
                <div class="p1">30元话费</div>
                <div class="p2">2016.9.10 15：00</div>
            </div>
        	<div class="l1">
                <div class="p1">500M省内流量</div>
                <div class="p2">2016.9.10 15：00</div>      
            </div>
            <div class="l1">
                <div class="p1">100M省内流量</div>
                <div class="p2">2016.9.10 15：00</div>
            </div> -->
  
        </div>
        <div class="title3">*温馨提示：中奖后，如奖品已派发请在首页查询订单。</div>
        <a href="/prize/luck" class="bt1">返&nbsp;回</a>
    </div>
     
     
     
  </div>  
 <script src="/prizeluck/js/jquery.min.js"></script>
 <script src="/prizeluck/js/jquery-1.8.3.min.js"></script>
 <script type="text/javascript">
 	//var prizes = ${prizes};
 	$.post("/prize/getPrizeRecord", 
			{ },
		   function(data){
				var prizes = data.prizes;
				//alert(data.prizes);
				for(var i=0;i<prizes.length;i++){
					$(".list1").append("<div class='l1'><div class='p1'>"+prizes[i].prizeName+"</div><div class='p2'>"+prizes[i].inPrizeTime+"</div></div>");
				}
		   },"json"); //加上,"json" 大概表示返回的是json格式的数据
 </script>



</body>
</html>