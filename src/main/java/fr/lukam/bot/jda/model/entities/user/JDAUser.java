package fr.lukam.bot.jda.model.entities.user;

import fr.lukam.bot.jda.adapters.EmbedAdapter;
import fr.lukam.bot.jda.adapters.MessageAdapter;
import fr.lukam.bot.jda.model.entities.channels.JDATextChannel;
import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.user.User;
import net.dv8tion.jda.api.MessageBuilder;

import java.time.LocalDateTime;

public class JDAUser implements User {

    private final net.dv8tion.jda.api.entities.User jdaUser;

    public JDAUser(net.dv8tion.jda.api.entities.User jdaUser) {
        this.jdaUser = jdaUser;
    }

    @Override
    public String getAvatarURL() {
        return this.jdaUser.getAvatarUrl();
    }

    @Override
    public String getAsTag() {
        return this.jdaUser.getAsTag();
    }

    @Override
    public TextChannel getPrivateChannel() {
        return new JDATextChannel(this.jdaUser.openPrivateChannel().complete());
    }

    @Override
    public void sendMessage(Message message) {

        this.jdaUser.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(MessageAdapter.fromAPIMessage(message)).queue());
    }

    @Override
    public LocalDateTime getCreateAccountTime() {
        return this.jdaUser.getTimeCreated().toLocalDateTime();
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getId() {
        return this.jdaUser.getId();
    }

    @Override
    public String getAsMention() {
        return this.jdaUser.getAsMention();
    }

    @Override
    public String getName() {
        return this.jdaUser.getName();
    }

}
