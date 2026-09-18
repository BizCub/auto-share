//? neoforge {
/*package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.AutoShareCommand;
import io.github.bizcub.autoShare.Main;
import io.github.bizcub.autoShare.config.ConfigHelperClient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Main.MOD_ID)
@EventBusSubscriber(modid = Main.MOD_ID)
public class NeoForge {

    public NeoForge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (container, parent) -> ConfigHelperClient.getScreen(parent));
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        AutoShareCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        Main.server = event.getServer();
    }
}*///?}
