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
    <form action="/dqProduct/addSubmit" class="pageForm" data-toggle="validate">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 新增【理财】定期产品表</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="dqName" class="control-label x85">定期名称：</label>
                    <input type="text" name="dqName"  id="dqName" value="" data-rule="定期名称:required" size="15">
                </td>
                <td>
                    <label for="dqRates" class="control-label x85">定期利率：</label>
                    <input type="text" name="dqRates" id="dqRates" value="" data-rule="定期利率:required" size="15">
                </td>
                <td>
                    <label for="activeRates" class="control-label x85">活动利率：</label>
                    <input type="text" name="dqRates" id="activeRates" value="0" data-rule="定期利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <%--<label for="dqDays" class="control-label x85">定期期限(天)：</label>
                    <input type="text" name="dqDays"  id="dqDays" value="" data-rule="定期名称:required" size="15">--%>
                        <label for="dqDays" class="control-label x85">定期期限:</label>
                        <select name="dqDays" id="dqDays" data-toggle="selectpicker" data-width="150">
                            <option value="7" selected>7天</option>
                            <option value="14" >14天</option>
                            <option value="28" >28天</option>
                            <option value="91">91天</option>
                            <option value="182">182天</option>
                            <option value="365">365天</option>
                        </select>
                </td>
                <td>
                    <label for="perMinAmt" class="control-label x85">起投金额：</label>
                    <input type="text" name="perMinAmt" id="perMinAmt" value="" data-rule="定期利率:required" size="15">
                </td>
                <td>
                    <label for="perMaxAmt" class="control-label x85">申购限额：</label>
                    <input type="text" name="perMaxAmt" id="perMaxAmt" value="0" data-rule="定期利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="investStatus" class="control-label x85">是否可投资：</label>
                    <select name="investStatus" id="investStatus" data-toggle="selectpicker" data-width="150">
                        <option value="yes">是</option>
                        <option value="no" selected>否</option>
                    </select>
                </td>
            </tr>
            <tr >
                    <td colspan="3">
                        <label for="remark" class="control-label x85">宣传描述：</label>
                        <textarea name="remark" id="remark" data-toggle="autoheight" cols="60" rows="1"></textarea>
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
