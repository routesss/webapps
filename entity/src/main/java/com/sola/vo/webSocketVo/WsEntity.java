package com.sola.vo.webSocketVo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String context ;

    private String from ;

    private String to ;

    private Date date ;

    private List<wsSession> wsSessions ;

    public void addSession(Integer sessionId, String name){
        this.wsSessions.add(new wsSession(sessionId, name)) ;
    }

    public List<wsSession> getWsSessions() {
        return wsSessions;
    }

    public void setWsSessions(List<wsSession> wsSessions) {
        this.wsSessions = wsSessions;
    }

    public WsEntity() {
        this.date = new Date() ;
        this.wsSessions = new LinkedList<wsSession>() ;
    }

    public void  setDateNow(){
        this.date = new Date() ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toJson(){
        return JSON.toJSONString(this) ;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

class wsSession{
    private Integer id ;
    private String name ;

    public wsSession(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
