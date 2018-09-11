<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/7/4
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%@ include file="../common/include.jsp" %>
</head>
<body>
<section class="main maxH login_page">
    <div class="logo"><%--<img src="/res/image/logintop.jpg">--%></div>
    <form id="myForm">
        <input class="textbox" type="hidden" name="inviteMode" value=""/>
        <input class="textbox" type="hidden" id="inviteCodeShiji" name="inviteCode" value="${inviteCode}"/>
        <input class="textbox" type="hidden" name="deviceSource" value=""/>
        <input type="hidden" name="token" value="${token}"/>
        <ul class="login_main">
            <li>
                <span class="phonenum"></span>
                <input class="textbox" type="tel" maxlength="11" id="mobile" name="mobile" placeholder="手机号"  value=""/>
            </li>
            <!-- <li>
                <span class="phonenum"></span>
                <input class="textbox" type="tel" maxlength="11" id="verifyCode" name="verifyCode" placeholder="验证码"  value=""/>
                <input id="getVerifyCode" type="button" onclick="getVerifyCode2();" style=" position: absolute;
							    height: 50%;
							    font-size: 15px;
							    background-color: #e2ebd4;color: black;
							    font-family: 仿宋;" value="获取验证码"></input>
            </li> -->
            <%-- <li>
                <span class="graphcode"></span>
                <input class="textbox" type="" maxlength="4" id="captchaStr" name="captchaStr" placeholder="图形验证码"  value=""/>
                <img id="pictureCode" alt="点击更换" title="点击更换" src="/login/captcha?token=${token}" class="graph_code">
            </li> --%>
            <!-- <li>
                <span class="forgetpwd"></span>
                <input class="textbox" type="tel" maxlength="4" id="phoneCode" name="phoneCode" placeholder="手机验证码"  value=""/>
                <a class="btnRed btnRed2 again" id="getRecode"  onclick="getRecode()"><font id="phonetext">获取验证码</font><font id="phoneCodeSent" color="#d44032"></font></a>
            </li> -->
            <li>
                <span class="pwd"></span>
                <input class="textbox" type="password" id="password" name="password" placeholder="请输入密码，(6-16)位字母+数字" value="" maxlength="16"/>
            </li>
            <!-- <li>
                <span class="phonenum"></span>
                <input class="textbox" type="text" id="inviteCode" placeholder="邀请码(用户必填)" maxlength="11" minlength="6"
                       value="${inviteCode}" />
            </li> -->
            <li>
                <span class="phonenum"></span>
                 <input name="jurisdiction" type="radio" value="7" />代理商
                <input name="jurisdiction" type="radio" value="1" />仓管
            </li>
            
        </ul>
        <!--<ul class="login_quick">
            <li><input type="checkbox" id="deal" checked value="1"/><label for="deal"> 用户协议</label></li>
            <li></li>
        </ul>-->
        <div class="protocol">
            <input type="checkbox" id="deal" class="chk_1 chk_2" checked/><label for="deal" id="checkbox_lable"></label>
            <span id="checkbox_protocol" class="checkbox_protocol" check="true">同意</span><a href="" class="checkbox_protocol" style="color: #4ccfe8">《用户服务协议》</a>
        </div>
    </form>
    <a id="doRegister" class="confirmblut" href="javascript:void(0)">注册</a>
    <span  class="go">已有账户？ <a href="/login/toLogin" class="blue">去登录</a></span>
</section>
<input type="hidden" id="token" value="${token}"/>
<script type="text/javascript">
    $(function () {
        $('#checkbox_protocol').click(function(){ /*用户协议是否勾选*/
            if($(this).attr('check')){
                $('#deal').click();
                //console.log($("#deal").attr("checked"))
            }
        })

        $('#pictureCode').on('click', function () {
            $('#pictureCode').attr("src", "/login/captcha?timestamp=" +new Date().getTime()+'&token=${token}');
        });
        /*$('#getRecode').on('click', function () {
            getRecode();
        });*/

        $("#mobile").on('keyup', function () {
            utils.check_phone_keyup($(this));
        })

    });

    document.addEventListener('touchstart', function (e) {
        if (e.target.id == "doRegister") {
            startRegister();
        }
    })

    /*验证手机号*/
    function check_name() {
        var mobile = $("#mobile").val();
        if ("" != mobile) {
            if (!check_phone(mobile)) {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '您的手机号有误，请重新输入'
                });
                return false;
            }
        } else {
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '手机号不能为空请输入'
            });
            return false;
        }
        return true;
    }
    function check_phone(phone) {
        var reg = /^1(3|4|5|7|8)\d{9}$/;
        if (!reg.test(phone)) {
            return false;
        }
        return true;
    }
    /* //验证图片验证码
    function check_recode() {
        var msgCode = $("#captchaStr").val();
        if (msgCode == "") {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入图形验证码'
            });
            return false;
        } else {
            return true;
        }
    } */

    //验证短信验证码
    /* function check_smsCode() {
        var phoneCode = $("#phoneCode").val();
        if (phoneCode == "") {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入手机验证码'
            });
            return false;
        } else {
            return true;
        }
    } */

    //验证密码
    function check_password() {
        var password = $("#password").val();
        if ('' == password) {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入密码，(6-16)位字母+数字'
            });
            return false;
        }
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
        if (!reg.test(password)) {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入密码，(6-16)位字母+数字'
            });
            return false;
        }/*
        if (password.length < 6 || password.length > 24 ||) {
            layer.open({
                content: "请输⼊( 6-16)位字母和数字组合",
                style: 'background-color:#545454; color:#fff; border:none;',
                time: 3
            });
            return false;
        }*/
        return true;
    }

    function check_deal() {
        var deal = document.getElementById("deal");
        if (!deal.checked) {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请先阅读并同意《用户服务协议》'
            });
            return false;
        } else {
            return true;
        }
    }
    
    /* function check_deal() {
        var deal = document.getElementById("deal");
        if (!deal.checked) {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请先阅读并同意《建安金融注册协议》'
            });
            return false;
        } else {
            return true;
        }
    } */
    
    function check_from() {
        if (!check_name()) {
            return false;
        }
        /* if (!check_smsCode()) {
            return false;
        } */
        
        /* var verifyCode = $("#verifyCode").val();
        if ("" == verifyCode) {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '手机验证码不能为空'
                });
                return false;
        } */
        
        if (!check_password()) {
            return false;
        }
        if (!check_deal()) {
            return false;
        }
        return true;
    }

    function startRegister() {
        if (!check_from()) {
            return;
        }
        
        
        
        /* var inviteCode = $("#inviteCode").val();
        $("#inviteCodeShiji").val(inviteCode); */ //这两行代码是为了完成邀请码功能
        
        var jurisdiction = $("input[name='jurisdiction']:checked").val();
        if (jurisdiction == null) {
        	//alert("用户类型必选");
            
        	layer.open({
                content: '<span>用户类型必选</span>',
                btn: ['<span class="single">确定</span>'],
                shadeClose: true,
                
                /* closeBtn: 1, //不显示关闭按钮
                shift: 2,
                area: ['420px', '500px'], //宽高 */
        		
                //area: ['420px', '500px'],
                //title: '弹出框',
                shade: 0.6,//遮罩透明度
                shadeClose:true,//点击遮罩关闭层
                moveType: 1,//拖拽风格，0是默认，1是传统拖动
                shift: 1,//0-6的动画形式，-1不开启
                fix:true,//不随滚动条滚动，一直在可视区域。
                border:[0],
                closeBtn:[1,true],
                
            });
        	
        	return ;
        }/* else if(jurisdiction == 0 ){
        	if(inviteCode == null || inviteCode == ""){ //input标签的值不能用null判断。
        		//alert("邀请码不能为空");
        	
        		layer.open({
                    content: '邀请码不能为空',
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: true,
                    
                });
        	
        		return;
        	}
        }else if(jurisdiction == 7 || jurisdiction == 1){ //当选择代理、仓管时，邀请码必须为空
        	if(inviteCode != ""){
        		//alert("含有邀请码时，为受邀注册，必须注册为用户类型！");
        		
        		layer.open({
                    content: '含有邀请码时，为受邀注册，必须注册为用户类型！',
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: true,
                    
                });
        		
        		return;
        	}
        } */
		
        
        var mobile = $("#mobile").val();
        var password = $("#password").val(); //这两行是为了注册成功后跳转页面
        
        $.post('/login/registerForInviteAgent', $('#myForm').serialize(),
        function (result) {
            var result = eval('(' + result + ')');
            if (result.code == 1) {
                $("#doRegister").focus();
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '注册成功!',
                    yes: function () {
                        window.location.href = "/login/regSuccess?mobile="+mobile+"&password="+password;
                    }
                });
            } else if(result.code==0) {
                $("#doRegister").focus();
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: result.msg
                });
                $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
            }else{
                $("#doRegister").focus();
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: result.msg
                });
            }

        }, 'json');
    }
	function getVerifyCode2(){
		var mobile = $("#mobile").val();
		if(mobile == null || mobile == ""){
			
			layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请先输入手机号'
            });
			
			return;
		}else{
			if (!check_phone(mobile)) {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '您的手机号有误，请重新输入'
                });
                return false;
            }
		}
		var flag2 = new Boolean(false);
		$.post('/login/getVerifyCode?mobile='+mobile,
		        function (result) {
			var a = result.flag;
			flag2 = new Boolean(a);
			layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: result.msg
            });
		        }, 'json');
			
			if(flag2){ //不能用flag2 == true 比较。 上面定义一个布尔变量的方式也要注意。大概是js版本问题。
				//开始60秒倒计时，此时不能再次请求验证码
				var countdown=60;
			    settime();
			    function settime() {
			        if (countdown == 0) {
			            $("#getVerifyCode").removeAttr("disabled"); 
			            $("#getVerifyCode").val("重新发送");
			            countdown = 60;
			            return; //重新赋值、return,如果不写，会有问题。
			        } else {
			            $("#getVerifyCode").attr("disabled",true);
			            $("#getVerifyCode").val("(" + countdown + ") s ");
			            countdown--;
			        }
			        setTimeout(function() {
			                    settime() }
			                ,1000)
			    }
			}
	}
	
    /* function getRecode() {
        if(!check_name()){
            return ;
        }
        $('#phoneCode').val('');
        $.post('/login/smsCode', {mobile:$('#mobile').val(),cmSmsModelId:$('#cmSmsModelId').val(),smsType:'reg',token:'${token}'},
        function (result) {
            var result = eval('(' + result + ')');
            if (result.ret == '0000') {
                //window.location.href = "../user/index";
                _clocking("getRecode", 60);
            } else if(result.ret=='0') {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: result.msg,
                    yes: function () {
                        window.location.href = "<c:url value='/user/index'/>";
                    }
                });
                $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
                $('#phoneCode').val('');
            } else if(result.ret=='1') {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: result.msg
                });
                $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
                $('#phoneCode').val('');
            } else {
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: result.msg
                });
            }
        }, 'json');
    } */
</script>

</body>
</html>
