package fr.lukam.bot.jda.model.events.message.actions;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.message.JDAMessage;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

public class JDAPrivateMessageReceivedEvent implements fr.lukam.bot.api.events.message.actions.PrivateMessageReceivedEvent {

    private PrivateMessageReceivedEvent event;

    public JDAPrivateMessageReceivedEvent(PrivateMessageReceivedEvent event) {
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
