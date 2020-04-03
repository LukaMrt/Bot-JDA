package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.jda.model.entities.channels.types.*;
import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;

public class ChannelTypeAdapterUtils {

    public static ChannelType fromJDAChannelType(net.dv8tion.jda.api.entities.ChannelType jdaChannelType) {

        switch (jdaChannelType) {

            case TEXT:
                return new GuildTextChannel();

            case GROUP: case PRIVATE:
                return new PrivateChannel();

            case VOICE:
                return new GuildVoice();

            case CATEGORY:
                return new Category();

            case STORE: case UNKNOWN:
                return new Unknown();

            default:
                throw new IllegalStateException("Unexpected value: " + jdaChannelType);

        }

    }

}
