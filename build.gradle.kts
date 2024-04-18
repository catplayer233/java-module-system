version = "1.0.0"
group = "org.catplayer.java.module.system"

subprojects {
    apply(plugin = "org.gradle.java")

    when (name.split("-").first()) {
        "library" -> apply(plugin = "org.gradle.java-library")
        else -> apply(plugin = "org.gradle.application")
    }


}