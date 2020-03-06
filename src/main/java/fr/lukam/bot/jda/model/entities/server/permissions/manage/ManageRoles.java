package fr.lukam.bot.jda.model.entities.server.permissions.manage;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ManageRoles implements Permission {

    @Override
    public String getName() {
        return "Manage roles";
    }

}

