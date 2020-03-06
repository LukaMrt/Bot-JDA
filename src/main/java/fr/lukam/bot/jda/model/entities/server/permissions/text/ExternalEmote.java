package fr.lukam.bot.jda.model.entities.server.permissions.text;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class ExternalEmote implements Permission {

    @Override
    public String getName() {
        return "Use external emote";
    }

}
