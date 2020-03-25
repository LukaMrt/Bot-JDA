package fr.lukam.bot.jda.model.entities.events.roles;

import fr.lukam.bot.api.entities.interfaces.server.Role;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.roles.RoleNameUpdateEvent;
import fr.lukam.bot.jda.model.entities.server.JDARole;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.role.update.RoleUpdateNameEvent;

import java.awt.*;

public class JDARoleNameUpdate implements RoleNameUpdateEvent {

    private final RoleUpdateNameEvent event;

    public JDARoleNameUpdate(RoleUpdateNameEvent event) {
        this.event = event;
    }

    @Override
    public Color getOldName() { //TODO : review
        return null;
    }

    @Override
    public Color getNewName() { //TODO : review
        return null;
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
