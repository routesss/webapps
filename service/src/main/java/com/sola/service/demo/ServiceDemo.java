package com.sola.service.demo;

import com.sola.dao.demo.DemoMapper;
import com.sola.entity.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {

    @Autowired
    private DemoMapper demoMapper ;

    public String demo1(){

        return "serviceDemo demo1" ;
    }

    public String demo2(){

        Demo demo = demoMapper.selectByPrimaryKey("123");
        System.out.println(demo.getBuffer()) ;
        return "serviceDemo demo2" ;
    }

}
