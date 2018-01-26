package com.gmail.gnoianko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        SomeClass sc = new SomeClass();
        Class<?> cls = sc.getClass();
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
                int res = (Integer) m.invoke(sc, myAnnotation.a(), myAnnotation.b());
                System.out.println(res);
            }

        }

    }
}
