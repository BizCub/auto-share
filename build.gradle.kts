plugins {
    id("io.github.bizcub.multiloader")
}

multiloader {
    sc.replacements {
        string(scp >= "1.21.11" && !isForge, "auto_config") {
            replace("AutoConfig", "AutoConfigClient")
        }
        string(scp >= "1.20.3") {
            replace("ClientboundResourcePackPacket", "ClientboundResourcePackPushPacket")
        }
    }

    setMREnvironment(mrEnvs.serverOnly)
    setCFEnvironment(cfEnvs.server)

    versionRange(version = "26.1.2", to = "latest")
    versionRange(version = "1.21.1", to = "1.21.11")
    versionRange(version = "1.21.1", from = "1.20.5", loader = "fabric")
    versionRange(version = "1.21.1", from = "1.20.6", loader = "forge")

    if (!isForge) addDependency(
        dependency = "maven.modrinth:rrls:${getDep("rrls")}"
    )
    addDependency(
        dependency = "maven.modrinth:simple-config-lib:${getDep("simple-config-lib")}",
        isPublishDepEnabled = true
    )
    val isClothConfigAvailable = !(isForge && scp > "1.21.3")
    addDependency(
        dependency = "me.shedaniel.cloth:cloth-config-${mod.loader}:${getDep("cloth-config").split("+").first()}",
        configuration = if (isClothConfigAvailable) "implementation" else "compileOnly",
        repository = "maven.shedaniel.me",
        isPublishDepEnabled = isClothConfigAvailable,
        publishProjectId = "cloth-config"
    )

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
        addDependency(
            dependency = "net.fabricmc.fabric-api:fabric-api:${getDep("fabric-api")}"
        )
        addDependency(
            dependency = "com.terraformersmc:modmenu:${getDep("modmenu")}",
            repository = "maven.terraformersmc.com/releases",
            excludedModules = listOf("eu.pb4"),
            isPublishDepEnabled = true
        )
    }
}
