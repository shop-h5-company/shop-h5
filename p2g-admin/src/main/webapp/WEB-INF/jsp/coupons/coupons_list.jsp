<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--
  Created by IntelliJ IDEA.
  User: fanchael
  Date: 2016/6/21
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp" %>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/coupons/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">

        <div class="bjui-searchBar">
            <label>用户序号：</label><input type="text" value="${userId}" name="userId" size="15"/>
            <label for="source">发放来源:</label>
            <select name="source" id="source" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="active" <c:if test="${source=='active' }">selected</c:if>>活动</option>
                <option value="reg" <c:if test="${source=='reg' }">selected</c:if>>注册</option>
                <option value="invite" <c:if test="${source=='invite' }">selected</c:if>>邀请其他用户注册</option>
                <option value="system" <c:if test="${source=='system' }">selected</c:if>>系统</option>
            </select>
            <label for="status">使用状态:</label>
            <select name="status" id="status" data-toggle="selectpicker" data-width="150">
                <option value="" selected>--请选择--</option>
                <option value="not_used" <c:if test="${status=='not_used' }">selected</c:if>>未使用 </option>
                <option value="has_used" <c:if test="${status=='has_used' }">selected</c:if>>已使用</option>
            </select>
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            &nbsp;
            <a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog"
               href="/coupons/coupons_edit">添加</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="user_id">用户序号</th>
            <th data-order-field="product_type">产品类型</th>
            <th data-order-field="inc_days">加息天数</th>
            <th data-order-field="inc_rates">加息利率</th>
            <th data-order-field="create_time">创建时间</th>
            <th data-order-field="expired_time">过期时间</th>
            <th data-order-field="used_time">使用时间</th>
            <th data-order-field="source">发放来源</th>
            <th data-order-field="status">使用状态</th>
            <th data-order-field="inc_end_time">加息截止时间</th>
            <th data-order-field="admin_name">发放人</th>
            <th width="100">操作</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${pageInfo.userId}</td>
                <td> <c:if test="${pageInfo.productType=='current'}">
                        活期
                    </c:if>
                    <c:if test="${pageInfo.productType=='plus'}">
                        活期plus
                    </c:if>
                    <c:if test="${pageInfo.productType=='deposit'}">
                        定期
                    </c:if>
                </td>
                <td>${pageInfo.incDays}</td>
                <td>${pageInfo.incRates}</td>
                <td><fmt:formatDate value="${pageInfo.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><fmt:formatDate value="${pageInfo.expiredTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><fmt:formatDate value="${pageInfo.usedTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>
                    <c:if test="${pageInfo.source=='active'}">
                        活动
                    </c:if>
                    <c:if test="${pageInfo.source=='reg'}">
                        注册
                    </c:if>
                    <c:if test="${pageInfo.source=='invite'}">
                        邀请其他用户注册
                    </c:if>
                    <c:if test="${pageInfo.source=='system'}">
                        系统
                    </c:if>
                </td>
                <td>
                    <c:if test="${pageInfo.status=='not_used'}">
                        <span class="label label-default">未使用</span>
                    </c:if>
                    <c:if test="${pageInfo.status=='has_used'}">
                        <span class="label label-success">已使用</span>
                    </c:if>
                </td>
                <td><fmt:formatDate value="${pageInfo.incEndTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${pageInfo.adminName}</td>
                <td>
                    <a href="/coupons/coupons_edit?couponsId=${pageInfo.couponsId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${pageInfo.userId}">编辑</a>

                    <a href="/coupons/deleteProduct?couponsId=${pageInfo.couponsId}" class="btn btn-red"
                       data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？">删</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>

        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="15">15</option>
                <option value="30">30</option>
                <option value="50">50</option>
                <option value="100">100</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${pageInfo.total} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageInfo.total}"
         data-page-size="${pageInfo.pageSize}" data-page-current="${pageInfo.pageNum}">
    </div>
</div>
</body>
</html>
