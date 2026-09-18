package io.github.bizcub.autoShare;

import io.github.bizcub.autoShare.config.*;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import net.minecraft.server.MinecraftServer;

import java.util.function.Consumer;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "auto_share";

    public static MinecraftServer server;

    private static final Consumer<SimpleConfig> ON_SAVE = cfg -> {
        if (server != null) PackSender.sendAll(server);
    };

    public static void init() {
        if (ConfigHelper.isSimpleConfigLoaded()) {
            ConfigHolder<SimpleConfig> holder = SimpleConfig.getInstance();
            Config.set(holder.get());
            holder.onSave(ON_SAVE);
        } else if (ConfigHelper.isClothConfigLoaded()) {
            ClothConfig.init();
            Config.set(ClothConfig.getInstance());
        }
    }

    public static void reload() {
        if (ConfigHelper.isSimpleConfigLoaded()) {
            ConfigHolder<SimpleConfig> holder = SimpleConfig.getInstance();
            holder.load();
            Config.set(holder.get());
        } else if (ConfigHelper.isClothConfigLoaded()) {
            Config.set(ClothConfig.getInstance());
        }
    }
}
