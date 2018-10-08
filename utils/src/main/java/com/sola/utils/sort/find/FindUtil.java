package com.sola.utils.sort.find;


public class FindUtil {


    public static int twoPoint(int buffer[], int num){

        int start = 0 ;//起始下标
        int end = buffer.length -1 ;//结束下标

        while (start <= end){

            int index = (start + end) / 2 ;

            if(buffer[index] == num){
                return index ;
            }else if(buffer[index] < num){
                start = index + 1;
            }else if(buffer[index] > num){
                end = index - 1 ;
            }
        }

        return -1 ;
    }

}
