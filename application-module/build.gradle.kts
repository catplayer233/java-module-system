dependencies {
    implementation(project(":library-high-module"))
    implementation(project(":library-transitive-high-module"))
    implementation(project(":library-automatic-module"))
    implementation(project(":reflection-module"))
}


application {

    mainModule = "java.module.system.application.module"

    mainClass = "org.catplayer.java.module.system.application.ApplicationStarter"

    applicationDefaultJvmArgs = listOf(
        "--add-opens",
        "java.module.system.library.transitive.low.module/org.catplayer.java.module.system.transitive.low=java.module.system.reflection.module",
    )
}