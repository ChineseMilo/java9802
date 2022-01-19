package demo02_reflection.classLoading;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        创建类的实例。
        Student stu = new Student();
//        类的静态变量，或者为静态变量赋值。
        System.out.println(Student.c);
//        类的静态方法。
        Student.method();
//        使用反射方式来强制创建某个类或接口对应的java.lang.Class对象。
        Class.forName("demo02_reflection.classLoading.Student");
//        初始化某个类的子类。
        Son son = new Son();
//        直接使用java.exe命令来运行某个主类。

    }



}
