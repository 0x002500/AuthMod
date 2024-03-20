package com.zerox.authmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.zerox.authmod.logic.RegisterCommandLogic;
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
                        .executes(ctx -> reg(ctx.getSource(), getString(ctx, "password")))));
    }

    private static int reg(ServerCommandSource source, String password) throws CommandSyntaxException {
        // get the command source
        String senderUUID = source.getPlayer().getUuid().toString();

        final boolean sendUserCode = RegisterCommandLogic.reqUserCode();
        return Command.SINGLE_SUCCESS; // 成功
    }
}
