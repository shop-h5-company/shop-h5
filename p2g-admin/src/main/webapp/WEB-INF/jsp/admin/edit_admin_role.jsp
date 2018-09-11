<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ include file="../common/include_head.jsp"%>
    <title>Title</title>
</head>
<script type="text/javascript">
var inputs=$('input[name="ids"]');
$(function(){
	//初始化选择用户已有角色
	var roleIds=eval('${roleIds}');
	if(roleIds!=undefined){
		for(var i=0;i<roleIds.length;i++){
			for(var j=0;j<inputs.length;j++){
				if($(inputs[j]).val()==roleIds[i]){
					$(inputs[j]).iCheck('check');
				}
			}
		}
	}
})
//确定分配
function saveAdminRole(adminId){
	var ids = new Array();
	for(var i=0;i< inputs.length;i++){
		if($(inputs[i]).is(':checked')){
			ids.push($(inputs[i]).val());
		}
	}
	ids=ids.join(",");
 	$.ajax({
		url:'/admin/saveAdminRole',
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
            <th>角色名称</th>
            <th>角色类型</th>
            <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="role" varStatus="status">
            <tr data-id="${status.index+1}">
                <td>${status.index+1}</td>
                <td>${role.roleName}</td>
                <td>${role.roleType}</td>
                <td><input type="checkbox" name="ids" data-toggle="icheck" value="${role.roleId }"></td>
            </tr>
        </c:forEach>
        </tbody>
    	</table>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li>
            <button class="btn-default btn" type="button" onclick="saveAdminRole('${adminId}')">确定</button>
        </li>
    </ul>
</div>
</body>
</html>
