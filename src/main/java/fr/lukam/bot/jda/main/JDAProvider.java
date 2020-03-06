package fr.lukam.bot.jda.main;

import fr.lukam.deltibot.core.domain.infos.InfosSaver;
import fr.lukam.deltibot.core.domain.infos.SaveInfos;
import fr.lukam.deltibot.core.domain.plugins.CommandsRepository;
import fr.lukam.deltibot.core.domain.plugins.ListenersRepository;
import fr.lukam.deltibot.core.domain.plugins.ManagePlugins;
import fr.lukam.deltibot.core.domain.plugins.PluginsActions;
import fr.lukam.deltibot.core.domain.plugins.model.Listener;
import fr.lukam.deltibot.core.infrastructure.infos.RedisInfosRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.adapters.ListenerAdapter;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.JarsPluginsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleCommandsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleListenersRepository;
import fr.lukam.deltibot.core.main.ObjectsProvider;

public class JDAProvider implements ObjectsProvider {

    public static final SimpleCommandsRepository SIMPLE_COMMANDS_REPOSITORY = new SimpleCommandsRepository();
    public static final SimpleListenersRepository SIMPLE_LISTENERS_REPOSITORY = new SimpleListenersRepository();
    public static final JarsPluginsRepository PLUGINS_REPOSITORY = new JarsPluginsRepository();
    public static final PluginsActions PLUGINS_ACTIONS = new PluginsActions(PLUGINS_REPOSITORY);
    public static final RedisInfosRepository INFOS_REPOSITORY = new RedisInfosRepository();
    public static final InfosSaver INFOS_SAVER = new InfosSaver(INFOS_REPOSITORY);
    public static final CommandListener LISTENER = new CommandListener();
    public static final ListenerAdapter LISTENER_ADAPTER = new ListenerAdapter(LISTENER);

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
        return LISTENER_ADAPTER;
    }

}
