package fr.lukam.bot.jda.model.entities.server.permissions.voice;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class MuteOthers implements Permission {

    @Override
    public String getName() {
        return "Mute other";
    }

}

