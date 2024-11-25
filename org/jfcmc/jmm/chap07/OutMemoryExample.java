package org.jfcmc.jmm.chap07;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    Person(String aName) {
        name = aName;
    }
}

public class OutMemoryExample {
    public static void main(String...args) {
        List<Person> list = new ArrayList<>();
        while (true) {
            Person p = new Person("John");
            list.add(p);
        }
    }
}
