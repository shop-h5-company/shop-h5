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
    <form action="/admin/addSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增管理员</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="adminCode" class="control-label x90">管理员账号：</label>
                    <input type="text" name="adminCode"  id="adminCode" value="" data-rule="管理员账号:required" size="20">
                </td>
                <td>
                    <label for="adminName" class="control-label x85">管理员姓名：</label>
                    <input type="text" name="adminName" id="adminName" value="" data-rule="管理员姓名:required" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="adminStatus" class="control-label x90">状态：</label>
                    <select name="status" id="adminStatus" data-toggle="selectpicker" data-width="200">
                        <option value="enabled">可用</option>
                        <option value="disabled" selected>不可用</option>
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
