package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.entities.fakes.server.FakeServer;
import fr.lukam.bot.api.entities.interfaces.commands.Command;
import fr.lukam.bot.api.entities.interfaces.events.Listener;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.message.actions.MessageReceivedEvent;
import fr.lukam.bot.api.events.message.actions.server.ServerMessageReceivedEvent;
import fr.lukam.bot.api.repositories.CommandsRepository;
import fr.lukam.bot.api.repositories.InfosRepository;

public class CommandListener extends Listener implements fr.lukam.deltibot.core.domain.plugins.model.Listener {

    private final CommandsRepository commandsRepository;
    private InfosRepository infosRepository;

    public CommandListener(CommandsRepository commandsRepository, InfosRepository infosRepository) {
        this.commandsRepository = commandsRepository;
        this.infosRepository = infosRepository;
    }

    @Override
    public void onPrivateMessageReceived(MessageReceivedEvent event) {
        execute(event, new FakeServer());
    }

    @Override
    public void onServerMessageReceived(ServerMessageReceivedEvent event) {
        execute(event, event.getServer());
    }

    private void execute(MessageReceivedEvent event, Server server) {

        String content = event.getMessage().getContent();

        if (content.isEmpty()) {
            return;
        }

        if (!String.valueOf(content.charAt(0)).equals(infosRepository.getString("prefix"))) {
            return;
        }

        String[] args = content.substring(1).split(" ");

        if (args.length == 0) {
            args = new String[]{" "};
        }

        Command command = this.commandsRepository.getCommandByName(args[0]);

        for (int i = 1; i < args.length; i++) {

            Command subCommand = command.getSubCommand(args[i]);

            if (subCommand != command) {
                command = subCommand;
            }

        }

        command.execute(new JDACommandEvent(infosRepository, event.getMessage(), event.getTextChannel(), server));
    }

}
