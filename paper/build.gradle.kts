dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")

    implementation(project(":common"))
    implementation("com.google.inject:guice:7.0.0")

    testImplementation(kotlin("test"))
}