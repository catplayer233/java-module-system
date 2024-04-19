package org.catplayer.java.module.system.application;

import org.catplayer.java.module.system.automatic.StdHttpClient;
import org.catplayer.java.module.system.high.HighLibraryFunction;
import org.catplayer.java.module.system.reflection.ReflectionInspection;
import org.catplayer.java.module.system.transitive.high.TransitiveHighFunction;
import org.catplayer.java.module.system.transitive.low.TransitiveLowFunction;

import java.io.IOException;
//you can not use the low level module unless you required it at your module-info
//import org.catplayer.java.module.system.low.LowLibraryFunction;

public class ApplicationStarter {

    public static void main(String[] args) {
        reflectionModuleDemo();

    }

    private static void normalModuleDemo() {
        HighLibraryFunction.highLevelInvoke();
        //you can not use the low level module unless you required it at your module-info
        //LowLibraryFunction.lowLevelInvoke();
    }

    private static void transitiveModuleDemo() {
        //you can use the transitive low module's class
        // even you do not require it
        TransitiveLowFunction.transitiveLowInvoke();
        TransitiveHighFunction.transitiveHighInvoke();
    }

    private static void automaticModuleDemo() {
        //StdHttpClient is required java.net.http module, but it's an automatic module
        //we must specify on our module
        try {
            StdHttpClient.googleIndex();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reflectionModuleDemo() {
        // TransitiveLowFunction is on transitive low module
        // it's module is not opened for reflection module
        // so this is failed unless open it to reflection module
        // add jvm options:
        // --add-opens
        // java.module.system.library.transitive.low.module/org.catplayer.java.module.system.transitive.low=java.module.system.reflection.module
        // before you start the application
        ReflectionInspection.inspectPrivateMethods("org.catplayer.java.module.system.transitive.low.TransitiveLowFunction");


        // TransitiveHighFunction is on high module
        // we opened org.catplayer.java.module.system.transitive.high package for reflection module
        // at high module's module-info.java file, so you can run it without any jvm options
        ReflectionInspection.inspectPrivateMethods("org.catplayer.java.module.system.transitive.high.TransitiveHighFunction");


    }

}
