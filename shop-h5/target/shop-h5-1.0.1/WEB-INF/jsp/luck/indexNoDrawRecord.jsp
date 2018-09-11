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
  <div class="main-header">
  <p>本月主套餐使用流量:<span>158M</span></p>
  <p class="p1">您有<span class="coud_num">0</span> 次机会</p>
  </div>
  <div class="main-body">
     <div id="zhuanpan">
          <img id="img" class="rotary-table" src="/prizeluck/images/four_zhuanpan.png">
          <img id="tip" class="point i_cont" src="/prizeluck/images/Pointer2.png" >
      </div>
  </div>  
  
  <div class="main-footer"><a href="抽奖记录.html" class="footer-a2">中奖记录>></a><a href="#" class="footer-a" data-toggle="modal" data-target="#myModal">活动规则>></a></div> 
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
      <p>1、活动时间：2016年10月18日——2016年12月31日。<br/>
      2、活动期间，主套餐内使用流量每达300M，即可参与抽奖一次（例：600M即2次，900M即3次，以此类推）。<br/>
      3、活动抽奖只能在当月进行，抽奖机会次数当月月底清零，次月重新计算。<br/>
      4、抽奖奖池：30元天翼手机话费（赠送话费不可抵扣SP业务、国际漫游、国际长话）、100M省内流量、300M省内流量、500M省内流量。<br/>
      5、话费和流量奖品次月10日前到账。获赠的流量包到账后，仅限获赠当月使用。流量超出后由号码本身套餐或者标准资费来收取。天翼副号、天翼小号、6分卡（0元保底）、4G 0元日租卡、上网卡、个人定制及时长型套餐等不能加装流量包套餐的用户不能订购，详询10000号。<br/>
       <span>备注：非实名制用户不能受理流量包，请进行实名补登记后再购买。 </span></p>
      
      </div>
  
  </div>
</div>
	
<script src="/prizeluck/js/jquery.min.js"></script> 
<script src="/prizeluck/js/bootstrap.min.js"></script>  
<script type="text/javascript">
   /* 获取抽奖机会值*/
    var nun1=$(".coud_num").html();
		// 转盘样式，a：旋转角度，p：概率（1代表100%），t：需要显示的其它信息（文案or分享）
		var result_angle = [{a:0,p:0.1,t:'30元话费'},{a:45,p:0.1,t:'500M省内流量'},{a:90,p:0.1,t:'100M省内流量'},{a:135,p:0.3,t:'300M省内流量'},{a:180,p:0.1,t:'30元话费'},{a:225,p:0.1,t:'500M省内流量'},{a:270,p:0.1,t:'100M省内流量'},{a:315,p:0.1,t:'300M省内流量'}];
		var rotate = {
			rotate_angle : 0, //起始位置为0
			flag_click : true, //转盘转动过程中不可再次触发
			calculate_result:function(type,during_time){//type:0,箭头转动,1,背景转动;during_time:持续时间(s)
				var self = this;
				type = type || 0; // 默认为箭头转动
				during_time = during_time || 1; // 默认为1s

				var rand_num = Math.ceil(Math.random() * 100); // 用来判断的随机数，1-100

				var result_index; // 最终要旋转到哪一块，对应result_angle的下标
				var start_pos = end_pos = 0; // 判断的角度值起始位置和结束位置

				for(var i in result_angle){
					start_pos = end_pos + 1; // 区块的起始值
					end_pos = end_pos + 100 * result_angle[i].p; // 区块的结束值

					if(rand_num >= start_pos && rand_num <= end_pos){ // 如果随机数落在当前区块，那么获取到最终要旋转到哪一块
						result_index = i;
						break;
					}
				}

				var rand_circle = Math.ceil(Math.random() * 2) + 1; // 附加多转几圈，2-3

				self.flag_click = false; // 旋转结束前，不允许再次触发
				if(type == 1){ // 转动盘子
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
					if(result_angle[result_index].t=="30元话费")
					{
							$('#apply1').modal('show');
					}else if(result_angle[result_index].t=="100M省内流量"){
							$('#apply2').modal('show');
					}else if(result_angle[result_index].t=="500M省内流量"){
							$('#apply3').modal('show');
					}else{
							$('#apply4').modal('show');
					}
					
					
					nun1--;
					$(".coud_num").html(nun1);
					if(parseInt(nun1)<= 0){
						$("#tip").attr("src","/prizeluck/images/Pointer2.png");
			             return false;
		            }
					
				},during_time*1000);
			}
		}
		$(document).ready(function(){
		
			$('#tip').click(function(){
			if(parseInt(nun1)<= 0){
			$("#tip").attr("src","/prizeluck/images/Pointer2.png");
			return false;
		}
				if(rotate.flag_click){ // 旋转结束前，不允许再次触发
					rotate.calculate_result(1,1);
				}
			});
					
	 });
		
		
$(".close2").click(function(){
		 $('#myModal').modal('hide');
});



</script>  
</body>
</html>