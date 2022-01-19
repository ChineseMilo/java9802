package demo02_reflection.classLoader;

public class Test {
    public static void main(String[] args) {
        ClassLoader c1 = Test.class.getClassLoader();
        System.out.println(c1);

        ClassLoader c2 = Student.class.getClassLoader();
        System.out.println(c2);

        ClassLoader c3 = String.class.getClassLoader();
        System.out.println(c3);

        System.out.println(c1.getParent());
        System.out.println(c2.getParent());


    }
}
