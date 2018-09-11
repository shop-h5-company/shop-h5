<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<script type="text/javascript">
var inputs=$('input[name="ids"]');
$(function(){
	//初始化选择用户已有权限
	var permissionIds=eval('${permissionIds}');
	if(permissionIds!=undefined){
		for(var i=0;i<permissionIds.length;i++){
			for(var j=0;j<inputs.length;j++){
				if($(inputs[j]).val()==permissionIds[i]){
					$(inputs[j]).iCheck('check');
				}
			}
		}
	}
})
//确定分配
function saveAdminPermission(adminId){
	var ids = new Array();
	for(var i=0;i< inputs.length;i++){
		if($(inputs[i]).is(':checked')){
			ids.push($(inputs[i]).val());
		}
	}
	ids=ids.join(",");
 	$.ajax({
		url:'/admin/saveAdminPermission',
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
            <th data-order-field="permission_id">序号</th>
            <th data-order-field="permission_name">权限名称</th>
            <th data-order-field="permission_url">权限URL</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="sysPerm" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${sysPerm.permissionId}</td>
                <td>${sysPerm.permissionName}</td>
                <td>${sysPerm.permissionUrl}</td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${sysPerm.permissionId }"></td>
            </tr>
        </c:forEach>
        </tbody>
    	</table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li>
            <button class="btn-default btn" type="button" onclick="saveAdminPermission('${adminId}')">确定</button>
        </li>
    </ul>
</div>
</body>
</html>
