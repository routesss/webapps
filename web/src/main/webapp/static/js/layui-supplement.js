
function openAddWin(title, url, height, width){
    layer.open({
        type: 2,
        title : title,
        area:[height, width],
        maxmin:true,
        btn: ['确认', '关闭'],
        content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        cancel:function(index, layero){
            return true ;
        },
        yes:function(index, layero){
            layer.msg('yes');
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        },
        btn2:function(index, layero){
            layer.msg('cancel');
        }
    });
}

function openLockWin(title, url, height, width){
    layer.open({
        type: 2,
        title : title,
        area:[height, width],
        maxmin:true,
        btn: ['关闭'],
        content: url,
        cancel:function(index, layero){
            return true ;
        },
        yes:function(index, layero){
            layer.msg('cancel');
            layer.close(index);
        }
    });
}