package fr.lukam.bot.jda.model.events.channels.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.events.channel.voice.VoiceChannelRemovedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;

public class JDAVoiceChannelRemovedEvent implements VoiceChannelRemovedEvent {

    private final VoiceChannelDeleteEvent event;

    public JDAVoiceChannelRemovedEvent(VoiceChannelDeleteEvent event) {
        this.event = event;
    }

    @Override
    public ServerVoiceChannel getChannel() {
        return new JDAServerVoiceChannel(event.getChannel());
    }

}
