package io.github.bizcub.autoShare;

import io.github.bizcub.autoShare.config.Config;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
/*? >=1.20.2*/ import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
/*? >=1.20.3*/ import net.minecraft.network.protocol.common.ClientboundResourcePackPopPacket;
import net.minecraft.network.chat.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class PackSender {

    private static final Set<UUID> lastSent = new HashSet<>();

    private static UUID idOf(String link) {
        return UUID.nameUUIDFromBytes(link.getBytes(StandardCharsets.UTF_8));
    }

    private static Map<UUID, String> enabledLinks() {
        Map<UUID, String> map = new LinkedHashMap<>();
        Config.get().linkProfiles().forEach(profile -> {
            if (profile.isEnabled) {
                profile.links.forEach(link -> map.put(idOf(link), link));
            }
        });
        return map;
    }

    public static void sendAll(MinecraftServer server) {
        Map<UUID, String> enabled = enabledLinks();

        Set<UUID> toRemove = new HashSet<>(lastSent);
        toRemove.removeAll(enabled.keySet());

        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            for (UUID id : toRemove) {
                popPack(player, id);
            }
            pushEnabled(player, enabled);
        }

        lastSent.clear();
        lastSent.addAll(enabled.keySet());
    }

    public static void send(ServerPlayer player) {
        pushEnabled(player, enabledLinks());
    }

    private static void pushEnabled(ServerPlayer player, Map<UUID, String> enabled) {
        boolean required = Config.get().arePacksRequired();
        enabled.forEach((id, link) -> {
            String hash = PackHashCache.get(link);
            if (hash.isEmpty()) {
                MinecraftServer server = player.level().getServer();
                PackHashCache.computeAsync(link, () -> {
                    if (server != null) {
                        server.execute(() -> {
                            ServerPlayer p = server.getPlayerList().getPlayer(player.getUUID());
                            if (p != null) {
                                sendPack(p, id, link, required);
                            }
                        });
                    }
                });
                return;
            }
            sendPack(player, id, link, required);
        });
    }

    private static void sendPack(ServerPlayer player, UUID id, String link, boolean required) {
        String hash = PackHashCache.get(link);
        //? >=1.20.2 {
        //~ if >=1.20.5 'Component.empty()' -> 'Optional.empty()' {
        player.connection.send(new ClientboundResourcePackPushPacket(/*? >=1.20.3 >>+ ','*/ id, link, hash, required, Optional.empty()));//~}
        //?} else
        //player.sendTexturePack(link, hash, required, Component.empty());
    }

    private static void popPack(ServerPlayer player, UUID id) {
        //? >=1.20.3
        player.connection.send(new ClientboundResourcePackPopPacket(Optional.of(id)));
    }
}
