package demo03_annotation.basesAnnotation;

public class Test {
    public static void main(String[] args) {
        @SuppressWarnings("all")
        int s;

    }
    @Deprecated
    public static void method1(){
        System.out.println("方法1");
    }

    public static void method2(){
        System.out.println("方法2");
    }
}
