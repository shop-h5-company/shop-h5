<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>活期提现打款</title>
</head>
<script type="text/javascript">
	var inputs=$('input[name="ids"]');
	/*退回*/
	function sendBack() {
		var ids = new Array();
		for (var i = 0; i < inputs.length; i++) {
			if ($(inputs[i]).is(':checked')) {
				ids.push($(inputs[i]).val());
			}
		}
		if(ids.length==0){
			$("<div></div>").alertmsg("warn","请选择至少一条记录！");
			return;
		}
		ids = ids.join(",");
		$("#backRecords").attr("href","/hq/sendBack?ids="+ids);
		$("#backRecords").removeAttr("onclick");
		$("#backRecords").click();
	}

	/*打款*/
	function pay() {
		var ids = new Array();
		for (var i = 0; i < inputs.length; i++) {
			if ($(inputs[i]).is(':checked')) {
				ids.push($(inputs[i]).val());
			}
		}
		if(ids.length==0){
			$("<div></div>").alertmsg("warn","请选择至少一条记录！");
			return;
		}
		ids = ids.join(",");
		$("#payRecords").attr("href","/hq/pay?ids="+ids);
		$("#payRecords").removeAttr("onclick");
		$("#payRecords").click();
	}
</script>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/hq/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
        	<label>付款状态:</label>
            <select name="payStatus" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="not_do" <c:if test="${payStatus=='not_do'}">selected</c:if>>初审通过</option>
<%--             <option value="back" <c:if test="${payStatus=='back'}">selected</c:if>>退回</option>
            <option value="lian_pay" <c:if test="${payStatus=='lian_pay'}">selected</c:if>>连连打款中</option>
            <option value="success" <c:if test="${payStatus=='success'}">selected</c:if>>成功</option> --%>
            <option value="fail" <c:if test="${payStatus=='fail'}">selected</c:if>>失败</option>
            </select>
        	<label>付款人：</label><input type="text" value="${payAdmin}" name="payAdmin"/>
             <label>付款时间：</label><input type="text" value="${beginpTime}" name="beginpTime" data-toggle="datepicker"/>--
            <input type="text" value="${endpTime}" name="endpTime" data-toggle="datepicker"/>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        	&nbsp;
        	<a id="backRecords" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要退回选中记录吗？" onclick="sendBack()">退回</a>&nbsp;
        	<a id="payRecords" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要打款选中记录吗？" onclick="pay()">打款</a>&nbsp;
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="trans_no">业务流水号</th>
            <th data-order-field="withdraw_amt">提现金额</th>
            <th data-order-field="withdraw_fee">提现手续费</th>
            <th data-order-field="pay_status">付款状态</th>
            <th data-order-field="pay_admin">付款人</th>
            <th data-order-field="pay_time">付款时间</th>
            <th data-order-field="create_time">创建时间</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.transNo}</td>
                <td>${pageInfo.withdrawAmt}</td>
                <td>${pageInfo.withdrawFee}</td>
                <td>
                <c:if test="${pageInfo.payStatus=='not_do'}"><span class="label label-default">初审通过</span></c:if>
                <c:if test="${pageInfo.payStatus=='back'}"><span class="label label-warning">退回</span></c:if>
                <c:if test="${pageInfo.payStatus=='lian_pay'}"><span class="label label-primary">连连打款中</span></c:if>
                <c:if test="${pageInfo.payStatus=='success'}"><span class="label label-success">成功</span></c:if>
                <c:if test="${pageInfo.payStatus=='fail'}"><span class="label label-danger">失败</span></c:if>
                </td>
                <td>${pageInfo.payAdmin}</td>
                <td><fmt:formatDate value="${pageInfo.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${pageInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${pageInfo.hqWithdrawCheckId }"></td>
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
