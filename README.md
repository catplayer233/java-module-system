# Inspect java module system since jdk 9
Since jdk 9, java add module system, many developers like me do not understand it at first,
so I write some examples with comments for giving you a hint what the java module system is exactly do.

# Code Entry
see code `org.catplayer.java.module.system.application.ApplicationStarter` this class's static methods run all features of java module system

## Jvm Options
some features required jvm options when you run it, you can check on [build.gradle.kts](application-module%2Fbuild.gradle.kts)