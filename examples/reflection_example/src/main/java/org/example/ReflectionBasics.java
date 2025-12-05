package org.example;

import java.lang.reflect.Modifier;

public class ReflectionBasics {

    // Sample class to work with

    static class Person {
        private String name;
        private int age;
        public static int count = 0;

        public Person() {}

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private void privateMethod() {
            System.out.println("Private method called");
        }
    }

    public static void main(String[] args) throws Exception {
        // Different ways to get the Class Object

        // 1. Using .class syntax
        Class<Person> personClass1 = Person.class;
        System.out.println("Class 1: " + personClass1.getName());

        // 2. Using getClass() on instance
        Person person = new Person();
        Class<?> personClass2 = person.getClass();
        System.out.println("Class 2: " + personClass2.getName());

        // 3. Using Class.forName()
//        Class<?> personClass3 = Class.forName("ReflectionBasics$Person");
//        System.out.println("Class 3: " + personClass3.getName());


        // **Getting class information**

        System.out.println("Simple name: " + personClass1.getSimpleName());
        System.out.println("Package: " + personClass1.getPackage());
        System.out.println("Superclass: " + personClass1.getSuperclass());
        System.out.println("Is Interface: " + personClass1.isInterface());
        System.out.println("Modifiers: " + Modifier.toString(personClass1.getModifiers()));


    }
}
