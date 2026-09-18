//? forge {
/*package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.Main;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Main.MOD_ID)
@EventBusSubscriber(modid = Main.MOD_ID)
public class Forge {

    public Forge() {
        Main.init();

        if (FMLEnvironment.dist.isClient()) {
            ForgeClient.init();
        }
    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        Main.server = event.getServer();
    }
}*///?}
