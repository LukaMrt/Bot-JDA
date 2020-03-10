package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.repositories.CommandsRepository;
import fr.lukam.bot.api.repositories.InfosRepository;
import fr.lukam.bot.api.repositories.ListenersRepository;
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

    public static final ObjectsProvider PROVIDER = new JDAProvider();
    private static final Configuration CONFIGURATION = ConfigurationLoaderUtils.loadFrom("configuration.toml");

    private static JDA jda;
    private static Main main = new Main(PROVIDER);

    public static void main(String[] args) {

        if (!buildJDA()) {
            return;
        }

        setUpAPI();

        main.start(new BotInfos(CONFIGURATION.prefix,
                CONFIGURATION.ownerId,
                CONFIGURATION.coOwnerIds,
                CONFIGURATION.mainServerId));

        startBotLoop(args);
    }

    private static boolean buildJDA() {

        jda = JDABuilder.buildJDA(CONFIGURATION.token, CONFIGURATION.prefix);

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
        API.setCommandsRepository((CommandsRepository) PROVIDER.getCommandsRepository());
        API.setListenersRepository((ListenersRepository) PROVIDER.getListenersRepository());
        API.setInfosRepository((InfosRepository) PROVIDER.getInfosRepository());
    }

    private static void startBotLoop(String[] args) {

        String nextLine;

        do {
            nextLine = SCANNER.nextLine();
            LOGGER.info("Write \"stop\" to stop DeltiBot or \"reload\" to reload DeltiBot");
        } while (!isValidEntry(nextLine));

        if (nextLine.equalsIgnoreCase("stop")) {
            main.stop();
            jda.shutdown();
            LOGGER.info("DeltiBot is stopped");
            System.exit(0);
            return;
        }

        JDAMain.main(args);
    }

    private static boolean isValidEntry(String nextLine) {
        return nextLine.equalsIgnoreCase("stop") || nextLine.equalsIgnoreCase("reload");
    }

}
