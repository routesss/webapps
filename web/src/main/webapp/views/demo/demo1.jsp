<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/include/taglib.jsp"%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"><%--移动端适应--%>
    <title>Bootstrap</title>

    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .container,.row,.col-md-4,.col-md-6,.col-md-8,col-md-9{
            border: 1px solid black;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        Subsequent columns continue along the new line.
        <div class="row">
            <div class="col-md-9">.col-xs-9</div>
            <div class="col-md-4">.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.</div>
            <div class="col-md-6">.col-xs-6<br>Subsequent columns continue along the new line.</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">C</div>
        <div class="col-md-8">D</div>
    </div>
</div>

<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
