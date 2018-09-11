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
    <form action="/dqProduct/addSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="dqProductId" value="${dqProduct.dqProductId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 编辑【理财】定期产品表</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="dqName" class="control-label x85">定期名称：</label>
                    <input type="text" name="dqName"  id="dqName" value="${dqProduct.dqName}" data-rule="定期名称:required" size="15">
                </td>
                <td>
                    <label for="dqRates" class="control-label x85">定期利率：</label>
                    <input type="text" name="dqRates" id="dqRates" value="${dqProduct.dqRates}" data-rule="定期利率:required" size="15">
                </td>
                <td>
                    <label for="activeRates" class="control-label x85">活动利率：</label>
                    <input type="text" name="dqRates" id="activeRates" value="${dqProduct.activeRates}" data-rule="定期利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dqDays" class="control-label x85">定期期限:</label>
                    <select name="dqDays" id="dqDays" data-toggle="selectpicker" data-width="150">
                        <option value="7" <c:if test="${dqProduct.dqDays=='7' }">selected</c:if>>7天 </option>
                        <option value="14" <c:if test="${dqProduct.dqDays=='14' }">selected</c:if>>14天</option>
                        <option value="28" <c:if test="${dqProduct.dqDays=='28' }">selected</c:if>>28天</option>
                        <option value="91" <c:if test="${dqProduct.dqDays=='91' }">selected</c:if>>91天</option>
                        <option value="182" <c:if test="${dqProduct.dqDays=='182' }">selected</c:if>>182天</option>
                        <option value="365" <c:if test="${dqProduct.dqDays=='365' }">selected</c:if>>365天</option>
                    </select>
                </td>
                <td>
                    <label for="perMinAmt" class="control-label x85">起投金额：</label>
                    <input type="text" name="perMinAmt" id="perMinAmt" value="${dqProduct.perMinAmt}" data-rule="定期利率:required" size="15">
                </td>
                <td>
                    <label for="perMaxAmt" class="control-label x85">申购限额：</label>
                    <input type="text" name="perMaxAmt" id="perMaxAmt" value="${dqProduct.perMaxAmt}" data-rule="定期利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td >
                    <label for="investStatus" class="control-label x85">是否可投资：</label>
                    <select name="investStatus" id="investStatus" data-toggle="selectpicker" data-width="150">
                        <option value="yes" <c:if test="${dqProduct.investStatus=='yes' }">selected</c:if>>是 </option>
                        <option value="no" <c:if test="${dqProduct.investStatus=='no' }">selected</c:if>>是 </option>
                    </select>
                </td>

            </tr>
            <tr >
                <td colspan="3">
                    <label for="remark" class="control-label x85">宣传描述：</label>
                    <textarea name="remark" id="remark" data-toggle="autoheight" cols="60" rows="1">${dqProduct.remark}</textarea>
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
