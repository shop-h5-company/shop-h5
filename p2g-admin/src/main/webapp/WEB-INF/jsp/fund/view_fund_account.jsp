<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<style type="text/css">
#viewSch tr{height: 45px}
</style>
<body>
<div class="bjui-pageContent">
        <table class="table table-condensed table-hover">
            <tbody id="viewSch">
            <tr>
                <td colspan="2" align="center"><h3>* 查看资金账户</h3></td>
            </tr>
            
           <tr>
                <td>
                    <label for=userId class="control-label x150">用户序号：</label>${fundAccount.userId }
                </td>
                <td>
                    <label for=hasInvest class="control-label x150">是否已投资：</label>
                    <c:if test="${fundAccount.hasInvest=='yes' }">是</c:if>
                    <c:if test="${fundAccount.hasInvest=='no' }">否</c:if>
                </td>
            </tr>
           <tr>
				<td>
                    <label for="hqBalanceAmt" class="control-label x150">活期余额：</label>${fundAccount.hqBalanceAmt }
                </td>
                <td>
                    <label for=hqNotAcctProfitAmt class="control-label x150">活期在投收益：</label>${fundAccount.hqNotAcctProfitAmt }
                </td>
            </tr>
           <tr>
				<td>
                    <label for="hqWithdrawFreezingAmt" class="control-label x150">活期提现冻结：</label>${fundAccount.hqWithdrawFreezingAmt }
                </td>
                <td>
                    <label for=hqTotalRechargeAmt class="control-label x150">活期累计充值：</label>${fundAccount.hqTotalRechargeAmt }
                </td>
            </tr>
           <tr>
				<td>
                    <label for="hqTotalWithdrawAmt" class="control-label x150">活期累计提现：</label>${fundAccount.hqTotalWithdrawAmt }
                </td>
                <td>
                    <label for="hqTotalProfitAmt" class="control-label x150">活期累计收益：</label>${fundAccount.hqTotalProfitAmt }
                </td>
            </tr>
           <tr>
				<td>
                    <label for="hqLastRechargeTime" class="control-label x150">活期最后充值时间：</label>
                    <fmt:formatDate value="${fundAccount.hqLastRechargeTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <label for="hqLastWithdrawTime" class="control-label x150">活期最后提现时间：</label>
                    <fmt:formatDate value="${fundAccount.hqLastWithdrawTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
           <tr>
				<td>
                    <label for="hqLastProfitTime" class="control-label x150">活期最后收益发放时间：</label>
                    <fmt:formatDate value="${fundAccount.hqLastProfitTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <label for="hqFloatRates" class="control-label x150">活期浮动利率：</label>${fundAccount.hqFloatRates }
                </td>
            </tr>
           <tr>
				<td>
                    <label for="couponsId" class="control-label x150">活期加息券序号：</label>${fundAccount.couponsId }
                </td>
                <td>
                    <label for="hqCouponRates" class="control-label x150">活期加息券利率：</label>${fundAccount.hqCouponRates }
                </td>
            </tr>
           <tr>
                <td>
                    <label for="hqCouponBeginTime" class="control-label x150">活期加息券开始时间：</label>
                    <fmt:formatDate value="${fundAccount.hqCouponBeginTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
				<td>
                    <label for="hqCouponEndTime" class="control-label x150">活期加息券结束时间：</label>
                    <fmt:formatDate value="${fundAccount.hqCouponEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
           <tr>
                <td>
                    <label for="hqWithdrawFlag" class="control-label x150">活期是否允许提现：</label>
                	<c:if test="${fundAccount.hqWithdrawFlag=='yes' }">可以</c:if>
                	<c:if test="${fundAccount.hqWithdrawFlag=='no' }">不可</c:if>
                </td>
				<td>
                    <label for="hqDayTotalWithdrawAmt" class="control-label x150">活期每日提现总金额：</label>${fundAccount.hqDayTotalWithdrawAmt }
                </td>
            </tr>
           <tr>
                <td>
                    <label for="hqMonthWithdrawCount" class="control-label x150">活期当月提现次数：</label>${fundAccount.hqMonthWithdrawCount }
                </td>
                <td>
                    <label for="lianAccountStatus" class="control-label x150">连连账户开通状态：</label>
                	<c:if test="${fundAccount.lianAccountStatus=='not' }">未开通</c:if>
                	<c:if test="${fundAccount.lianAccountStatus=='has' }">已开通</c:if>
                	<c:if test="${fundAccount.lianAccountStatus=='unbind' }">已解绑</c:if>
                </td>
            </tr>
            </tbody>
        </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>
</body>
</html>
