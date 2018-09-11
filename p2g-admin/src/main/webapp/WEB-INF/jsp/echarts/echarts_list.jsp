<%--
  Created by IntelliJ myeclipse.
  User: zhaozizhen
  Date: 2016/6/29
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="echarts/goEcharts" method="post">
        <div class="bjui-searchBar">
            <label>&nbsp;注册年份:</label>
            <span style="position: relative; display: inline-block;" class="wrap_bjui_btn_box">
            <input value="<fmt:formatDate value="${regTime}" pattern="yyyy"/>" class="form-control" style="padding-right: 15px;" name="regTime" data-toggle="datepicker" placeholder="请输入您要查询的注册年份" type="text"><a style="height: 22px; line-height: 22px;" class="bjui-lookup" href="javascript:;" data-toggle="datepickerbtn"><i class="fa fa-calendar"></i></a></span>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
    <div style="margin:15px auto 0; width:96%;">
        <div class="row" style="padding: 0 8px;">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> 注册人数统计图 </h3></div>
                    <div class="panel-body">
                        <div style="mini-width:400px;height:350px" data-toggle="echarts" data-type="bar,line" data-url="echarts/goEchartsJson"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>