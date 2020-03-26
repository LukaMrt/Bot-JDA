package fr.lukam.bot.jda.model.events.server;

import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.server.ServerNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;

public class JDAServerNameUpdatedEvent implements ServerNameUpdatedEvent {

    private final GuildUpdateNameEvent event;

    public JDAServerNameUpdatedEvent(GuildUpdateNameEvent event) {
        this.event = event;
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

    @Override
    public String getOldName() {
        return event.getOldName();
    }

    @Override
    public String getNewName() {
        return event.getNewName();
    }

}
