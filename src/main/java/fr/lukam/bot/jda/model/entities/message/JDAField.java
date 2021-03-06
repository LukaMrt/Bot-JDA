package fr.lukam.bot.jda.model.entities.message;

import fr.lukam.bot.api.entities.interfaces.message.Field;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class JDAField implements Field {

    private final MessageEmbed.Field field;

    public JDAField(MessageEmbed.Field field) {
        this.field = field;
    }

    @Override
    public String getTitle() {
        return this.field.getName();
    }

    @Override
    public String getContent() {
        return this.field.getValue();
    }

    @Override
    public boolean isInline() {
        return this.field.isInline();
    }

}
