dependencies {
    implementation("com.zaxxer:HikariCP:7.0.2")
    api("com.j256.ormlite:ormlite-jdbc:6.1")

    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.1.0-beta.1")
    implementation("com.google.inject:guice:7.0.0")

    runtimeOnly("com.h2database:h2:2.4.240")
    runtimeOnly("com.mysql:mysql-connector-j:9.5.0")
    runtimeOnly("org.postgresql:postgresql:42.7.8")
    runtimeOnly("org.xerial:sqlite-jdbc:3.51.1.0")

    testImplementation(kotlin("test"))
}