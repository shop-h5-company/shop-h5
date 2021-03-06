<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>首页推荐管理</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/operation/getCmHomeTuijianList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>创建时间：</label><input type="text" value="${beginTime}" name="beginTime" data-toggle="datepicker"/>--
            <input type="text" value="${endTime}" name="endTime" data-toggle="datepicker"/>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        	<a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" href="/operation/addCmHomeTuijian">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="cm_home_tuijian_id">推荐序号</th>
            <th data-order-field="img_url">图片路径</th>
            <th data-order-field="go_uri">跳转路径</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="update_time">更新时间</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="cmHomeTuijian" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${cmHomeTuijian.cmHomeTuijianId}</td>
                <td>${cmHomeTuijian.imgUrl}</td>
                <td>${cmHomeTuijian.goUrl}</td>
                <td><fmt:formatDate value="${cmHomeTuijian.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${cmHomeTuijian.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <a href="/operation/editCmHomeTuijian?cmHomeTuijianId=${cmHomeTuijian.cmHomeTuijianId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${cmHomeTuijian.cmHomeTuijianId}">编辑</a>
                    <a href="/operation/deleteCmHomeTuijian?cmHomeTuijianId=${cmHomeTuijian.cmHomeTuijianId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
