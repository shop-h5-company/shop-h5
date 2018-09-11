<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>连连充值日志查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/lian/getLianRechargeLogList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>商户订单号：</label><input type="text" value="${orderNo}" name="orderNo" size="15" />
            <label>签约协议号：</label><input type="text" value="${agreeNo}" name="agreeNo" size="15" />
            &nbsp;
           <label>订单状态:</label>
            <select name="status" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="0" <c:if test="${status=='0' }">selected</c:if>>处理中</option>
            <option value="1" <c:if test="${status=='1' }">selected</c:if>>异步成功</option>
            <option value="2" <c:if test="${status=='2' }">selected</c:if>>异步失败</option>
            <option value="3" <c:if test="${status=='3' }">selected</c:if>>实时回显成功</option>
            <option value="4" <c:if test="${status=='4' }">selected</c:if>>实时回显失败</option>
            <option value="5" <c:if test="${status=='5' }">selected</c:if>>无效订单</option>
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
            <th data-order-field="lian_recharge_log_id">充值日志序号</th>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="order_no">商户订单号</th>
            <th data-order-field="order_date">商户订单时间</th>
            <th data-order-field="amount">金额</th>
            <th data-order-field="bank_card">银行卡号</th>
            <th data-order-field="name">姓名</th>
            <th data-order-field="id_card">身份证</th>
            <th data-order-field="agree_no">签约协议号</th>
            <th data-order-field="status">订单状态</th>
            <th data-order-field="yintong_pay_no">连连支付单号</th>
            <th data-order-field="yintong_pay_result">连连支付结果</th>
            <th data-order-field="yintong_settle_date">清算日期</th>
            <th data-order-field="verify_status">对账状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="lianRechargeLog" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${lianRechargeLog.lianRechargeLogId}</td>
                <td>${lianRechargeLog.userId}</td>
                <td>${lianRechargeLog.orderNo}</td>
                <td>${lianRechargeLog.orderDate}</td>
                <td>${lianRechargeLog.amount}</td>
                <td>
	                <c:if test="${lianRechargeLog.bankCard!=null}">
		                ${fn:substring(lianRechargeLog.bankCard,0,4)}****${fn:substring(lianRechargeLog.bankCard,lianRechargeLog.bankCard.length()-4,lianRechargeLog.bankCard.length())}
	                </c:if>
                </td>
                <td>${lianRechargeLog.name}</td>
                <td>
	                <c:if test="${lianRechargeLog.idCard!=null}">
		                ${fn:substring(lianRechargeLog.idCard,0,4)}****${fn:substring(lianRechargeLog.idCard,lianRechargeLog.idCard.length()-4,lianRechargeLog.idCard.length())}
	                </c:if>
                </td>
                <td>${lianRechargeLog.agreeNo}</td>
                <td>
                	<c:if test="${lianRechargeLog.status=='0'}">
                		<span class="label label-primary">处理中</span>
                	</c:if>
                	<c:if test="${lianRechargeLog.status=='1'}">
                		<span class="label label-success">异步成功</span>
                	</c:if>
                	<c:if test="${lianRechargeLog.status=='2'}">
                		<span class="label label-danger">异步失败</span>
                	</c:if>
                	<c:if test="${lianRechargeLog.status=='3'}">
                		<span class="label label-success">实时回显成功</span>
                	</c:if>
                	<c:if test="${lianRechargeLog.status=='4'}">
                		<span class="label label-danger">实时回显失败</span>
                	</c:if>
                	<c:if test="${lianRechargeLog.status=='5'}">
                		<span class="label label-default">无效订单</span>
                	</c:if>
                </td>
                <td>${lianRechargeLog.yintongPayNo}</td>
                <td>
	                <c:if test="${lianRechargeLog.yintongPayResult=='0'}">
					   <span class="label label-primary">  处理中</span>
	                </c:if>
	                <c:if test="${lianRechargeLog.yintongPayResult=='1'}">
					   <span class="label label-success">成功</span>
	                </c:if>
	                <c:if test="${lianRechargeLog.yintongPayResult=='2'}">
					   <span class="label label-danger">失败</span>
	                </c:if>
                </td>
                <td>${lianRechargeLog.yintongSettleDate}</td>
                <td>
	                <c:if test="${lianRechargeLog.verifyStatus=='not'}">
					   <span class="label label-default">未对帐</span>
	                </c:if>
	                <c:if test="${lianRechargeLog.verifyStatus=='ok'}">
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
