package fr.lukam.bot.jda.model.events.server;

import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import fr.lukam.bot.api.events.server.ServerOwnerUpdatedEvent;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateOwnerEvent;

public class JDAServerOwnerUpdatedEvent implements ServerOwnerUpdatedEvent {

    private final GuildUpdateOwnerEvent event;

    public JDAServerOwnerUpdatedEvent(GuildUpdateOwnerEvent event) {
        this.event = event;
    }

    @Override
    public ServerMember getOldOwner() {
        return new JDAServerMember(event.getOldOwner());
    }

    @Override
    public ServerMember getNewOwner() {
        return new JDAServerMember(event.getNewOwner());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
