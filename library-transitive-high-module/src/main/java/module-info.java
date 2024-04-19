module java.module.system.library.transitive.high.module {

    requires transitive java.module.system.library.transitive.low.module;

    exports org.catplayer.java.module.system.transitive.high;

    //opens to all
//    opens org.catplayer.java.module.system.transitive.high;
    //opens to specific module when the target module want to use reflection feature for current module
    opens org.catplayer.java.module.system.transitive.high to java.module.system.reflection.module;


}