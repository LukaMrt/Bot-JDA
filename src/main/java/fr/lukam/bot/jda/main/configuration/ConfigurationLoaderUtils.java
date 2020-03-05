package fr.lukam.bot.jda.main.configuration;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.file.FileConfig;

import java.util.ArrayList;

public class ConfigurationLoaderUtils {

    public static Configuration loadFrom(String filePath) {

        FileConfig fileConfig = CommentedFileConfig.builder(filePath)
                .defaultResource("configuration.toml")
                .autosave()
                .build();

        fileConfig.load();

        Configuration configuration = ConfigurationBuilder.aConfiguration()
                .withToken(fileConfig.getOrElse("bot.token", ""))
                .withPrefix(fileConfig.getCharOrElse("bot.prefix", ' '))
                .withOwnerId(fileConfig.getOrElse("ids.owner_id", ""))
                .withCoOwnerIds(fileConfig.getOrElse("ids.co_owners_ids", new ArrayList<String>()).toArray(new String[]{}))
                .withMainServerId(fileConfig.getOrElse("ids.main_server_id", ""))
                .build();

        fileConfig.close();

        return configuration;
    }

}
