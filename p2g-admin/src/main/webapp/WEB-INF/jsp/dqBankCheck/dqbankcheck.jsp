<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/23
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/dqBankCheck/addSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4fe">
        <input type="hidden" name="depositBankCheckId" value="${dqBankCheck.depositBankCheckId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 定期到期审核</h3></td>
            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">用户手机号：</label>
                    ${dqBankCheck.userId}
                </td>
                <td>
                    <label   class="control-label x95">定期产品序号：</label>
                    ${dqBankCheck.dqProductId}
                </td>
                <td>
                    <label   class="control-label x95">定期交易序号：</label>
                    ${dqBankCheck.dqTransLogId}
                </td>

                </tr>
            <tr>   <td>
                <label   class="control-label x95">业务流水号：</label>
                ${dqBankCheck.transNo}
            </td>
                <td>
                    <label   class="control-label x95">投资金额：</label>
                   ${dqBankCheck.investAmt}
                </td>
                <td>
                    <label   class="control-label x95">定期利率：</label>
                    ${dqBankCheck.dqRates}
                </td>

            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">活动利率：</label>
                   ${dqBankCheck.activeRates}
                </td>
                <td>
                    <label   class="control-label x95">加息劵利率：</label>
                    ${dqBankCheck.ticketRates}
                </td>
                <td>
                    <label   class="control-label x95">投资收益金额：</label>
                    ${dqBankCheck.investProfitAmt}
                </td>

            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">活动收益：</label>
                    ${dqBankCheck.activeProfitAmt}
                </td>
                <td>
                    <label   class="control-label x95">加息劵收益金额：</label>
                   ${dqBankCheck.ticketProfitAmt}
                </td>
                <td>
                    <label   class="control-label x95">总收益金额：</label>
                    ${dqBankCheck.totalProfitAmt}
                </td>
            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">总提现金额：</label>
                    ${dqBankCheck.totalWithdrawAmt}
                </td>
                <td>
                    <label   class="control-label x95">投资时间：</label>

                    <fmt:formatDate value="${dqBankCheck.investTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>

                </td>
                <td>
                    <label   class="control-label x95">投资期限：</label>
                    ${dqBankCheck.investDays}
                </td>

            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">到期时间：</label>

                        <fmt:formatDate value="${dqBankCheck.endTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>

                </td>
                <td>
                    <label   class="control-label x95">创建时间：</label>


                        <fmt:formatDate value="${dqBankCheck.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>

                </td>
                <td>
                    <label for="checkStatus"  class="control-label x95">审核状态：</label>
                    <select name="checkStatus" id="checkStatus" data-toggle="selectpicker" data-width="150">
                        <option value="not_do" <c:if test="${dqBankCheck.checkStatus=='not_do' }">selected</c:if>>未审核 </option>
                        <option value="pass" <c:if test="${dqBankCheck.checkStatus=='pass' }">selected</c:if>>通过</option>
                        <option value="back" <c:if test="${dqBankCheck.checkStatus=='back' }">selected</c:if>>退回</option>
                    </select>
                </td>


            </tr>
            <tr>
                <td>
                    <label   class="control-label x95">审核时间：</label>

                        <fmt:formatDate value="${dqBankCheck.checkTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>

                </td>
                <td>
                    <label   class="control-label x95">付款状态：</label>
                    <c:if test="${dqBankCheck.payStatus=='not_do'}">
                        初审通过
                    </c:if>
                    <c:if test="${dqBankCheck.payStatus=='back'}">
                        退回
                    </c:if>
                    <c:if test="${dqBankCheck.payStatus=='success'}">
                        成功
                    </c:if>
                    <c:if test="${dqBankCheck.payStatus=='fail'}">
                        失败
                    </c:if>
                </td>
                <td>
                    <label   class="control-label x95">付款时间：</label>

                        <fmt:formatDate value="${dqBankCheck.payTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>


                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li>
            <button class="btn-default btn" type="submit">保存</button>
        </li>
    </ul>
</div>
</body>
</html>
