import com.sola.controller.shiro.ShiroTEST;
import org.junit.Test;

/**
 * Created by sola on 2018/10/23.
 */
public class ApplicationTEST {

    /**
     * imi realm
     */
    @Test
    public void demo1(){
        ShiroTEST shiroTEST = new ShiroTEST();
        shiroTEST.demo1() ;
    }

    /**
     * 测试jdbc realm
     */
    @Test
    public void demo2(){
        ShiroTEST shiroTEST = new ShiroTEST();
        shiroTEST.demo3();
    }

    /**
     * 测试 自定义realm
     */
    @Test
    public void  demo3(){
        ShiroTEST shiroTEST = new ShiroTEST();
        shiroTEST.demo4();

    }


}
