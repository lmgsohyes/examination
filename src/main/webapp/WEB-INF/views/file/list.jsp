<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>文件上传页面</title>
	<meta charset="utf-8"/>
	<!-- 引入样式 -->
	<link rel="stylesheet" type="text/css" href="/examination/static/js/webuploader/webuploader.css">
	
	<!-- 引入jquery -->
    <script type="text/javascript" src="/examination/static/js/jquery/jquery.js"></script>
	
	
	<!--引入JS-->
    <script type="text/javascript" src="/examination/static/js/webuploader/webuploader.js"></script>
	
	<!-- 引入我们自定义的上传操作按钮 -->
    <script type="text/javascript" src="/examination/static/js/file/list.js"></script>
</head>
<body>
 	<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</div>
</body>
</html>