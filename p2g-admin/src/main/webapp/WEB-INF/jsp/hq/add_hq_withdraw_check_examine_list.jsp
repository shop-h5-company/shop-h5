<%--
  Created by IntelliJ myeclipse.
  User: zhaozizhen
  Date: 2016/6/29
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/hq/editHqWithdrawCheckSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 操作备注</h3></td>
            </tr>
            <tr>
                <td colspan="2">
                	<input type="hidden" name="checkStatus" value="${checkStatus}">
                	<input type="hidden" name="hqWithdrawCheckId" value="${hqWithdrawCheckId}">
                	<textarea cols="40" rows="6" name="remark" id="remark"  data-rule="操作备注:required"></textarea>
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