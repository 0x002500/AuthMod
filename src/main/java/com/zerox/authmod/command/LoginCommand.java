package com.zerox.authmod.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;


public class LoginCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("login")
                .then(argument("password", greedyString())
                        .executes(ctx -> verify_password(ctx.getSource(), getString(ctx, "password")))));
    }

    private static int verify_password(ServerCommandSource source, String password) {
        // get
        return Command.SINGLE_SUCCESS; // 成功
    }
}