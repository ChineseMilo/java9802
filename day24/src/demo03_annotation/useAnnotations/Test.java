package demo03_annotation.useAnnotations;

public class Test {
    @MyAnnotation1
    @MyAnnotation2(name = "张三",age = 20,arr = {"1","2","3"})
    public static void main(String[] args) {
        @MyAnnotation1
        @MyAnnotation2(name = "张三",age = 20,arr = {"1","2","3"})
        int num = 100;



    }
}
