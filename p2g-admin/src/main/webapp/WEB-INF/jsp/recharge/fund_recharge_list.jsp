<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>充值查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/recharge/getRechargeList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>用户序号：</label><input type="text" value="${userId}" name="userId" size="15" />
            <label>订单状态：</label>
            <select name="status" id="status" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="0" <c:if test="${status=='0' }">selected</c:if>>处理中 </option>
                <option value="1" <c:if test="${status=='1' }">selected</c:if>>异步成功</option>
                <option value="2" <c:if test="${status=='2' }">selected</c:if>>异步失败</option>
                <option value="3" <c:if test="${status=='3' }">selected</c:if>>实时回显成功</option>
                <option value="4" <c:if test="${status=='4' }">selected</c:if>>实时回显失败</option>
                <option value="5" <c:if test="${status=='5' }">selected</c:if>>无效订单</option>
            </select>
            <label>对账状态：</label>
            <select name="verifyStatus" id="verifyStatus" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="not" <c:if test="${verifyStatus=='not' }">selected</c:if>>未对账 </option>
                <option value="ok" <c:if test="${verifyStatus=='ok' }">selected</c:if>>对账成功</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            &nbsp;
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog"
               href="/recharge/fund_recharge_add">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="order_no">商户订单号</th>
            <th data-order-field="order_date">商户订单时间</th>
            <th data-order-field="amount">金额</th>
            <th data-order-field="product_type">产品类型</th>
            <th data-order-field="bank_card">银行卡号</th>
            <th data-order-field="lian_bank_code">银行编码</th>

            <th data-order-field="bank_name">银行名称</th>
            <th data-order-field="name">姓名</th>
            <th data-order-field="id_card">身份证</th>
            <th data-order-field="agree_no">签约协议号</th>

            <th data-order-field="risk_item">风控参数</th>
            <th data-order-field="return_url">同步回显地址</th>
            <th data-order-field="notify_url">异步通知地址</th>
            <th data-order-field="status">订单状态</th>
            <th data-order-field="yintong_pay_no">连连支付单号</th>
            <th data-order-field="yintong_pay_result">连连支付结果</th>
            <th data-order-field="yintong_settle_date">清算日期</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="update_time">更新时间</th>
            <th data-order-field="verify_status">对账状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="rechargeList" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${rechargeList.userId}</td>
                <td>${rechargeList.orderNo}</td>
                <td>${rechargeList.orderDate}</td>
                <td>${rechargeList.amount}</td>
                <td>
                    <c:if test="${rechargeList.productType=='hq'}">
                        活期
                    </c:if>
                    <c:if test="${rechargeList.productType=='dq'}">
                        定期
                    </c:if>
                </td>
                <td>
                    <c:if test="${rechargeList.bankCard!=''}">
                        ${fn:substring(rechargeList.bankCard,0,4)}****${fn:substring(rechargeList.bankCard,rechargeList.bankCard.length()-4,rechargeList.bankCard.length())}
                    </c:if>
                </td>
                <td>${rechargeList.lianBankCode}</td>
                <td>${rechargeList.bankName}</td>
                <td>${rechargeList.name}</td>
                <td>
                    <c:if test="${rechargeList.idCard!=''}">
                    ${fn:substring(rechargeList.idCard,0,4)}****${fn:substring(rechargeList.idCard,rechargeList.idCard.length()-4,rechargeList.idCard.length())}
                    </c:if>
                </td>
                <td>${rechargeList.agreeNo}</td>
                <td>${rechargeList.riskItem}</td>
                <td>${rechargeList.returnUrl}</td>
                <td>${rechargeList.notifyUrl}</td>
                <td>
                    <c:if test="${rechargeList.status=='0'}">
                         <span class="label label-primary">处理中</span>
                    </c:if>
                    <c:if test="${rechargeList.status=='1'}">
                        <span class="label label-success">异步成功</span>
                    </c:if>
                    <c:if test="${rechargeList.status=='2'}">
                        <span class="label label-danger">异步失败</span>
                    </c:if>
                    <c:if test="${rechargeList.status=='3'}">
                        <span class="label label-success">实时回显成功</span>
                    </c:if>
                    <c:if test="${rechargeList.status=='4'}">
                         <span class="label label-danger">实时回显失败</span>
                    </c:if>
                    <c:if test="${rechargeList.status=='5'}">
                       <span class="label label-default">无效订单</span>
                    </c:if>
                </td>
                <td>${rechargeList.yintongPayNo}</td>
                <td>
                    <c:if test="${rechargeList.yintongPayResult=='0'}">
                        <span class="label label-primary">处理中</span>
                    </c:if>
                    <c:if test="${rechargeList.yintongPayResult=='1'}">
                        <span class="label label-success">成功</span>
                    </c:if>
                    <c:if test="${rechargeList.yintongPayResult=='2'}">
                        <span class="label label-danger">失败</span>
                    </c:if>
                </td>
                <td>${rechargeList.yintongSettleDate}</td>
                <td> <fmt:formatDate value="${rechargeList.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${rechargeList.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:if test="${rechargeList.verifyStatus=='not'}">
                        <span class="label label-default">未对账</span>
                    </c:if>
                    <c:if test="${rechargeList.verifyStatus=='ok'}">
                        <span class="label label-success">对账成功</span>
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
