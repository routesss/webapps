package com.sola.controller.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sys")
public class sysController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    /**
     * 主要菜单页面
     * @return
     */
    @RequestMapping(value = "/toSys")
    public Object toSys(){

        return "sys/sys" ;
    }

}
