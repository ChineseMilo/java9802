package demo02_reflection.method;

public class Student {
    public void show1(){
        System.out.println("公共成员方法");
    }

    public void show2(int n){
        System.out.println("有参无返回成员方法"+n);
    }

    private void show3(){
        System.out.println("私有成员方法");
    }

    private void show4(int n){
        System.out.println("私有有参无返回成员方法"+n);
    }

    public int show5(int n){
        System.out.println("有参有返回值成员方法"+n);
        return 100;
    }
}
