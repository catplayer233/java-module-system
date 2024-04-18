dependencies {


}


tasks.withType<Jar> {
    manifest {
        attributes("Automatic-Module-Name" to "java.module.system.library.automatic.module")
    }
}