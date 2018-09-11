<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>连连提现日志查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/lian/getLianWithdrawLogList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>商户订单号：</label><input type="text" value="${orderNo}" name="orderNo" size="15" />
            <label>连连订单号：</label><input type="text" value="${lianPayNo}" name="lianPayNo" size="15" />
            &nbsp;
            <label>订单状态:</label>
            <select name="status" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="doing" <c:if test="${status=='doing' }">selected</c:if>>处理中</option>
            <option value="success_asyn" <c:if test="${status=='success_asyn' }">selected</c:if>>异步成功</option>
            <option value="fail_asyn" <c:if test="${status=='fail_asyn' }">selected</c:if>>异步失败</option>
            <option value="success_sync" <c:if test="${status=='success_sync' }">selected</c:if>>实时回显成功</option>
            <option value="fail_sync" <c:if test="${status=='fail_sync' }">selected</c:if>>实时回显失败</option>
            <option value="invalid" <c:if test="${status=='invalid' }">selected</c:if>>无效订单</option>
            </select>
            &nbsp;
            <label>对账状态:</label>
            <select name="verifyStatus" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="not" <c:if test="${verifyStatus=='not' }">selected</c:if>>未对帐</option>
            <option value="ok" <c:if test="${verifyStatus=='ok' }">selected</c:if>>对账成功</option>
            </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="lian_withdraw_log_id">提现日志序号</th>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="order_no">商户订单号</th>
            <th data-order-field="order_date">商户订单时间</th>
            <th data-order-field="amount">金额</th>
            <th data-order-field="bank_card">银行卡号</th>
            <th data-order-field="bank_name">银行名称</th>
            <th data-order-field="lian_pay_no">连连订单号</th>
            <th data-order-field="settle_date">清算日期</th>
            <th data-order-field="brabank_name">开户支行名称</th>
            <th data-order-field="status">订单状态</th>
            <th data-order-field="verify_status">对账状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="lianWithdrawLog" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${lianWithdrawLog.lianWithdrawLogId}</td>
                <td>${lianWithdrawLog.userId}</td>
                <td>${lianWithdrawLog.orderNo}</td>
                <td>${lianWithdrawLog.orderDate}</td>
                <td>${lianWithdrawLog.amount}</td>
                <td>
	                <c:if test="${lianWithdrawLog.bankCard!=null}">
		                ${fn:substring(lianWithdrawLog.bankCard,0,4)}****${fn:substring(lianWithdrawLog.bankCard,lianWithdrawLog.bankCard.length()-4,lianWithdrawLog.bankCard.length())}
	                </c:if>
                </td>
                <td>${lianWithdrawLog.bankName}</td>
                <td>${lianWithdrawLog.lianPayNo}</td>
                <td>${lianWithdrawLog.settleDate}</td>
                <td>${lianWithdrawLog.brabankName}</td>
                <td>
                	<c:if test="${lianWithdrawLog.status=='doing'}">
                		<span class="label label-primary">处理中</span>
                	</c:if>
                	<c:if test="${lianWithdrawLog.status=='success_asyn'}">
                		<span class="label label-success">异步成功</span>
                	</c:if>
                	<c:if test="${lianWithdrawLog.status=='fail_asyn'}">
                		<span class="label label-danger">异步失败</span>
                	</c:if>
                	<c:if test="${lianWithdrawLog.status=='success_sync'}">
                		<span class="label label-success">实时回显成功</span>
                	</c:if>
                	<c:if test="${lianWithdrawLog.status=='fail_sync'}">
                		<span class="label label-danger">实时回显失败</span>
                	</c:if>
                	<c:if test="${lianWithdrawLog.status=='invalid'}">
                		<span class="label label-default">无效订单</span>
                	</c:if>
                </td>
                <td>
	                <c:if test="${lianWithdrawLog.verifyStatus=='not'}">
					   <span class="label label-default">未对帐</span>
	                </c:if>
	                <c:if test="${lianWithdrawLog.verifyStatus=='ok'}">
					   <span class="label label-success">对帐成功</span>
	                </c:if>
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
