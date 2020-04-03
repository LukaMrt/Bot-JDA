package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;
import fr.lukam.bot.api.utils.ChannelTypeAdapter;
import fr.lukam.bot.jda.model.entities.channels.types.Category;
import fr.lukam.bot.jda.model.entities.channels.types.GuildTextChannel;
import fr.lukam.bot.jda.model.entities.channels.types.GuildVoice;
import fr.lukam.bot.jda.model.entities.channels.types.PrivateChannel;
import fr.lukam.bot.jda.model.entities.channels.types.Unknown;

public class JDAChannelTypeAdapter implements ChannelTypeAdapter {

    @Override
    public ChannelType fromChannelTypeName(String channelTypeName) {

        switch (channelTypeName.toLowerCase()) {

            case "text":
                return new GuildTextChannel();

            case "groupe":

            case "private":
                return new PrivateChannel();

            case "voice":
                return new GuildVoice();

            case "category":
                return new Category();

            default:
                return new Unknown();

        }

    }

}
