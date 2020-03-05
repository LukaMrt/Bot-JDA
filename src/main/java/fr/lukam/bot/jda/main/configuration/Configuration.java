package fr.lukam.bot.jda.main.configuration;

public class Configuration {

    public final String token;
    public final char prefix;

    public final String ownerId;
    public final String[] coOwnerIds;
    public final String mainServerId;

    public Configuration(ConfigurationBuilder configurationBuilder) {
        this.token = configurationBuilder.token;
        this.prefix = configurationBuilder.prefix;

        this.ownerId = configurationBuilder.ownerId;
        this.coOwnerIds = configurationBuilder.coOwnerIds;
        this.mainServerId = configurationBuilder.mainServerId;
    }

}