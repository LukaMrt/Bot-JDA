package fr.lukam.bot.jda.model.events.user;

import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.user.UserNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;

public class JDAUserNameUpdatedEvent implements UserNameUpdatedEvent {

    private final UserUpdateNameEvent event;

    public JDAUserNameUpdatedEvent(UserUpdateNameEvent event) {
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
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
