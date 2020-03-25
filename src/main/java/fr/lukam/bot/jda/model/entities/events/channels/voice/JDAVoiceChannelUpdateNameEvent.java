package fr.lukam.bot.jda.model.entities.events.channels.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.events.channel.voice.VoiceChannelUpdateNameEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;

public class JDAVoiceChannelUpdateNameEvent implements VoiceChannelUpdateNameEvent {

    private final net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateNameEvent event;

    public JDAVoiceChannelUpdateNameEvent(net.dv8tion.jda.api.events.channel.voice.update.VoiceChannelUpdateNameEvent event) {
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
