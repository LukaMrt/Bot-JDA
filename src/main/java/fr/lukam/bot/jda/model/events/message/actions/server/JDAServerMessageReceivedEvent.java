package fr.lukam.bot.jda.model.events.message.actions.server;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.message.actions.server.ServerMessageReceivedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.message.JDAMessage;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class JDAServerMessageReceivedEvent implements ServerMessageReceivedEvent {

    private final GuildMessageReceivedEvent event;

    public JDAServerMessageReceivedEvent(GuildMessageReceivedEvent event) {
        this.event = event;
    }

    @Override
    public Message getMessage() {
        return new JDAMessage(event.getMessage());
    }

    @Override
    public TextChannel getTextChannel() {
        return new JDATextChannel(event.getChannel());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
