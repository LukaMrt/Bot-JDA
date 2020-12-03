package fr.lukam.bot.jda.main;

import fr.lukam.bot.jda.adapters.JDAChannelTypeAdapter;
import fr.lukam.bot.jda.adapters.JDAPermissionsAdapter;
import fr.lukam.bot.jda.adapters.JDAStatusAdapter;
import fr.lukam.bot.jda.main.configuration.Configuration;
import fr.lukam.bot.jda.main.configuration.ConfigurationLoaderUtils;
import fr.lukam.bot.jda.model.bot.JDABot;
import fr.lukam.bot.jda.model.entities.message.JDAEmbedBuilder;
import fr.lukam.bot.jda.model.entities.message.JDAFieldBuilder;
import fr.lukam.bot.jda.model.entities.message.JDAMessageBuilder;
import fr.lukam.bot.api.bot.API;
import fr.lukam.deltibot.core.domain.bot.BotInfos;
import fr.lukam.deltibot.core.main.Main;
import fr.lukam.deltibot.core.main.ObjectsProvider;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class JDAMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDAMain.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static ObjectsProvider PROVIDER;
    private static final Configuration CONFIGURATION = ConfigurationLoaderUtils.loadFrom("configuration.toml");

    private static JDA jda;
    private static Main main;

    public static void main(String[] args) {

        PROVIDER = new JDAProvider();
        main = new Main(PROVIDER);

        setUpAPI();

        if (!buildJDA(new DeltiBotJDAListener(API.getListenersRepository()))) {
            return;
        }

        main.start(new BotInfos(CONFIGURATION.prefix,
                CONFIGURATION.ownerId,
                CONFIGURATION.coOwnerIds,
                CONFIGURATION.mainServerId));

        startBotLoop(args);
    }

    private static boolean buildJDA(DeltiBotJDAListener listener) {

        jda = JDABuilderUtils.buildJDA(CONFIGURATION.token, CONFIGURATION.prefix, listener);

        if (jda == null) {

            LOGGER.error("Error while launching DeltiBot");
            return false;
        }

        LOGGER.info("DeltiBot started successfully");
        return true;
    }

    private static void setUpAPI() {
        API.setBot(new JDABot(jda));
        API.setEmbedBuilder(new JDAEmbedBuilder());
        API.setMessageBuilder(new JDAMessageBuilder());
        API.setFieldBuilder(new JDAFieldBuilder());
        API.setCommandsRepository(PROVIDER.getCommandsRepository());
        API.setListenersRepository(PROVIDER.getListenersRepository());
        API.setInfosRepository(PROVIDER.getInfosRepository());
        API.setPluginsRepository(PROVIDER.getPluginsRepository());
        API.setPermissionAdapter(new JDAPermissionsAdapter());
        API.setStatusAdapter(new JDAStatusAdapter());
        API.setChannelTypeAdapter(new JDAChannelTypeAdapter());
    }

    private static void startBotLoop(String[] args) {

        String nextLine;

        do {
            nextLine = SCANNER.nextLine();
            LOGGER.info("Write \"stop\" to stop DeltiBot or \"reload\" to reload DeltiBot");
        } while (!isValidEntry(nextLine));

        main.stop();
        jda.shutdown();
        LOGGER.info("DeltiBot is stopped");

        if (nextLine.equalsIgnoreCase("stop")) {
            System.exit(0);
            return;
        }

        JDAMain.main(args);
    }

    private static boolean isValidEntry(String nextLine) {
        return nextLine.equalsIgnoreCase("stop") || nextLine.equalsIgnoreCase("reload");
    }

}
