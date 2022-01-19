package demo03_annotation.annotationAnalysis;

import java.lang.reflect.Method;

@MyAnnotation(name = "张三",age = 20)
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {

        Class<Test> tc = Test.class;
        MyAnnotation at = tc.getAnnotation(MyAnnotation.class);
        String name = at.name();
        int age = at.age();

        System.out.println(name+":"+age);

        System.out.println("-------------------------------------------------");

        Method show1 = tc.getDeclaredMethod("show1");
        MyAnnotation mt = show1.getAnnotation(MyAnnotation.class);
        System.out.println(mt.age());
        System.out.println(mt.name());

        System.out.println("---------------------------------------");

        Method show2 = tc.getDeclaredMethod("show2");
        System.out.println(show1.isAnnotationPresent(MyAnnotation.class));
        System.out.println(show2.isAnnotationPresent(MyAnnotation.class));


    }

    @MyAnnotation(name = "李四",age = 40)
    public void show1(){
        System.out.println("show1");
    }

    public void show2(){
        System.out.println("show2");
    }


}
