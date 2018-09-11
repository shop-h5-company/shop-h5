<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/23
  Time: 20:08
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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/admin/menuList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>权限名称：</label><input type="text" value="${menuName }" name="menuName" size="15" />
            <label>权限URL:</label><input type="text" value="${menuUrl }" name="menuUrl" size="10">
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" href="/admin/menu_add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="admin_menu_id">菜单序号</th>
            <th data-order-field="menu_name">菜单名称</th>
            <th data-order-field="data_faicon">菜单图标</th>
            <th data-order-field="menu_type">菜单类型</th>
            <th data-order-field="parent_id">父菜单标识</th>
            <th data-order-field="iconcls">菜单样式图标</th>
            <th data-order-field="reqUrl">菜单URL</th>
            <th data-order-field="state">状态</th>
            <th data-order-field="remark">说明</th>
            <th data-order-field="level">级别</th>
            <th data-order-field="sn">排序</th>
            <th data-order-field="create_time">创建日期</th>
            <th data-order-field="data_options_id">菜单名称标识</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="sysPerm" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${sysPerm.adminMenuId}</td>
                <td>${sysPerm.menuName}</td>
                <td>${sysPerm.dataFaicon}</td>
                <td>
                    <c:if test="${sysPerm.menuType=='0'}">
                        其他
                    </c:if>
                    <c:if test="${sysPerm.menuType=='1'}">
                        菜单
                    </c:if>
                </td>
                <td>${sysPerm.parentId}</td>
                <td>${sysPerm.iconcls}</td>
                <td>${sysPerm.reqUrl}</td>
                <td>
                    <c:if test="${sysPerm.state=='0'}">
                        <span class="label label-default">隐藏</span>
                    </c:if>
                    <c:if test="${sysPerm.state=='1'}">
                        <span class="label label-success">显示</span>
                    </c:if>
                </td>
                <td>${sysPerm.remark}</td>
                <td>
                    <c:if test="${sysPerm.level=='1'}">
                       一级
                    </c:if>
                    <c:if test="${sysPerm.level=='2'}">
                        二级
                    </c:if>
                    <c:if test="${sysPerm.level=='3'}">
                       三级
                    </c:if>
                </td>
                <td>${sysPerm.sn}</td>
                <td><fmt:formatDate value="${sysPerm.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${sysPerm.dataOptionsId}</td>
                <td>
                    <a href="/admin/menu_edit?adminMenuId=${sysPerm.adminMenuId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${sysPerm.menuName}">编辑</a>
                    <a href="/admin/deleteMenu?adminMenuId=${sysPerm.adminMenuId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
