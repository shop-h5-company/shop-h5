<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GJF
  Date: 2016/6/28
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>

           $('#expiredTime').datepicker({
                pattern:'yyyy-MM-dd HH:mm:ss',
               onlybtn:true
            });

    </script>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/dqTicket/addSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="dqTicketId" value="${dqTicket.dqTicketId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 新增定期加息券</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="userId" class="control-label x85">用户序号：</label>
                    <input type="text" name="userId"  id="userId" value="${dqTicket.userId}" data-rule="用户序号:required" size="15">
                </td>
                <td>
                    <label for="dqProductId" class="control-label x85">定期产品序号：</label>
                    <input type="text" name="dqProductId" id="dqProductId" value="${dqTicket.dqProductId}" data-rule="定期产品序号:required" size="15">
                </td>
                <td>
                    <label for="incRates" class="control-label x85">加息利率：</label>
                    <input type="text" name="incRates" id="incRates" value="${dqTicket.incRates}" data-rule="加息利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="incDays" class="control-label x85">加息天数：</label>
                    <input type="text" name="incDays"  id="incDays" value="${dqTicket.incDays}" data-rule="加息天数:required" size="15">
                </td>
                <td>
                    <label for="expiredTime" class="control-label x85">过期日期：</label>
                    <input type="text" size="15"  data-toggle="datepicker"  value="${expiredTimeStr}"  id="expiredTime" name="expiredTimeStr" style="padding-right: 15px; width: 150px;" class="form-control ok" aria-required="true">

                </td>
                <td>
                    <label for="status" class="control-label x85">使用状态：</label>
                    <select name="status" id="status" data-toggle="selectpicker" data-width="150">
                        <option value="not_used" <c:if test="${dqTicket.status=='not_used' }">selected</c:if>>未使用 </option>
                        <option value="has_used" <c:if test="${dqTicket.status=='has_used' }">selected</c:if>>已使用</option>
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
