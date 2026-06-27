package com.bizcub.autoShare;

import com.bizcub.autoShare.config.ModConfig;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "auto_share";

    public static void init() {
        getConfig();
    }

    public static ModConfig getConfig() {
        return ModConfig.CONFIG;
    }
}
