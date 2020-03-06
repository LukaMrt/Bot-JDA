package fr.lukam.bot.jda.model.entities.server.permissions.text;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ManageMessages implements Permission {

    @Override
    public String getName() {
        return "Manage messages";
    }

}
