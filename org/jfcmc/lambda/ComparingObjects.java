package org.jfcmc.lambda;

import java.util.Comparator;
import java.util.List;

public class ComparingObjects {
    public static void main(String []args) {
        List<Person> persons = Person.getPersons();

        persons.sort(Comparator.comparing(Person::getFirstName));

        System.out.println("Sorted by the first name:");
        FunctionUtil.forEach(persons, System.out::println);

        persons.sort(Comparator.comparing(Person::getLastName)
                     .thenComparing(Person::getFirstName)
                     .thenComparing(Person::getDob));

        System.out.println("\nSorted by the last name, first name, and dob:");
        FunctionUtil.forEach(persons, System.out::println); 
    }
}
