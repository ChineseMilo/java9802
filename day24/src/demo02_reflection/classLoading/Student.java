package demo02_reflection.classLoading;

public class Student {
    static int c = 10;
    static {
        System.out.println("静态代码块");
    }

    public static void method(){
        System.out.println("静态方法");
    }


}
