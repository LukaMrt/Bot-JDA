package fr.lukam.bot.jda.model.events.server;

import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.UnBanEvent;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;

public class JDAUnbanEvent implements UnBanEvent {

    private final GuildUnbanEvent event;

    public JDAUnbanEvent(GuildUnbanEvent event) {
        this.event = event;
    }

    @Override
    public User getUser() {
        return new JDAUser(event.getUser());
    }

}
