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
    <title>忘记密码</title>
    <%@ include file="../common/include.jsp"%>
</head>
<body>
<section class="main maxH login_page">
    <div class="logo"><%--<img src="/res/image/logintop.jpg">--%></div>
    <form id="myForm">
    <ul class="login_main">
        <li>
            <span class="phonenum"></span>
            <input class="textbox" type="tel" maxlength="11" id="mobile" name="mobile" placeholder="已注册过的手机号"  value=""/>
        </li>
        <%--<li>
            <span class="graphcode"></span>
            <input class="textbox" type="" maxlength="4" id="captchaStr" name="captchaStr" placeholder="图形验证码"  value=""/>
            <img id="pictureCode" alt="点击更换" title="点击更换" src="/login/captcha?token=${token}" class="graph_code">
        </li>--%>
        <li>
            <span class="forgetpwd"></span>
            <input class="textbox" type="tel" maxlength="4" id="phoneCode" name="phoneCode" placeholder="短信验证码"  value=""/>
            <a id="getRecode" class="btnRed btnRed2 again" onclick="getRecode()"><font id="phonetext">获取验证码</font><font id="phoneCodeSent" color="#d44032"></font></a>
        </li>
        <li>
            <span class="pwd"></span>
            <input class="textbox" type="password" id="password" name="password" placeholder="请输入密码，(6-16)位字母+数字"  value="" maxlength="16"/>
        </li>
    </ul>
   </form>
    <ul class="login_quick"><li>&nbsp;</li></ul>
    <a id="doRegister" class="confirmblut" href="javascript:void(0)">确定</a>
</section>
<input type="hidden" id="token" value="${token}"/>
<script type="text/javascript">
    $(function(){
        $('#pictureCode').on('click',function(){
            $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
        });
       /* $('#doRegister').on('click',function(){
            startRegister();
        });*/
        /*$('#getRecode').on('click',function(){
            getSmsRecode();
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
                $("#doRegister").focus();
                layer.open({
                    btn: ['<span class="single">确定</span>'],
                    shadeClose: false,
                    content: '您输入的手机号有误，请重新输入'
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
        var reg = /^1\d{10}$/;
        if (!reg.test(phone)) {
            return false;
        }
        return true;
    }
    //验证图片验证码
   /* function check_recode() {
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
    }*/

    //验证短信验证码
    function check_smsCode() {
        var phoneCode = $("#phoneCode").val();
        if (phoneCode == "") {
            $("#doRegister").focus();
            layer.open({
                btn: ['<span class="single">确定</span>'],
                shadeClose: false,
                content: '请输入短信验证码'
            });
            return false;
        } else {
            return true;
        }
    }
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
        }
        return true;
    }

    function check_from() {
        if (!check_name()) {
            return false;
        }if (!check_smsCode()) {
            return false;
        }
        if (!check_password()) {
            return false;
        }
        return true;
    }

    function startRegister(){
        if (!check_from()) {
            return;
        }
        $.post('/login/retrievePwd', $('#myForm').serialize(),
                function (result) {
                    var result = eval('(' + result + ')');
                    if (result.ret == '0000') {
                        $("#doRegister").focus();
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            content: '修改密码成功!',
                            shadeClose: false,
                            yes: function () {
                                window.location.href = "<c:url value='/login/toLogin'/>";
                            }
                        });
                    } else if(result.ret=='1') {
                        $("#doRegister").focus();
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: result.msg
                        });
                        $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
                    } else {
                        $("#doRegister").focus();
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: result.msg
                        });
                        $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
                    }
                    $("#doRegister").focus();
                }, 'json');
    }

    function getRecode(){
        if(!check_name()){
            return ;
        }
        $('#phoneCode').val('');
        $.post('/login/smsCode', {mobile:$('#mobile').val(),cmSmsModelId:$('#cmSmsModelId').val(),smsType:'lpwd',token:'${token}'},
                function (result) {
                    var result = eval('(' + result + ')');
                    if (result.ret == '0000') {
                        _clocking("getRecode", 60);
                    }else if(result.ret=='1') {
                        $("#doRegister").focus();
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: result.msg
                        });
                        $('#pictureCode').attr("src", "/login/captcha?timestamp="  +new Date().getTime()+'&token=${token}');
                        $('#phoneCode').val('');
                    }else if (result.ret == '3') {
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            content: '该用户未注册，赶快去注册吧！',
                            shadeClose: false,
                            yes: function () {
                                window.location.href = "<c:url value='/login/toRegister'/>";
                            }
                        });
                    } else {
                        layer.open({
                            btn: ['<span class="single">确定</span>'],
                            shadeClose: false,
                            content: result.msg
                        });
                    }
                }, 'json');
    }
</script>
</body>
</html>
