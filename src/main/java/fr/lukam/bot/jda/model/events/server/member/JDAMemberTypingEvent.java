package fr.lukam.bot.jda.model.events.server.member;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.member.MemberTypingEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.user.UserTypingEvent;

public class JDAMemberTypingEvent implements MemberTypingEvent {

    private final UserTypingEvent event;

    public JDAMemberTypingEvent(UserTypingEvent event) {
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
    public TextChannel getChannel() {
        return new JDATextChannel(event.getChannel());
    }

    @Override
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
