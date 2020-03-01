package fr.lukam.bot.jda.main.configuration;

import java.util.List;

public class Configuration {

    public String token;
    public final char prefix;

    public final long ownerId;
    public final List<Long> coOwnerIds;

    public Configuration(ConfigurationBuilder configurationBuilder) {
        this.token = configurationBuilder.token;
        this.prefix = configurationBuilder.prefix;

        this.ownerId = configurationBuilder.ownerId;
        this.coOwnerIds = configurationBuilder.coOwnerIds;
    }

}