<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/recharge/addSubmit" class="pageForm" data-toggle="validate" id="myForm">
        <input type="hidden" name="productType" value="hq">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 后台充值</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="userId" class="control-label x85">用户序号：</label>
                    <input type="text" name="userId" id="userId" value="" >
                </td>
                <td>
                    <label for="amount" class="control-label x85">投资金额：</label>
                    <input type="text" name="amount" id="amount" value="" >
                </td>
            </tr>
            <%--<tr>
                <td>
                    <label for="bankCard" class="control-label x85">银行卡号：</label>
                    <input type="text" name="bankCard" id="bankCard" value="" placeholder="银行卡号" size="15">
                </td>
                <td>
                    <label for="bankName" class="control-label x85">银行名称：</label>
                    <input type="text" name="bankName" id="bankName" value="" placeholder="银行名称"  size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="agreeNo" class="control-label x85">签约协议号：</label>
                    <input type="text" name="agreeNo" id="agreeNo" value="" placeholder="签约协议号" size="15">
                </td>
                <td>
                    <label for="lianBankCode" class="control-label x85">银行编码：</label>

                    <select name="lianBankCode" id="lianBankCode"  data-toggle="selectpicker" data-width="150" >
                        <c:forEach items="${lianBanks}" var="pageInfo" varStatus="status">
                            <option value="${pageInfo.lianBankCode}" style="color: #515151;">${pageInfo.bankName}(单笔${pageInfo.singleAmt}元)</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>--%>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close">关闭</button>
        </li>
        <li>
            <button class="btn-default btn" type="submit">保存</button>
        </li>
    </ul>
</div>

<script>
    $('#myForm').validator({
        rules: {
                gtZeroCheck:[/^([1-9]\d*|([1-9]\d*)\.\d*[1-9])$/,'请输入大于0的整数或小数!'],
                gtInteger:[/^\+?[1-9]\d*$/,'请输入数字串!']
        },
        fields: {
            amount: {
                rule: "required;gtZeroCheck",
                msg: {required: "必填项"},
                tip: "请输入大于0的整数或小数",
                target: "#amount"
            } ,
            userId: {
                rule: "required;gtInteger",
                msg: {required: "必填项"},
                tip: "请输入数字串",
                target: "#userId"
            }
        }
    });
</script>
</body>
</html>
