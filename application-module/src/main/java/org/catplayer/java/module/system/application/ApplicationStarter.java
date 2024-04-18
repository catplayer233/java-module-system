package org.catplayer.java.module.system.application;

import org.catplayer.java.module.system.automatic.StdHttpClient;
import org.catplayer.java.module.system.high.HighLibraryFunction;
import org.catplayer.java.module.system.transitive.high.TransitiveHighFunction;
import org.catplayer.java.module.system.transitive.low.TransitiveLowFunction;

import java.io.IOException;
//you can not use the low level module unless you required it at your module-info
//import org.catplayer.java.module.system.low.LowLibraryFunction;

public class ApplicationStarter {

    public static void main(String[] args) throws IOException, InterruptedException {
        HighLibraryFunction.highLevelInvoke();
        //you can not use the low level module unless you required it at your module-info
        //LowLibraryFunction.lowLevelInvoke();

        //you can use the transitive low module's class
        // even you do not require it
        TransitiveLowFunction.transitiveLowInvoke();
        TransitiveHighFunction.transitiveHighInvoke();

        //StdHttpClient is required java.net.http module, but it's an automatic module
        //we must specify on our module
        StdHttpClient.googleIndex();
    }
}
