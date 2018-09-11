<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 1516/6/23
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/admin/addMenuSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增菜单</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="menuName" class="control-label x90">菜单名称：</label>
                    <input type="text" name="menuName" id="menuName" value="" data-rule="菜单名称:required" size="15">
                </td>
                <td>
                    <label for="menuType" class="control-label x90">菜单类型：</label>
                    <select name="menuType" id="menuType" data-toggle="selectpicker" data-width="150">
                        <option value="0" selected>其他</option>
                        <option value="1">菜单</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="parentId" class="control-label x90">父菜单序号：</label>
                    <select name="parentId" id="parentId" data-toggle="selectpicker" data-width="150">
                        <option value="0" selected>--请选择--</option>
                        <c:forEach items="${adminMenus}" var="sysPerm" varStatus="status">
                            <option value="${sysPerm.adminMenuId}">${sysPerm.menuName}-
                                <c:if test="${sysPerm.level=='1'}">
                                    一级
                                </c:if>
                                <c:if test="${sysPerm.level=='2'}">
                                    二级
                                </c:if> <c:if test="${sysPerm.level=='3'}">
                                    三级
                                </c:if></option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <label for="iconcls" class="control-label x90">菜单样式图标：</label>
                    <input type="text" name="iconcls" id="iconcls" value="" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="level" class="control-label x90">菜单级别：</label>
                    <select name="level" id="level" data-toggle="selectpicker" data-width="150">
                        <option value="1" selected>一级</option>
                        <option value="2">二级</option>
                        <option value="3">三级</option>
                    </select>
                </td>
                <td>
                    <label for="sn" class="control-label x90">排序：</label>
                    <input type="text" name="sn" id="sn" value="" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="reqUrl" class="control-label x90">请求路径：</label>
                    <input type="text" name="reqUrl" id="reqUrl" value="" size="15">
                </td>
                <td>
                    <label for="state" class="control-label x90">状态：</label>
                    <select name="state" id="state" data-toggle="selectpicker" data-width="150">
                        <option value="1" selected>显示</option>
                        <option value="0">隐藏</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dataOptionsId" class="control-label x90">菜单名称标识：</label>
                    <input type="text" name="dataOptionsId" id="dataOptionsId" value="" size="15">
                </td>
                <td>
                    <label for="dataFaicon" class="control-label x90">菜单图标：</label>
                    <input type="text" name="dataFaicon" id="dataFaicon" value="" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="remark" class="control-label x90">说明：</label>
                    <input type="text" name="remark" id="remark" value="" size="15">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close">关闭</button>
        </li>
        <li>
            <button class="btn-default btn" type="submit">保存</button>
        </li>
    </ul>
</div>
</body>
</html>
