package com.zerox.authmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.*;

public class LoginCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("login")
                //.requires(source -> source.hasPermissionLevel(2)) // 只有管理员能够执行命令。命令不会对非操作员或低于 1 级权限的玩家显示在 tab-完成中，也不会让他们执行。
                .then(argument("color", ColorArgumentType.color())
                        .then(argument("message", greedyString())
                                .executes(ctx -> broadcast(ctx.getSource(), getColor(ctx, "color"), getString(ctx, "message")))))); // 你可以在这里处理参数，并处理成命令。
    }

    public static int broadcast(ServerCommandSource source, Formatting formatting, String message) {
        final Text text = Text.literal(message).formatted(formatting);

        source.getMinecraftServer().getPlayerManager().broadcastChatMessage(text, MessageType.CHAT, source.getPlayer().getUuid());
        return Command.SINGLE_SUCCESS; // 成功
    }
}
