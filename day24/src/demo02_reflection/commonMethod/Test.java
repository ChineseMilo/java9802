package demo02_reflection.commonMethod;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Student> c = Student.class;

        System.out.println(c.getSimpleName());

        System.out.println(c.getName());

        Student stu = (Student) c.newInstance();

        System.out.println(stu.c);
    }
}
