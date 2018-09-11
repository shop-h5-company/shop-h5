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
        <input type="hidden" name="adminMenuId" value="${adminMenu.adminMenuId}">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增菜单</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="menuName" class="control-label x90">菜单名称：</label>
                    <input type="text" name="menuName" id="menuName" value="${adminMenu.menuName}"
                           data-rule="菜单名称:required" size="15">
                </td>
                <td>
                    <label for="menuType" class="control-label x90">菜单类型：</label>
                    <select name="menuType" id="menuType" data-toggle="selectpicker" data-width="150">
                        <option value="0" <c:if test="${adminMenu.menuType=='0' }">selected</c:if>>其他</option>
                        <option value="1" <c:if test="${adminMenu.menuType=='1' }">selected</c:if>>菜单</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="parentId" class="control-label x90">父菜单序号：</label>
                    <select name="parentId" id="parentId" data-toggle="selectpicker" data-width="150">
                        <c:forEach items="${adminMenus}" var="sysPerm" varStatus="status">
                            <option value="${sysPerm.adminMenuId}"
                                    <c:if test="${sysPerm.adminMenuId==adminMenu.parentId}">selected</c:if>>${sysPerm.menuName}-
                                <c:if test="${sysPerm.level=='1'}">
                                    一级
                                </c:if>
                                <c:if test="${sysPerm.level=='2'}">
                                    二级
                                </c:if> <c:if test="${sysPerm.level=='3'}">
                                    三级
                                </c:if>

                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <label for="iconcls" class="control-label x90">菜单样式图标：</label>
                    <input type="text" name="iconcls" id="iconcls" value="${adminMenu.iconcls}"
                             size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="level" class="control-label x90">菜单级别：</label>
                    <select name="level" id="level" data-toggle="selectpicker" data-width="150">
                        <option value="1" <c:if test="${adminMenu.level=='1' }">selected</c:if>>一级</option>
                        <option value="2" <c:if test="${adminMenu.level=='2' }">selected</c:if>>二级</option>
                        <option value="3" <c:if test="${adminMenu.level=='3' }">selected</c:if>>三级</option>
                    </select>
                </td>
                <td>
                    <label for="sn" class="control-label x90">排序：</label>
                    <input type="text" name="sn" id="sn" value="${adminMenu.sn}" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="reqUrl" class="control-label x90">请求路径：</label>
                    <input type="text" name="reqUrl" id="reqUrl" value="${adminMenu.reqUrl}" size="15">
                </td>
                <td>
                    <label for="state" class="control-label x90">状态：</label>
                    <select name="state" id="state" data-toggle="selectpicker" data-width="150">
                        <option value="0" <c:if test="${adminMenu.state=='0' }">selected</c:if>>隐藏</option>
                        <option value="1" <c:if test="${adminMenu.state=='1' }">selected</c:if>>显示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="dataOptionsId" class="control-label x90">菜单名称标识：</label>
                    <input type="text" name="dataOptionsId" id="dataOptionsId" value="${adminMenu.dataOptionsId}"
                           size="15">
                </td>
                <td>
                    <label for="dataFaicon" class="control-label x90">菜单图标：</label>
                    <input type="text" name="dataFaicon" id="dataFaicon" value="${adminMenu.dataFaicon}" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="remark" class="control-label x90">说明：</label>
                    <input type="text" name="remark" id="remark" value="${adminMenu.remark}" size="15">
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
