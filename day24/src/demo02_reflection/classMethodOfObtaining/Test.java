package demo02_reflection.classMethodOfObtaining;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Student stu2 = new Student();
        Class<? extends Student> c2 = stu2.getClass();

        Class<?> c3 = Class.forName("demo02_reflection.classMethodOfObtaining.Student");

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);


    }
}
