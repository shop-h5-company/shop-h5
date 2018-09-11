<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../common/include_head.jsp"%>
    <title>资金交易查询</title>
</head>
<body>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/task/getTaskSchedulerList" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        
       <div class="bjui-searchBar">
            <label>任务名称：</label><input type="text" value="${taskName}" name="taskName" size="15" />
            &nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        	<a class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" href="/task/addTaskScheduler">添加</a>
        	<a style="float:right" class="btn btn-green" href="/task/refreshTaskScheduler" data-toggle="doajax" data-title="恢复" data-confirm-msg="确定要重新加载吗？">重新加载</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        <tr>
            <th data-order-field="scheduler_id">序号</th>
            <th data-order-field="group_id">定时分组</th>
            <th data-order-field="task_name">任务名称</th>
            <th data-order-field="task_type">任务类型</th>
            <th data-order-field="task_cron">执行时间</th>
            <th data-order-field="task_previous_fire_time">前次执行时间</th>
            <th data-order-field="task_next_fire_time">下次执行时间</th>
            <th data-order-field="enable">是否可用</th>
            <th data-order-field="create_time">创建时间</th>
            <%--<th data-order-field="update_time">更新时间</th>--%>
             <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="taskSchedulerList" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${taskSchedulerList.schedulerId}</td>
                <td>${taskSchedulerList.groupId}</td>
                <td>${taskSchedulerList.taskName}</td>
                <td>${taskSchedulerList.taskType}</td>
                <td>${taskSchedulerList.taskCron}</td>
                <td><fmt:formatDate value="${taskSchedulerList.taskPreviousFireTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${taskSchedulerList.taskNextFireTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                <c:if test="${taskSchedulerList.enable==0}">否</c:if>
                <c:if test="${taskSchedulerList.enable==1}">是</c:if>
                
                </td>
                <td><fmt:formatDate value="${taskSchedulerList.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <%--<td><fmt:formatDate value="${taskSchedulerList.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                
            	<td>
                    <a href="/task/viewTaskScheduler?schedulerId=${taskSchedulerList.schedulerId}" class="btn btn-green" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="查看详情">查看</a>
                    <a href="/task/editTaskScheduler?schedulerId=${taskSchedulerList.schedulerId}" class="btn btn-default" data-id="dialog" data-height="400" data-width="800" data-toggle="dialog" data-mask="true" data-reload-warn="本页已有打开的内容，确定将刷新本页内容，是否继续？" data-title="编辑">编辑</a>
                    <a href="/task/runTaskScheduler?schedulerId=${taskSchedulerList.schedulerId}" class="btn btn-red" data-toggle="doajax" data-title="执行" data-confirm-msg="确定要执行吗？">执行</a>
                    <a href="/task/stopTaskScheduler?schedulerId=${taskSchedulerList.schedulerId}" class="btn btn-blue" data-toggle="doajax" data-title="暂停" data-confirm-msg="确定要暂停吗？">暂停</a>
                    <a href="/task/startTaskScheduler?schedulerId=${taskSchedulerList.schedulerId}" class="btn btn-orange" data-toggle="doajax" data-title="恢复" data-confirm-msg="确定要恢复吗？">恢复</a>
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
