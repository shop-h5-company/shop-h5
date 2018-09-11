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
    <form action="/taskGroup/editTaskGroupSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="groupId" value="${taskGroup.groupId}">
        <input type="hidden" name="createTime" value="<fmt:formatDate value="${taskGroup.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 修改定时分组</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="groupName" class="control-label x90">分组名称：</label>
                    <input type="text" name="groupName" id="groupName" value="${taskGroup.groupName}" data-rule="配置编码:required" size="20">
                </td>
                <td>
                    <label for="groupDesc" class="control-label x85">分组描述：</label>
                    <input type="text" name="groupDesc" id="groupDesc" value="${taskGroup.groupDesc}" data-rule="配置内容:required" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="enable" class="control-label x90">是否可用：</label>
                    <select id="enable" name="enable"  style="width: 200px;">  
					    <option value="1">是</option>  
					    <option value="0">否</option>  
					</select>
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
