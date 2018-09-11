<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<script type="text/javascript">
var inputs=$('input[name="ids"]');
$(function(){
	//初始化选择用户已有菜单
	var menuIds=eval('${menuIds}');
	if(menuIds!=undefined){
		for(var i=0;i<menuIds.length;i++){
			for(var j=0;j<inputs.length;j++){
				if($(inputs[j]).val()==menuIds[i]){
					$(inputs[j]).iCheck('check');
				}
			}
		}
	}
})
//确定分配
function saveAdminMenu(adminId){
	var ids = new Array();
	for(var i=0;i< inputs.length;i++){
		if($(inputs[i]).is(':checked')){
			ids.push($(inputs[i]).val());
		}
	}
	ids=ids.join(",");
 	$.ajax({
		url:'/admin/saveAdminMenu',
		type:'post',
		data:{"adminId":adminId,"ids":ids},
		success:function(rsp){
			$("<div></div>").alertmsg('ok', '分配成功！');
			$(".btn-close").click();
		},
		error:function(rsp){
			$("<div></div>").alertmsg('error', '分配失败！');
		}
	}) 
}
</script>
<body>
<div class="bjui-pageContent">
        <table class="table table-bordered table-hover table-striped table-top">
    	<thead>
        <tr>
            <th>序号</th>
            <th>菜单名称</th>
            <th>菜单URL</th>
            <th>菜单级别</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="sysPerm" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${sysPerm.adminMenuId}</td>
                <td>${sysPerm.menuName}</td>
                <td>${sysPerm.reqUrl}</td>
                <td>
					<c:if test="${sysPerm.level=='1'}">
						一级
					</c:if>
					<c:if test="${sysPerm.level=='2'}">
						二级
					</c:if> <c:if test="${sysPerm.level=='3'}">
						三级
					</c:if>
				</td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${sysPerm.adminMenuId }"></td>
            </tr>
        </c:forEach>
        </tbody>
    	</table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li>
            <button class="btn-default btn" type="button" onclick="saveAdminMenu('${adminId}')">确定</button>
        </li>
    </ul>
</div>
</body>
</html>
