package fr.lukam.bot.jda.model.entities.message;

import fr.lukam.bot.jda.adapters.EmbedAdapterUtils;
import fr.lukam.bot.api.entities.fakes.message.FakeEmbed;
import fr.lukam.bot.api.entities.interfaces.message.Embed;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.message.MessageBuilder;

public class JDAMessageBuilder implements MessageBuilder {

    private String text = "";
    private Embed embed = new FakeEmbed();

    @Override
    public MessageBuilder aMessage() {
        return new JDAMessageBuilder();
    }

    @Override
    public MessageBuilder setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public MessageBuilder setEmbed(Embed embed) {
        this.embed = embed;
        return this;
    }

    @Override
    public Message build() {

        net.dv8tion.jda.api.MessageBuilder messageBuilder = new net.dv8tion.jda.api.MessageBuilder();

        if (!text.isEmpty()) {
            messageBuilder.setContent(text);
        } /* else { // TODO : to test
            messageBuilder.setContent("erreur");
        } */

        if (embed != null) {
            messageBuilder.setEmbed(EmbedAdapterUtils.fromAPIEmbed(embed));
        }

        return new JDAMessage(messageBuilder.build());
    }

    @Override
    public boolean isFake() {
        return false;
    }

}
