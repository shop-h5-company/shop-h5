<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>资金账户查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/fund/getFundAccountList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>用户序号：</label><input type="text" value="${userId}" name="userId" size="15" />
            <label>连连账户开通状态:</label>
            <select name="lianAccountStatus" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="not" <c:if test="${lianAccountStatus=='not' }">selected</c:if>>未开通</option>
            <option value="has" <c:if test="${lianAccountStatus=='has' }">selected</c:if>>已开通</option>
            <option value="unbind" <c:if test="${lianAccountStatus=='unbind' }">selected</c:if>>已解绑</option>
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
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="has_invest">是否已投资</th>
            <th data-order-field="hq_balance_amt">活期余额</th>
            <th data-order-field="hq_not_acct_profit_amt">活期在投收益</th>
            <th data-order-field="hq_withdraw_freezing_amt">活期提现冻结</th>
            <th data-order-field="hq_total_recharge_amt">活期累计充值</th>
            <th data-order-field="hq_total_withdraw_amt">活期累计提现</th>
            <th data-order-field="hq_total_profit_amt">活期累计收益</th>
            <th data-order-field="hq_last_recharge_time">最后充值时间</th>
            <th data-order-field="hq_last_withdraw_time">最后提现时间</th>
            <th data-order-field="lian_account_status">连连帐户开通状态</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="fundAccount" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${fundAccount.userId}</td>
                <td>
	                <c:if test="${fundAccount.hasInvest=='yes'}">
				   	              是
	                </c:if>
	                <c:if test="${fundAccount.hasInvest=='no'}">
	                	否
	                </c:if>
                </td> 
                <td>${fundAccount.hqBalanceAmt}</td>
                <td>${fundAccount.hqNotAcctProfitAmt}</td>
                <td>${fundAccount.hqWithdrawFreezingAmt}</td>
                <td>${fundAccount.hqTotalRechargeAmt}</td>
                <td>${fundAccount.hqTotalWithdrawAmt}</td>
                <td>${fundAccount.hqTotalProfitAmt}</td>
                <td><fmt:formatDate value="${fundAccount.hqLastRechargeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${fundAccount.hqLastWithdrawTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
	                <c:if test="${fundAccount.lianAccountStatus=='not'}">
		               	<span class="label label-default">未开通</span>
	                </c:if>
	                <c:if test="${fundAccount.lianAccountStatus=='has'}">
		       		    <span class="label label-success"> 已开通</span>
	                </c:if>
	                <c:if test="${fundAccount.lianAccountStatus=='unbind'}">
					    <span class="label label-primary">已解绑</span>
	                </c:if>
              	</td>
              	<td>
                    <a href="/fund/viewFundAccount?userId=${fundAccount.userId}" class="btn btn-green" data-id="dialog" data-height="620" data-width="900" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="查看详情">查看</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
        	<th>合计：</th>
        	<th></th>
        	<th>${sumHqBalance}</th>
        	<th></th>
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
