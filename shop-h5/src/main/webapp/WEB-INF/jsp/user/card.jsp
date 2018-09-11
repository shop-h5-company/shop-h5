<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    	<title>设置银行信息</title>
</head>
<body>
<div class="mask"></div>
<section class="main maxH">
    <ul class="login card_mes">
        <li>
            <span>开户银行</span>
            <div class="divSelect">
                <select name="" id="bankName" class="SelectList gray">
                    <option value ="请选择">请选择开户银行</option>
                    <c:forEach items="${lianBanks}" var="pageInfo" varStatus="status">
                        <option value ="${pageInfo.lianBankCode}" <c:if test="${pageInfo.lianBankCode==lianBank.lianBankCode}">selected</c:if>>${pageInfo.bankName}</option>
                    </c:forEach>
                </select>
            </div>
            <em class="arrow"></em>
        </li>
        <li>
            <span>借记卡</span>
            <input id="cardNo" type="text" value="${lianAccount.bankCard}" maxlength="19" placeholder="请输入银行卡号">
        </li>
    </ul>
    <a href="javascript:void(0)" onclick="userForm()" class="confirm">确定</a>
    <div class="tips">
        <p>
            <strong>温馨提示：</strong><br>
            1. 为保障您的资金安全，绑定的银行卡开户名必须与您的
            建安金融账户真实姓名一致，否则提现申请将无法提交；<br>
            2. 禁止信用卡套现、虚假交易等行为、一经确认、该账户
            停止使用；<br>
            3. 为保障您的资金安全，您选择的提现银行卡必须与您充
            值银行卡一致，否则提现申请将不予受理；<br>
            4. 若您在提现过程中，有任何疑问，请联系客服<br>
            400-068-0836。
        </p>
    </div>
</section>
<script type="text/javascript">
function userForm(){
	var cardno = $("#cardNo").val();
	var bankname = $("#bankName").val();
 	var reg = /^(\d{16}|\d{19})$/;
	if(reg.test(cardno) === false){
		layer.open({
            content: "银行卡号输入不合法",
            btn: ['确定'],
		    shadeClose: false,
		    yes: function(index){
		    	layer.close(index);
		    }
        });
		return false;
	}
	$.ajax({
		url:'/user/addCardNo',
		type:'post',
		data:{"cardNo":cardno, "bankName":bankname},
		async:false,
		success:function(res){
		    layer.open({
			    content: "保存成功",
			    btn: ['确定'],
			    shadeClose: false,
			    yes: function(){
			    	window.location.href = "../user/personalSet";
			    }
			});
		},
		error:function(res){}
	})
}
</script>
</body>
</html>