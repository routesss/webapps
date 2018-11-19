import com.alibaba.fastjson.JSON;
import com.sola.utils.security.SecurityUtil;
import com.sola.utils.sort.SortUtil;
import com.sola.utils.sort.find.FindUtil;
import com.sola.utils.tree.tfTree.TfTree;
import com.sola.utils.treeAVL.TreeAVL;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //快速排序 例子
    @Test
    public void demo3(){

        int buffer[] = new int[]{4, 3, 7, 5, 9, 2} ;
        SortUtil.QuickSort(buffer);
        for(int item : buffer){
            System.out.println(item);
        }
    }

    //快速排序
    @Test
    public void  demo4(){
        int buffer[] = new int[]{6, 4, 3, 7, 5, 9, 2, 1} ;

        SortUtil.fastSort(buffer) ;

        new HashMap<>() ;
        for (int item : buffer){
            System.out.println(item);
        }
    }

    //二叉树测试
    @Test
    public void demo5(){
        int buffer[] = new int[]{5, 4, 3, 7, 9, 2, 10, 8} ;
        TfTree tree = new TfTree();
        for (int item : buffer){
            tree.insert(item);
        }
        System.out.println(tree);//json格式
        tree.infixOrder();
        System.out.println("--------------------------------");
        tree.paintTree();
        System.out.println("--------------------------------");
        tree.delete(5);
        tree.paintTree();
        tree.infixOrder();
        System.out.println("--------------------------------");
        tree.delete(7);
        tree.paintTree();
        tree.infixOrder();
    }

    //avl tree
    @Test
    public void demo6(){
        Integer buffer[] = new Integer[]{5, 4, 3, 7, 9, 2, 10, 8, -1, -5} ;
        TreeAVL<Integer> tree = new TreeAVL<>();
        for(Integer item : buffer){
            tree.insert(item) ;
        }
        tree.infixOrder();
        System.out.println();
        tree.paintTree();
    }


    //非对称加密解密
    @Test
    public void demo7(){
        try{
            //SecurityUtil.testOne();
            SecurityUtil.testTwo();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
