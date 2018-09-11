<%--
  Created by IntelliJ myeclipse.
  User: zhaozizhen
  Date: 2016/6/27
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/user/getList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>手机号：</label><input type="text" value="${mobile}" name="mobile" size="15" />
            <label>&nbsp;姓名:</label><input type="text" value="${userName}" name="userName" size="10">
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
        	<th data-order-field="user_id">用户序号</th>
        	<th data-order-field="weixin">微信号</th>
        	<th data-order-field="reg_time">注册时间</th>
        	<th data-order-field="device_source">终端来源</th>
        	<th data-order-field="invite_mode">邀请方式</th>
        	<th data-order-field="invite_user_id">邀请人</th>
        	<th data-order-field="user_name">姓名</th>
        	<th data-order-field="id_card">身份证</th>
        	<th data-order-field="is_idcheck">是否实名</th>
        	<th data-order-field="invite_right">邀请资格</th>
        	<th data-order-field="inside_invite_right">内推资格</th>
        	<th>操作</th>
		</tr>        
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="status">
            <tr data-id="${status.index+1}">
            	<td>${pageInfo.userId}</td>
            	<td>
            		<c:if test="${pageInfo.weixin != null}">
            			已绑定
            		</c:if>
            		<c:if test="${pageInfo.weixin == null}">
            			未绑定
            		</c:if>
            	</td>
            	<td ><fmt:formatDate value="${pageInfo.regTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate></td>
            	<td>${pageInfo.deviceSource}</td>
            	<td>
	            	<c:if test="${pageInfo.inviteMode == null}">无邀请</c:if>
	            	<c:if test="${pageInfo.inviteMode == 'follw_weixin'}">扫描二维码关注公众号邀请</c:if>
	            	<c:if test="${pageInfo.inviteMode == 'reg_code'}">注册界面邀请码邀请</c:if>
	            	<c:if test="${pageInfo.inviteMode == 'weixin_share'}">微信分享邀请</c:if>
	            	<c:if test="${pageInfo.inviteMode == 'ios_share'}">ios分享邀请</c:if>
	            	<c:if test="${pageInfo.inviteMode == 'android_share'}">android分享邀请</c:if>
            	</td>
            	<td>${pageInfo.inviteUserId}</td>
            	<td>${pageInfo.userName}</td>
            	<td>
            		<c:if test="${pageInfo.idCard != null}">${fn:substring(pageInfo.idCard,0,4)}****${fn:substring(pageInfo.idCard,pageInfo.idCard.length()-4,pageInfo.idCard.length())}</c:if>
            	</td>
            	<td>
	            	<c:if test="${pageInfo.isIdcheck == 'true'}">是</c:if> 
	            	<c:if test="${pageInfo.isIdcheck == null}">否</c:if> 
            	</td>
            	<td>
	            	<c:if test="${pageInfo.inviteRight == 'yes' || pageInfo.inviteRight == null}">有</c:if> 
	            	<c:if test="${pageInfo.inviteRight == 'no'}">无</c:if> 
            	</td>
            	<td>
	            	<c:if test="${pageInfo.insideInviteRight == 'yes'}">有</c:if> 
	            	<c:if test="${pageInfo.insideInviteRight == 'no' || pageInfo.insideInviteRight == null}">无</c:if> 
            	</td>
            	<td>
            		<a href="/user/queryUser?userId=${pageInfo.userId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="420" data-width="800" data-toggle="dialog" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="用户详情">查看</a>
            		<a href="/user/add?userId=${pageInfo.userId}" class="btn btn-green" data-toggle="dialog" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑-${pageInfo.userId}">编辑</a>
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
    <div class="pagination-box" data-toggle="pagination" data-total="${pageInfo.total}" data-page-size="${pageInfo.pageSize}" data-page-current="${pageInfo.pageNum}">
    </div>
</div>
</body>
</html>
