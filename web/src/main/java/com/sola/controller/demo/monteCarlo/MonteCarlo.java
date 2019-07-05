package com.sola.controller.demo.monteCarlo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

/**
 * 蒙特卡罗
 */
public class MonteCarlo {

    private final Logger logger =LoggerFactory.getLogger(this.getClass()) ;

    /**
     *  圆比例系数
     * @param randomPointSize   随机点数量
     * @param radius            半径
     */
    public double circleAreaTEST(int randomPointSize, int radius){
        Random random = new Random(System.currentTimeMillis());
        double distance ;       //随机点到中心距离
        int inRange = 0 ;       //范围内数量
        double proportion =0.0 ;//比例

        int[] buffer = new int[randomPointSize * 2];        //存放生成的随机点值 生成的两个值顺序存储 偶数x 奇数y

        for (int index = 0; index < buffer.length; index+=2){
            buffer[index]   = random.nextInt(radius) ;  //x
            buffer[index+1] = random.nextInt(radius) ;  //y

            int x = 0, y = 0 ;
            if(buffer[index] > radius){
                x = buffer[index] - radius ;
            }else{
                x = buffer[index] ;
            }
            if(buffer[index+1] > radius){
                y = buffer[index+1] - radius ;
            }else{
                y = buffer[index+1] ;
            }

            distance = Math.sqrt(x*x+y*y) ;
            if(distance < radius){
                inRange++;
            }
        }

        proportion = inRange/(randomPointSize/4d) ;

        return proportion ;
    }

    public static void main(String[] args) {
        System.out.println(new MonteCarlo().circleAreaTEST(1000*1000, 1000));
    }
}
