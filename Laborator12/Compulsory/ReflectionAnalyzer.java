/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.lang.reflect.Method;

public class ReflectionAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Compulsory.ReflectionAnalyzer <fully-qualified-class-name>");
            return;
        }

        String className = args[0];
        try {
            Class<?> clazz = Class.forName(className);
            analyzeClass(clazz);
            invokeTestMethods(clazz);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void analyzeClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        System.out.println("Methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void invokeTestMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0 &&
                    java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                try {
                    method.invoke(null);
                    System.out.println("Invoked: " + method.getName());
                } catch (Exception e) {
                    System.err.println("Failed to invoke: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}
