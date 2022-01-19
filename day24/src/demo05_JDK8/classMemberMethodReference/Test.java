package demo05_JDK8.classMemberMethodReference;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3");

        list.stream().forEach(s -> System.out.println(s));

        list.stream().forEach(System.out::println);
    }
}
