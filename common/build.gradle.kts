dependencies {
    implementation("com.zaxxer:HikariCP:7.0.2")
    api("com.j256.ormlite:ormlite-jdbc:6.1")

    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.1.0-beta.1")
    implementation("com.google.inject:guice:7.0.0")

    implementation("com.h2database:h2:2.4.240")
    implementation("com.mysql:mysql-connector-j:9.6.0")
    implementation("org.postgresql:postgresql:42.7.8")
    implementation("org.xerial:sqlite-jdbc:3.51.1.0")

    testImplementation(kotlin("test"))
}