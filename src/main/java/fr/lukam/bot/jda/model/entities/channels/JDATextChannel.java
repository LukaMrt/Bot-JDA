package fr.lukam.bot.jda.model.entities.channels;

import fr.lukam.bot.jda.adapters.ChannelTypeAdapterUtils;
import fr.lukam.bot.jda.adapters.MessageAdapterUtils;
import fr.lukam.bot.api.entities.interfaces.channels.ChannelType;
import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.message.Message;

import java.util.List;
import java.util.stream.Collectors;

public class JDATextChannel implements TextChannel {

    private final net.dv8tion.jda.api.entities.MessageChannel jdaChannel;

    public JDATextChannel(net.dv8tion.jda.api.entities.MessageChannel jdaChannel) {
        this.jdaChannel = jdaChannel;
    }

    @Override
    public void sendMessage(Message message) {
        this.jdaChannel.sendMessage(MessageAdapterUtils.fromAPIMessage(message)).queue();
    }

    @Override
    public Message getMessageById(String messageId) {
        net.dv8tion.jda.api.entities.Message jdaMessage = this.jdaChannel.retrieveMessageById(messageId).complete();
        return MessageAdapterUtils.fromJDAMessage(jdaMessage); // TODO : catch null
    }

    @Override
    public List<Message> getHistoryBefore(Message message, boolean include, int count) {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.jdaChannel.getHistoryBefore(message.getId(), count).complete().getRetrievedHistory();
        List<Message> apiMessages = jdaMessages.stream()
                .map(MessageAdapterUtils::fromJDAMessage)
                .collect(Collectors.toList());

        if (include) {
            apiMessages.add(message);
        }

        return apiMessages;
    }

    @Override
    public List<Message> getHistoryAfter(Message message, boolean include, int count) {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.jdaChannel.getHistoryAfter(message.getId(), count).complete().getRetrievedHistory();
        List<Message> apiMessages = jdaMessages.stream()
                .map(MessageAdapterUtils::fromJDAMessage)
                .collect(Collectors.toList());

        if (include) {
            apiMessages.add(message);
        }

        return apiMessages;
    }

    @Override
    public List<Message> getPinnedMessages() {
        List<net.dv8tion.jda.api.entities.Message> jdaMessages = this.jdaChannel.retrievePinnedMessages().complete();

        return jdaMessages.stream()
                .map(MessageAdapterUtils::fromJDAMessage)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getName() {
        return this.jdaChannel.getName();
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelTypeAdapterUtils.fromJDAChannelType(this.jdaChannel.getType());
    }

}
