package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.bot.API;
import fr.lukam.bot.api.entities.fakes.server.FakeServer;
import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.commands.Command;
import fr.lukam.bot.api.entities.interfaces.events.Listener;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.message.actions.PrivateMessageReceivedEvent;
import fr.lukam.bot.api.events.message.actions.server.ServerMessageReceivedEvent;
import fr.lukam.bot.api.repositories.CommandsRepository;
import fr.lukam.bot.api.repositories.InfosRepository;

import java.util.Arrays;

public class CommandListener extends Listener implements fr.lukam.deltibot.core.domain.plugins.model.Listener {

    private final CommandsRepository commandsRepository;
    private InfosRepository infosRepository;

    public CommandListener(CommandsRepository commandsRepository, InfosRepository infosRepository) {
        this.commandsRepository = commandsRepository;
        this.infosRepository = infosRepository;
    }

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        execute(event.getMessage(), event.getTextChannel(), new FakeServer());
    }

    @Override
    public void onServerMessageReceived(ServerMessageReceivedEvent event) {
        execute(event.getMessage(), event.getTextChannel(), event.getServer());
    }

    private void execute(Message message, TextChannel channel, Server server) {

        String content = message.getContent();

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

        int a = 1;

        for (int i = 1; i < args.length; i++) {

            Command subCommand = command.getSubCommand(args[i]);

            if (!subCommand.equals(command)) {
                command = subCommand;
                ++a;
            }

        }

        JDACommandEvent event = new JDACommandEvent(infosRepository, message, channel, server, Arrays.copyOfRange(args, a, args.length));

        if (command.canExecute(event)) {
            command.execute(event);
            return;
        }

        Message errorMessage = API.createMessage().setText("Vous ne pouvez pas exécuter cette commande.").build();
        channel.sendMessage(errorMessage);
    }

}
