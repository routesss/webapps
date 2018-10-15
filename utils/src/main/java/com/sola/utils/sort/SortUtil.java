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


    public static void fastSorting(int buffer[]){

        int datum ; //基准值
        int maxBuffer[] ;//大于基准值的数据
        int minBuffer[] ;//小于等于基准值的数据
        if(buffer.length > 1){//递归条件
            datum = buffer[0] ;
            for (int i = 0; i < buffer.length; i++){
                if(datum > buffer[i]){
                    //maxBuffer.add
                }else{

                }
            }
        }else{
            //基线条件

        }

    }



    public static void QuickSort(int[] arr)
    {
        QuickSort(arr, 0, arr.length - 1);
    }

    private static void QuickSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int middle = arr[(left + right) / 2];
            int i = left - 1;
            int j = right + 1;
            while (true)
            {
                while (arr[++i] < middle) ;

                while (arr[--j] > middle) ;

                if (i >= j)
                    break;

                Swap(arr, i, j);
            }

            QuickSort(arr, left, i - 1);
            QuickSort(arr, j + 1, right);
        }
    }

    private static void Swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }









}
