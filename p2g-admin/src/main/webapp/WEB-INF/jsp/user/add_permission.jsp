<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/21
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增权限</title>
    <script>
        $('#saveBtn').click(function() {
            $(this).alertmsg('confirm', '确认要新增权限吗？', {displayPosition:'middlecenter', title:'新增权限',okCall:doSubmit})
        })
        function doSubmit() {
            $("#j_custom_form").submit();
        }
    </script>
</head>
<body>
<div class="bjui-pageContent">
    <form action="ajaxDone2.html" id="j_custom_form" data-toggle="validate" data-alertmsg="false">
        <input type="hidden" name="custom.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover" width="100%">
            <tbody>
            <tr>
                <td>
                    <label for="permissionName" class="control-label x85">权限名称：</label>
                    <input type="text" name="permissionName" id="permissionName" value="" data-rule="required" size="20">
                </td>

            </tr>
            <tr>
                <td>
                    <label for="permissionUrl" class="control-label x85">权限URL：</label>
                    <input type="text" name="permissionUrl" id="permissionUrl" value="" data-rule="required" size="50">
                </td>

            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <li><button type="button" id="saveBtn" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>
</body>
</html>
