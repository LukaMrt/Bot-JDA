package fr.lukam.bot.jda.fake;

import fr.lukam.deltibot.core.domain.infos.InfosRepository;

public class FakeInfosRepository implements InfosRepository {

    @Override
    public void set(String key, String value) {
        // Empty because fake object
    }

    @Override
    public void set(String key, String[] value) {
        // Empty because fake object
    }

    @Override
    public void set(String key, int value) {
        // Empty because fake object
    }

    @Override
    public String getString(String key) {
        return "";
    }

    @Override
    public String[] getStringArray(String key) {
        return new String[0];
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

}
