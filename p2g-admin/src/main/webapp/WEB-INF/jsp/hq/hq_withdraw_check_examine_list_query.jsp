<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>活期提现审核查询</title>
</head>
<script type="text/javascript">

</script>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/hq/getAllExamineList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>用户序号：</label><input type="text" placeholder="请输入用户序号" name="userId" value="${userId}"/>
            <label>流水号：</label><input type="text" placeholder="请输入流水号" name="transNo" value="${transNo}"/>
            <label for="checkStatus">审核状态:</label>
            <select name="checkStatus" id="checkStatus" data-toggle="selectpicker" data-width="150" >
                <option value="" selected>--请选择--</option>
                <option value="not_do" <c:if test="${checkStatus=='not_do' }">selected</c:if>>未审核 </option>
                <option value="pass" <c:if test="${checkStatus=='pass' }">selected</c:if>>审核通过</option>
                <option value="reject" <c:if test="${checkStatus=='reject' }">selected</c:if>>审核拒绝</option>
                <option value="back" <c:if test="${checkStatus=='back' }">selected</c:if>>付款退回</option>
            </select>
            <label for="payStatusList">付款状态:</label>
            <select name="payStatusList" id="payStatusList" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="not_do" <c:if test="${payStatusList!=null and payStatusList.get(0)=='not_do' }">selected</c:if>>初审通过</option>
                <option value="back" <c:if test="${payStatusList!=null and payStatusList.get(0)=='back' }">selected</c:if>>退回</option>
                <option value="lian_pay" <c:if test="${payStatusList!=null and payStatusList.get(0)=='lian_pay' }">selected</c:if>>连连打款中</option>
                <option value="success" <c:if test="${payStatusList!=null and payStatusList.get(0)=='success' }">selected</c:if>>成功</option>
                <option value="fail" <c:if test="${payStatusList!=null and payStatusList.get(0)=='fail' }">selected</c:if>>失败</option>
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
            <th data-order-field="trans_no">业务流水号</th>
            <th data-order-field="withdraw_amt">提现金额</th>
            <th data-order-field="withdraw_fee">提现手续费</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="check_admin">审核人</th>
            <th data-order-field="check_status">审核状态</th>

            <th data-order-field="check_time">审核时间</th>
            <th data-order-field="pay_status">付款状态</th>
            <th data-order-field="pay_admin">付款人</th>
            <th data-order-field="pay_time">付款时间</th>
            <th data-order-field="bank_code">银行编码</th>
            <th data-order-field="bank_name">银行名称</th>
            <th data-order-field="bank_card">银行卡号</th>
            <th data-order-field="remark">操作备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.userId}</td>
                <td>${pageInfo.transNo}</td>
                <td>${pageInfo.withdrawAmt}</td>
                <td>${pageInfo.withdrawFee}</td>
                <td><fmt:formatDate value="${pageInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${pageInfo.checkAdmin}</td>
                <td>
	                <c:if test="${pageInfo.checkStatus == 'not_do'}"><span class="label label-default">未审核</span></c:if>
	                <c:if test="${pageInfo.checkStatus == 'pass'}"><span class="label label-success">审核通过</span></c:if>
	                <c:if test="${pageInfo.checkStatus == 'reject'}"><span class="label label-danger">审核拒绝</span></c:if>
	                <c:if test="${pageInfo.checkStatus == 'back'}"><span class="label label-warning">付款退回</span></c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.checkTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:if test="${pageInfo.payStatus == 'not_do'}"><span class="label label-success">初审通过</span></c:if>
                    <c:if test="${pageInfo.payStatus == 'back'}"><span class="label label-warning">退回</span></c:if>
                    <c:if test="${pageInfo.payStatus == 'lian_pay'}"><span class="label label-primary">连连打款中</span></c:if>
                    <c:if test="${pageInfo.payStatus == 'success'}"><span class="label label-success">成功</span></c:if>
                    <c:if test="${pageInfo.payStatus == 'fail'}"><span class="label label-danger">失败</span></c:if>
                </td>

                <td>${pageInfo.payAdmin}</td>
                <td><fmt:formatDate value="${pageInfo.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${pageInfo.bankCode}</td>
                <td>${pageInfo.bankName}</td>
                <td>
                    <c:if test="${pageInfo.bankCard!=null}">
                        ${fn:substring(pageInfo.bankCard,0,4)}****${fn:substring(pageInfo.bankCard,pageInfo.bankCard.length()-4,pageInfo.bankCard.length())}
                    </c:if>
                </td>
                <td>${pageInfo.remark}</td>
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
