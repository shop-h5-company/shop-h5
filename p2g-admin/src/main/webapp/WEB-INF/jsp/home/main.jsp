<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/15
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include.jsp"%>
    <%@ include file="../common/include_head.jsp"%>
    <script type="text/javascript">
        $(function(){
            SyntaxHighlighter.config.clipboardSwf = '/res/js/BJUI/syntaxhighlighter-2.1.382/scripts/clipboard.swf'
            $(document).on(BJUI.eventType.initUI, function(e) {
                SyntaxHighlighter.highlight();
            })
        })
    </script>
    <!-- for doc end -->
</head>
<body>
<!--[if lte IE 7]>
<div id="errorie"><div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
<![endif]-->
<div id="bjui-window">
    <header id="bjui-header">
        <div class="bjui-navbar-header">
            <button type="button" class="bjui-navbar-toggle btn-default" data-toggle="collapse" data-target="#bjui-navbar-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="bjui-navbar-logo" href="#"><img src="/res/images/logo_header.png"></a>
        </div>
        <nav id="bjui-navbar-collapse">
            <ul class="bjui-navbar-right">
                <li class="datetime"><div><span id="bjui-date"></span> <span id="bjui-clock"></span></div></li>
                <%--<li><a href="#">消息 <span class="badge">4</span></a></li>--%>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${adminName} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/home/changePwd" data-toggle="dialog" data-id="changepwd_page" data-mask="true" data-width="450" data-height="300">&nbsp;<span class="glyphicon glyphicon-lock"></span> 修改密码&nbsp;</a></li>
                        <li><a href="#">&nbsp;<span class="glyphicon glyphicon-user"></span> 我的资料</a></li>
                        <li class="divider"></li>
                        <li><a href="/login/logout" class="red">&nbsp;<span class="glyphicon glyphicon-off"></span> 注销登陆</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle theme blue" data-toggle="dropdown" title="切换皮肤"><i class="fa fa-tree"></i></a>
                    <ul class="dropdown-menu" role="menu" id="bjui-themes">
                        <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li>
                        <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li>
                        <li><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>
                        <li class="active"><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 天空蓝</a></li>
                        <li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="bjui-hnav">
            <button type="button" class="btn-default bjui-hnav-more-left" title="导航菜单左移"><i class="fa fa-angle-double-left"></i></button>
            <div id="bjui-hnav-navbar-box">
                <ul id="bjui-hnav-navbar">

                    <li class="active"><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-coffee"></i> 业务作业</a>
                        <div class="items hide" data-noinit="true">
                            <ul class="menu-items" data-faicon="star-o" data-tit="用户维护">
                                <li><a href="/user/getList" data-options="{id:'user-list', faicon:'caret-right'}">用户管理</a></li>
                                <li><a href="/user/getQueryList" data-options="{id:'user-query', faicon:'caret-right'}">用户查询</a></li>
                                <li><a href="/userLoginLog/getList" data-options="{id:'user-login-log', faicon:'caret-right'}">登录日志</a></li>
                            </ul>
                            <ul class="menu-items" data-faicon="th" data-tit="活期理财">
                                <li><a href="/hq/getHqTransLogList" data-options="{id:'hq-trans', faicon:'caret-right'}">活期交易查询</a></li>
                                <li><a href="/hq/getHqProfitLogList" data-options="{id:'hq-profit-log', faicon:'caret-right'}">活期收益查询</a></li>
                                <li><a href="/hq/getAllExamineList" data-options="{id:'hq-withdraw-query', faicon:'caret-right'}">提现审核查询</a></li>
                                <li><a href="/hq/getExamineList?checkStatusNotDo=not_do&checkStatusBack=back" data-options="{id:'hq-withdraw-check', faicon:'caret-right'}">活期提现审核</a></li>
                                <li><a href="/hq/getList" data-options="{id:'hq-withdraw-pay', faicon:'caret-right'}">活期提现打款</a></li>
                                <li><a href="/coupons/getList" data-options="{id:'coupons', faicon:'caret-right'}">活期加息券管理</a></li>
                            </ul>
                            <%--<ul class="menu-items" data-faicon="th" data-tit="定期理财">
                                <li><a href="/dqProduct/getList" data-options="{id:'deposit-product', faicon:'caret-right'}">定期产品管理</a></li>
                                <li><a href="/dqTransLog/getList" data-options="{id:'deposit-trans', faicon:'caret-right'}">定期交易查询</a></li>
                                <li><a href="/dqTicket/getList" data-options="{id:'deposit-ticket', faicon:'caret-right'}">定期加息券管理</a></li>
                                <li><a href="/dqBankCheck/getList" data-options="{id:'deposit-check', faicon:'caret-right'}">定期到期审核</a></li>
                                <li><a href="/dqBankCheck/getPayList" data-options="{id:'deposit-pay', faicon:'caret-right'}">定期到期付款</a></li>
                            </ul>--%>
                            <ul class="menu-items" data-faicon="money" data-tit="资金管理">
                                <li><a href="/fund/getFundAccountList" data-options="{id:'fund-account', faicon:'caret-right'}">资金账户查询</a></li>
                                <li><a href="/fund/getFundTransList" data-options="{id:'fund-trans', faicon:'caret-right'}">资金交易查询</a></li>
                                <c:if test="${rechargeOpenFlag=='on'}">
                                    <li><a href="/recharge/getRechargeList" data-options="{id:'fund-recharge', faicon:'caret-right'}">资金账户充值</a></li>
                                </c:if>
                            </ul>
                            <ul class="menu-items" data-faicon="money" data-tit="连连支付">
                                <li><a href="/lian/getLianAccountList" data-options="{id:'lian-account', faicon:'caret-right'}">连连账户管理</a></li>
                                <li><a href="/lian/getLianBankList" data-options="{id:'lian-support-bank', faicon:'caret-right'}">支持银行管理</a></li>
                                <li><a href="/lian/getLianRechargeLogList" data-options="{id:'lian-recharge-log', faicon:'caret-right'}">充值日志查询</a></li>
                                <li><a href="/lian/getLianWithdrawLogList" data-options="{id:'lian-withdraw-log', faicon:'caret-right'}">提现日志查询</a></li>
                            </ul>
                            <ul class="menu-items" data-faicon="spinner" data-tit="运营作业">
                                <li><a href="/operation/getCmAnnouncementList" data-options="{id:'cm_announcement', faicon:'caret-right'}">公告管理</a></li>
                                <li><a href="/operation/getCmHomeTuijianList" data-options="{id:'cm_home_tuijian', faicon:'caret-right'}">首页推荐管理</a></li>
                            </ul>
                        </div>
                    </li>
                    <%--<li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-database"></i> 数据统计</a>
                        <div class="items hide" data-noinit="true">
                            <ul class="menu-items" data-faicon="star-o" data-tit="用户统计">
                                <li><a href="#" data-options="{id:'doc-file', faicon:'caret-right'}">用户列表</a></li>
                            </ul>

                        </div>
                    </li>--%>
                    <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-bug"></i> 公共服务</a>
                        <div class="items hide" data-noinit="true">
                            <ul class="menu-items" data-faicon="star-o" data-tit="短信管理">
                                <li><a href="/cmSmsModel/getList" data-options="{id:'cm_sms_model', faicon:'caret-right'}">短信模板管理</a></li>
                                <li><a href="/cmSmsLog/getList" data-options="{id:'cm_sms_log', faicon:'caret-right'}">发送记录查询</a></li>
                                <li><a href="/cmSmsCode/getList" data-options="{id:'cm_sms_code', faicon:'caret-right'}">短信验证码查询</a></li>
                            </ul>

                        </div>
                    </li>
                    <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-bug"></i> 技术作业</a>
                        <div class="items hide" data-noinit="true">
                            <ul class="menu-items" data-faicon="star-o" data-tit="数据配置">
                                <li><a href="/cmConfig/getList" data-options="{id:'cm_config', faicon:'caret-right'}">业务数据管理</a></li>
                            </ul>
                            <ul class="menu-items" data-faicon="star-o" data-tit="定时管理">
                                <li><a href="/taskFireLog/getList" data-options="{id:'task_fire_log', faicon:'caret-right'}">定时日志查询</a></li>
                                <li><a href="/taskGroup/getList" data-options="{id:'task_group', faicon:'caret-right'}">定时分组管理</a></li>
                                <li><a href="/task/getTaskSchedulerList" data-options="{id:'task_scheduler', faicon:'caret-right'}">定时调度管理</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-cog"></i> 系统设置</a>
                        <div class="items hide" data-noinit="true">
                            <ul class="menu-items" data-faicon="star-o" data-tit="系统设置">
                                <li><a href="/admin/list" data-options="{id:'admin_info', faicon:'caret-right'}">管理员管理</a></li>
                                <li><a href="/admin/permissionList" data-options="{id:'admin_permission', faicon:'caret-right'}">权限管理</a></li>
                                <li><a href="/admin/roleList" data-options="{id:'admin_role', faicon:'caret-right'}">角色管理</a></li>

                                <li><a href="/admin/menuList" data-options="{id:'admin_menu', faicon:'caret-right'}">菜单管理</a></li>

                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <button type="button" class="btn-default bjui-hnav-more-right" title="导航菜单右移"><i class="fa fa-angle-double-right"></i></button>
        </div>
    </header>
    <div id="bjui-container" class="clearfix">
        <div id="bjui-leftside">
            <div id="bjui-sidebar-s">
                <div class="collapse"></div>
            </div>
            <div id="bjui-sidebar">
                <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
                <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu">
                </div>
            </div>
        </div>
        <div id="bjui-navtab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent">
                    <ul class="navtab-tab nav nav-tabs">
                        <li data-url="/echarts/goEcharts" data-faicon="home"><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
                <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
                <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">#maintab#</a></li>
            </ul>
            <div class="navtab-panel tabsPageContent">
                <div class="navtabPage unitBox">
                    <div class="bjui-pageContent" style="background:#FFF;">
                        Loading...
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer id="bjui-footer">Copyright &copy; 2016 - 2017
        <!--
        <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1252983288'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s23.cnzz.com/stat.php%3Fid%3D1252983288%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
        -->
    </footer>
</div>
</body>
</html>
