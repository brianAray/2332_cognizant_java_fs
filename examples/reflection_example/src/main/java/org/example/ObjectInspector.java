package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectInspector {

    /**
     * Inspect any object and prints its structure
     */

    public static void inspectObject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        System.out.println("Inspecting: " + clazz.getSimpleName());
        System.out.println("Full Class Name: " + clazz.getName());
        System.out.println("Package: " + clazz.getPackage().getName());
        System.out.println("Superclass: " + clazz.getSuperclass().getSimpleName());

        // Fields
        System.out.println("--- FIELDS ---");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
            String modifiers = Modifier.toString(field.getModifiers());
            System.out.printf(" %s %s %s = %s%n", modifiers, field.getType().getSimpleName(), field.getName(), field.get(obj));
        }

        // Methods
        System.out.println("--- METHODS ---");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method: methods){
            String modifiers = Modifier.toString(method.getModifiers());
            System.out.printf(" %s %s %s(", modifiers, method.getReturnType().getSimpleName(), method.getName());

            // Parameters
            Class<?>[] params = method.getParameterTypes();
            for(int i = 0; i < params.length; i++){
                System.out.print(params[i].getSimpleName());
                if(i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Constructors
        System.out.println("\n--- CONSTRUCTORS ---");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor<?> constructor: constructors){
            String modifiers = Modifier.toString(constructor.getModifiers());
            System.out.printf(" %s %s(", modifiers, clazz.getSimpleName());

            // Parameters
            Class<?>[] params = constructor.getParameterTypes();
            for(int i = 0; i < params.length; i++){
                System.out.print(params[i].getSimpleName());
                if(i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
    }

    static class Employee {
        private String name;
        private int id;
        private double salary;
        private static String company = "TechCorp";

        public Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        private void giveRaise(double percentage){
            this.salary += this.salary * percentage / 100;
        }

        @Override
        public String toString(){
            return String.format("Employee{name='%s', id=%d, salary=%.2f}", name, id, salary);
        }
    }

    public static void main(String[] args) throws Exception{

        Employee emp = new Employee("John Doe", 101, 50000.0);
        inspectObject(emp);

        // Dynamically invoke private methods
        System.out.println("\n--- INVOKING PRIVATE METHOD ---");
        Method giveRaise = emp.getClass().getDeclaredMethod("giveRaise", double.class);
        giveRaise.setAccessible(true);
        giveRaise.invoke(emp, 10.0);

        System.out.println("After raise: " + emp.getSalary());

    }
}
