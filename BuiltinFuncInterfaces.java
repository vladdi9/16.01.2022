package org.itstep;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFuncInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = i->i>0;
        System.out.println(isPositive.test(5));

        Predicate<Integer> isZero = i->i==0;
        System.out.println(isPositive.test(5));

        Predicate<Integer> isNegative = isPositive.or(isZero);
        System.out.println(isPositive.test(-5));

        Function<Person, String> getName = Person::getName;
        Function<String, Character> firstChar = S->S.charAt(0);
        Function<Person, Character> firstCharName = getName.andThen(firstChar);
        System.out.println(firstCharName.apply(new Person("Vlad", "Chalov")));

        Supplier <Person> supplier = Person::new;
        Person person=supplier.get();
        System.out.println(person);

        Consumer<Person> greetingPerson = p-> System.out.printf("Hello, %s!%n", p.getName());
        greetingPerson.accept(new Person("Vlad", "Chalov"));

        //Сравниватель
        Comparator<Person> comparator = (p1, p2)->p1.getName().compareTo(p2.getName());
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Alice", "Krige");
        System.out.println(comparator.compare(person1, person2));

        Optional<String> isEmpty = Optional.empty();
        if(!isEmpty.isEmpty())
        System.out.println(isEmpty.get());

        Optional<String> isNoteEmpty = Optional.of("");
        isNoteEmpty.ifPresent(s-> System.out.println(isNoteEmpty.isPresent()));
        System.out.println(isNoteEmpty.get());

        Optional <String> optionalS = Optional.ofNullable(null);
        System.out.println(optionalS.isPresent());
    }
}
