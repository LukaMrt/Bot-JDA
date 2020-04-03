package fr.lukam.bot.jda.model.events.roles;

import fr.lukam.bot.api.entities.interfaces.server.Role;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.roles.RoleCreatedEvent;
import fr.lukam.bot.jda.model.entities.server.JDARole;
import fr.lukam.bot.jda.model.entities.server.JDAServer;

public class JDARoleAddedEvent implements RoleCreatedEvent {

    private final net.dv8tion.jda.api.events.role.RoleCreateEvent event;

    public JDARoleAddedEvent(net.dv8tion.jda.api.events.role.RoleCreateEvent event) {
        this.event = event;
    }

    @Override
    public Role getRole() {
        return new JDARole(event.getRole());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
