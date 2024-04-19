package org.catplayer.java.module.system.transitive.low;

public class TransitiveLowFunction {

    public static void transitiveLowInvoke() {
        System.out.println("transitiveLowInvoke");
    }

    private static void privateScopeInvoke() {
        System.out.println("transitiveLowPrivateInvoke");
    }
}
