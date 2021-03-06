package fr.lukam.bot.jda.model.entities.user.status;

import fr.lukam.bot.api.entities.interfaces.user.Status;

import java.awt.*;

public class Invisible implements Status {

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getName() {
        return "Invisible";
    }

}
