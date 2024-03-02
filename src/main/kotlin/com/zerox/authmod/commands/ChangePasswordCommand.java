package com.zerox.authmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class ChangePasswordCommand {
    public static final Logger test = LoggerFactory.getLogger("AuthMod_test");
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("login")
                .then(argument("old_password", greedyString())
                        .then(argument("new_password", greedyString()))
                        .executes(ctx -> change_password(ctx.getSource(), getString(ctx, "old_password"), getString(ctx, "new_password")))));
    }
    private static int change_password(ServerCommandSource source, String old_password, String new_password) {
        return Command.SINGLE_SUCCESS;
    }
}
