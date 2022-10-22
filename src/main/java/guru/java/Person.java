package guru.java;

public class Person {
    int age;
    String name;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void goToPension() {
        if (age > 65) {
            System.out.println("I am pension");
        } else {
            System.out.println("I am young!!!");
        }
    }
}
