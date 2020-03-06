package fr.lukam.bot.jda.model.entities.channels.types;

import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;

public class PrivateChannel implements ChannelType {

    @Override
    public String getType() {
        return "Private channel";
    }

    @Override
    public boolean isFake() {
        return false;
    }

}
