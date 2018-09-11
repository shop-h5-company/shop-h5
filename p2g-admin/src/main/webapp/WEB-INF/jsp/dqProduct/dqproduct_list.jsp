<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/21
  Time: 17:42
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
    <form id="pagerForm" data-toggle="ajaxsearch" action="/dqProduct/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar">
            <label>定期名称：</label><input type="text" value="${dqProduct.dqName}" name="dqName" size="15"/>
            <label for="dqDays">定期期限:</label>
            <select name="dqDays" id="dqDays" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="7" <c:if test="${dqProduct.dqDays=='7' }">selected</c:if>>7天 </option>
                <option value="14" <c:if test="${dqProduct.dqDays=='14' }">selected</c:if>>14天</option>
                <option value="28" <c:if test="${dqProduct.dqDays=='28' }">selected</c:if>>28天</option>
                <option value="91" <c:if test="${dqProduct.dqDays=='91' }">selected</c:if>>91天</option>
                <option value="182" <c:if test="${dqProduct.dqDays=='182' }">selected</c:if>>182天</option>
                <option value="365" <c:if test="${dqProduct.dqDays=='365' }">selected</c:if>>365天</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            &nbsp;
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog"
               href="/dqProduct/dqproduct_add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="dq_name">定期名称</th>
            <th data-order-field="remark">宣传描述</th>
            <th data-order-field="dq_rates">定期利率</th>
            <th data-order-field="active_rates">活期利率</th>
            <th data-order-field="dq_days">定期期限</th>
            <th data-order-field="per_min_amt">起投金额</th>
            <th data-order-field="per_max_amt">申购限额</th>
            <th data-order-field="invest_status">是否可投</th>
            <th data-order-field="createtime">更新时间</th>
            <th width="100">操作</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.dqName}</td>
                <td>${pageInfo.remark}</td>
                <td>${pageInfo.dqRates}</td>
                <td>${pageInfo.activeRates}</td>
                <td>${pageInfo.dqDays}</td>
                <td>${pageInfo.perMinAmt}</td>
                <td>${pageInfo.perMaxAmt}</td>
                <td>
                    <c:if test="${pageInfo.investStatus=='yes'}">
                        是
                    </c:if>
                    <c:if test="${pageInfo.investStatus=='no'}">
                        否
                    </c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.updateTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>

                    <a href="/dqProduct/dqproduct_edit?dqProductId=${pageInfo.dqProductId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${pageInfo.dqName}">编辑</a>

                    <a href="/dqProduct/deleteProduct?dqProductId=${pageInfo.dqProductId}" class="btn btn-red"
                       data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
