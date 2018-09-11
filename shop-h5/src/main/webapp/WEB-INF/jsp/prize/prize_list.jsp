<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../common/include.jsp"%>
<%@ include file="../common/include_header.jsp"%>
<title>中奖名单</title>
</head>
<body>
<section class="main">
	<div class="message">
        <ul class="meslist">
        	<li>中奖名单<li>
        </ul>
    </div>
    <ul  class="person">
    	<c:if test="${prizes != null}">
	    	<c:forEach items="${prizes }" var="prize">
		        <li class="arrow_parent">
		                <i class="ico_set4"></i>
		                <%-- <span id="prizeId">id:${prize.id }</span> --%>
		                <c:if test="${common == null }">
		                	<span>${prize.userName }</span>，
		                </c:if>
		                <!-- 顶级代理商显示：派奖或已派奖。  普通用户：未派奖已派奖 -->
		                <span>${prize.prizeName }</span>，
		                
		                <c:if test="${prize.prizeOutTime != null }">
		                	<span style="color:green;">已派奖,${prize.prizeOutTime2}</span>
		                </c:if>
		                <c:if test="${prize.prizeOutTime == null }">
		                	<c:if test="${prize.userType == 1 }">
		                		<button onclick="paijiang(${prize.id });" id="${prize.id }">派奖</button>
		                		<span>,${prize.inPrizeTime2}</span>
		                	</c:if>
		                	<c:if test="${prize.userType == 0 }"><span>未派奖,${prize.inPrizeTime2}</span></c:if>
		                </c:if>
		                
		                <span class="ico_val ab_arrow green"></span>
		                <em class="arrow"></em>
		        </li>
	       </c:forEach>
        </c:if>
    </ul>
<%--     <ul  class="person">
    	<c:if test="${prizes == null}">
	    	<c:forEach items="${prizes }" var="prize">
		        <li class="arrow_parent">
		        	<!-- 点击时传id到后台 查询下级所有用户，当用户标示为未邀请时不可点击，已邀请时显示未结算金额，并可进入到下级，没有未结算金额则为0 -->
		            <a href="/prize/prizeList?currentUserId=${user.id}">
		                <i class="ico_set4"></i>
		                	<!-- 未结算的为当前用户下级所有未结算的总额    10元为当前用户未结算的金额   -->
		                <span>${user.wxName }（${user.weixin }）顏無心（無心）  <c:if test=""><!-- 未结算或者一个图片感叹号 --></c:if></span>
		                <span><!-- 2017-09-25 12:11:11  -->10元现金  <c:if test=""><!-- 参数为空的时候显示 --><button>结算</button></c:if></span>
		                <span class="ico_val ab_arrow green"></span>
		                <em class="arrow"></em>
		            </a>
		        </li>
	        </c:forEach>
        </c:if>
    </ul> --%>
</section>
<!-- 底部 -->
<script>
    var footSelect = "people";
    function paijiang(prizeId){
    	//var id = $("#prizeId").text();
    	//alert(prizeId);
    $.post('/prize/sendPrize?id='+prizeId,
			   function(data){
    				if(data.result == true){
						alert(data.msg);
						$("#"+prizeId+"").text("已派奖");
    				}else{
						alert("派奖失败，请重试");
    				}
			   },
			"json");
    	};
    
</script>
<%@ include file="../common/footer.jsp"%>
<!-- 底部 -->
</body>
</html>