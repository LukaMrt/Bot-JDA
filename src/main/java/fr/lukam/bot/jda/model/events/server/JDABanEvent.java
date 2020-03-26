package fr.lukam.bot.jda.model.events.server;

import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.events.server.BanEvent;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;

public class JDABanEvent implements BanEvent {

    private final GuildBanEvent event;

    public JDABanEvent(GuildBanEvent event) {
        this.event = event;
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
