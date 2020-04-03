package fr.lukam.bot.jda.model.events.message.reactions;

import fr.lukam.bot.api.entities.interfaces.reaction.Reaction;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.message.reactions.PrivateMessageReactionAddedEvent;
import fr.lukam.bot.jda.model.entities.reaction.JDAReaction;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;

public class JDAPrivateMessageReactionAddedEvent implements PrivateMessageReactionAddedEvent {

    private final PrivateMessageReactionAddEvent event;

    public JDAPrivateMessageReactionAddedEvent(PrivateMessageReactionAddEvent event) {
        this.event = event;
    }

    @Override
    public Reaction getReaction() {
        return new JDAReaction(event.getReaction());
    }

    @Override
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
