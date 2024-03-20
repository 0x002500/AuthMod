package com.zerox.authmod;

import com.zerox.authmod.commands.ChangePasswordCommand;
import com.zerox.authmod.commands.LoginCommand;
import com.zerox.authmod.commands.RegisterCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("AuthMod");

    @Override
    public void onInitialize() {
        LOGGER.info("Thank you for using AuthMod");
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            LoginCommand.register(dispatcher);
            ChangePasswordCommand.register(dispatcher);
            RegisterCommand.register(dispatcher);
        });
    }
}