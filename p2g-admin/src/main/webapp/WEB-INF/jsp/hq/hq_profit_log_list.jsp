<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>活期收益查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/hq/getHqProfitLogList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>发放状态:</label>
            <select name="status" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="not_account" <c:if test="${status=='not_account' }">selected</c:if>>未结算发放</option>
            <option value="has_account" <c:if test="${status=='has_account' }">selected</c:if>>已结算发放</option>
            </select>
            &nbsp;
             <label>发放时间：</label><input type="text" value="${beginTime}" name="beginTime" data-toggle="datepicker"/>--
            <input type="text" value="${endTime}" name="endTime" data-toggle="datepicker"/>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="balance_amt">活期金额</th>
            <th data-order-field="profit_date">收益日期</th>
            <th data-order-field="profit_amt">收益金额</th>
            <th data-order-field="base_rates">基础利率</th>
            <th data-order-field="active_rates">活动利率</th>
            <th data-order-field="create_time">发放时间</th>
            <th data-order-field="status">发放状态</th>
            <th data-order-field="update_time">更新时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="hqProfitLog" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${hqProfitLog.userId}</td>
                <td>${hqProfitLog.balanceAmt}</td>
                <td>${hqProfitLog.profitDate}</td>
                <td>${hqProfitLog.profitAmt}</td>
                <td>${hqProfitLog.baseRates}</td>
                <td>${hqProfitLog.activeRates}</td>
                <td><fmt:formatDate value="${hqProfitLog.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
           		<td>
           		<c:if test="${hqProfitLog.status=='not_account'}"><span class="label label-default">未结算发放</span></c:if>
           		<c:if test="${hqProfitLog.status=='has_account'}"><span class="label label-success">已结算发放</span></c:if>
           		</td>
           		<td><fmt:formatDate value="${hqProfitLog.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
         <tr>
        	<th>合计：</th>
        	<th></th>
        	<th></th>
        	<th>${sumProfitAmt }</th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
        </tr>
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
