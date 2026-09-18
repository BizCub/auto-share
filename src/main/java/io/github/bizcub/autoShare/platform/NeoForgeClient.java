//? neoforge {
/*package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.Main;
import io.github.bizcub.autoShare.config.ConfigHelperClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Main.MOD_ID, dist = Dist.CLIENT)
public class NeoForgeClient {

    public NeoForgeClient() {
        if (FMLEnvironment.getDist().isClient()) {
            ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                    (container, parent) -> ConfigHelperClient.getScreen(parent));
        }
    }
}*///?}
