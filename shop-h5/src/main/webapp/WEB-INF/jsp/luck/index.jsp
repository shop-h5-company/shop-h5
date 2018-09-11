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


<script type="text/javascript" src="/res/js/adaptive.js?v=4"></script><!--适配js layer需要这两个js文件-->
<script type="text/javascript" src="/res/js/layer/layer.js?v=4"></script>

</head>
<body>
<div class="main">
  <div class="banner"><img src="/prizeluck/images/banner-cj.jpg"/></div>
  <div class="main-header">
  <p>您当前拥有积分:<span id="jifen">${jifen}</span></p>
  <p class="p1">您有<span class="coud_num"></span> 次抽奖机会</p>
  <div id="dejiang" style="color: red;font-family: 仿宋;font-size: 12px;">
	  <marquee scrollamount="3">
	  </marquee>
  </div>
  </div>
  <div class="main-body">
     <div id="zhuanpan">
          <img id="img" class="rotary-table" src="/prizeluck/images/zhuanpan2.png">
          <img id="tip" class="point i_cont" src="/prizeluck/images/Pointer1.png" >
      </div>
  </div>  

  <div class="main-footer"><a href="/prize/drawRecord" class="footer-a2">中奖记录>></a><a id="guize" href="#" class="footer-a" data-toggle="modal" data-target="#myModal">活动规则>></a></div> 
  
</div>
		<!-- 30元话费 -->
			<div id="apply1" class="modal fade padding1" tabindex="-1" data-replace="true" data-backdrop="static" >
				<div class="modal-dialog modal-content">
					<div class="modal-body">
					   <div class="img1"><img src="/prizeluck/images/30yuanhuafei.png"/></div>
                       <p><span>奖品将于次月10日前到账，请留意查收！</span></p>
                       <a href="#" class="colse1" data-dismiss="modal"></a>
                       <button type="button" class="but5" data-dismiss="modal" data-toggle="modal" >确定</button>
					</div>
				</div>
			</div>
            
		<!--100M省内流量 -->
			<div id="apply2" class="modal fade padding1" tabindex="-1" data-replace="true" data-backdrop="static">
				<div class="modal-dialog modal-content">
					<div class="modal-body">
					   <div class="img1"><img src="/prizeluck/images/100Mshengneiliuliang.png"/></div>
                        <p><span>奖品将于次月10日前到账，请留意查收！</span></p>
                       <a href="#" class="colse1" data-dismiss="modal"></a>
                       <button type="button" class="but5" data-dismiss="modal" data-toggle="modal" >确定</button>
					</div>
				</div>
			</div>
            
       	<!--500M省内流量 -->
			<div id="apply3" class="modal fade padding1" tabindex="-1" data-replace="true" data-backdrop="static">
				<div class="modal-dialog modal-content">
					<div class="modal-body">
					   <div class="img1"><img src="/prizeluck/images/500Mshengneiliuliang.png"/></div>
                       <p><span>奖品将于次月10日前到账，请留意查收！</span></p>
                       <a href="#" class="colse1" data-dismiss="modal"></a>
                       <button type="button" class="but5" data-dismiss="modal" data-toggle="modal" >确定</button>
					</div>
				</div>
			</div>
            
            
         	<!--300M省内流量 -->
			<div id="apply4" class="modal fade padding1" tabindex="-1" data-replace="true" data-backdrop="static">
				<div class="modal-dialog modal-content">
					<div class="modal-body">
					   <div class="img1"><img src="/prizeluck/images/300Mshengneiliuliang.png"/></div>
                        <p><span>奖品将于次月10日前到账，请留意查收！</span></p>
                       <a href="#" class="colse1" data-dismiss="modal"></a>
                       <button type="button" class="but5" data-dismiss="modal" data-toggle="modal" >确定</button>
					</div>
				</div>
			</div>
<!--加载-->
	<div id="applyLoading" class="modal fade" tabindex="-1" data-replace="true"  data-backdrop="static" >
				<div class="modal-dialog modal-content">
					<div class="modal-body">
						<div class="loading-container" align="center">
							<img src="/prizeluck/images/ajax-loader.gif" alt="Loading" class="loading-gif">
						</div>
						<p align="center">后台在努力加载，稍等一会儿哦~</p>
					</div>
				</div>
	</div>

<!-- 温馨提示 -->
<div id="myModal" class="modal fade s3" tabindex="-1" data-replace="true" data-backdrop="static">
  <div class="modal-dialog">
      <div class="hd-title"></div>
      <a href="#" class="close2"></a>
      <div class="modal-body" style="height: 250px; overflow: auto;">

      <p id="rule">
      </p>
      
      </div>
      <!-- <div class="modal-body" style="height: 250px; overflow: auto;">

      <p>1、活动时间：2016年10月18日——2016年12月31日。<br/>
      2、活动期间，主套餐内使用流量每达300M，即可参与抽奖一次（例：600M即2次，900M即3次，以此类推）。<br/>
      3、活动抽奖只能在当月进行，抽奖机会次数当月月底清零，次月重新计算。<br/>
      4、抽奖奖池：30元天翼手机话费（赠送话费不可抵扣SP业务、国际漫游、国际长话）、100M省内流量、300M省内流量、500M省内流量。<br/>
      5、话费和流量奖品次月10日前到账。获赠的流量包到账后，仅限获赠当月使用。流量超出后由号码本身套餐或者标准资费来收取。天翼副号、天翼小号、6分卡（0元保底）、4G 0元日租卡、上网卡、个人定制及时长型套餐等不能加装流量包套餐的用户不能订购，详询10000号。<br/>
       <span>备注：非实名制用户不能受理流量包，请进行实名补登记后再购买。 </span></p>
      
      </div> -->
  
  </div>
</div>

<script src="/prizeluck/js/jquery.min.js"></script> 
<script src="/prizeluck/js/bootstrap.min.js"></script>  
<script type="text/javascript">
var a29 = "代理商：185xxxx1546下 186xxxx1549抽到了 iphonex";
var a20 = "代理商：188xxxx3256下 177xxxx7952抽到了 50元红包";
var a21 = "代理商：155xxxx5665下 133xxxx7852抽到了 10元红包";
var a22 = "代理商：152xxxx2563下 170xxxx2369抽到了 抱枕";
var a23 = "代理商：137xxxx8985下 152xxxx6563抽到了 电风扇";
var a24 = "代理商：182xxxx8567下 177xxxx1289抽到了 500元红包";
var a25 = "代理商：177xxxx1238下 136xxxx8551抽到了 联想笔记本";
var a26 = "代理商：139xxxx8253下 188xxxx9625抽到了 5元红包";
var a27 = "代理商：170xxxx7518下 136xxxx8765抽到了 洗衣机";
var a28 = "代理商：185xxxx5263下 152xxxx8628抽到了 热水器";
var fanhuis = "${fanhuis}";
var arr=fanhuis.split(",");
// $("#dejiang").text(<marquee scrollamount='6'>a0</marquee>);//报错
document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a29+"</marquee>";
setInterval(function(){
	 //var num = parseInt(Math.random()*20+0);//[0,20)
	 /* alert(num);
	 alert(arr);
	 alert(arr[num]); */
	var num = parseInt(Math.random()*30+0);
	if(num == 29){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a29+"</marquee>";
	}else if(num == 20){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a20+"</marquee>";
	}else if(num == 21){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a21+"</marquee>";
	}else if(num == 22){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a22+"</marquee>";
	}else if(num == 23){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a23+"</marquee>";
	}else if(num == 24){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a24+"</marquee>";
	}else if(num == 25){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a25+"</marquee>";
	}else if(num == 26){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a26+"</marquee>";
	}else if(num == 27){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a27+"</marquee>";
	}else if(num == 28){
		document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a28+"</marquee>";
	}else {
		//真实中奖
		if(arr[num] == null){//数据库中没有20条记录
			if(num >0 && num <5){
				document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a23+"</marquee>";
			}else if(num >=5 && num <10){
				document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a24+"</marquee>";
			}else if(num >=10 && num <15){
				document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a25+"</marquee>";
			}else if(num >=15 && num <20){
				document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+a27+"</marquee>";
			}
			//document.all.dejiang.innerHTML = "<marquee scrollamount='18'></marquee>";
		}else{
			document.all.dejiang.innerHTML = "<marquee scrollamount='6'>"+arr[num]+"</marquee>";
		}
	}
},8000)

	var prizeName;
   /* 获取抽奖机会值*/
	var jifen = $("#jifen").html();
	var cishu2 = parseInt(jifen/100);
	if(cishu2 < 1){
		cishu2 = 0;
			$("#tip").attr("src","/prizeluck/images/Pointer2.png");
	}
	$(".coud_num").html(cishu2); //赋值抽奖次数
    var nun1=$(".coud_num").html();
	// 转盘样式，a：旋转角度，p：概率（1代表100%），t：需要显示的其它信息（文案or分享）
	//var result_angle = [{a:0,p:0.1,t:'30元话费'},{a:45,p:0.1,t:'500M省内流量', id:"124"},{a:90,p:0.1,t:'100M省内流量'},{a:135,p:0.3,t:'300M省内流量'},{a:180,p:0.1,t:'30元话费'},{a:225,p:0.1,t:'500M省内流量'},{a:270,p:0.1,t:'100M省内流量'},{a:315,p:0.1,t:'300M省内流量'}];
	var result_angle = [{a:0,p:0.1,t:'一等奖'},{a:45,p:0.1,t:'二等奖', id:"124"},{a:90,p:0.1,t:'三等奖'},{a:135,p:0.3,t:'四等奖'},{a:180,p:0.1,t:'五等奖'},{a:225,p:0.1,t:'六等奖'},{a:270,p:0.1,t:'七等奖'},{a:315,p:0.1,t:'八等奖'}];
	var rotate = {
		rotate_angle : 0, //起始位置为0
		flag_click : true, //转盘转动过程中不可再次触发
		calculate_result:function(type, during_time, result_index){//type:0,箭头转动,1,背景转动;during_time:持续时间(s)
			var self = this;
			//type = type || 0; // 默认为箭头转动
			type = 1; // 默认为盘子转动
			during_time = during_time || 1; // 默认为1s

			var rand_circle = Math.ceil(Math.random() * 2) + 1; // 附加多转几圈，2-3

			self.flag_click = false; // 旋转结束前，不允许再次触发
			if(type == 1){ // 转动盘子
				//self.rotate_angle =  self.rotate_angle - rand_circle * 360 - result_angle[result_index].a - self.rotate_angle % 360;
				self.rotate_angle =  self.rotate_angle - rand_circle * 360 - result_angle[result_index].a - self.rotate_angle % 360;
				$('#img').css({
					'transform': 'rotate('+self.rotate_angle+'deg)',
					'-ms-transform': 'rotate('+self.rotate_angle+'deg)',
					'-webkit-transform': 'rotate('+self.rotate_angle+'deg)',
					'-moz-transform': 'rotate('+self.rotate_angle+'deg)',
					'-o-transform': 'rotate('+self.rotate_angle+'deg)',
					'transition': 'transform ease-out '+during_time+'s',
					'-moz-transition': '-moz-transform ease-out '+during_time+'s',
					'-webkit-transition': '-webkit-transform ease-out '+during_time+'s',
					'-o-transition': '-o-transform ease-out '+during_time+'s'
				});
			}else{ // 转动指针
				self.rotate_angle = self.rotate_angle + rand_circle * 360 + result_angle[result_index].a - self.rotate_angle % 360;
				$('.i_cont').css({
					'transform': 'rotate('+self.rotate_angle+'deg)',
					'-ms-transform': 'rotate('+self.rotate_angle+'deg)',
					'-webkit-transform': 'rotate('+self.rotate_angle+'deg)',
					'-moz-transform': 'rotate('+self.rotate_angle+'deg)',
					'-o-transform': 'rotate('+self.rotate_angle+'deg)',
					'transition': 'transform ease-out '+during_time+'s',
					'-moz-transition': '-moz-transform ease-out '+during_time+'s',
					'-webkit-transition': '-webkit-transform ease-out '+during_time+'s',
					'-o-transition': '-o-transform ease-out '+during_time+'s'
				});
			}
			// 旋转结束后，允许再次触发
			setTimeout(function(){ 
				self.flag_click = true;
				// 告诉结果
				/* if(result_angle[result_index].t=="30元话费"){
						$('#apply1').modal('show');
				}else if(result_angle[result_index].t=="100M省内流量"){
						$('#apply2').modal('show');
				}else if(result_angle[result_index].t=="500M省内流量"){
						$('#apply3').modal('show');
				}else{
						$('#apply4').modal('show');
				} */
				if(result_angle[result_index].t=="一等奖"){
						//$('#apply1').modal('show');
					//alert("恭喜您获得一等奖");
					
					layer.open({
                        content:'恭喜您获得一等奖:'+prizeName,
                        btn:['确定'],
                        shadeClose: false,
                        });
					
				}else if(result_angle[result_index].t=="二等奖"){
						//$('#apply2').modal('show');
					//alert("恭喜您获得二等奖");
					layer.open({
                        content:'恭喜您获得二等奖:'+prizeName,
                        btn:['确定'],
                        shadeClose: false,
                        });
				}else if(result_angle[result_index].t=="三等奖"){
						//$('#apply3').modal('show');
					//alert("恭喜您获得三等奖");
					layer.open({
                        content:'恭喜您获得三等奖:'+prizeName,
                        btn:['确定'],
                        });
				}else if(result_angle[result_index].t=="四等奖"){
						//$('#apply4').modal('show');
					//alert("恭喜您获得四等奖");
					layer.open({
                        content:'恭喜您获得四等奖:'+prizeName,
                        btn:['确定'],
                        });
				}else if(result_angle[result_index].t=="五等奖"){
					//alert("恭喜您获得五等奖");
					layer.open({
                        content:'恭喜您获得五等奖:'+prizeName,
                        btn:['确定'],
                        });
				}else if(result_angle[result_index].t=="六等奖"){
					//alert("恭喜您获得六等奖");
					layer.open({
                        content:'恭喜您获得六等奖:'+prizeName,
                        btn:['确定'],
                        });
				}else if(result_angle[result_index].t=="七等奖"){
					//alert("恭喜您获得七等奖");
					layer.open({
                        content:'恭喜您获得七等奖:'+prizeName,
                        btn:['确定'],
                        });
				}else if(result_angle[result_index].t=="八等奖"){
					//alert("恭喜您获得八等奖");
					layer.open({
                        content:'恭喜您获得八等奖:'+prizeName,
                        btn:['确定'],
                        });
				}
				
				var c = $(".coud_num").html();
				if(parseInt(c)<= 0){
					$("#tip").attr("src","/prizeluck/images/Pointer2.png");
		             return false;
	            }
				
			},during_time*1000);
		}
	}//循环到此结束
		$(document).ready(function(){
			$('#tip').click(function(){
				var c = $(".coud_num").html();
				if(parseInt(c)<= 0){
					$("#tip").attr("src","/prizeluck/images/Pointer2.png");
					return false;
				}
				var prizeconfig;
				$.post("/prize/getPrizeInfo", 
					{ },
				   function(data){
						if(data.code == 1){ //表示返回成功消息
							if(data.result == true){
								var shengyuJifen = data.prizeconfig.shengyuJifen;
								//var a = $(".coud_num").html();
								$("#jifen").html(shengyuJifen); //剩余积分
								//$(".coud_num").html(a - b); //剩余抽奖次数
								var a = $("#jifen").html();
								var b = parseInt(a/100);
								$(".coud_num").html(b); //剩余抽奖次数
								
								prizeconfig = data.prizeconfig;
								prizeName=prizeconfig.prizeName;
							}else{
								//alert("代理尚未设置奖品！");
								layer.open({
			                        content:'代理尚未设置奖品或奖品数量不足！',
			                        btn:['确定'],
			                        });
							}
						}else{
							//错误消息
							alert(data.msg);
						}
						if(rotate.flag_click){ // 旋转结束前，不允许再次触发。prizeconfig.sequence-1是奖品的索引
							//rotate.calculate_result(1, 1, prizeconfig.sequence-1);
							rotate.calculate_result(1, 1, prizeconfig.sequence);
						}
				   },
				"json");
			});
					
	 });
		
		
$(".close2").click(function(){
		 $('#myModal').modal('hide');
});
var flag = 0;
$("#guize").click(function(){
 if(flag == 0){ //解决不刷新页面时，重复点击之后，内容会出现重复叠加的问题。
	$.post("/prize/getPrizeInfoForRule", 
			{ },
		   function(data){
					var prize = data.prize;
						$("#rule").append("1、活动时间：2018年04月01日——2020年12月31日。<br/>2、活动期间，积分每达100分，即可参与抽奖一次。<br/>3、抽奖奖池：<br/>");
					for(var i=0;i<prize.length;i++){
						$("#rule").append(""+prize[i].prizeName+"<br/>");
					}
						$("#rule").append("<span>备注：奖品派发时间由发奖人确定。 </span>");
						$("#rule").append("<span>奖品将按照手机号以及微信名派发，如已派发，请在首页订单查询查看订单进度</span>");
						flag++;
		   },
		"json");
				}
});

</script>
<a href="/home/index" class="bt1">返&nbsp;回</a>
</body>

</html>