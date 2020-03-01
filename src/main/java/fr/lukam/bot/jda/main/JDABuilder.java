package fr.lukam.bot.jda.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class JDABuilder {

    public static JDA buildJDA(String token, char prefix) {

        JDA jda;

        try {

            jda = new net.dv8tion.jda.api.JDABuilder()
                    .setToken(token)
                    .setStatus(OnlineStatus.ONLINE)
                    .setActivity(Activity.of(Activity.ActivityType.DEFAULT, prefix + "help"))
                    .build();

        } catch (LoginException e) {

            e.printStackTrace();
            jda = null;

        }

        return jda;

    }

}
