<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/css/sys.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">

                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    sola
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="${MainNavName}">

                <li class="layui-nav-item layui-nav-itemed" data-url="" data-name="所有商品" data-open="0">
                    <a href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="/menuController/list" data-name="列表一" data-open="1" data-external="0">列表一</a></dd>
                        <dd><a href="javascript:;" data-url="/menuController/toListTree" data-name="列表二" data-open="1" data-external="0">列表二</a></dd>
                        <dd><a href="javascript:;" data-url="https://www.baidu.com/" data-name="列表三" data-open="1" data-external="1">列表三</a></dd>
                        <dd><a href="javascript:;" data-url="https://www.baidu.com/" data-name="超链接" data-open="1" data-external="1">超链接</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item" data-url="new url5" data-name="云市场" data-open="1" data-external="0"><a href="">云市场</a></li>


            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-filter="${MainTabName}" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this">网站设置</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">内容1</div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script>
    //JavaScript代码区域
    $(function () {

        //加载element模块
        layui.use(['element'], function(){
            var element = layui.element;

            //tab事件监控
            element.on('tab(${MainTabName})', function (data) {

                //console.log(data) ;

            });

            //监控菜单栏点击事件
            element.on('nav(${MainNavName})', function(elem){

                //console.log(elem) ; //当前点击的dom对象
                var dataUrl = elem.attr("data-url") ;           //菜单url
                var dataName = elem.attr("data-name") ;         //菜单名
                var dataOpen = elem.attr("data-open") ;         //是否打开tab
                var dataExternal = elem.attr("data-external") ; //是否是外站连接

                //是否新增tab
                if(dataOpen == 1){
                    //如果tab不存在则创建tab
                    if(findTab("${MainTabName}", dataUrl) == false){
                        //是否是外站连接
                        if(dataExternal == 0){
                            dataUrl = "${ctx}"+dataUrl ;
                        }
                        //添加tab
                        element.tabAdd('${MainTabName}',{
                            title : dataName,
                            content : "<iframe frameborder='0' scrolling='auto' id='if"+dataUrl+"' width='100%' height='100%' src='"+dataUrl+"'></iframe>",
                            id:dataUrl
                        }) ;
                    }
                    //跳转到打开的tab窗口
                    element.tabChange("${MainTabName}", dataUrl);
                }

            }) ;
        });


    }) ;


    //查找指定tab是否存在
    function findTab(t,i)
    {
        var a=layui.$ ;
        var e=".layui-tab-title",
            l=a(".layui-tab[lay-filter="+t+"]"),
            n=l.children(e),
            s=n.find('>li[lay-id="'+i+'"]');
        //console.log(s[0]) ;
        if(s[0] == undefined){
            return false ;
        }else{
            return true ;
        }
    }

</script>
</body>
</html>
