package fr.lukam.bot.jda.model.entities.events.channels.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.events.channel.voice.VoiceChannelAddedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;

public class JDAVoiceChannelAddedEvent implements VoiceChannelAddedEvent {

    private final VoiceChannelCreateEvent event;

    public JDAVoiceChannelAddedEvent(VoiceChannelCreateEvent event) {
        this.event = event;
    }

    @Override
    public ServerVoiceChannel getChannel() {
        return new JDAServerVoiceChannel(event.getChannel());
    }

}
