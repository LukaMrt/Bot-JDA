package fr.lukam.bot.jda.model.entities.server.permissions.manage;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ManageChannel implements Permission {

    @Override
    public String getName() {
        return "Manage channel";
    }

}
