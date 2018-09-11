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
    <form action="/operation/saveCmAnnouncementSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增公告</h3></td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="announceTitle" class="control-label x90">公告标题：</label>
                    <input type="text" name="announceTitle"  id="announceTitle" value="" data-rule="公告标题:required" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="announceUri" class="control-label x90">公告路径：</label>
                    <input type="text" name="announceUri"  id="announceUri" value="" data-rule="公告路径:required" size="20">
                   	（ 公告路径须以http://开头）
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
