dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")

    implementation(project(":common"))
    implementation("com.google.inject:guice:7.0.0")

    implementation("dev.rollczi:litecommands-bukkit:3.10.9")

    implementation("com.eternalcode:multification-paper:1.2.4")

    testImplementation(kotlin("test"))
}