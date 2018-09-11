<%--
  Created by IntelliJ IDEA.
  User: GJF
  Date: 2016/6/28
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp" %>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/dqTicket/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar">
            <label>用户手机号：</label><input type="text" value="${dqTicket.userId}" name="userId" size="15"/>
            <label for="status">投资期限:</label>
            <select name="status" id="status" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="not_used" <c:if test="${dqTicket.status=='not_used' }">selected</c:if>>未使用 </option>
                <option value="has_used" <c:if test="${dqTicket.status=='has_used' }">selected</c:if>>已使用</option>
            </select>
            <label for="source">发送来源:</label>
            <select name="source" id="source" data-toggle="selectpicker">
                <option value="" selected>--请选择--</option>
                <option value="admin_people" <c:if test="${dqTicket.source=='admin_people' }">selected</c:if>>后台人工 </option>
                <option value="system_reg" <c:if test="${dqTicket.source=='system_reg' }">selected</c:if>>注册自动</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            &nbsp;
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog"
               href="/dqTicket/dqticket_add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="user_id">用户手机号</th>
            <th data-order-field="dq_product_id">定期产品序号</th>
            <th data-order-field="inc_rates">加息利率</th>
            <th data-order-field="inc_days">加息天数</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="expired_time">过期时间</th>
            <th data-order-field="status">使用状态</th>
            <th data-order-field="used_time">used_time</th>
            <th data-order-field="source">发放来源</th>
            <th width="100">操作</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.dqProductId}</td>
                <td>${pageInfo.incRates}</td>
                <td>${pageInfo.incDays}</td>
                <td>
                    <fmt:formatDate value="${pageInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <fmt:formatDate value="${pageInfo.expiredTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <c:if test="${pageInfo.status=='not_used'}">
                        未使用
                    </c:if>
                    <c:if test="${pageInfo.status=='has_used'}">
                        已使用
                    </c:if>
                </td>
                <td>
                    <fmt:formatDate value="${pageInfo.usedTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <c:if test="${pageInfo.source=='admin_people'}">
                        后台人工
                    </c:if>
                    <c:if test="${pageInfo.source=='system_reg'}">
                        注册自动
                    </c:if>
                </td>
                <td>
                    <a href="/dqTicket/dqticket_edit?dqTicketId=${pageInfo.dqTicketId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${pageInfo.dqTicketId}">编辑</a>
                    <a href="/dqTicket/deleteDqTicket?dqTicketId=${pageInfo.dqTicketId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
    <div class="pagination-box" data-toggle="pagination" data-total="${pageInfo.total}"
         data-page-size="${pageInfo.pageSize}" data-page-current="${pageInfo.pageNum}">
    </div>
</div>
</body>
</html>
