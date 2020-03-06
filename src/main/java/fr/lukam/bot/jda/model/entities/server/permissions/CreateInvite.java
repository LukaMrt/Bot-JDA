package fr.lukam.bot.jda.model.entities.server.permissions;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class CreateInvite implements Permission {

    @Override
    public String getName() {
        return "Create instant invite";
    }

}
