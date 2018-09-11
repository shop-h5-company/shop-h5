<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>连连支持银行管理</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/lian/getLianBankList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>银行名称：</label><input type="text" value="${bankName}" name="bankName" size="15" />
            <label>是否需要支行：</label>
            <select name="needBrabank" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="yes" <c:if test="${needBrabank=='yes'}">selected</c:if>>需要</option>
            <option value="no" <c:if test="${needBrabank=='no'}">selected</c:if>>不需要</option>
            </select>
            &nbsp;
            <label>是否允许投资：</label>
            <select name="investFlag" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="yes" <c:if test="${investFlag=='yes'}">selected</c:if>>允许</option>
            <option value="no" <c:if test="${investFlag=='no'}">selected</c:if>>不允许</option>
            </select>
            &nbsp;
            <label>是否允许提现：</label>
            <select name="withdrawFlag" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="yes" <c:if test="${withdrawFlag=='yes'}">selected</c:if>>允许</option>
            <option value="no" <c:if test="${withdrawFlag=='no'}">selected</c:if>>不允许</option>
            </select>
            &nbsp;
            <label>连连状态：</label>
            <select name="lianStatus" data-toggle="selectpicker">
            <option value="">全部</option>
            <option value="0" <c:if test="${lianStatus=='0'}">selected</c:if>>正常</option>
            <option value="2" <c:if test="${lianStatus=='2'}">selected</c:if>>维护中</option>
            </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        	<a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" href="/lian/addLianBank">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="lian_bank_code">银行编码</th>
            <th data-order-field="bank_name">银行名称</th>
            <th data-order-field="need_brabank">是否需要支行</th>
            <th data-order-field="invest_flag">是否允许投资</th>
            <th data-order-field="withdraw_flag">是否允许提现</th>
            <th data-order-field="single_amt">单笔限额</th>
            <th data-order-field="day_amt">单日限额</th>
            <th data-order-field="month_amt">单月限额</th>
            <th data-order-field="lian_status">连连状态</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="lianBank" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${lianBank.lianBankCode}</td>
                <td>${lianBank.bankName}</td>
                <td>
	                <c:if test="${lianBank.needBrabank=='yes'}">
		                <span class="label label-success">需要</span>
	                </c:if>
	                <c:if test="${lianBank.needBrabank=='no'}">
		            	<span class="label label-default">不需要</span>
	                </c:if>
                </td>
                <td>
	                <c:if test="${lianBank.investFlag=='yes'}">
					   <span class="label label-success">允许</span>
	                </c:if>
	                <c:if test="${lianBank.investFlag=='no'}">
					   <span class="label label-default">不允许</span>
	                </c:if>
                </td>
                <td>
	                <c:if test="${lianBank.withdrawFlag=='yes'}">
					   <span class="label label-success">允许</span>
	                </c:if>
	                <c:if test="${lianBank.withdrawFlag=='no'}">
					   <span class="label label-default"> 不允许</span>
	                </c:if>
                </td>
                <td>${lianBank.singleAmt}</td>
                <td>${lianBank.dayAmt}</td>
                <td>${lianBank.monthAmt}</td>
                <td>
	                <c:if test="${lianBank.lianStatus=='0'}">
					    <span class="label label-success">正常</span>
	                </c:if>
	                <c:if test="${lianBank.lianStatus=='2'}">
					    <span class="label label-default">维护中</span>
	                </c:if>
               </td> 
                <td>
                    <a href="/lian/editLianBank?lianBankCode=${lianBank.lianBankCode}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${lianBank.lianBankCode}">编辑</a>
                    <a href="/lian/deleteLianBank?lianBankCode=${lianBank.lianBankCode}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
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
