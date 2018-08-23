<%--
  Created by IntelliJ IDEA.
  User: fenggeng
  Date: 2018/6/5
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getAdminPath()}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>--%>
<html>
<head>
    <title>Title</title>
    <script src="/static/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
DEMO TEST

<input type="text" id="msg" name="msg"/>
<input type="button" onclick="sendMsg()" value="发送"/>
<input type="button" onclick="closeSocket()" value="关闭连接"/>

<script type="text/javascript">
    var ws ;//websocket对象

    function closeSocket() {
        //关闭连接
        ws.close() ;
    }

    function sendMsg(){
        var $msg = $("#msg").val() ;
        ws.send($msg) ;
    }

    $(function(){


        if("WebSocket" in window){
            // 初始化一个 WebSocket 对象
            ws = new WebSocket("ws://localhost:8080/socket");

            // 建立 web socket 连接成功触发事件
            ws.onopen = function () {
                // 使用 send() 方法发送数据
                ws.send("建立连接");
            };

            // 接收服务端数据时触发事件
            ws.onmessage = function (evt) {
                var received_msg = evt.data;
                console.log(received_msg) ;
            };

            //连接失败，发送、接收数据失败或者处理数据出现错误，browser会触发onerror消息;
            ws.onerror = function(evt){

            }
            // 断开 web socket 连接成功触发事件
            ws.onclose = function () {
                alert("连接已关闭...");
            };
        }else{
            alert("您的浏览器不支持 WebSocket!") ;
        }


    }) ;

</script>
</body>
</html>
