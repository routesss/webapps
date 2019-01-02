
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>菜单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body layadmin-themealias="default">
<div class="layui-card layadmin-header"></div>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-md12">
            <button class="layui-btn layui-btn-sm" id="add">添加</button>
            <button class="layui-btn layui-btn-sm up-all">全部收起</button>
            <button class="layui-btn layui-btn-sm down-all">全部展开</button>
        </div>
        <div class="layui-col-md12">
            <table id="menuTable" class="layui-table" lay-filter="menuTable"></table>
        </div>
    </div>
</div>

<script type="text/javascript">
    layui.config({
        base:'${ctx}/static/lay-treetable/js/'
    }).extend({
        treetable : 'treetable'
    }) ;

    layui.use(['treetable','form'],function(){
        var data=[{"id":1,"pid":0,"title":"1-1"},{"id":2,"pid":0,"title":"1-2"},{"id":3,"pid":0,"title":"1-3"},{"id":4,"pid":1,"title":"1-1-1"},{"id":5,"pid":1,"title":"1-1-2"},{"id":6,"pid":2,"title":"1-2-1"},{"id":7,"pid":2,"title":"1-2-3"},{"id":8,"pid":3,"title":"1-3-1"},{"id":9,"pid":3,"title":"1-3-2"},{"id":10,"pid":4,"title":"1-1-1-1"},{"id":11,"pid":4,"title":"1-1-1-2"}];
        var o = layui.$,treetable = layui.treetable;
        var form = layui.form,layer = layui.layer;
        treetable.render({
            treeColIndex: 1,          // 树形图标显示在第几列
            treeSpid: 0,             // 	最上级的父级id
            treeIdName: 'id',       // id字段的名称
            treePidName: 'pid',     // 	pid字段的名称
            treeDefaultClose: true,   // 是否默认折叠
            treeLinkage: false,        // 父级展开时是否自动展开所有子级
            elem: '#menuTable',
            data: data,
            field: 'title',
            is_checkbox: true,
            cols: [
                {
                    field: 'title',
                    title: '标题',
                    width: '30%',
                    template: function(item){
                        if(item.level == 1){
                            return '<span style="color:red;">'+item.title+'</span>';
                        }
                        if(item.level == 2){
                            return '<span style="color:green;">'+item.title+'</span>';
                        }
                        return item.title;
                    }
                },
                {
                    field: 'id',
                    title: 'ID',
                    width: '20%'
                },
                {
                    field: 'pid',
                    title: '父ID',
                    width: '20%',
                },
                {
                    field: 'actions',
                    title: '操作',
                    width: '30%',
                    template: function(item){
                        var tem = [];
                        if(item.pid == 0){
                            tem.push('<a class="add-child" lay-filter="add">添加子级</a>');
                        }
                        tem.push('<a lay-filter="edit">编辑</a>');
                        if(item.pid > 0){
                            tem.push('<a class="set-attr">设置属性</a>');
                        }
                        return tem.join(' <font>|</font> ')
                    },
                },
            ]
        });

        treetable.on('treetable(add)',function(data){
            layer.msg('添加操作');
            console.dir(data);
        })

        treetable.on('treetable(edit)',function(data){
            layer.msg('编辑操作');
            console.dir(data);
        })

        o('.up-all').click(function(){
            treetable.all('up');
        })

        o('.down-all').click(function(){
            treetable.all('down');
        })

        $("#add").click(function(){
            openAddWin("添加菜单", "${ctx}/menuController/toForm", '500px', '900px') ;

            var iframeWindow = layero.find('iframe')[0].contentWindow;
            iframeWindow.reRender() ;
        }) ;

    })
</script>

</body>
</html>
