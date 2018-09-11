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
<%@ include file="../common/include_head.jsp" %>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/user/addSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="userId" value="${user.userId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 修改邀请信息</h3></td>
            </tr>
            <tr>
                <td>
                	<label for="inviteRight" class="control-label x90">邀请资格：</label>
                	<select name="inviteRight" id="inviteRight" data-toggle="selectpicker" data-width="200">
                        <option value="yes" <c:if test="${user.inviteRight == 'yes' || user.inviteRight == null}">selected</c:if>>有</option>
                        <option value="no" <c:if test="${user.inviteRight == 'no'}">selected</c:if>>无</option>
                    </select>
                </td>
                <td>
                    <label for="insideInviteRight" class="control-label x85">内推资格：</label>
                    <select name="insideInviteRight" id="insideInviteRight" data-toggle="selectpicker" data-width="200">
                        <option value="yes" <c:if test="${user.insideInviteRight == 'yes'}">selected</c:if>>有</option>
                        <option value="no" <c:if test="${user.insideInviteRight == 'no' || user.insideInviteRight == null}">selected</c:if>>无</option>
                    </select>
                    <%-- <input type="text" name="insideInviteRight" id="insideInviteRight" value="${insideInviteRight}" data-rule="配置内容:required" size="20"> --%>
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
