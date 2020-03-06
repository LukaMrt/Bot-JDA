package fr.lukam.bot.jda.model.entities.server.permissions;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ViewLogs implements Permission {

    @Override
    public String getName() {
        return "View logs";
    }

}
