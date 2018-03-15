group = "com.potix.demo"
version = "1.0-SNAPSHOT"

apply {
    plugin("java")
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.slf4j", "slf4j-parent", "1.7.25")
    compile("org.slf4j", "slf4j-jdk14", "1.7.25")
    testCompile("org.jmockit:jmockit:1.38")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
