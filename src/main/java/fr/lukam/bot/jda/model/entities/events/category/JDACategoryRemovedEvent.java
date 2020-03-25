package fr.lukam.bot.jda.model.entities.events.category;

import fr.lukam.bot.api.entities.interfaces.server.Category;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.category.CategoryRemovedEvent;
import fr.lukam.bot.jda.model.entities.server.JDACategory;
import fr.lukam.bot.jda.model.entities.server.JDAServer;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;

public class JDACategoryRemovedEvent implements CategoryRemovedEvent {

    private final CategoryDeleteEvent event;

    public JDACategoryRemovedEvent(CategoryDeleteEvent event) {
        this.event = event;
    }

    @Override
    public Category getCategory() {
        return new JDACategory(event.getCategory());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
