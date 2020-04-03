package fr.lukam.bot.jda.fake;

import fr.lukam.bot.jda.main.CommandListener;
import fr.lukam.deltibot.core.domain.infos.InfosRepository;
import fr.lukam.deltibot.core.domain.infos.InfosSaver;
import fr.lukam.deltibot.core.domain.infos.SaveInfos;
import fr.lukam.deltibot.core.domain.plugins.CommandsRepository;
import fr.lukam.deltibot.core.domain.plugins.ListenersRepository;
import fr.lukam.deltibot.core.domain.plugins.PluginsRepository;
import fr.lukam.deltibot.core.domain.plugins.ManagePlugins;
import fr.lukam.deltibot.core.domain.plugins.PluginsActions;
import fr.lukam.deltibot.core.domain.plugins.model.Listener;
import fr.lukam.deltibot.core.infrastructure.plugins.adapters.ListenerAdapter;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.JarsPluginsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleCommandsRepository;
import fr.lukam.deltibot.core.infrastructure.plugins.repositories.SimpleListenersRepository;
import fr.lukam.deltibot.core.main.ObjectsProvider;

public class TestProvider implements ObjectsProvider {

    public final CommandsRepository SIMPLE_COMMANDS_REPOSITORY = new SimpleCommandsRepository();
    public final ListenersRepository SIMPLE_LISTENERS_REPOSITORY = new SimpleListenersRepository();
    public final PluginsRepository PLUGINS_REPOSITORY = new JarsPluginsRepository();
    public final ManagePlugins PLUGINS_ACTIONS = new PluginsActions(PLUGINS_REPOSITORY);
    public final InfosRepository INFOS_REPOSITORY = new FakeInfosRepository();
    public final SaveInfos INFOS_SAVER = new InfosSaver(INFOS_REPOSITORY);
    public final fr.lukam.bot.api.entities.interfaces.events.Listener LISTENER = new CommandListener((fr.lukam.bot.api.repositories.CommandsRepository) SIMPLE_COMMANDS_REPOSITORY, (fr.lukam.bot.api.repositories.InfosRepository) INFOS_REPOSITORY);
    public final Listener LISTENER_ADAPTER = new ListenerAdapter(LISTENER);

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

    @Override
    public PluginsRepository getPluginsRepository() {
        return PLUGINS_REPOSITORY;
    }

}
