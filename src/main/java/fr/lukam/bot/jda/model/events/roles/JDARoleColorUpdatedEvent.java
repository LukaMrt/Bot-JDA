package fr.lukam.bot.jda.model.events.roles;

import fr.lukam.bot.api.entities.interfaces.server.Role;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.roles.RoleColorUpdatedEvent;
import fr.lukam.bot.jda.model.entities.server.JDARole;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.role.update.RoleUpdateColorEvent;

import java.awt.*;

public class JDARoleColorUpdatedEvent implements RoleColorUpdatedEvent {

    private final RoleUpdateColorEvent event;

    public JDARoleColorUpdatedEvent(RoleUpdateColorEvent event) {
        this.event = event;
    }

    @Override
    public Color getOldColor() {
        return event.getOldColor();
    }

    @Override
    public Color getNewColor() {
        return event.getNewColor();
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
