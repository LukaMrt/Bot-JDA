package fr.lukam.bot.jda.main.configuration;

public class ConfigurationBuilder {

    public String token;
    public char prefix;

    public String ownerId;
    public String[] coOwnerIds;
    public String mainServerId;

    private ConfigurationBuilder() {
    }

    public static ConfigurationBuilder aConfiguration() {
        return new ConfigurationBuilder();
    }

    public ConfigurationBuilder withToken(String token) {
        this.token = token;
        return this;
    }

    public ConfigurationBuilder withPrefix(char prefix) {
        this.prefix = prefix;
        return this;
    }

    public ConfigurationBuilder withOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public ConfigurationBuilder withCoOwnerIds(String[] coOwnerIds) {
        this.coOwnerIds = coOwnerIds;
        return this;
    }

    public ConfigurationBuilder withMainServerId(String mainServerId) {
        this.mainServerId = mainServerId;
        return this;
    }

    public Configuration build() {
        return new Configuration(this);
    }

}
