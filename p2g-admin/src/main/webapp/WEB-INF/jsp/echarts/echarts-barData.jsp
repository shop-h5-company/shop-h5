<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/include_head.jsp"%>
<c:if test="${echartsJson!=null}">${echartsJson}</c:if>
<c:if test="${echartsJson==null}">当前年份无数据</c:if>

