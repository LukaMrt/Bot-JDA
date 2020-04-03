package fr.lukam.bot.jda.model.events.message.reactions.server;

import fr.lukam.bot.api.entities.interfaces.reaction.Reaction;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.message.reactions.server.ServerMessageReactionAddedEvent;
import fr.lukam.bot.jda.model.entities.reaction.JDAReaction;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;

public class JDAServerMessageReactionAddedEvent implements ServerMessageReactionAddedEvent {

    private final GuildMessageReactionAddEvent event;

    public JDAServerMessageReactionAddedEvent(GuildMessageReactionAddEvent event) {
        this.event = event;
    }

    @Override
    public Reaction getReaction() {
        return new JDAReaction(event.getReaction());
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
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
