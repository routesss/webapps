package com.sola.utils.sort;

/**
 * 排序相关
 */
import java.util.Arrays;

public class SortUtil {

    /**
     * 选择排序
     * @param buffer
     */
    public static void selectionSorting(int buffer[]){
        int minIndex = 0 ;
        for(int i = 0; i < buffer.length; i++){
            minIndex = i ;
            for(int index = i; index < buffer.length; index++){
                if(buffer[minIndex] > buffer[index]){
                    minIndex = index ;
                }
            }
            if (i != minIndex){
                buffer[i] = buffer[i] + buffer[minIndex] ;
                buffer[minIndex] = buffer[i] - buffer[minIndex] ;
                buffer[i] = buffer[i] - buffer[minIndex] ;
            }
        }
    }

}
