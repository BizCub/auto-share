//? forge {
/*package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.config.ConfigHelperClient;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class ForgeClient {

    public static void init() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((minecraft, parent) -> ConfigHelperClient.getScreen(parent)));
    }
}*///?}
