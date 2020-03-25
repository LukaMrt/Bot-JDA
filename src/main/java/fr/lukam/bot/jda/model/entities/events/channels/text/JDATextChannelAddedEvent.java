package fr.lukam.bot.jda.model.entities.events.channels.text;

import fr.lukam.bot.api.entities.interfaces.channels.ServerTextChannel;
import fr.lukam.bot.api.events.channel.text.TextChannelAddedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerTextChannel;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;

public class JDATextChannelAddedEvent implements TextChannelAddedEvent {

    private final TextChannelCreateEvent event;

    public JDATextChannelAddedEvent(TextChannelCreateEvent event) {
        this.event = event;
    }

    @Override
    public ServerTextChannel getChannel() {
        return new JDAServerTextChannel(event.getChannel());
    }

}
