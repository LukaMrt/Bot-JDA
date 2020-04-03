package fr.lukam.bot.jda.model.events.channels.text;

import fr.lukam.bot.api.entities.interfaces.channels.ServerTextChannel;
import fr.lukam.bot.api.events.channel.text.TextChannelNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerTextChannel;

public class JDATextChannelNameUpdatedEvent implements TextChannelNameUpdatedEvent {

    private final net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNameEvent event;

    public JDATextChannelNameUpdatedEvent(net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNameEvent event) {
        this.event = event;
    }

    @Override
    public String getOldName() {
        return event.getOldName();
    }

    @Override
    public String getNewName() {
        return event.getNewName();
    }

    @Override
    public ServerTextChannel getChannel() {
        return new JDAServerTextChannel(event.getChannel());
    }

}
