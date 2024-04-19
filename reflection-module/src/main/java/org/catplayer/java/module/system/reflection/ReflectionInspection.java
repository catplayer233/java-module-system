package org.catplayer.java.module.system.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionInspection {

    /**
     * inspect class from outside module, see whether reflection module can access it
     *
     * @param className other module's class name
     */
    public static void inspectPrivateMethods(String className) {
        var classLoader = ReflectionInspection.class.getClassLoader();

        try {
            Class<?> targetClass = classLoader.loadClass(className);
            Arrays.stream(targetClass.getDeclaredMethods()).forEach(method -> {
                    System.out.println("class: " + className + ", method: " + method.getName());
                    var modifiers = method.getModifiers();
                    if (Modifier.isPrivate(modifiers) && Modifier.isStatic(modifiers)) {
                        method.setAccessible(true);
                        try {
                            method.invoke(targetClass);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
