<%--
  Created by IntelliJ IDEA.
  User: fenggeng
  Date: 2018/6/5
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/include/taglib.jsp"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getAdminPath()}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>--%>
<html>
<head>
    <title>socket</title>

    <style type="text/css">
        #content{
            border: solid 1px black;height: 90%;width: 80%;float: left;
        }
        #userList{
            border: solid 1px black;height: 90%;width: 19%;float: right;
        }
        #sendMessage{
            border: solid 1px black;height: 10%;width: 100%;clear: both;
        }
        #msg,#name{
            width:50%;
        }
    </style>
</head>
<body>

<div style="height: 500px; width: 800px;">

    <div id="content">
        <textarea id="msgArea" style="width: 100%; height: 100%;"></textarea>
    </div>
    <div id="userList"></div>
    <div id="sendMessage">
        <span>内容 : </span><input type="text" id="msg" name="msg"/>
        <input type="button" onclick="sendMsg()" value="发送"/>
        <br/>
        <span>标识 : </span><input type="text" id="name" name="name">
        <input type="button" onclick="onOpen()" value="建立连接">
        <input type="button" onclick="closeSocket()" value="关闭连接"/>
    </div>

</div>



<script type="text/javascript">
    var ws ;//websocket对象

    $(function(){

    }) ;

    function closeSocket() {
        if(ws != undefined){
            //关闭连接
            ws.close() ;
        }else{
            alert("webSocket 未打开") ;
        }
    }

    //建立websocket连接通道
    function onOpen() {
        if("WebSocket" in window){
            //判断表示不为空
            var $name = $("#name").val() ;
            if($name == undefined || $name == ''){
                alert("标识不能为空") ;
                return false ;
            }
            //判断是否已建立连接
            if(ws != undefined) {alert("连接已建立") ; return false ;}

            // 初始化一个 WebSocket 对象
            ws = new WebSocket("ws://localhost:8080/socket?ws-name="+$name);

            // 建立 web socket 连接成功触发事件
            ws.onopen = function () {
                //ws.send("建立连接");
            };


            // 接收服务端数据时触发事件
            ws.onmessage = function (evt) {
                var $received_msg = $.parseJSON(evt.data);
                //填入消息
                console.log($received_msg) ;
                $("#msgArea").val($("#msgArea").val()+"\n"+HandleMessage($received_msg)) ;
                //填入用户列表
                if($received_msg.wsSessions != undefined){
                    $("#userList").html(HandleUserList($received_msg)) ;
                }
            };


            //连接失败，发送、接收数据失败或者处理数据出现错误，browser会触发onerror消息;
            ws.onerror = function(evt){
                alert("error") ;
                console.log(evt) ;
            }


            // 断开 web socket 连接成功触发事件
            ws.onclose = function () {
                alert("连接已关闭...");
            };

        }else{
            alert("您的浏览器不支持 WebSocket!") ;
        }
    }

    /**
     * 处理回调数据显示
     * @param message
     * @constructor
     */
    function HandleMessage(message) {
        var result = message.from + "-" + new Date(message.date).pattern("yyyy-MM-dd hh:mm:ss") + " : " + message.content;
        return result ;
    }

    /**
     * 处理用户列表
     * @param message
     * @returns {string}
     * @constructor
     */
    function HandleUserList(message){
        var result = "" ;

        //处理之前选中的数据

        for(var i = 0; i < message.wsSessions.length; i++){
            result = result + "<label><input name='userdata' type='checkbox' value='"+message.wsSessions[i].id+"'/>"+message.wsSessions[i].name+"</label><br/>" ;
        }

        return result ;
    }

    /**
     * 发送消息
     */
    function sendMsg(){
        if (ws != undefined){

            var $msg = $("#msg").val() ;
            var to = "";

            var userlist = $("input[name='userdata']:checked") ;

            for(var i = 0; i < userlist.length; i++){
                to = to + userlist[i].value + "," ;
            }
            if(to.length >0){
                to = to.substring(0, to.length-1) ;
            }

            var param = {
                context : $msg,
                to : to
            };

            console.log(JSON.stringify(param)) ;

            //ws.send($msg) ;
        }else{
            alert("webSocket 未连接") ;
        }
    }


</script>
</body>
</html>
