package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.api.bot.API;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.message.MessageBuilder;

public class MessageAdapter {

    public static Message fromJDAMessage(net.dv8tion.jda.api.entities.Message jdaMessage) {

        MessageBuilder message = API.createMessage();
        message.setText(jdaMessage.getContentDisplay());

        if (jdaMessage.getEmbeds().size() != 0) {
            message.setEmbed(EmbedAdapter.fromJDAEmbed(jdaMessage));
        }

        return message.build();
    }

    public static net.dv8tion.jda.api.entities.Message fromAPIMessage(Message newMessage) {

        return new net.dv8tion.jda.api.MessageBuilder()
                .setContent(newMessage.getContent())
                .setEmbed(EmbedAdapter.fromAPIEmbed(newMessage.getEmbed()))
                .build();
    }

}
