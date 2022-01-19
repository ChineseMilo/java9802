package demo05_JDK8.objectMemberMethodReference;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"111","22","3");

        list.stream().map(s -> s.length()).forEach(System.out :: println);

        list.stream().map(String::length).forEach(System.out :: println);


    }
}
