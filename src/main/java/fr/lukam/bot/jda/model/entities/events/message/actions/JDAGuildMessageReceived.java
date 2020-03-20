package fr.lukam.bot.jda.model.entities.events.message.actions;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.events.message.actions.MessageReceivedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.message.JDAMessage;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class JDAGuildMessageReceived implements MessageReceivedEvent {

    private final GuildMessageReceivedEvent event;

    public JDAGuildMessageReceived(GuildMessageReceivedEvent event) {
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

}
