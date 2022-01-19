package demo05_JDK8.methodReference;

public class Test {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("线程");
        }).start();

        new Thread(Test :: show).start();


    }

    public static void show(){
        System.out.println("线程");
    }

}
