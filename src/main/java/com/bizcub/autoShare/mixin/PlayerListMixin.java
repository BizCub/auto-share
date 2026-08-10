package com.bizcub.autoShare.mixin;

import com.bizcub.autoShare.config.Config;
import net.minecraft.network.Connection;
/*? >=1.20.2*/ import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
/*? >=1.20.2*/ import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    private void sendPack(Connection connection, ServerPlayer player, /*? >=1.20.2 >>+ ','*/ CommonListenerCookie cookie, CallbackInfo ci) {
        Config.get().links().forEach(link -> {
            boolean required = Config.get().arePacksRequired();

            //? >=1.20.2 {
            UUID id = UUID.nameUUIDFromBytes(link.getBytes(StandardCharsets.UTF_8));
            //~ if >=1.20.5 'Component.empty()' -> 'Optional.empty()' {
            connection.send(new ClientboundResourcePackPushPacket(/*? >=1.20.3 >>+ ','*/ id, link, "", required, Optional.empty()));//~}

            //?} else {
            /*player.sendTexturePack(link, "", required, Component.empty());*///?}
        });
    }
}
