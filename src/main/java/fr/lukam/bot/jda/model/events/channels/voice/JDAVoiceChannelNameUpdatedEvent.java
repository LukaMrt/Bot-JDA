package fr.lukam.bot.jda.model.events.channels.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.events.channel.voice.VoiceChannelNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;

public class JDAVoiceChannelNameUpdatedEvent implements VoiceChannelNameUpdatedEvent {

    private final net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateNameEvent event;

    public JDAVoiceChannelNameUpdatedEvent(net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateNameEvent event) {
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
    public ServerVoiceChannel getChannel() {
        return new JDAServerVoiceChannel(event.getChannel());
    }

}
