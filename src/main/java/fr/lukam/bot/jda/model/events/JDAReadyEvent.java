package fr.lukam.bot.jda.model.events;

import fr.lukam.bot.api.events.ReadyEvent;

public class JDAReadyEvent implements ReadyEvent {

    private final net.dv8tion.jda.api.events.ReadyEvent readyEvent;

    public JDAReadyEvent(net.dv8tion.jda.api.events.ReadyEvent readyEvent) {
        this.readyEvent = readyEvent;
    }

    @Override
    public int getServerCount() {
        return 0;
    }

}
