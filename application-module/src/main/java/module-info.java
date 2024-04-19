module java.module.system.application.module {
    requires java.module.system.library.high.module;

    requires java.module.system.library.transitive.high.module;
    requires java.module.system.library.automatic.module;
    requires java.net.http;

    requires java.module.system.reflection.module;
}