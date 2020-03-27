package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.jda.model.entities.message.JDAField;
import fr.lukam.bot.jda.model.entities.user.JDAUser;
import fr.lukam.bot.api.bot.API;
import fr.lukam.bot.api.entities.interfaces.message.Embed;
import fr.lukam.bot.api.entities.interfaces.message.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class EmbedAdapter {

    public static MessageEmbed fromAPIEmbed(Embed embed) {

        net.dv8tion.jda.api.EmbedBuilder embedBuilder = new net.dv8tion.jda.api.EmbedBuilder();

        if (embed.getTitle().isEmpty()) {
            return null;
        }

        embedBuilder.setAuthor(embed.getAuthorName()/*, embed.getAuthor().getAvatarURL(), embed.getAuthor().getAvatarURL()*/)
                .setDescription(embed.getDescription())
                .setColor(embed.getColor())
                .setTitle(embed.getTitle())
                .setFooter(embed.getFooter());

        if (!embed.getImageURL().isEmpty()) {
            embedBuilder.setImage(embed.getImageURL());
        }

        embed.getFields().forEach(field -> embedBuilder.addField(field.getTitle(), field.getContent(), false));

        return embedBuilder.build();
    }

    public static Embed fromJDAEmbed(Message message) {

        MessageEmbed embed = message.getEmbeds().get(0);

        EmbedBuilder embedBuilder = API.createEmbed();

        if (embed.getAuthor() != null && embed.getAuthor().getName() != null && !embed.getAuthor().getName().isEmpty()) {
            embedBuilder.setAuthor(API.getUserByName(embed.getAuthor().getName()));
        }

        if (embed.getColor() != null) {
            embedBuilder.setColor(embed.getColor());
        }

        if (embed.getTitle() != null && !embed.getTitle().isEmpty()) {
            embedBuilder.setTitle(embed.getTitle());
        }

        if (embed.getDescription() != null && !embed.getDescription().isEmpty()) {
            embedBuilder.setDescription(embed.getDescription());
        }

        if (embed.getFooter() != null) {
            embedBuilder.setFooter(embed.getFooter().getText());
        }

        if (embed.getImage() != null) {
            embedBuilder.setImageURL(embed.getImage().getUrl());
        }

        embed.getFields().forEach(field -> embedBuilder.addField(new JDAField(field)));
        return embedBuilder.build();
    }

}
