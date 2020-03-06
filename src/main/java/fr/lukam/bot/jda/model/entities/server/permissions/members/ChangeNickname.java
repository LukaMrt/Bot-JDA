package fr.lukam.bot.jda.model.entities.server.permissions.members;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ChangeNickname implements Permission {

    @Override
    public String getName() {
        return "Change nickname";
    }

}

