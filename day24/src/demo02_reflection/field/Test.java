package demo02_reflection.field;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Student> s = Student.class;

        Field name = s.getField("name");
        Field age = s.getDeclaredField("age");

        Field[] pubFields = s.getFields();
        Field[] priFields = s.getDeclaredFields();

        for (Field pubField : pubFields) {
            System.out.println(pubField);
        }

        System.out.println("-------------------------------------------------");

        for (Field priField : priFields) {
            System.out.println(priField);
        }

        System.out.println("-------------------------------------------------");

        Student student = s.newInstance();

        name.set(student,"张三");

        age.setAccessible(true);
        age.setInt(student,20);

        System.out.println(name.get(student));
        System.out.println(age.getInt(student));
    }
}
