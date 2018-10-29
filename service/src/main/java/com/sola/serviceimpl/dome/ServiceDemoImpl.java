package com.sola.serviceimpl.dome;

import com.sola.dao.demo.DemoMapper;
import com.sola.entity.demo.Demo;
import com.sola.service.demo.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceDemoImpl implements ServiceDemo {

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

