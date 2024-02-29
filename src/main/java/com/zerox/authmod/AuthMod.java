package com.zerox.authmod;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.LiteralText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.*;
import com.zerox.authmod.command.LoginCommand;

public class AuthMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("AuthMod");

	@Override
	public void onInitialize() {
		LOGGER.info("Thank you for using AuthMod");
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> LoginCommand.register(dispatcher);
				/*
				dispatcher.register(literal("foo")
				.executes(context -> {
					// 对于 1.19 之前的版本，把“Text.literal”替换为“new LiteralText”。
					// 对于 1.20 之前的版本，请移除“() ->”。
					context.getSource().sendFeedback(new LiteralText("调用 /foo，不带参数"), false);

					return 1;
				})));
				 */
	}
}