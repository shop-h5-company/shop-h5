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
    <form action="/cmSmsModel/editCmSmsModelSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="cmSmsModelId" value="${cmSmsModel.cmSmsModelId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 修改业务数据</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="modelCode" class="control-label x90">业务编码：</label>
                    <input type="text" name="modelCode" id="modelCode" value="${cmSmsModel.modelCode}" data-rule="业务编码:required" size="20">
                </td>
                <td>
                    <label for="remark" class="control-label x85">业务说明：</label>
                    <input type="text" name="remark" id="remark" value="${cmSmsModel.remark}" data-rule="业务说明:required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="content" class="control-label x90">短信内容：</label>
                    <input type="text" name="content" id="content" value="${cmSmsModel.content}" data-rule="短信内容:required" size="20">
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
