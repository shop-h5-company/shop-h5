<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>资金交易查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/fund/getFundTransList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
       <div class="bjui-searchBar">
            <label>业务流水号：</label><input type="text" value="${transNo}" name="transNo" size="15" />
            <label>支付渠道流水号：</label><input type="text" value="${payNo}" name="payNo" size="15" />
            <label>交易类型:</label>
            <select name="kind" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="dq_rechage" <c:if test="${kind=='dq_rechage'}">selected</c:if>>定期充值投资</option>
            <option value="dq_withdraw" <c:if test="${kind=='dq_withdraw'}">selected</c:if>> 定期转银行卡提现</option>
            <option value="hq_rechage" <c:if test="${kind=='hq_rechage'}">selected</c:if>> 活期充值投资</option>
            <option value="hq_withdraw" <c:if test="${kind=='hq_withdraw'}">selected</c:if>> 活期提现</option>
            <option value="hq_profit" <c:if test="${kind=='hq_profit'}">selected</c:if>> 活期在投收益转余额</option>
            </select>
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
            <th data-order-field="fund_trans_list_id">资金交易序号</th>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="trans_no">业务流水号</th>
            <th data-order-field="pay_no">支付渠道流水号</th>
            <th data-order-field="kind">交易类型</th>
            <th data-order-field="income_kind">收支类型</th>
            <th data-order-field="trans_date">交易日期</th>
            <th data-order-field="trans_amt">交易金额</th>
            <th data-order-field="trans_fee">交易手续费</th>
            <th data-order-field="trans_time">交易时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="fundTransList" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${fundTransList.fundTransListId}</td>
                <td>${fundTransList.userId}</td>
                <td>${fundTransList.transNo}</td>
                <td>${fundTransList.payNo}</td>
                <td>
	                <c:if test="${fundTransList.kind=='dq_rechage'}">
					                定期充值投资
	                </c:if>
	                <c:if test="${fundTransList.kind=='dq_withdraw'}">
					                定期转银行卡提现
	                </c:if>
	                <c:if test="${fundTransList.kind=='hq_rechage'}">
					              活期充值投资
	                </c:if>
	                <c:if test="${fundTransList.kind=='hq_withdraw'}">
					                活期提现
	                </c:if>
	                <c:if test="${fundTransList.kind=='hq_profit'}">
					                活期在投收益转余额
	                </c:if>
                </td>
                <td>
	                <c:if test="${fundTransList.incomeKind=='in'}">
					                资金转入系统
	                </c:if>
	                <c:if test="${fundTransList.incomeKind=='out'}">
					                资金从系统转出
	                </c:if>
                </td>
                <td>${fundTransList.transDate}</td>
                <td>${fundTransList.transAmt}</td>
                <td>${fundTransList.transFee}</td>
                <td><fmt:formatDate value="${fundTransList.transTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
            <tr>
        	<th>合计：</th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th></th>
        	<th>${sumTransAmt }</th>
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
