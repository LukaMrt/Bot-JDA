package fr.lukam.bot.jda.model.events.server.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.voice.VoiceMemberMovedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;

public class JDAVoiceMoveEvent implements VoiceMemberMovedEvent {

    private final GuildVoiceMoveEvent event;

    public JDAVoiceMoveEvent(GuildVoiceMoveEvent event) {
        this.event = event;
    }

    @Override
    public ServerMember getMember() {
        return new JDAServerMember(event.getMember());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

    @Override
    public ServerVoiceChannel getChannel() {
        return new JDAServerVoiceChannel(event.getChannelJoined());
    }

    @Override
    public User getUser() {
        return new JDAUser(event.getMember().getUser());
    }

    @Override
    public ServerVoiceChannel getOldChannel() {
        return new JDAServerVoiceChannel(event.getChannelLeft());
    }

    @Override
    public ServerVoiceChannel getNewChannel() {
        return new JDAServerVoiceChannel(event.getChannelJoined());
    }

}
