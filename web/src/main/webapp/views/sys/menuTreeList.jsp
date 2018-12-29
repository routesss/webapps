
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body>
<table id="menuTable" class="layui-table" lay-filter="menuTable"></table>

<script type="text/javascript">
    $(function(){

        //加载 treeTable
        layui.config({
            base:'${ctx}/static/treetable-lay/module/treetable-lay/'
        }).extend({
            treetable : 'treetable'
        }) ;

        layui.use(['element','treetable'], function () {
            var element = layui.element;
            var treetable = layui.treetable;
            var layer = layui.layer ;

            // 渲染表格
            layer.load(2) ;
            treetable.render({
                treeColIndex: 1,          // 树形图标显示在第几列
                treeSpid: 1,             // 	最上级的父级id
                treeIdName: 'authorityId',       // id字段的名称
                treePidName: 'parentId',     // 	pid字段的名称
                treeDefaultClose: true,   // 是否默认折叠
                treeLinkage: false,        // 父级展开时是否自动展开所有子级
                elem: '#menuTable',
                url: '${ctx}/menuController/toListDateTree',
                page: "false" ,
                cols: [[
                    {type: 'numbers'},
                    {field: 'authorityName', title: 'name'},
                    {field: 'menuUrl', title: 'menuUrl'},
                    {field: 'createTime', title: 'createTime'},
                ]],
                done:function(){
                    layer.closeAll('loading') ;
                }
            });
        });

    }) ;
</script>
</body>
</html>
