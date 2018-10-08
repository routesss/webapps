package com.sola.utils.sort.find;

/**
 * 查找数据
 */
public class FindUtil {


    /**
     * 二分查找
     * @param buffer 元素集合
     * @param num 要查找的元素
     * @return 所在下标 没有返回-1
     */
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
