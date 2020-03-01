package fr.lukam.bot.jda.main.configuration;

import java.util.List;

public class ConfigurationBuilder {

    public String token;
    public char prefix;

    public long ownerId;
    public List<Long> coOwnerIds;

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

    public ConfigurationBuilder withOwnerId(long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public ConfigurationBuilder withCoOwnerIds(List<Long> coOwnerIds) {
        this.coOwnerIds = coOwnerIds;
        return this;
    }

    public Configuration build() {
        return new Configuration(this);
    }

}
