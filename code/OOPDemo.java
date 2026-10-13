package dcst;

import java.lang.reflect.Field;

public class OOPDemo {
    public static void run(Student student) {
        System.out.println("\\n--- Reflection / RTTI ---");
        Class<?> type = student.getClass();
        System.out.println("Class name: " + type.getName());
        System.out.println("Parent class: " + type.getSuperclass().getSimpleName());
        System.out.println("Declared fields:");
        for (Field field : type.getDeclaredFields()) {
            System.out.println("  " + field.getName() + " : " + field.getType().getSimpleName());
        }

        System.out.println("\\n--- Access modifiers ---");
        System.out.println("Public institution: " + student.institution);
        System.out.println("Protected department (same package): " + student.department);
        System.out.println("Private name is accessed through getter: " + student.getName());

        System.out.println("\\n--- Generics ---");
        GenericBox<String> box = new GenericBox<>("DCST sample");
        System.out.println("GenericBox value: " + box.getValue());

        System.out.println("\\n--- Overloading ---");
        SearchService.searchStudent(2603);
        SearchService.searchStudent("Aditya Gaonkar");
    }
}
