package fr.lukam.bot.jda.model.entities.channels.types;

import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;

public class GuildVoice implements ChannelType {

    @Override
    public String getType() {
        return "Guild voice";
    }

    @Override
    public boolean isFake() {
        return false;
    }

}
