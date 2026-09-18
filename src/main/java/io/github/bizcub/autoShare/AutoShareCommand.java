package io.github.bizcub.autoShare;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.permissions.Permissions;

public class AutoShareCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("autoshare")
                .requires(src -> src.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER))
                .then(Commands.literal("reload").executes(ctx -> {
                    Main.reload();
                    PackSender.sendAll(ctx.getSource().getServer());
                    ctx.getSource().sendSuccess(() -> Component.literal("Auto Share reloaded"), true);
                    return 1;
                })));
    }
}
