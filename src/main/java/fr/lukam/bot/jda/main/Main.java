package fr.lukam.bot.jda.main;

import fr.lukam.bot.jda.main.configuration.Configuration;
import fr.lukam.bot.jda.main.configuration.ConfigurationLoaderUtils;
import fr.lukam.bot.jda.model.bot.JDABot;
import fr.lukam.bot.jda.model.entities.message.JDAEmbedBuilder;
import fr.lukam.bot.jda.model.entities.message.JDAFieldBuilder;
import fr.lukam.bot.jda.model.entities.message.JDAMessageBuilder;
import fr.lukam.bot_api.bot.API;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Configuration CONFIGURATION = ConfigurationLoaderUtils.loadFrom("configuration.toml");

    private static JDA jda;

    public static void main(String[] args) {

        if (!buildJDA()) {
            return;
        }

        setUpAPI();

        startBotLoop();
    }

    private static boolean buildJDA() {

        jda = JDABuilder.buildJDA(CONFIGURATION.token, CONFIGURATION.prefix);

        if (jda == null) {

            LOGGER.error("Error while launching DeltiBot");
            return false;
        }

        LOGGER.info("Bot connected");
        return true;
    }

    private static void setUpAPI() {
        API.setBot(new JDABot(jda));
        API.setEmbedBuilder(new JDAEmbedBuilder());
        API.setMessageBuilder(new JDAMessageBuilder());
        API.setFieldBuilder(new JDAFieldBuilder());
    }

    private static void startBotLoop() {
        while (!SCANNER.nextLine().equalsIgnoreCase("stop")) {
            LOGGER.info("\"stop\" to stop DeltiBot");
        }

        jda.shutdown();
        System.exit(0);
    }

}
