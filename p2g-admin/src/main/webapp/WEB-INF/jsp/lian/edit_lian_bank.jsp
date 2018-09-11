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
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form id="lianBankForm" action="/lian/editLianBankSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 编辑支持银行</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="lianBankCode" class="control-label x90">银行编码：</label>
                    <input type="text" name="lianBankCode"  id="lianBankCode" value="${lianBank.lianBankCode }" data-rule="银行编码:required" size="20" readonly>
                </td>
                <td>
                    <label for="bankName" class="control-label x90">银行名称：</label>
                    <input type="text" name="bankName" id="bankName" value="${lianBank.bankName }" data-rule="银行名称:required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="needBrabank" class="control-label x90">是否需要支行：</label>
                    <select name="needBrabank" id="needBrabank" data-toggle="selectpicker" data-width="200">
                        <option value="yes" <c:if test="${lianBank.needBrabank=='yes' }">selected</c:if>>需要</option>
                        <option value="no" <c:if test="${lianBank.needBrabank=='no' }">selected</c:if>>不需要</option>
                    </select>
                </td>
                <td>
                    <label for="investFlag" class="control-label x90">是否允许投资：</label>
                    <select name="investFlag" id="investFlag" data-toggle="selectpicker" data-width="200">
                        <option value="yes" <c:if test="${lianBank.investFlag=='yes'}">selected</c:if>>允许</option>
                        <option value="no" <c:if test="${lianBank.investFlag=='no'}">selected</c:if>>不允许</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="withdrawFlag" class="control-label x90">是否允许提现：</label>
                    <select name="withdrawFlag" id="withdrawFlag" data-toggle="selectpicker" data-width="200">
                        <option value="yes" <c:if test="${lianBank.withdrawFlag=='yes'}">selected</c:if>>允许</option>
                        <option value="no" <c:if test="${lianBank.withdrawFlag=='no'}">selected</c:if>>不允许</option>
                    </select>
                </td>
                <td>
                    <label for="singleAmt" class="control-label x90">单笔限额：</label>
                    <input type="text" name="singleAmt"  id="singleAmt" value="${lianBank.singleAmt }" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dayAmt" class="control-label x90">单日限额：</label>
                    <input type="text" name="dayAmt" id="dayAmt" value="${lianBank.dayAmt }" size="20">
                </td>
                <td>
                    <label for="monthAmt" class="control-label x90">单月限额：</label>
                    <input type="text" name="monthAmt"  id="monthAmt" value="${lianBank.monthAmt }"  size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lianStatus" class="control-label x90">连连状态：</label>
                    <select name="lianStatus" id="lianStatus" data-toggle="selectpicker" data-width="200">
                        <option value="0" <c:if test="${lianBank.lianStatus=='0'}">selected</c:if>>正常</option>
                        <option value="2" <c:if test="${lianBank.lianStatus=='2'}">selected</c:if>>维护中</option>
                    </select>
                </td>
                <td>
                    <label for="status" class="control-label x90">可用状态：</label>
                    <select name="status" id="status" data-toggle="selectpicker" data-width="200">
                        <option value="enabled" <c:if test="${lianBank.status=='enabled'}">selected</c:if>>可用</option>
                        <option value="disabled" <c:if test="${lianBank.status=='disabled'}">selected</c:if>>不可用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dayAmt" class="control-label x90">银行logo：</label>
                    <input type="text" name="bankLogo" id="bankLogo" value="${lianBank.bankLogo }" size="20">
                </td>
                <td>
                    <label for="seqNum" class="control-label x90">排列顺序：</label>
                    <input type="text" name="seqNum" id="seqNum" value="${lianBank.seqNum }" size="20">
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
<script>
    $('#lianBankForm').validator({
        rules: {
                gtZeroCheck:[/^([1-9]\d*|([1-9]\d*)\.\d*[1-9])$/,'请输入大于0的整数或小数!']
        },
        fields: {
        	singleAmt: {
                rule: "required;gtZeroCheck",
                msg: {required: "必填项"},
                tip: "请输入大于0的整数或小数",
                target: "#singleAmt"
            } ,
            dayAmt: {
                rule: "required;gtZeroCheck",
                msg: {required: "必填项"},
                tip: "请输入大于0的整数或小数",
                target: "#dayAmt"
            },
            monthAmt: {
                rule: "required;gtZeroCheck",
                msg: {required: "必填项"},
                tip: "请输入大于0的整数或小数",
                target: "#monthAmt"
            } 
        }
    });
</script>
</html>
