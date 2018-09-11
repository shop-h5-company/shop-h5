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
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/cmConfig/editCmConfigSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="cmConfigId" value="${cmConfig.cmConfigId}">
        <input type="hidden" name="createTime" value="<fmt:formatDate value="${cmConfig.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 修改业务数据</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="configCode" class="control-label x90">配置编码：</label>
                    <input type="text" name="configCode" id="configCode" value="${cmConfig.configCode}" data-rule="配置编码:required" size="20">
                </td>
                <td>
                    <label for="configValue" class="control-label x85">配置内容：</label>
                    <input type="text" name="configValue" id="configValue" value="${cmConfig.configValue}" data-rule="配置内容:required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="configRemark" class="control-label x90">配置说明：</label>
                    <input type="text" name="configRemark" id="configRemark" value="${cmConfig.configRemark}" data-rule="配置说明:required" size="20">
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
