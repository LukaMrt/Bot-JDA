package fr.lukam.bot.jda.fake;

import fr.lukam.bot.jda.main.CommandListener;
import fr.lukam.deltibot.core.domain.infos.InfosRepository;
import fr.lukam.deltibot.core.domain.infos.InfosSaver;
import fr.lukam.deltibot.core.domain.infos.SaveInfos;
import fr.lukam.deltibot.core.domain.plugins.*;
import fr.lukam.deltibot.core.domain.plugins.model.Listener;
import fr.lukam.deltibot.core.infrastructure.plugins.adapters.ListenerAdapter;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.JarsPluginsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleCommandsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleListenersRepository;
import fr.lukam.deltibot.core.main.ObjectsProvider;

public class TestProvider implements ObjectsProvider {

    public static final CommandsRepository SIMPLE_COMMANDS_REPOSITORY = new SimpleCommandsRepository();
    public static final ListenersRepository SIMPLE_LISTENERS_REPOSITORY = new SimpleListenersRepository();
    public static final PluginsRepository PLUGINS_REPOSITORY = new JarsPluginsRepository();
    public static final ManagePlugins PLUGINS_ACTIONS = new PluginsActions(PLUGINS_REPOSITORY);
    public static final InfosRepository INFOS_REPOSITORY = new FakeInfosRepository();
    public static final SaveInfos INFOS_SAVER = new InfosSaver(INFOS_REPOSITORY);
    public static final fr.lukam.bot.api.entities.interfaces.events.Listener LISTENER = new CommandListener();
    public static final Listener LISTENER_ADAPTER = new ListenerAdapter(LISTENER);

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
        return LISTENER_ADAPTER;
    }

}
