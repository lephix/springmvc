<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h3>foo: "${foo}"</h3>
	<h3>fruit: "${fruit}"</h3>
	<h3>model.integerTest: "${integerTest}"</h3>
	<h3>model.boolTest: "${boolTest}"</h3>
	<br/>
	<h3>converterTestObject.stringTest: "${converterTestObject.stringTest}"</h3>
	<h3>stringTest: "${stringTest}"</h3>
	<h3>converterTestObject.doubleTest: "${converterTestObject.doubleTest}"</h3>
	<h3>converterTestObject.boolTest: "${converterTestObject.boolTest}"</h3>
</div>
</body>
</html>