var utils = {
    versions: function () {
        var u = navigator.userAgent, app = navigator.appVersion;
        return { //移动终端浏览器版本信息
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
            iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1 //是否iPad
        };
    }(),
    check_phone_keyup: function(e){
        var e = $(e);
        e.val(e.val().replace(/\s|[^\d]/g,''));
    }
};

$(function () {
    $("#confirmblut").on('click',function () {  /*点击注册按钮验证*/
        submitForm();
        return false;
    });

    function showError(msg) {
        var showDiv = $('.error_timeout')[0], bgDiv = $('.mask')[0];
        var wHeight = $(window).height();
        var showDivHeighr = $(showDiv).height();
        $(showDiv).css('top', (wHeight - showDivHeighr) / 2);
        $(bgDiv).show();
        $(showDiv).html(msg).show();
        window.setTimeout(function(){
            $(bgDiv).hide();
            $(showDiv).hide();
        },1000)
    }

    function check_name() {
        var phone = document.getElementById("logName").value;
        if (phone) {
            if (!check_phone(phone)) {
                showError("请输入正确的手机号！");
                return false;
            }
        } else {
            showError("请输入手机号！");
            document.getElementById("logName").focus();
            return false;
        }
        return true;
    }

    function check_phone_keyup(e){ /*手机号非字符验证*/
        var e = $(this);
        e.val(e.val().replace(/\s|[^\d]/g,''));
    }

    function check_phone(phone) {  /*手机号码验证*/
        var reg = /^0?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
        if (!reg.test(phone)) {
            return false;
        }
        return true;
    }
    function check_emall(emall){  /*邮箱验证*/
        var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
        if (!reg.test(emall)) {
            return false;
        }
        return true;
    }

    function check_password() {  /*密码*/
        var pw = $("#password").val();
        if (pw != '' || pw == null) {
            if (pw.length < 6 || pw.length > 24) {
                showError("密码不能少于6位或大于24位");
                return false;
            }

        } else {
            showError("请输入密码！");
            return false;
        }
    }

    function check_form() {
        if($('#logName').val()=='') {
            showError("请输入手机号！");
            return false;
        }else if($('#graph_code2').val()=='') {
            showError("请输入图形验证码！");
            return false;
        }   else if($('#message_code').val()==''){
            showError("请输入手机验证码！");
            return false;
        }
        if (check_name() && check_password() /*&& check_userCode()*/) {
            return true;
        }
        return false;
    }



    function ajaxVadateFrom() {
        if (!check_name()) {
            return false;
        }

        var msgCode = $("#message_code").val();
        var inviteCode = $("#inviteCode").val();
        var reCode = $("#graph_code2").val();
        var userPhone = $("#logName").val();
        if (msgCode==null ||msgCode=='') {
            showError("短信验证码不能为空!");
            return false;
        }
        if (msgCode && msgCode.length==4 || msgCode.length==4) {
            $.ajax({
                url: "",
                type: "POST",
                dataType: "JSON",
                timeout: 10000,
                data: {msgCode: msgCode,userPhone:userPhone,reCode:reCode,inviteCode:inviteCode},
                success: function (data) {
                    if (data != null) {
                        if (data.state == 1) {
                            if (!document.getElementById("checkbox_a1").checked) {
                                showError("请查看协议，并同意方可注册 ");
                                return false;
                            }
                            document.forms.form.action = "newRegister";
                            document.forms.form.submit();
                            document.forms.form.action = "";
                            return ;
                        } else {
                            if(data.state==0){
                                $('#reCode').val('');
                            }else if(data.state==-1){
                                $('#msgCode').val('');
                            }
                            return false;
                        }
                    }
                },
                error: OnError
            });
        } else {
            showError("请输入正确完整信息!");
            return false;
        }

    }

    function submitForm() {  /*注册验证*/
        if (check_form()) {
            ajaxVadateFrom();
        }
        return false;
    }


    /*登录 验证*/
    $('#logName').focus();
    var xhr = new XMLHttpRequest;
    document.addEventListener('touchstart', function (e) {
        if (e.target.id == "btn") {
            var logName = document.getElementById("logName").value;
            var password = document.getElementById("password").value;
            if(logName == ""&&password == ""){
                showError("手机号和密码不能为空！");
            }else if(logName == ""){
                showError("手机号和密码不能为空！");
            }else if(password == ""){
                showError("手机号或密码错误！");
            }else{
                xhr.open("post", "./dologin", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.timeout = 10000;
                xhr.onreadystatechange = function () {
                    var reg = /^2\d{2}$/;
                    if (xhr.readyState == 4 && reg.test(xhr.status)) {
                        var res = xhr.responseText;
                        if(res == "0"){
                            document.location.href= url;
                        }else if(res == "1"){
                            showError("手机号和密码不能为空！");
                        }else if(res == "2"){
                            showError("密码解析错误！");
                        }else if(res == "3"){
                            showError("手机号或密码错误！");
                        }

                    }
                };
                xhr.ontimeout = function () {
                    showError("请求超时！请刷新再试下！");
                };
                xhr.send("logName="+logName+"&password="+password);
            }
            //e.preventDefault();
        }
    });

    /*修改登录密码*/
    $('#set_newpwd').click(function(){
        var oldpwd = $("#oldpwd").val();
        var newpwd = $("#newpwd").val();
        if(oldpwd == '' || newpwd == ''){
            showError("密码不能为空");
        }else if(oldpwd !== newpwd){
            showError("密码不一致!");
        }
        return false;
    })

    /*邮箱验证*/
    $('#check_emall').click(function(){
        var emall = $("#emall").val();
        if(emall == ''){
            showError("请输入绑定邮箱！");
        }else if(!check_emall(emall)){
            showError("邮箱格式不正确!");
        }
    })

    /*select模拟箭头添加点事件*/
    $(".arlist_click .arr_mask,.arlist_click .arrow").click(function(){
        $(this).parent(".arlist_click").find("select").trigger("mousedown");
    })

});

//倒计时功能  按钮ID，秒+1，显示文字

function _clocking(id,i){
    var btn = document.getElementById(id);
    btn.setAttribute("onclick","");
    btn.style.backgroundColor="#cdcfd1";
    document.getElementById("phonetext").innerHTML="";
    _timeSet(id,i);
}
function _timeSet(id,i){
    i--;
    if(i==0){
        document.getElementById("phoneCodeSent").innerHTML="";
        document.getElementById("phonetext").innerHTML="再次获取";
        document.getElementById(id).setAttribute("onclick","getRecode()");
        // document.getElementById(id).style.backgroundColor="#d44032" ;
        $('#pictureCode').attr("src", "/login/captcha?timestamp=" +new Date().getTime()+'&token='+$("#token").val());
    }
    else{
        document.getElementById("phoneCodeSent").innerHTML = i+ "秒";
        setTimeout("_timeSet(\""+id+"\","+i+")",1000);
    }
}


function getReCode(){
    _clocking("getRecode",60);
}







