package fr.lukam.bot.jda.model.events.message.actions.server;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.message.actions.server.ServerMessageDeletedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;

public class JDAServerMessageDeletedEvent implements ServerMessageDeletedEvent {

    private final GuildMessageDeleteEvent event;

    public JDAServerMessageDeletedEvent(GuildMessageDeleteEvent event) {
        this.event = event;
    }

    @Override
    public TextChannel getTextChannel() {
        return new JDATextChannel(event.getChannel());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

    @Override
    public String getMessageId() {
        return event.getMessageId();
    }

}
