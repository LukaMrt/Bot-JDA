package fr.lukam.bot.jda.model.events.message.actions.server;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.message.actions.server.ServerMessageUpdatedEvent;
import fr.lukam.bot.jda.adapters.MessageAdapter;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;

public class JDAServerMessageUpdatedEvent implements ServerMessageUpdatedEvent {

    private final GuildMessageUpdateEvent event;

    public JDAServerMessageUpdatedEvent(GuildMessageUpdateEvent event) {
        this.event = event;
    }

    @Override
    public Message getMessage() {
        return MessageAdapter.fromJDAMessage(event.getMessage());
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
