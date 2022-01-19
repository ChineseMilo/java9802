package demo01_Junit;

import org.junit.*;

public class Demo {

    @Test
    public void show(){
        System.out.println("你好1");
    }

    @Test
    public void show11(){
        System.out.println("你好2");
    }

    @Before
    public void show2(){
        System.out.println("before");
    }

    @After
    public void show3(){
        System.out.println("after");
    }

    @BeforeClass
    public static void show4(){
        System.out.println("静态before");
    }

    @AfterClass
    public static void show5(){
        System.out.println("静态after");
    }


}
