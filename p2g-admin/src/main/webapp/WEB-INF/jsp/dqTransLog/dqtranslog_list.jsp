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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/dqTransLog/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar">
            <label>用户手机号：</label><input type="text" value="${dqTransLog.userId}" name="userId" size="15"/>
            <label for="investDays">投资期限:</label>
            <select name="investDays" id="investDays" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="7" <c:if test="${dqTransLog.investDays=='7' }">selected</c:if>>7天 </option>
                <option value="30" <c:if test="${dqTransLog.investDays=='30' }">selected</c:if>>30天</option>
                <option value="90" <c:if test="${dqTransLog.investDays=='90' }">selected</c:if>>90天</option>
                <option value="180" <c:if test="${dqTransLog.investDays=='180' }">selected</c:if>>180天</option>
                <option value="360" <c:if test="${dqTransLog.investDays=='360' }">selected</c:if>>360天</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="dq_trans_log_id" >定期交易序号</th>
            <th data-order-field="user_id">用户手机号</th>
            <th data-order-field="dq_product_id">定期产品序号</th>
            <th data-order-field="trans_no">业务流水号</th>
            <th data-order-field="invest_time">投资时间</th>
            <th data-order-field="invest_days">投资期限</th>
            <th data-order-field="end_time">到期时间</th>
            <th data-order-field="dq_rates">定期利率</th>
            <th data-order-field="active_rates">活动利率</th>
            <th data-order-field="invest_amt">投资金额</th>
            <th data-order-field="total_profit_amt">总收益金额</th>
            <th data-order-field="invest_profit_amt">投资收益金额</th>
            <th data-order-field="active_profit_amt">活动收益金额</th>
            <th data-order-field="end_deal">到期处理方式</th>
            <th data-order-field="continue_product_id">到期续投产品</th>
            <th data-order-field="continue_auto_ticket">到期续投使用加息券</th>
            <th data-order-field="end_deal_time">到期处理设置时间</th>
            <th data-order-field="fund_source">资金来源</th>
            <th data-order-field="platform_source">平台来源</th>
            <th data-order-field="dq_ticket_id">加息券序号</th>
            <th data-order-field="ticket_rates">加息券利率</th>
            <th data-order-field="ticket_profit_amt">加息券收益</th>
            <th data-order-field="status">状态</th>
            <th data-order-field="close_time">到期关闭时间</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.dqTransLogId}</td>
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.dqProductId}</td>
                <td>${pageInfo.transNo}</td>
                <td>
                    <fmt:formatDate value="${pageInfo.investTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${pageInfo.investDays}</td>
                <td>
                    <fmt:formatDate value="${pageInfo.endTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${pageInfo.dqRates}</td>
                <td>${pageInfo.activeRates}</td>
                <td>${pageInfo.investAmt}</td>
                <td>${pageInfo.totalProfitAmt}</td>
                <td>${pageInfo.investProfitAmt}</td>
                <td>${pageInfo.activeProfitAmt}</td>
                <td>
                    <c:if test="${pageInfo.endDeal=='continue'}">
                        续投
                    </c:if>
                    <c:if test="${pageInfo.endDeal=='withdraw'}">
                        转到银行卡
                    </c:if>
                </td>
                <td>${pageInfo.continueProductId}</td>
                <td>
                    <c:if test="${pageInfo.continueAutoTicket=='yes'}">
                        是
                    </c:if>
                    <c:if test="${pageInfo.continueAutoTicket=='no'}">
                        否
                    </c:if>
                </td>
                <td>${pageInfo.endDealTime}</td>
                <td>
                    <c:if test="${pageInfo.fundSource=='continue'}">
                        续投
                    </c:if>
                    <c:if test="${pageInfo.fundSource=='recharge'}">
                        直接充值转入
                    </c:if>
                </td>
                <td>${pageInfo.platformSource}</td>
                <td>${pageInfo.dqTicketId}</td>
                <td>${pageInfo.ticketRates}</td>
                <td>${pageInfo.ticketProfitAmt}</td>
                <td>
                    <c:if test="${pageInfo.status=='doing'}">
                        投资中
                    </c:if>
                    <c:if test="${pageInfo.status=='checking'}">
                        转到银行卡审核中
                    </c:if>
                    <c:if test="${pageInfo.status=='end'}">
                        已到期
                    </c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.closeTime}" pattern="YYYY年MM月dd日 HH:mm"></fmt:formatDate></td>

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
