<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>活期交易查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/hq/getHqTransLogList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>交易类型:</label>
            <select name="transKind" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="invest" <c:if test="${transKind=='invest' }">selected</c:if>>投资（充值）</option>
            <option value="profit" <c:if test="${transKind=='profit' }">selected</c:if>>利息收益</option>
            <option value="withdraw" <c:if test="${transKind=='withdraw' }">selected</c:if>>提现</option>
            </select>
            &nbsp;
            <label>状态:</label>
            <select name="status" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="init" <c:if test="${status=='init'}">selected</c:if>>初始状态</option>
            <option value="success" <c:if test="${status=='success'}">selected</c:if>>成功</option>
            <option value="fail" <c:if test="${status=='fail'}">selected</c:if>>失败</option>
            </select>
            &nbsp;
             <label>交易时间：</label><input type="text" value="${beginTime}" name="beginTime" data-toggle="datepicker"/>--
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
            <th data-order-field="trans_no">流水号</th>
            <th data-order-field="trans_amt">交易金额</th>
            <th data-order-field="withdraw_fee">手续费</th>
            <th data-order-field="before_amt">交易前金额</th>
            <th data-order-field="after_amt">交易后金额</th>
            <th data-order-field="trans_time">交易时间</th>
            <th data-order-field="trans_kind">交易类型</th>
            <th data-order-field="balance_type">收支类型</th>
            <th data-order-field="status">状态</th>
            <th data-order-field="update_time">更新时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="hqTransLog" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${hqTransLog.userId}</td>
                <td>${hqTransLog.transNo}</td>
                <td>${hqTransLog.transAmt}</td>
                <td>${hqTransLog.withdrawFee}</td>
                <td>${hqTransLog.beforeAmt}</td>
                <td>${hqTransLog.afterAmt}</td>
                <td><fmt:formatDate value="${hqTransLog.transTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                <c:if test="${hqTransLog.transKind=='invest'}">
                	投资（充值）
                </c:if>
                <c:if test="${hqTransLog.transKind=='profit'}">
                	利息收益
                </c:if>
                <c:if test="${hqTransLog.transKind=='withdraw'}">
                	提现
                </c:if>
                </td>
                <td>
                <c:if test="${hqTransLog.balanceType=='in'}">
                	收入
                </c:if>
                <c:if test="${hqTransLog.balanceType=='out'}">
                	支出
                </c:if>
                </td>
                <td>
                	<c:if test="${hqTransLog.status=='init'}">
                	<span class="label label-primary">初始状态</span>
                	</c:if>
                	<c:if test="${hqTransLog.status=='success'}">
                	<span class="label label-success">成功</span>
                	</c:if>
                	<c:if test="${hqTransLog.status=='fail'}">
                	<span class="label label-danger">失败</span>
                	</c:if>
                </td>
                <td><fmt:formatDate value="${hqTransLog.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
            <tr>
        	<th>合计：</th>
        	<th></th>
        	<th>${sumTransAmt }</th>
        	<th></th>
        	<th></th>
        	<th></th>
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
