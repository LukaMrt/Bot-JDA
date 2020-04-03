package fr.lukam.bot.jda.model.events.message.actions;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.events.message.actions.PrivateMessageDeletedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;

public class JDAPrivateMessageDeletedEvent implements PrivateMessageDeletedEvent {

    private final PrivateMessageDeleteEvent event;

    public JDAPrivateMessageDeletedEvent(PrivateMessageDeleteEvent event) {
        this.event = event;
    }

    @Override
    public TextChannel getTextChannel() {
        return new JDATextChannel(event.getChannel());
    }

    @Override
    public String getMessageId() {
        return event.getMessageId();
    }

}
