package fr.lukam.bot.jda.model.events.server.emotes;

import fr.lukam.bot.api.entities.interfaces.reaction.Emote;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.server.emote.EmoteNameUpdatedEvent;
import fr.lukam.bot.jda.model.entities.reaction.JDAEmote;
import fr.lukam.bot.jda.model.entities.server.JDAServer;

public class JDAEmoteNameUpdatedEvent implements EmoteNameUpdatedEvent {

    private final net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent event;

    public JDAEmoteNameUpdatedEvent(net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent event) {
        this.event = event;
    }

    @Override
    public String getOldName() {
        return event.getOldName();
    }

    @Override
    public String getNewName() {
        return event.getNewName();
    }

    @Override
    public Emote getEmote() {
        return new JDAEmote(event.getEmote());
    }

    @Override
    public Server getServer() {
        return new JDAServer(event.getGuild());
    }

}
