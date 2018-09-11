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
    <form action="/admin/addRoleSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
       	<input type="hidden" name="roleId" value="${adminRole.roleId }">
       	<input type="hidden" name="createTime" value="<fmt:formatDate value="${adminRole.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 编辑角色</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="roleName" class="control-label x90">角色名称：</label>
                    <input type="text" name="roleName"  id="roleName" value="${adminRole.roleName}" data-rule="角色名称:required" size="20">
                </td>
                <td>
                    <label for="roleType" class="control-label x90">角色类型：</label>
                    <select name="roleType" id="roleType" data-toggle="selectpicker">
                        <option value="biz">业务角色</option>
                        <option value="manage" selected>管理角色</option>
                        <option value="sys" selected>系统内置角色</option>
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
