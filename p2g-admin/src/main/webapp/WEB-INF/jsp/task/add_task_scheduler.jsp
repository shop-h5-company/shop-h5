<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<body>
<div class="bjui-pageContent">
    <form action="/task/addTaskSchedulerSubmit" class="pageForm" data-toggle="validate">
        <input type="hidden" name="dialog.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td colspan="2" align="center"><h3>* 新增定时调度</h3></td>
            </tr>
            
           <tr>
                <td>
                    <label for="groupId" class="control-label x90">定时分组：</label>
                    <select name="groupId" id="groupId" data-toggle="selectpicker" data-width="200">
                        <c:forEach items="${groupList}" var ="group">
                        	<option value="${group.groupId }">${group.groupName }</option>
                        
                        </c:forEach>
                    </select>
                </td>
				<td>
                    <label for="taskName" class="control-label x90">任务名称：</label>
                    <input type="text" name="taskName"  id="taskName" value="" data-rule="任务名称:required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="taskType" class="control-label x90">任务类型：</label>
                    <input type="text" name="taskType"  id="taskType" value="" data-rule="任务类型:required" size="20">
                </td>
                <td>
                    <label for="taskCron" class="control-label x90">执行时间：</label>
                    <input type="text" name="taskCron" id="taskCron" value="0/30 * * * * ?" data-rule="执行时间:required" size="20">
                </td>
            </tr>
            <tr>
       			<td>
                    <label for="jobData" class="control-label x90">JSON参数：</label>
                    <textarea name="jobData"  id="jobData" cols="20" rows="3" maxlength="40"></textarea>
                </td>
       			<td>
                    <label for="taskDesc" class="control-label x90">任务描述：</label>
                    <textarea name="taskDesc"  id="taskDesc" cols="20" rows="3" maxlength="40"></textarea>
                </td>
            </tr>
			<tr>
                <td>
                    <label for="enable" class="control-label x90">是否可用：</label>
                    <select name="enable" id="enable" data-toggle="selectpicker" data-width="200">
                        <option value="1">可用</option>
                        <option value="0">不可用</option>
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
