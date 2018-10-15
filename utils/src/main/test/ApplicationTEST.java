import com.sola.utils.sort.SortUtil;
import com.sola.utils.sort.find.FindUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试类
 */
public class ApplicationTEST {

    @Test
    public void demo1(){
        int num[] = new int[]{1, 3, 7, 15, 23, 45, 58, 78, 85, 95} ;

        System.out.println(FindUtil.twoPoint(num, 23));
    }

    @Test
    public void demo2(){
        int num[] = new int[]{98,55,15,69,87,25,36,84,1,65} ;

        SortUtil.selectionSorting(num);
        System.out.println(Arrays.toString(num));
    }

    @Test
    public void demo3(){

        int buffer[] = new int[]{4, 3, 7, 5, 9, 2} ;
        SortUtil.QuickSort(buffer);
        for(int item : buffer){
            System.out.println(item);
        }
    }

}
