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
    <link href="${ctx}/static/layui/css/layui.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .container,.row,.col-md-4,.col-md-6,.col-md-8,col-md-9,col-xs-6,col-sm-3{
            border: 1px solid black;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3Resize your viewport or check it out on your phone for an example.</div>
        <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>

        <!-- Add the extra clearfix for only the required viewport -->
        <div class="clearfix visible-xs-block"></div>

        <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
        <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
    </div>


</div>

<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;

        layer.msg('Hello World');
    });
</script>

</body>
</html>
