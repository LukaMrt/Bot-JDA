package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.entities.interfaces.events.Listener;
import fr.lukam.bot.api.repositories.CommandsRepository;
import fr.lukam.bot.api.repositories.InfosRepository;
import fr.lukam.bot.api.repositories.ListenersRepository;
import fr.lukam.bot.api.repositories.PluginsRepository;
import fr.lukam.deltibot.core.domain.infos.InfosSaver;
import fr.lukam.deltibot.core.domain.infos.SaveInfos;
import fr.lukam.deltibot.core.domain.plugins.*;
import fr.lukam.deltibot.core.infrastructure.infos.RedisInfosRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.DefaultCommandsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.DefaultListenersRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.JarsPluginsRepository;
import fr.lukam.deltibot.core.main.ObjectsProvider;

public class JDAProvider implements ObjectsProvider {

    public final CommandsRepository SIMPLE_COMMANDS_REPOSITORY = new DefaultCommandsRepository();
    public final ListenersRepository SIMPLE_LISTENERS_REPOSITORY = new DefaultListenersRepository();
    public final PluginsRepository PLUGINS_REPOSITORY = new JarsPluginsRepository();
    public final ManagePlugins PLUGINS_ACTIONS = new PluginsActions(PLUGINS_REPOSITORY);
    public final InfosRepository INFOS_REPOSITORY = new RedisInfosRepository();
    public final SaveInfos INFOS_SAVER = new InfosSaver((fr.lukam.deltibot.core.domain.infos.InfosRepository) INFOS_REPOSITORY);
    public final fr.lukam.bot.api.entities.interfaces.events.Listener LISTENER = new CommandListener(SIMPLE_COMMANDS_REPOSITORY, INFOS_REPOSITORY);

    @Override
    public InfosRepository getInfosRepository() {
        return INFOS_REPOSITORY;
    }

    @Override
    public CommandsRepository getCommandsRepository() {
        return SIMPLE_COMMANDS_REPOSITORY;
    }

    @Override
    public ListenersRepository getListenersRepository() {
        return SIMPLE_LISTENERS_REPOSITORY;
    }

    @Override
    public ManagePlugins getPluginManager() {
        return PLUGINS_ACTIONS;
    }

    @Override
    public SaveInfos getInfosSaver() {
        return INFOS_SAVER;
    }

    @Override
    public Listener getCommandsListener() {
        return LISTENER;
    }

    @Override
    public PluginsRepository getPluginsRepository() {
        return this.PLUGINS_REPOSITORY;
    }

}
