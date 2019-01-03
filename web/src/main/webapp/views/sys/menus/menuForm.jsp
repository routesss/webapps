<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑菜单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md12">

            <form class="layui-form layui-form-pane" lay-filter="menuForm">
                <div class="layui-row">
                    <div class="layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">上级菜单</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="parentId" lay-verify="required" placeholder="必填"/>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">菜单名</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="name" lay-verify="required" placeholder="必填"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <div class="layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">排序</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="sort" lay-verify="required" placeholder="必填"/>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">链接</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="href" lay-verify="required" placeholder="必填"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <div class="layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">图标</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="icon"/>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-sm6">
                        <div class="layui-form-item" pane>
                            <label class="layui-form-label">单选框</label>
                            <div class="layui-input-block">
                                <input type="radio" name="sex" value="男" title="男">
                                <input type="radio" name="sex" value="女" title="女" checked>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <div class="layui-col-sm12">
                        <div class="layui-form-item">
                            <label class="layui-form-label">权限标识</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" name="permission" lay-verify="required" placeholder="必填"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <div class="layui-col-sm12">
                        <div class="layui-form-item">
                            <textarea name="remarks" placeholder="备注" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script type="text/javascript">
    layui.use(['treetable', 'form'], function () {
        var element = layui.element;
        var form = layui.form;

    });

    function renderForm(){
        layui.use(['form'], function(){
            var form = layui.form;

            form.render();
        }) ;
    }

</script>
</body>
</html>
