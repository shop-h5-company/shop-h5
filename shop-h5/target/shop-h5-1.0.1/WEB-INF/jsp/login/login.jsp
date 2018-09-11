<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/15
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="../common/include.jsp" %>
</head>
<body>
<section class="main maxH login_page">
    <div class="logo" style="overflow: visible">
       <ul class="menu_logo">
           <li><a href="/login/toLogin" class="nav_now">密码登录</a></li>
           <!-- <li><a href="/login/toLoginSms">短信登录</a></li> -->
       </ul>
    </div>
    <form id="myForm">
            <ul class="login_main login_special">
                <input type="hidden" id="backUrl" value="${backUrl}"/>
                <li>
                    <span class="phonenum"></span>
                    <input class="textbox" type="tel" maxlength="11" id="mobile" name="mobile" placeholder="请输入手机号码"  value=""/>
                </li>
                <li>
                    <span class="pwd"></span>
                    <input class="textbox" type="password" id="password"   maxlength="16"  name="password"  placeholder="请输入登录密码" style="width:4.2rem"/>
                </li>
                <li>
                    <span class="pwd"></span>
                    <input class="textbox" type="input" id="inviteAuthorityCode"  maxlength="16"  name="inviteAuthorityCode"  placeholder="邀请权限码（选填）" style="width:4.2rem"/>
                </li>
            </ul>
        <ul class="login_quick">
            <li><a id="registerNew" href="/login/toRegister">立即注册</a></li>
            <!-- <li><a href="/login/forgetPwd">忘记密码？</a></li> -->
            <li><a class="explan" id="explan">忘记密码？</a></li>
            <!-- <span class="explan" id="explan"></span> -->
        </ul>
    </form>
    <a id="doLogin" class="confirmblut">确定</a>

    <div class="code">
        <img  src="/res/image/invite/code.jpg" alt="">
    </div>
    <div class="code">
    </div>
</section>
<script type="text/javascript">
    /*$(function () {
        $('#mobile').focus();
        $('#doLogin').on('click', function () {
            var loginFlag = validateLogin();
            if (loginFlag) {
                ajaxLogin();
            }
        });
    });*/
	/*$('#explan').on('click',function(){
        layer.open({
            //skin: 'demo-class',
			//style: ' text-align:center',
            content: ' <p style="text-align: left">请联系客服微信号：18911049994 重置密码。</p>' //这里content是一个普通的String
        });
    }); */
    $('#explan废弃').on('click',function(){
        	layer.open({
                content: '<span  onclick="layerClose();">请联系客服微信号：18911049994 重置密码。</span>',
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
            });
    });
    $('#explan').on('click',function(){
        	layer.open({
                content: '<span  onclick="layerClose();">请联系客服微信号：18911049994 重置密码。</span>',
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
            });
    });
    
    document.getElementById("mobile").focus();
    document.addEventListener('touchstart', function (e) {
        if (e.target.id == "doLogin") {
            var loginFlag = validateLogin();
            if (loginFlag) {
                ajaxLogin();
            }
        }
    })
    function validateLogin() {
        var mobile = $("#mobile").val();
        var password = $("#password").val();
        var reg = /^1\d{10}$/;
        var regPwd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;

        if (mobile == "" && password == "") {
            $("#doLogin").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '手机号和密码不能为空请输入'
            });
            return false;
        }else if (mobile == "") {
            $("#doLogin").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '手机号不能为空请输入'
            });
            return false;
        }
        else if (password == "") {
            $("#doLogin").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入登录密码,(6-16)位字母+数字'
            });
            return false;
        }else if (!regPwd.test(password)) {
            $("#password").blur();
            $("#doLogin").focus();
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '登录密码须为(6-16)位字母+数字'
                });
                return false;
        }else if (!reg.test(mobile)) {
            $("#doLogin").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '您的手机号有误，请重新输入！'
            });
            return false;
        } else {
            return true;
        }
    }
    function cc(){
    	layer.open({
            content: '12',
            btn: ['<span class="single">确定</span>'],
            shadeClose: false,
        });
    }
    function ajaxLogin() {
        $.post('/login/loginSubmit', $('#myForm').serialize(),
                function (result) {
		        	var results = result;
                    var result = eval('(' + result + ')');
                    
                    if (result.ret == '0') { //登录成功
                    	if(result.msg == "7"){ //代理登录
	                    	if(parseInt(result.value) < 10 ){
	                        	//alert(parseInt(result.value));
	                        	window.location.href = "../login/inviteAuthorityCode?inviteNum="+parseInt(result.value);
	                        	return ;
	                        }else{
	                        	
	                        	layer.open({
	                                //type:1,//类型：Number，默认：00（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
	                                content:'邀请名额还剩'+parseInt(result.value)+'人',
	                                //btn:['确定','取消'],
	                                btn:['确定'],
	                                yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
	                                	var url = $("#backUrl").val();
	                                	if (url == '/home/null/login/toLogin' || url == '/home/null/login/toWxLogin') {
	                                		$("#backUrl").val("");
	            						}
	                                    window.location.href = "../login/success?backUrl="+$("#backUrl").val();
	                                }
	                                });
	                        	//alert("邀请名额还剩"+parseInt(result.value)+"人");
	                        }
                    	}else{//用户登录
                    		var url = $("#backUrl").val();
                        	if (url == '/home/null/login/toLogin' || url == '/home/null/login/toWxLogin') {
                        		$("#backUrl").val("");
    						}
                            window.location.href = "../login/success?backUrl="+$("#backUrl").val();
                    	}
                    	
                    	/* var url = $("#backUrl").val();
                    	if (url == '/home/null/login/toLogin' || url == '/home/null/login/toWxLogin') {
                    		$("#backUrl").val("");
						}
                        window.location.href = "../login/success?backUrl="+$("#backUrl").val(); */
                    } else if (results == '{}') {
                    	layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: "用户名或密码错误"
                        });
                    } else {
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: result.msg
                        });
                    }
                    $("#doLogin").focus();
                }, 'json');
    }
    $("#mobile").on('keyup', function () {
        utils.check_phone_keyup($(this));
    })
</script>
</body>
</html>
