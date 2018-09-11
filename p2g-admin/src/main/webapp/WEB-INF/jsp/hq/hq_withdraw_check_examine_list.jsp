<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>活期提现审核</title>
</head>
<script type="text/javascript">
	var inputs=$('input[name="ids"]');
	/*通过*/
	function sendPass() {
		var ids = new Array();
		for (var i = 0; i < inputs.length; i++) {
			if ($(inputs[i]).is(':checked')) {
				ids.push($(inputs[i]).val());
			}
		}
		ids = ids.join(",");
		if(ids == ""){
			$("<div></div>").alertmsg("warn","请选择至少一条数据")
			return false;
		}
		$("#backAdopts").attr("href","/hq/editHqWithdrawCheckSubmit?ids="+ids+"&checkStatus=pass");
		$("#backAdopts").removeAttr("onclick");
		$("#backAdopts").click();
	}
</script>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/hq/getExamineList?checkStatusNotDo=not_do&checkStatusBack=back" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
        	<label>审核人：</label><input type="text" value="${checkAdmin}" name="checkAdmin"/>
             <label>审核时间：</label><input type="text" value="${begincTime}" name="begincTime" data-toggle="datepicker"/>--
            <input type="text" value="${endcTime}" name="endcTime" data-toggle="datepicker"/>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        	&nbsp;
        	<a id="backAdopts" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要通过审核选中记录吗？" onclick="sendPass()">通过</a>&nbsp;
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
            <th data-order-field="check_admin">审核人</th>
            <th data-order-field="check_status">审核状态</th>
            <th data-order-field="check_time">审核时间</th>
            <th data-order-field="create_time">创建时间</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.transNo}</td>
                <td>${pageInfo.withdrawAmt}</td>
                <td>${pageInfo.withdrawFee}</td>
                <td>${pageInfo.checkAdmin}</td>
                <td>
	                <c:if test="${pageInfo.checkStatus == 'not_do'}"><span class="label label-default">未审核</span></c:if>
	                <c:if test="${pageInfo.checkStatus == 'pass'}"><span class="label label-success">通过</span></c:if>
	                <c:if test="${pageInfo.checkStatus == 'back'}"><span class="label label-warning">退回</span></c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.checkTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${pageInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${pageInfo.hqWithdrawCheckId }"></td>
                <td>
                	<a href="/hq/editHqWithdrawCheck?checkStatus=reject&hqWithdrawCheckId=${pageInfo.hqWithdrawCheckId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="300" data-width="500" data-toggle="dialog" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="拒绝">拒绝</a>
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
