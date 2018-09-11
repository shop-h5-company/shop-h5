<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<style type="text/css">
#viewSch tr{height: 45px}
</style>
<body>
<div class="bjui-pageContent">
        <table class="table table-condensed table-hover">
            <tbody id="viewSch">
            <tr>
                <td colspan="2" align="center"><h3>* 查看用户详情</h3></td>
            </tr>
            <tr>
                <td>
                    <label for="taskType" class="control-label x90">用户序号：</label>
                    ${pageInfo.userId }
                </td>
                <td>
                    <label for="taskCron" class="control-label x90">微信号：</label>
                    ${pageInfo.weixin }
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskType" class="control-label x90">注册时间：</label>
                    <fmt:formatDate value="${pageInfo.regTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>
                    <label for="taskCron" class="control-label x90">终端来源：</label>
                    ${pageInfo.deviceSource }
                </td>
           	</tr>
           	<tr>     
                <td>
                    <label for="taskCron" class="control-label x90">邀请方式：</label>
                    ${pageInfo.inviteMode }
                </td>
                <td>
                    <label for="taskType" class="control-label x90">邀请人：</label>
                    ${pageInfo.inviteUserId }
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskCron" class="control-label x90">姓名：</label>
                    ${pageInfo.userName }
                </td>
                <td>
                    <label for="taskType" class="control-label x90">身份证：</label>
                    <c:if test="${pageInfo.idCard != null}">${fn:substring(pageInfo.idCard,0,4)}****${fn:substring(pageInfo.idCard,pageInfo.idCard.length()-4,pageInfo.idCard.length())}</c:if>
                </td>
            </tr>
            <tr>    
                <td>
                    <label for="taskCron" class="control-label x90">是否实名：</label>
                    <c:if test="${pageInfo.isIdcheck == 'true'}">是</c:if> 
            		<c:if test="${pageInfo.isIdcheck == null}">否</c:if> 
                </td>
                <td>
                    <label for="taskType" class="control-label x90">手机号：</label>
                    <c:if test="${pageInfo.mobile != null}">${fn:substring(pageInfo.mobile,0,4)}****${fn:substring(pageInfo.mobile,pageInfo.mobile.length()-4,pageInfo.mobile.length())}</c:if>
                </td>
            </tr>
            <tr>    
                <td>
                    <label for="taskCron" class="control-label x90">邀请码：</label>
                    ${pageInfo.hisInviteCode }
                </td>
            
                <td>
                    <label for="taskType" class="control-label x90">状态：</label>
                    <c:if test="${pageInfo.status == 'enabled'}">可用</c:if> 
            		<c:if test="${pageInfo.status == 'disabled'}">停用</c:if> 
                </td>
            </tr>
            </tbody>
        </table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>
</body>
</html>