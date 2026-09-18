//? fabric {
package io.github.bizcub.autoShare.platform;

import io.github.bizcub.autoShare.AutoShareCommand;
import io.github.bizcub.autoShare.Main;
import io.github.bizcub.autoShare.config.ConfigHelper;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class Fabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Main.init();

        ServerLifecycleEvents.SERVER_STARTING.register(s -> Main.server = s);
        ServerLifecycleEvents.SERVER_STOPPED.register(s -> Main.server = null);
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, registry, env) -> AutoShareCommand.register(dispatcher));
    }

    public static class ModMenu implements ModMenuApi {

        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return ConfigHelper::getScreen;
        }
    }
}//?}
