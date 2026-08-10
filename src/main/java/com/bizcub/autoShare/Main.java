package com.bizcub.autoShare;

import com.bizcub.autoShare.config.*;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "auto_share";

    public static void init() {
        if (ConfigHelper.isSimpleConfigLoaded()) {
            Config.set(SimpleConfig.getInstance().get());
        } else if (ConfigHelper.isClothConfigLoaded()) {
            Config.set(ClothConfig.getInstance());
        }
    }
}
