package fr.lukam.bot.jda.model.entities.message;

import fr.lukam.bot.api.entities.interfaces.message.Field;
import fr.lukam.bot.api.entities.interfaces.message.FieldBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class JDAFieldBuilder implements FieldBuilder {

    private String title;
    private String content;
    private boolean inline;

    @Override
    public FieldBuilder aField() {
        return new JDAFieldBuilder();
    }

    @Override
    public FieldBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public FieldBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public FieldBuilder setInline(boolean inline) {
        this.inline = inline;
        return this;
    }

    @Override
    public Field build() {
        MessageEmbed.Field jdaField = new MessageEmbed.Field(this.title, this.content, inline);
        return new JDAField(jdaField);
    }

}
