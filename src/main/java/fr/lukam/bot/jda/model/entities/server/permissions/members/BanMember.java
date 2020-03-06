package fr.lukam.bot.jda.model.entities.server.permissions.members;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class BanMember implements Permission {

    @Override
    public String getName() {
        return "Ban member";
    }

}
