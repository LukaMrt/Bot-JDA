package fr.lukam.bot.jda.model.events.message.actions;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.events.message.actions.PrivateMessageUpdatedEvent;
import fr.lukam.bot.jda.adapters.MessageAdapterUtils;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;

public class JDAPrivateMessageUpdatedEvent implements PrivateMessageUpdatedEvent {

    private final PrivateMessageUpdateEvent event;

    public JDAPrivateMessageUpdatedEvent(PrivateMessageUpdateEvent event) {
        this.event = event;
    }

    @Override
    public Message getMessage() {
        return MessageAdapterUtils.fromJDAMessage(event.getMessage());
    }

    @Override
    public TextChannel getTextChannel() {
        return new JDATextChannel(event.getChannel());
    }

}
