<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../common/include.jsp"%>
    <title>银行信息</title>
</head>
<body>
<div class="mask"></div>
<section class="main maxH">
    <ul class="login card_mes">
    	<li>
            <span>开户银行</span>
            <span>${lianBank.bankName}</span>
        </li>
        <li>
            <span>借记卡</span>
            <span>${bankCard}</span>
        </li>
    </ul>
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
</body>
</html>