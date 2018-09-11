<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta name="format-detection" content="telephone=no"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="-1"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <title>微联盟</title>
    <script type="text/javascript" src="/res/js/adaptive.js"></script><!--适配js-->
    <style>
        .box {
            width: 4rem;
            height: 4.8rem;
            margin: 0 auto;
            position: absolute;
            top: 45%;
            left: 50%;
            margin-top: -2.4rem;
            margin-left: -2rem;
            text-align: center;

        }
        .box img{ width:100%;max-width:100%}
    </style>
</head>
<body>
<div class="box"><img src="/res/image/loading.gif"/></div>
<form id="payBillForm" action="${reqUrl}" method="post">
    <input type="hidden" name="backUrl" value='${backUrl}'/>
    <input type="hidden" name="sign" value='${sign}'/>
</form>
</body>
<script language="javascript" type="text/javascript">
    window.onload = function () {
        document.getElementById("payBillForm").submit();
    }
</script>
</html>

