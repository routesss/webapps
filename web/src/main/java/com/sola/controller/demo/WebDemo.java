package com.sola.controller.demo;

import com.sola.service.demo.ServiceDemo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.Date;

/**
 * 测试类
 */
@Controller
@RequestMapping(value = "/webDemo")
public class WebDemo {

    private static final Logger logger =LoggerFactory.getLogger(WebDemo.class) ;

    @Autowired
    private ServiceDemo serviceDemo ;

    /**
     * 测试跳转
     * @return
     */
    @RequestMapping(value = "/demo1")
    public String demo1(){

        logger.info("demo1 日志消息 " + new Date()) ;
        logger.info("demo2 日志消息 " + new Date()) ;


        return "demo/demo1" ;
    }

    /**
     * 测试依赖注入
     * @return
     */
    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(){

        return serviceDemo.demo1() ;
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3(){

        return serviceDemo.demo2() ;
    }

    @RequestMapping("/demo4")
    @ResponseBody
    public String demo4(){

        File file = null ;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null ;

        File fileout = null ;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null ;

        try{
            file = new File("D:\\TEST\\执行结果-1.txt");
            fileReader = new FileReader(file) ;
            bufferedReader = new BufferedReader(fileReader);

            String str ;

            fileout = new File("D:\\TEST\\合并.txt") ;
            fileWriter = new FileWriter(fileout) ;
            bufferedWriter = new BufferedWriter(fileWriter) ;


            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
                bufferedWriter.write(str+",");
            }

        }catch (Exception e){
            logger.info("{}",e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e){

            }
        }
        return "demo4" ;
    }

}










