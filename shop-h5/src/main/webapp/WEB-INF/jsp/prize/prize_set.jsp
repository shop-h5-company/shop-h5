<%--
  Created by IntelliJ IDEA.
  User: zhaozizhen
  Date: 2016/7/4
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    <script type="text/javascript" src="/res/js/adaptive.js?v=4"></script><!--适配js layer需要这两个js文件-->
	<script type="text/javascript" src="/res/js/layer/layer.js?v=4"></script>
    <title>奖品编辑</title>
</head>
<body>
<section class="main">
<form id="mForm">
    <ul class="login login_css">
        <%-- <input type="hidden" type="text" id="sequence" name="sequence" value="${sequence}"/> lz--%>
        <input type="hidden" type="text" id="sequence" name="sequence" value="${sequence}"/>
        <li>
        	<select name="" id="sort" class="SelectList gray">
        		<c:if test="${prizeconfig.sort=='0'}">
					<option value="0"  selected="selected">红包</option> 
					<option value ="1">实物</option>
			    </c:if>
        		<c:if test="${prizeconfig.sort=='1'}">                 
					<option value="1"  selected="selected">实物</option> 
					<option value ="0">红包</option>
			    </c:if>
			    <c:if test="${prizeconfig.sort==null}"> 
                	<option value ="请选择">请选择奖品类型</option>
                    <option value ="0">红包</option>
                    <option value ="1">实物</option>
			    </c:if>
            </select>
        </li>
        <li>
        	<span>奖品名称</span>
            <input type="text" autocomplete="on" id="prizeName" value="${prizeconfig.prizeName }" maxlength="18" placeholder="请输入奖品名称"/>
        </li>
        <li>
        	<span>中奖概率</span>
            <input class="textbox" type="tel" maxlength="1" id="probability" value="${prizeconfig.probability }" placeholder="0-9，0不中、9为保中"/>
        </li>
        <li>
        	<span>库存数量</span>
            <input class="textbox" type="tel" maxlength="8" id="stockNum" value="${prizeconfig.stockNum }" placeholder="请输入库存数量"/>
        </li>
    </ul>
    <a id="set_password" class="confirm" href="javascript:setPrize()">确定</a>
</form>
</section>
<div class="mask"></div>
<div class="error_timeout"></div>
<script type="text/javascript">
	function setPrize(){
		var sequence = $("#sequence").val();
		var sort = $("#sort").val();
		var prizeName = $("#prizeName").val();
		var probability = $("#probability").val();
		var stockNum = $("#stockNum").val();
		var reg = /^\d{1}$/;
		var regStockNum = /^[0-9]\d{0,7}$/;
		//校验
		if(sort == "请选择"){
			//alert("奖品类型为必选项");
			layer.open({
                content:'奖品类型为必选项',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		if(prizeName.length == 0){
			//alert("奖品名称不能为空");
			layer.open({
                content:'奖品名称不能为空',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		if(prizeName.length > 10){
			//alert("奖品名称限制最长10个字符");
			layer.open({
                content:'奖品名称限制最长10个汉字',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		
		if(!reg.test(probability) || probability.length == 0){
			//alert("概率限制为1个字符");
			layer.open({
                content:'概率必须设置数字',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		if(stockNum.length == 0){
			//alert("库存数量不能为空");
			layer.open({
                content:'库存数量不能为空',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		if(stockNum.length == 0){
			//alert("库存数量不能为空");
			layer.open({
                content:'库存数量不能为空',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		if(!regStockNum.test(stockNum)){
			//alert("库存数量限制最长8个字符");
			layer.open({
                content:'库存数量必须为数字',
                btn:['确定'],
                shadeClose: false,
                });
			return;
		}
		
		$.post('/prize/addPrize?prizeName='+prizeName+'&probability='+probability+'&sort='+sort+'&sequence='+sequence+'&stockNum='+stockNum,
			   function(data){
					//alert(data.msg);
					layer.open({
                       content:data.msg,
                       btn:['确定'],
                       yes:function(index,layero){//按确定，则执行yes。点击取消关闭弹框层
							window.location.href = "../prize/index";
                       }
                   });
			   },
			"json");
	}
</script>
</body>
</html>