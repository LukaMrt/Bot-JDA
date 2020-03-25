package fr.lukam.bot.jda.model.entities.channels;

import fr.lukam.bot.jda.adapters.EmbedAdapter;
import fr.lukam.bot.jda.adapters.MessageAdapter;
import fr.lukam.bot.api.entities.interfaces.channels.ServerTextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.stream.Collectors;

public class JDAServerTextChannel extends JDAGuildChannel implements ServerTextChannel {

    private final TextChannel textChannel;

    public JDAServerTextChannel(GuildChannel textChannel) {
        super(textChannel);
        this.textChannel = textChannel.getGuild().getTextChannelById(textChannel.getId());
    }

    @Override
    public void sendMessage(Message message) {
        this.textChannel.sendMessage(MessageAdapter.fromAPIMessage(message)).queue();
    }

    @Override
    public Message getMessageById(String messageId) {
        net.dv8tion.jda.api.entities.Message jdaMessage = this.textChannel.retrieveMessageById(messageId).complete();
        return MessageAdapter.fromJDAMessage(jdaMessage); // TODO : catch null
    }

    @Override
    public List<Message> getHistoryBefore(Message message, boolean include, int count) {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.textChannel.getHistoryBefore(message.getId(), count).complete().getRetrievedHistory();
        List<Message> apiMessages = jdaMessages.stream()
                .map(MessageAdapter::fromJDAMessage)
                .collect(Collectors.toList());

        if (include) {
            apiMessages.add(message);
        }

        return apiMessages;
    }

    @Override
    public List<Message> getHistoryAfter(Message message, boolean include, int count) {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.textChannel.getHistoryAfter(message.getId(), count).complete().getRetrievedHistory();
        List<Message> apiMessages = jdaMessages.stream()
                .map(MessageAdapter::fromJDAMessage)
                .collect(Collectors.toList());

        if (include) {
            apiMessages.add(message);
        }

        return apiMessages;
    }

    @Override
    public List<Message> getPinnedMessages() {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.textChannel.retrievePinnedMessages().complete();

        return jdaMessages.stream()
                .map(MessageAdapter::fromJDAMessage)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getName() {
        return this.textChannel.getName();
    }

}