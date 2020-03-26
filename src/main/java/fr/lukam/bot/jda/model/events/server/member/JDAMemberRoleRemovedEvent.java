package fr.lukam.bot.jda.model.events.server.member;

import fr.lukam.bot.api.entities.interfaces.server.Role;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.member.MemberRoleRemovedEvent;
import fr.lukam.bot.jda.model.entities.server.JDARole;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;

public class JDAMemberRoleRemovedEvent implements MemberRoleRemovedEvent {

    private final GuildMemberRoleRemoveEvent event;

    public JDAMemberRoleRemovedEvent(GuildMemberRoleRemoveEvent event) {
        this.event = event;
    }

    @Override
    public Role getRole() {
        return new JDARole(event.getRoles().get(0));
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

    @Override
    public ServerMember getMember() {
        return new JDAServerMember(event.getMember());
    }

    @Override
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
