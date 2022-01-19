package demo04_dynamicProxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        JinLian jl = new JinLian();
        Happy p = (Happy)Proxy.newProxyInstance(JinLian.class.getClassLoader(), JinLian.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("happy")) {

                    System.out.println("开房");
                    method.invoke(jl);
                    System.out.println("善后");

                }


                return null;
            }
        });


        p.happy();

    }
}
