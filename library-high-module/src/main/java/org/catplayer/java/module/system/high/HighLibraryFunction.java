package org.catplayer.java.module.system.high;

import org.catplayer.java.module.system.low.LowLibraryFunction;

public class HighLibraryFunction {

    public static void highLevelInvoke() {

        System.out.println("invoke high level function, we will try to invoke the low level");

        LowLibraryFunction.lowLevelInvoke();
    }
}
