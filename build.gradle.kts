plugins {
    id("java")
}

group = "fr.sandro642.github"
version = "1.0.0"

repositories {
    mavenCentral()

    // Add repo spigot
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    /*
     As Spigot-API depends on the BungeeCord ChatComponent-API,
    we need to add the Sonatype OSS repository, as Gradle,
    in comparison to maven, doesn't want to understand the ~/.m2
    directory unless added using mavenLocal(). Maven usually just gets
    it from there, as most people have run the BuildTools at least once.
    This is therefore not needed if you're using the full Spigot/CraftBukkit,
    or if you're using the Bukkit API.
    */
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Add api github
    implementation("org.kohsuke:github-api:1.315")

    // Add api spigot
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT") // The Spigot API with no shadowing. Requires the OSS repo.
}

tasks.test {
    useJUnitPlatform()
}