package com.zerox.authmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;


public class LoginCommand {
    public static final Logger test = LoggerFactory.getLogger("AuthMod_test");
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("login")
                .then(argument("password", greedyString())
                        .executes(ctx -> verify_password(ctx.getSource(), getString(ctx, "password")))));
    }

    private static int verify_password(ServerCommandSource source, String password) throws CommandSyntaxException {
        // get the command source
        final String name = source.getName();
        test.info(name);
        return Command.SINGLE_SUCCESS; // 成功
    }
}