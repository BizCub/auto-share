//? neoforge {
/*package com.bizcub.autoShare.platform;

import com.bizcub.autoShare.Main;
import com.bizcub.autoShare.config.ConfigHelper;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Main.MOD_ID)
public class NeoForge {

    public NeoForge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class, () -> (minecraft, screen) ->
                        ConfigHelper.getScreen(screen)
        );
    }
}*///?}
