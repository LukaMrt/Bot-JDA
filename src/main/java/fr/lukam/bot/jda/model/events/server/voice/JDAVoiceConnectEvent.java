package fr.lukam.bot.jda.model.events.server.voice;

import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.voice.VoiceMemberConnectedEvent;
import fr.lukam.bot.jda.model.entities.channels.JDAServerVoiceChannel;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;

public class JDAVoiceConnectEvent implements VoiceMemberConnectedEvent {

    private final GuildVoiceJoinEvent event;

    public JDAVoiceConnectEvent(GuildVoiceJoinEvent event) {
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

}
