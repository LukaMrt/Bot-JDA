package fr.lukam.bot.jda.model.events.roles;

import fr.lukam.bot.api.entities.interfaces.server.Role;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.roles.RoleNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.server.JDARole;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.role.update.RoleUpdateNameEvent;

public class JDARoleNameUpdatedEvent implements RoleNameUpdatedEvent {

    private final RoleUpdateNameEvent event;

    public JDARoleNameUpdatedEvent(RoleUpdateNameEvent event) {
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
    public Role getRole() {
        return new JDARole(event.getRole());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
