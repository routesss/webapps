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


    public static void fastSort(int buffer[]){
        fastSort(buffer,0, buffer.length-1);
    }

    /**
     * 自定义版本 快速排序  先实现选中一个基准值排序两边的值，再递归调用该函数
     * @param buffer
     * @param low
     * @param hight
     */
    private static void fastSort(int buffer[], int low, int hight){

        int datum = buffer[(low + hight) / 2] ;

        int Blow = low ;//保存下限索引值 递归时需要调用
        int Bhight = hight ;//保存上限索引值 递归时需要调用

        while (low < hight){
            while (datum > buffer[low]){
                low++ ;
            }

            while (datum < buffer[hight]){
                hight-- ;
            }
            if(low >= hight){
                fastSort(buffer, Blow, low -1);
                fastSort(buffer, hight+1, Bhight);
                break ;
            }

            buffer[low] += buffer[hight] ;
            buffer[hight] = buffer[low] - buffer[hight] ;
            buffer[low] -= buffer[hight] ;

        }

    }


    /**
     * 网上例子 快速排序
     * @param arr
     */
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
