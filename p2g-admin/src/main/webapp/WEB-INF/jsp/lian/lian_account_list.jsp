<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>连连账户管理</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/lian/getLianAccountList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>签约协议号：</label><input type="text" value="${agreeNo}" name="agreeNo" size="15" />
            <label>银行卡号：</label><input type="text" value="${bankCard}" name="bankCard" size="18" />
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
            <th data-order-field="agree_no">签约协议号</th>
            <th data-order-field="bank_card">银行卡号</th>
            <th data-order-field="brabank_name">开户支行名称</th>
            <th data-order-field="create_time">开通时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="lianAccount" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${lianAccount.userId}</td>
                <td>${lianAccount.agreeNo}</td>
                <td>
	                <c:if test="${lianAccount.bankCard!=null}">
		                ${fn:substring(lianAccount.bankCard,0,4)}****${fn:substring(lianAccount.bankCard,lianAccount.bankCard.length()-4,lianAccount.bankCard.length())}
	                </c:if>
                </td>
                <td>${lianAccount.brabankName}</td>
                <td><fmt:formatDate value="${lianAccount.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
