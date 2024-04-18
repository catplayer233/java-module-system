package org.catplayer.java.module.system.application;

import org.catplayer.java.module.system.high.HighLibraryFunction;
import org.catplayer.java.module.system.transitive.high.TransitiveHighFunction;
import org.catplayer.java.module.system.transitive.low.TransitiveLowFunction;
//you can not use the low level module unless you required it at your module-info
//import org.catplayer.java.module.system.low.LowLibraryFunction;

public class ApplicationStarter {

    public static void main(String[] args) {
        HighLibraryFunction.highLevelInvoke();
//        you can not use the low level module unless you required it at your module-info
//        LowLibraryFunction.lowLevelInvoke();

        //you can use the transitive low module's class
        // even you do not require it
        TransitiveLowFunction.transitiveLowInvoke();
        TransitiveHighFunction.transitiveHighInvoke();
    }
}
