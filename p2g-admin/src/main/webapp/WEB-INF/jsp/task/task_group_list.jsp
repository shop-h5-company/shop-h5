<%--
  Created by IntelliJ myeclipse.
  User: zhaozizhen
  Date: 2016/6/28
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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/taskGroup/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>组名：</label><input type="text" value="${groupName}" name="groupName" size="15" />
            <label>更新时间:</label>
            <span style="position: relative; display: inline-block;" class="wrap_bjui_btn_box"><input value="<fmt:formatDate value="${updateTime}" pattern="yyyy-MM-dd"/>" class="form-control" style="padding-right: 15px;" name="updateTime" data-toggle="datepicker" placeholder="更新时间" type="text"><a style="height: 22px; line-height: 22px;" class="bjui-lookup" href="javascript:;" data-toggle="datepickerbtn"><i class="fa fa-calendar"></i></a></span>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" href="/taskGroup/add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
        	<th data-order-field="No" width="15">No</th>
            <th data-order-field="group_name">分组名称</th>
            <th data-order-field="group_desc">分组描述</th>
            <th data-order-field="enable">是否可用</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="update_time">更新时间</th>
            <th width="100">操作</th>
        </tr>
        
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
            	<td>${status.index+1}</td>
            	<td>${pageInfo.groupName}</td>
                <td>${pageInfo.groupDesc}</td>
                <c:if test="${pageInfo.enable == 1}">
                	<td>是</td>
                </c:if>
                <c:if test="${pageInfo.enable == 0}">
                	<td>否</td>
                </c:if>
                <td ><fmt:formatDate value="${pageInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td ><fmt:formatDate value="${pageInfo.updateTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>
                    <a href="/taskGroup/editTaskGroup?groupId=${pageInfo.groupId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${pageInfo.groupId}">编辑</a>
                    <a href="/taskGroup/deleteTaskGroup?groupId=${pageInfo.groupId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
