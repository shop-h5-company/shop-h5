<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/21
  Time: 17:42
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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/user/permissionList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>权限名称：</label><input type="account" value="" name="profession" size="15" />
            <label>权限URL:</label><input type="text" value="" name="mobile" size="10">
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;

        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="sex">序号</th>
            <th data-order-field="operation" align="center">权限名称</th>
            <th data-order-field="name">权限URL</th>
            <th data-order-direction="asc" data-order-field="createtime">登记时间</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="sysPerm" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${sysPerm.permissionId}</td>
                <td>${sysPerm.permissionName}</td>
                <td>${sysPerm.permissionUrl}</td>
                <td>2014-10-24 15:50</td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${sysPerm.id}"></td>
                <td>
                    <a href="form.html?id=1" class="btn btn-green" data-toggle="navtab" data-id="form" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-孙悟空">编辑</a>
                    <a href="ajaxDone2.html" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="15">15</option>
                <option value="30">30</option>
                <option value="50">50</option>
                <option value="100">100</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${pageInfo.total} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageInfo.total}" data-page-size="${pageInfo.pageSize}" data-page-current="${pageInfo.pageNum}">
    </div>
</div>
</body>
</html>
