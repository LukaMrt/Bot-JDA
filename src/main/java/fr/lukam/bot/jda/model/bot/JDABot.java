package fr.lukam.bot.jda.model.bot;

import fr.lukam.bot.api.entities.fakes.user.FakeUser;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import fr.lukam.bot.api.bot.Bot;
import fr.lukam.bot.api.entities.fakes.server.FakeServer;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.user.User;
import net.dv8tion.jda.api.JDA;

import java.util.Optional;

public class JDABot implements Bot {

    private final JDA jda;

    public JDABot(JDA jda) {
        this.jda = jda;
    }

    @Override
    public Server getServer(String serverId) {
        return Optional.ofNullable(jda.getGuildById(serverId))
                .map(guild -> (Server) new JDAServer(guild))
                .orElseGet(FakeServer::new);
    }

    @Override
    public User getSelfUser() {
        return new JDAUser(this.jda.getSelfUser());
    }

    @Override
    public User getUser(String userId) {
        return new JDAUser(this.jda.getUserById(userId));
    }

    @Override
    public User getUserByName(String userName) {
        return jda.getUsersByName(userName, true)
                .stream()
                .findFirst()
                .map(JDAUser::new)
                .map( jdaUser -> (User) jdaUser)
                .orElseGet(FakeUser::new);
    }

    @Override
    public boolean isFake() {
        return false;
    }

}
