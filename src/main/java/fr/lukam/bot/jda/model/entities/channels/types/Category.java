package fr.lukam.bot.jda.model.entities.channels.types;

import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;

public class Category implements ChannelType {

    @Override
    public String getType() {
        return "Category";
    }

    @Override
    public boolean isFake() {
        return false;
    }

}
