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
    <form action="/operation/saveCmHomeTuijianSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增推荐</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="imgUrl" class="control-label x90">图片路径：</label>
                    <input type="text" name="imgUrl"  id="imgUrl" value="" data-rule="图片路径:required" size="20">
                	  （图片 路径须以http://开头）
                </td>
            </tr>
            <tr>
                <td>
                    <label for="goUrl" class="control-label x90">跳转路径：</label>
                    <input type="text" name="goUrl"  id="goUrl" value="" data-rule="跳转路径:required" size="20">
                	  （跳转 路径须以http://开头）
                </td>
            </tr>
            <tr>
       			<td>
                    <label for="remark" class="control-label x90">描述：</label>
                    <textarea name="remark"  id="remark" cols="20" rows="3"></textarea>
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
