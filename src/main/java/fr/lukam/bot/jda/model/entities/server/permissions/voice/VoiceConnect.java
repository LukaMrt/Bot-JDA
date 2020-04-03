package fr.lukam.bot.jda.model.entities.server.permissions.voice;

import fr.lukam.bot.api.entities.interfaces.server.Permission;

public class VoiceConnect implements Permission {

    @Override
    public String getName() {
        return "Voice connect";
    }

}
