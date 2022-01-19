package demo02_reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception{
        Class<Student> c = Student.class;

        Method show1 = c.getMethod("show1");
        Method show2 = c.getMethod("show2", int.class);
        Method show3 = c.getDeclaredMethod("show3");
        Method show4 = c.getDeclaredMethod("show4", int.class);
        Method show5 = c.getMethod("show5", int.class);

        Method[] pubm = c.getMethods();
        Method[] prim = c.getDeclaredMethods();

        for (Method method : pubm) {
            System.out.println(method);
        }

        System.out.println("-------------------------------------------------------------------");

        for (Method method : prim) {
            System.out.println(method);
        }

        System.out.println("--------------------------------------------------------------------");

        Student stu = c.newInstance();


        show1.invoke(stu);

        show2.invoke(stu,10);

        show3.setAccessible(true);
        show3.invoke(stu);

        show4.setAccessible(true);
        show4.invoke(stu,20);

        System.out.println(show5.invoke(stu, 30));

    }
}
