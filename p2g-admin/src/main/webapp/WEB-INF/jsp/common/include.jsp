<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path+"/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>中外建金融运营管理平台</title>
<meta name="Keywords" content="jiananfinance,中外建金融,建安金融"/>
<meta name="Description" content="jiananfinance,中外建金融,建安金融"/>
<!-- bootstrap - css -->
<link href="/res/BJUI/themes/css/bootstrap.css" rel="stylesheet">
<!-- core - css -->
<link href="/res/BJUI/themes/css/style.css" rel="stylesheet">
<link href="/res/BJUI/themes/blue/core.css" id="bjui-link-theme" rel="stylesheet">
<!-- plug - css -->
<link href="/res/BJUI/plugins/kindeditor_4.1.10/themes/default/default.css" rel="stylesheet">
<link href="/res/BJUI/plugins/colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
<link href="/res/BJUI/plugins/niceValidator/jquery.validator.css" rel="stylesheet">
<link href="/res/BJUI/plugins/bootstrapSelect/bootstrap-select.css" rel="stylesheet">
<link href="/res/BJUI/themes/css/FA/css/font-awesome.min.css" rel="stylesheet">
<!--[if lte IE 7]>
<link href="/res/BJUI/themes/css/ie7.css" rel="stylesheet">
<![endif]-->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lte IE 9]>
<script src="/res/BJUI/other/html5shiv.min.js"></script>
<script src="/res/BJUI/other/respond.min.js"></script>
<![endif]-->
<!-- jquery -->
<script src="/res/BJUI/js/jquery-1.11.3.min.js"></script>
<script src="/res/BJUI/js/jquery.cookie.js"></script>
<!--[if lte IE 9]>
<script src="/res/BJUI/other/jquery.iframe-transport.js"></script>
<![endif]-->
<!-- BJUI.all 分模块压缩版 -->
<script src="/res/BJUI/js/bjui-all.js"></script>
<!-- plugins -->
<!-- swfupload for uploadify && kindeditor -->
<script src="/res/BJUI/plugins/swfupload/swfupload.js"></script>
<!-- kindeditor -->
<script src="/res/BJUI/plugins/kindeditor_4.1.10/kindeditor-all.min.js"></script>
<script src="/res/BJUI/plugins/kindeditor_4.1.10/lang/zh_CN.js"></script>
<!-- colorpicker -->
<script src="/res/BJUI/plugins/colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- ztree -->
<script src="/res/BJUI/plugins/ztree/jquery.ztree.all-3.5.js"></script>
<!-- nice validate -->
<script src="/res/BJUI/plugins/niceValidator/jquery.validator.js"></script>
<script src="/res/BJUI/plugins/niceValidator/jquery.validator.themes.js"></script>
<!-- bootstrap plugins -->
<script src="/res/BJUI/plugins/bootstrap.min.js"></script>
<script src="/res/BJUI/plugins/bootstrapSelect/bootstrap-select.min.js"></script>
<script src="/res/BJUI/plugins/bootstrapSelect/defaults-zh_CN.min.js"></script>
<!-- icheck -->
<script src="/res/BJUI/plugins/icheck/icheck.min.js"></script>
<!-- dragsort -->
<script src="/res/BJUI/plugins/dragsort/jquery.dragsort-0.5.1.min.js"></script>
<!-- HighCharts -->
<script src="/res/BJUI/plugins/highcharts/highcharts.js"></script>
<script src="/res/BJUI/plugins/highcharts/highcharts-3d.js"></script>
<script src="/res/BJUI/plugins/highcharts/themes/gray.js"></script>
<!-- ECharts -->
<script src="/res/BJUI/plugins/echarts/echarts.js"></script>
<!-- other plugins -->
<script src="/res/BJUI/plugins/other/jquery.autosize.js"></script>
<link href="/res/BJUI/plugins/uploadify/css/uploadify.css" rel="stylesheet">
<script src="/res/BJUI/plugins/uploadify/scripts/jquery.uploadify.min.js"></script>
<script src="/res/BJUI/plugins/download/jquery.fileDownload.js"></script>


<!-- init -->
<script type="text/javascript">
    $(function() {
        BJUI.init({
            JSPATH       : '/res/BJUI/',         //[可选]框架路径
            PLUGINPATH   : '/res/BJUI/plugins/', //[可选]插件路径
            loginInfo    : {url:'login_timeout.html', title:'登录', width:400, height:200}, // 会话超时后弹出登录对话框
            statusCode   : {ok:200, error:300, timeout:301}, //[可选]
            ajaxTimeout  : 50000, //[可选]全局Ajax请求超时时间(毫秒)
            pageInfo     : {total:'total', pageCurrent:'pageCurrent', pageSize:'pageSize', orderField:'orderField', orderDirection:'orderDirection'}, //[可选]分页参数
            alertMsg     : {displayPosition:'topcenter', displayMode:'slide', alertTimeout:3000}, //[可选]信息提示的显示位置，显隐方式，及[info/correct]方式时自动关闭延时(毫秒)
            keys         : {statusCode:'statusCode', message:'message'}, //[可选]
            ui           : {
                windowWidth      : 0, //框架显示宽度，0=100%宽，> 600为则居中显示
                showSlidebar     : true, //[可选]左侧导航栏锁定/隐藏
                clientPaging     : true, //[可选]是否在客户端响应分页及排序参数
                overwriteHomeTab : false //[可选]当打开一个未定义id的navtab时，是否可以覆盖主navtab(我的主页)
            },
            debug        : true,    // [可选]调试模式 [true|false，默认false]
            theme        : 'sky' // 若有Cookie['bjui_theme'],优先选择Cookie['bjui_theme']。皮肤[五种皮肤:default, orange, purple, blue, red, green]
        })

        // main - menu
        $('#bjui-accordionmenu')
                .collapse()
                .on('hidden.bs.collapse', function(e) {
                    $(this).find('> .panel > .panel-heading').each(function() {
                        var $heading = $(this), $a = $heading.find('> h4 > a')

                        if ($a.hasClass('collapsed')) $heading.removeClass('active')
                    })
                })
                .on('shown.bs.collapse', function (e) {
                    $(this).find('> .panel > .panel-heading').each(function() {
                        var $heading = $(this), $a = $heading.find('> h4 > a')

                        if (!$a.hasClass('collapsed')) $heading.addClass('active')
                    })
                })

        $(document).on('click', 'ul.menu-items li > a', function(e) {
            var $a = $(this), $li = $a.parent(), options = $a.data('options').toObj(), $children = $li.find('> .menu-items-children')
            var onClose = function() {
                $li.removeClass('active')
            }
            var onSwitch = function() {
                $('#bjui-accordionmenu').find('ul.menu-items li').removeClass('switch')
                $li.addClass('switch')
            }

            $li.addClass('active')
            if (options) {
                options.url      = $a.attr('href')
                options.onClose  = onClose
                options.onSwitch = onSwitch
                if (!options.title) options.title = $a.text()

                if (!options.target)
                    $a.navtab(options)
                else
                    $a.dialog(options)
            }
            if ($children.length) {
                $li.toggleClass('open')
            }

            e.preventDefault()
        })

        //时钟
        var today = new Date(), time = today.getTime()
        $('#bjui-date').html(today.formatDate('yyyy/MM/dd'))
        setInterval(function() {
            today = new Date(today.setSeconds(today.getSeconds() + 1))
            $('#bjui-clock').html(today.formatDate('HH:mm:ss'))
        }, 1000)
    })

    //菜单-事件
    function MainMenuClick(event, treeId, treeNode) {
        event.preventDefault()

        if (treeNode.isParent) {
            var zTree = $.fn.zTree.getZTreeObj(treeId)

            zTree.expandNode(treeNode, !treeNode.open, false, true, true)
            return
        }

        if (treeNode.target && treeNode.target == 'dialog')
            $(event.target).dialog({id:treeNode.tabid, url:treeNode.url, title:treeNode.name})
        else
            $(event.target).navtab({id:treeNode.tabid, url:treeNode.url, title:treeNode.name, fresh:treeNode.fresh, external:treeNode.external})
    }
</script>
<!-- for doc begin -->
<link type="text/css" rel="stylesheet" href="/res/js/BJUI/syntaxhighlighter-2.1.382/styles/shCore.css"/>
<link type="text/css" rel="stylesheet" href="/res/js/BJUI/syntaxhighlighter-2.1.382/styles/shThemeEclipse.css"/>
<script type="text/javascript" src="/res/js/BJUI/syntaxhighlighter-2.1.382/scripts/brush.js"></script>