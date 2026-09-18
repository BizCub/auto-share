package io.github.bizcub.autoShare.mixin;

import io.github.bizcub.autoShare.PackSender;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
/*? >=1.20.2*/ import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    private void sendPack(Connection connection, ServerPlayer player, /*? >=1.20.2 >>+ ','*/ CommonListenerCookie cookie, CallbackInfo ci) {
        PackSender.send(player);
    }
}
