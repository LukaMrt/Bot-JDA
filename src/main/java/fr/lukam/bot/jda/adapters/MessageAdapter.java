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

        net.dv8tion.jda.api.MessageBuilder messageBuilder = new net.dv8tion.jda.api.MessageBuilder();

        if (!newMessage.getContent().isEmpty()) {
            messageBuilder.setContent(newMessage.getContent());
        } else {
            messageBuilder.setContent("erreur");
        }

        if (newMessage.getEmbed() != null) {
            messageBuilder.setEmbed(EmbedAdapter.fromAPIEmbed(newMessage.getEmbed()));
        }

        return messageBuilder.build();
    }

}
