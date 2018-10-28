package com.sola.utils.resultUtil;

import java.util.Map;

/**
 * Created by sola on 2018/10/28.
 */
public class Result {

    private Integer state ; //状态
    private String  msg ; //消息
    private Map<Object, Object> data ;//数据

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}
