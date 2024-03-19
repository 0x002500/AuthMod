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

public class RegisterCommand {public static final Logger LOGGER = LoggerFactory.getLogger("AuthMod");

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("register")
                .then(argument("password", greedyString())
                        .executes(ctx -> get_info(ctx.getSource(), getString(ctx, "password")))));
    }

    private static int get_info(ServerCommandSource source, String password) throws CommandSyntaxException {
        // get the command source
        String senderUUID = source.getPlayer().getUuid().toString();
        // verify the password
        final boolean is_player = LoginCommandLogic.verifyPassword(senderUUID, password);
        return Command.SINGLE_SUCCESS; // 成功
    }
}
