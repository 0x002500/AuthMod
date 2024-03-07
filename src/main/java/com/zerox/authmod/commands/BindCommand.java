package com.zerox.authmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.zerox.authmod.logic.LoginCommandLogic;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class BindCommand {
    public static final Logger LOGGER = LoggerFactory.getLogger("AuthMod");
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("login")
                .then(argument("password", greedyString())
                        .executes(ctx -> bind_account(ctx.getSource(), getString(ctx, "password")))));
    }
    private static int bind_account(ServerCommandSource source, String password) throws CommandSyntaxException {
        // get the command source
        //final String name = source.getName();
        // verify the password
        //final boolean is_player = LoginCommandLogic.verifyPassword(name, password);
        return Command.SINGLE_SUCCESS; // 成功
    }
}
