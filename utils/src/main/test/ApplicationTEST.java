import com.sola.utils.sort.find.FindUtil;
import org.junit.Test;

/**
 * 测试类
 */
public class ApplicationTEST {

    @Test
    public void demo1(){
        int num[] = new int[]{1, 3, 7, 15, 23, 45, 58, 78, 85, 95} ;

        System.out.println(FindUtil.twoPoint(num, 23));
    }

}
