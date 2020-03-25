package fr.lukam.bot.jda.model.entities.events.channels.text;

import fr.lukam.bot.api.entities.interfaces.channels.ServerTextChannel;
import fr.lukam.bot.api.events.channel.text.TextChannelRemovedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerTextChannel;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;

public class JDATextChannelRemovedEvent implements TextChannelRemovedEvent {

    private final TextChannelDeleteEvent event;

    public JDATextChannelRemovedEvent(TextChannelDeleteEvent event) {
        this.event = event;
    }

    @Override
    public ServerTextChannel getChannel() {
        return new JDAServerTextChannel(event.getChannel());
    }

}
