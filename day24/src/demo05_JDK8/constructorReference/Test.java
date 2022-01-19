package demo05_JDK8.constructorReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3");


//        list.stream().map(s -> new Person(s)).forEach(s -> System.out.println(s));

        list.stream().map(Person::new).forEach(s -> System.out.println(s));
    }
}
