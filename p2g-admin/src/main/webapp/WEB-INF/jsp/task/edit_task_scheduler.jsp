<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/task/editTaskSchedulerSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <input type="hidden" name="schedulerId" value="${taskScheduler.schedulerId }">
        <input type="hidden" name="createTime" value="<fmt:formatDate value="${taskScheduler.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <input type="hidden" name="taskPreviousFireTime" value="<fmt:formatDate value="${taskScheduler.taskPreviousFireTime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <input type="hidden" name="taskNextFireTime" value="<fmt:formatDate value="${taskScheduler.taskNextFireTime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 编辑定时调度</h3></td>
            </tr>
            
           <tr>
                <td>
                    <label for="groupId" class="control-label x90">定时分组：</label>
                    <select name="groupId" id="groupId" data-toggle="selectpicker" data-width="200">
                        <c:forEach items="${groupList}" var ="group">
                        	<option value="${group.groupId }" <c:if test="${taskScheduler.groupId==group.groupId }">selected</c:if>>${group.groupName }</option>
                        </c:forEach>
                    </select>
                </td>
				<td>
                    <label for="taskName" class="control-label x90">任务名称：</label>
                    <input type="text" name="taskName"  id="taskName" value="${taskScheduler.taskName }" data-rule="任务名称:required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskType" class="control-label x90">任务类型：</label>
                    <input type="text" name="taskType"  id="taskType" value="${taskScheduler.taskType }" data-rule="任务类型:required" size="20">
                </td>
                <td>
                    <label for="taskCron" class="control-label x90">执行时间：</label>
                    <input type="text" name="taskCron" id="taskCron" value="${taskScheduler.taskCron }" data-rule="执行时间:required" size="20">
                </td>
            </tr>
            <tr>
       			<td>
                    <label for="jobData" class="control-label x90">JSON参数：</label>
                    <textarea name="jobData"  id="jobData" cols="20" rows="3" maxlength="50">${taskScheduler.jobData }</textarea>
                </td>
       			<td>
                    <label for="taskDesc" class="control-label x90">任务描述：</label>
                    <textarea name="taskDesc"  id="taskDesc" cols="20" rows="3" maxlength="50">${taskScheduler.taskDesc }</textarea>
                </td>
            </tr>
			<tr>
                <td>
                    <label for="enable" class="control-label x90">是否可用：</label>
                    <select name="enable" id="enable" data-toggle="selectpicker" data-width="200">
                        <option value="1" <c:if test="${taskScheduler.enable==1}">selected</c:if>>可用</option>
                        <option value="0" <c:if test="${taskScheduler.enable==0}">selected</c:if>>不可用</option>
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
