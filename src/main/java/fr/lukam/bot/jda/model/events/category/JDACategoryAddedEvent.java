package fr.lukam.bot.jda.model.events.category;

import fr.lukam.bot.api.entities.interfaces.server.Category;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.jda.model.entities.server.JDACategory;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;

public class JDACategoryAddedEvent implements fr.lukam.bot.api.events.category.CategoryAddedEvent {

    private final CategoryCreateEvent categoryCreateEvent;

    public JDACategoryAddedEvent(CategoryCreateEvent categoryCreateEvent) {
        this.categoryCreateEvent = categoryCreateEvent;
    }

    @Override
    public Category getCategory() {
        return new JDACategory(categoryCreateEvent.getCategory());
    }

    @Override
    public Server getServer() {
        return new JDAServer(this.categoryCreateEvent.getGuild());
    }

}
