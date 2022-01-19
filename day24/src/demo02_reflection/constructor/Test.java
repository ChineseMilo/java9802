package demo02_reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c1 = Student.class;

        Constructor<Student> stu1 = c1.getConstructor();
        Constructor<Student> stu2 = c1.getDeclaredConstructor();

        Constructor<Student> stu3 = c1.getDeclaredConstructor(String.class, int.class);

        Constructor<Student> stu4 = c1.getDeclaredConstructor(String.class);

        Constructor<?>[] s = c1.getDeclaredConstructors();

        for (Constructor<?> constructor : s) {
            System.out.println(constructor);
        }


        Student student1 = stu1.newInstance();
        System.out.println(student1);

        Student student2 = stu3.newInstance("张三", 18);
        System.out.println(student2);

        stu4.setAccessible(true);
        Student student3 = stu4.newInstance("罗翔");
        System.out.println(student3);
    }
}
