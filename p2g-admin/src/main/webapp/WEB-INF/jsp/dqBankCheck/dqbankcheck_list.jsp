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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/dqBankCheck/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar">
            <label>用户手机号：</label><input type="text" value="${dqBankCheck.userId}" name="userId" size="15"/>
            <label for="checkStatus" >审核状态:</label>
            <select name="checkStatus" id="checkStatus" data-toggle="selectpicker" data-width="150" multiple>
                <option value="" selected>--请选择--</option>
                <option value="not_do" <c:if test="${dqBankCheck.checkStatus=='not_do' }">selected</c:if>>未审核 </option>
                <option value="pass" <c:if test="${dqBankCheck.checkStatus=='pass' }">selected</c:if>>通过</option>
                <option value="back" <c:if test="${dqBankCheck.checkStatus=='back' }">selected</c:if>>退回</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true" >
        <thead>
        <tr>
            <th data-order-field="deposit_bank_check_id">定期转银行审核序号</th>
            <th data-order-field="user_id">用户手机号</th>
            <th data-order-field="dq_product_id">定期产品序号</th>
            <th data-order-field="dq_trans_log_id">定期交易序号</th>
            <th data-order-field="trans_no">业务流水号</th>
            <th data-order-field="invest_amt">投资金额</th>
            <th data-order-field="dq_rates">定期利率</th>
            <th data-order-field="active_rates">活动利率</th>
            <th data-order-field="ticket_rates">加息劵利率</th>
            <th data-order-field="invest_profit_amt">投资收益金额</th>
            <th data-order-field="active_profit_amt">活动收益</th>
            <th data-order-field="ticket_profit_amt">加息劵收益金额</th>
            <th data-order-field="total_profit_amt">总收益金额</th>
            <th data-order-field="total_withdraw_amt">总提现金额</th>
            <th data-order-field="invest_time">投资时间</th>
            <th data-order-field="invest_days">投资期限</th>
            <th data-order-field="end_time">到期时间</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="check_status">审核状态</th>
            <th data-order-field="check_time">审核时间</th>
            <th data-order-field="pay_status">付款状态</th>
            <th data-order-field="pay_time">付款时间</th>
            <th width="100">操作</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.depositBankCheckId}</td>
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.dqProductId}</td>
                <td>${pageInfo.dqTransLogId}</td>
                <td>${pageInfo.transNo}</td>
                <td>${pageInfo.investAmt}</td>
                <td>${pageInfo.dqRates}</td>
                <td>${pageInfo.activeRates}</td>
                <td>${pageInfo.ticketRates} </td>
                <td>${pageInfo.investProfitAmt} </td>
                <td>${pageInfo.activeProfitAmt} </td>
                <td>${pageInfo.ticketProfitAmt} </td>
                <td>${pageInfo.totalProfitAmt} </td>
                <td>${pageInfo.totalWithdrawAmt} </td>
                <td><fmt:formatDate value="${pageInfo.investTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                <td>${pageInfo.investDays} </td>
                <td>
                    <fmt:formatDate value="${pageInfo.endTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <fmt:formatDate value="${pageInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <c:if test="${pageInfo.checkStatus=='not_do'}">
                        未审核
                    </c:if>
                    <c:if test="${pageInfo.checkStatus=='pass'}">
                        通过
                    </c:if>
                    <c:if test="${pageInfo.checkStatus=='back'}">
                        退回
                    </c:if>
                </td>
                <td>
                    <fmt:formatDate value="${pageInfo.checkTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <c:if test="${pageInfo.payStatus=='not_do'}">
                        初审通过
                    </c:if>
                    <c:if test="${pageInfo.payStatus=='back'}">
                        退回
                    </c:if>
                    <c:if test="${pageInfo.payStatus=='success'}">
                        成功
                    </c:if>
                    <c:if test="${pageInfo.payStatus=='fail'}">
                        失败
                    </c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.payTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>

                    <a href="/dqBankCheck/dqbankcheck?depositBankCheckId=${pageInfo.depositBankCheckId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？"  data-title="审核-${pageInfo.transNo}">审核</a>

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
