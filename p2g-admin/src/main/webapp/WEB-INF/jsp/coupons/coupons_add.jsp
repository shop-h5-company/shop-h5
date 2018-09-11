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
    <form action="/coupons/addSubmit" class="pageForm" data-toggle="validate">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="3" align="center"><h3>* 添加加息券表</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="userId" class="control-label x85">用户序号：</label>
                    <input type="text" name="userId"  id="userId" value="${coupons.userId}" data-rule="用户序号:required" size="15">
                </td>
                <td >
                    <label for="productType" class="control-label x85">产品类型：</label>
                    <select name="productType" id="productType" data-toggle="selectpicker" data-width="150">
                        <option value="current" <c:if test="${coupons.productType=='current' }">selected</c:if>>活期</option>
                        <option value="plus" <c:if test="${coupons.productType=='plus' }">selected</c:if>>活期plus</option>
                        <option value="deposit" <c:if test="${coupons.productType=='deposit' }">selected</c:if>>定期 </option>
                    </select>
                </td>
                <td>
                    <label for="incRates" class="control-label x85">加息利率：</label>
                    <input type="text" name="incRates" id="incRates" value="${coupons.incRates}" data-rule="加息利率:required" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="source" class="control-label x85">发放来源:</label>
                    <select name="source" id="source" data-toggle="selectpicker" data-width="150">
                        <option value="system" <c:if test="${coupons.source=='system' }">selected</c:if>>系统</option>
                        <option value="active" <c:if test="${coupons.source=='active' }">selected</c:if>>活动 </option>
                        <option value="reg" <c:if test="${coupons.source=='reg' }">selected</c:if>>注册</option>
                        <option value="invite" <c:if test="${coupons.source=='invite' }">selected</c:if>> 邀请其他用户注册</option>
                    </select>
                </td>
                <td>
                    <label for="expiredTime" class="control-label x85">过期时间：</label>
                    <input value='<fmt:formatDate value="${coupons.expiredTime}" pattern="yyyy-MM-dd 23:59:59"/>' class="form-control" style="padding-right: 15px;" name="expiredTime" id="expiredTime"  data-pattern="yyyy-MM-dd 23:59:59"   data-toggle="datepicker" data-rule="过期时间:required" type="text" size="15">
                </td>
                <td>
                    <label for="incDays" class="control-label x85">加息天数：</label>
                    <input type="text" name="incDays" id="incDays" value="${coupons.incDays}" data-rule="加息天数:required" size="15">
                </td>
            </tr>
            <tr>
                <%-- <td>
                    <label for="usedTime" class="control-label x85">使用时间：</label>
                    <input value='<fmt:formatDate value="${coupons.usedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>' class="form-control" style="padding-right: 15px;" name="usedTime" id="usedTime"  data-pattern="yyyy-MM-dd HH:mm:ss"   data-toggle="datepicker"  data-rule="使用时间:required" type="text" size="15">
                </td>--%>

                <td >
                    <label for="status" class="control-label x85">使用状态：</label>
                    <select name="status" id="status" data-toggle="selectpicker" data-width="150">
                        <option value="not_used" <c:if test="${coupons.status=='not_used' }">selected</c:if>>未使用 </option>
                        <option value="has_used" <c:if test="${coupons.status=='has_used' }">selected</c:if>>已使用 </option>
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
