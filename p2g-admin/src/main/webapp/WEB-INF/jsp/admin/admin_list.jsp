<% try {

%>
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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/admin/list" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>管理员账号：</label><input type="text" value="${adminCode}" name="adminCode" size="15" />
            <label>管理员姓名:</label><input type="text" value="${adminNameq }" name="adminNameq" size="15">
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
           	<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" href="/admin/add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="admin_id">序号</th>
            <th data-order-field="admin_code" align="center">管理员账号</th>
            <th data-order-field="admin_name">管理员姓名</th>
            <th data-order-field="status">状态</th>
            <th data-order-direction="asc" data-order-field="update_time">更新时间</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="admin" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${admin.adminId}</td>
                <td>${admin.adminCode}</td>
                <td>${admin.adminName}</td>
                <td>
                <c:if test="${admin.status=='disabled'}">
                	不可用
                </c:if>
                <c:if test="${admin.status=='enabled'}">
                	可用
                </c:if>
                </td>
                <td><fmt:formatDate value="${admin.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <a href="/admin/editAdmin?adminId=${admin.adminId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${admin.adminCode}">编辑</a>
                    <a href="/admin/deleteAdmin?adminId=${admin.adminId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
                	<a href="/admin/editAdminRole?adminId=${admin.adminId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="分配角色">分配角色</a>
                	<a href="/admin/editAdminPermission?adminId=${admin.adminId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="分配权限">分配权限</a>
                	<a href="/admin/editAdminMenu?adminId=${admin.adminId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="分配菜单">分配菜单</a>
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
<%}catch (Exception e){
    System.out.print(e);
}%>