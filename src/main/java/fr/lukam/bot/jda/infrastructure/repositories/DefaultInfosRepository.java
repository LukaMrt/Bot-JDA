package fr.lukam.bot.jda.infrastructure.repositories;

import fr.lukam.bot.api.repositories.InfosRepository;

import java.util.HashMap;
import java.util.Map;

public class DefaultInfosRepository implements InfosRepository, fr.lukam.deltibot.core.domain.infos.InfosRepository {

    private final Map<String, Object> store = new HashMap<>();

    @Override
    public void set(String key, String value) {
        this.store.put(key, value);
    }

    @Override
    public void set(String key, String[] value) {
        this.store.put(key, value);
    }

    @Override
    public void set(String key, int value) {
        this.store.put(key, value);
    }

    @Override
    public String getString(String key) {
        return (String) this.store.get(key);
    }

    @Override
    public String[] getStringArray(String key) {
        return (String[]) this.store.get(key);
    }

    @Override
    public int getInt(String key) {
        return (int) this.store.get(key);
    }

}
