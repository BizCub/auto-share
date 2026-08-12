//? neoforge {
/*package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.Main;
import io.github.bizcub.autoShare.config.ConfigHelper;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Main.MOD_ID)
public class NeoForge {

    public NeoForge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
            (container, parent) -> ConfigHelper.getScreen(parent));
    }
}*///?}
