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
    <form action="/admin/addPermissionSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="permissionId" value="${adminPermission.permissionId }">
       	<input type="hidden" name="createTime" value="<fmt:formatDate value="${adminPermission.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 编辑权限</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="permissionName" class="control-label x90">权限名称：</label>
                    <input type="text" name="permissionName"  id="permissionName" value="${adminPermission.permissionName }" data-rule="权限名称:required" size="20">
                </td>
            </tr>
            <tr>
            	<td>
                    <label for="permissionUrl" class="control-label x90">权限URL：</label>
                    <input type="text" name="permissionUrl"  id="permissionUrl" value="${adminPermission.permissionUrl }" data-rule="角色名称:required" size="20">
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
