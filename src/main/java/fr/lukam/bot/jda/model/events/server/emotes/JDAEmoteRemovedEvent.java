package fr.lukam.bot.jda.model.events.server.emotes;

import fr.lukam.bot.api.entities.interfaces.reaction.Emote;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.events.server.emote.EmoteRemovedEvent;
import fr.lukam.bot.jda.model.entities.reaction.JDAEmote;
import fr.lukam.bot.jda.model.entities.server.JDAServer;

public class JDAEmoteRemovedEvent implements EmoteRemovedEvent {

    private final net.dv8tion.jda.api.events.emote.EmoteRemovedEvent event;

    public JDAEmoteRemovedEvent(net.dv8tion.jda.api.events.emote.EmoteRemovedEvent event) {
        this.event = event;
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
