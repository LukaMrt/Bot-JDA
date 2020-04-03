package fr.lukam.bot.jda.model.events.user;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.user.UserTypingEvent;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.jda.model.entities.user.JDAUser;

public class JDAUserTypingEvent implements UserTypingEvent {

    private final net.dv8tion.jda.api.events.user.UserTypingEvent event;

    public JDAUserTypingEvent(net.dv8tion.jda.api.events.user.UserTypingEvent event) {
        this.event = event;
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
