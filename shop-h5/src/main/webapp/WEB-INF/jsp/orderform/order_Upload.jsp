<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>批量添加订单</title>
</head>
<body>
<section class="main">
    <form id="mForm" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<a id="batch_upload" class="confirm" href="javascript:void(0)">批量添加</a>
		<a href="/res/批量新增物流信息模版.csv" class="confirm">下载模版</a>
	</form>
</section>
<!-- 底部 -->
<script type="text/javascript">
$(function () {
    $('#batch_upload').on('click', function () {
		$("#batch_upload").attr('disabled',true); //添加disabled属性 
    	batchUpload();
    	$('#batch_upload').removeAttr("disabled"); //移除disabled属性
    });
});

function batchUpload(){
	$.ajax({
        url: "/orderform/batchUpload",
        type: 'POST',
        cache: false,
        data: new FormData($('#mForm')[0]),
        processData: false,
        contentType: false,
        dataType:"json",
        beforeSend: function(){
            uploading = true;
        },
        success : function(result) {
        	var result = eval('(' + result + ')');
            if (result.code == '1') {
                layer.open({
    			    content: "批量添加成功！",
    			    btn: ['确定'],
    			    shadeClose: false,
    			    yes: function(){
    			    	window.location.href = "../orderform/index";
    			    }
    			});
            }else{
            	layer.open({
    	            content: result.msg,
    	            btn: ['确定'],
    			    shadeClose: false,
    			    yes: function(index){
    			    	layer.close(index);
    			    }
    	        });
            }
        }
    });
}
</script>
<!-- 底部 -->
</body>
</html>