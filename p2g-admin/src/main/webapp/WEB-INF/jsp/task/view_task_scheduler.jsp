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
                <td colspan="2" align="center"><h3>* 查看定时调度</h3></td>
            </tr>
            
           <tr>
                <td>
                    <label for="groupId" class="control-label x90">定时分组：</label>
                    <c:forEach items="${groupList}" var ="group">
                        	<c:if test="${taskScheduler.groupId==group.groupId }">${group.groupName }</c:if>
                    </c:forEach>
                </td>
				<td>
                    <label for="taskName" class="control-label x90">任务名称：</label>${taskScheduler.taskName }
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskType" class="control-label x90">任务类型：</label>
                    ${taskScheduler.taskType }
                </td>
                <td>
                    <label for="taskCron" class="control-label x90">执行时间：</label>
                    ${taskScheduler.taskCron }
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskPreviousFireTime" class="control-label x90">前次执行时间：</label>
                    <fmt:formatDate value="${taskScheduler.taskPreviousFireTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <label for="taskNextFireTime" class="control-label x90">下次执行时间：</label>
                    <fmt:formatDate value="${taskScheduler.taskNextFireTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr>
       			<td>
                    <label for="taskDesc" class="control-label x90">任务描述：</label>
                    ${taskScheduler.taskDesc }
                </td>
               	<td colspan="2">
                    <label for="enable" class="control-label x90">是否可用：</label>
                    <c:if test="${taskScheduler.enable==1}">是</c:if>
                    <c:if test="${taskScheduler.enable==0}">否</c:if>
               	
                </td>
            </tr>
			<tr>
			    <td colspan="2">
                    <label for="jobData" class="control-label x90">JSON参数：</label>
                    ${taskScheduler.jobData }
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
