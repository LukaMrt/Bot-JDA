package fr.lukam.bot.jda.model.entities.user.status;

import fr.lukam.bot.api.entities.interfaces.user.Status;

import java.awt.*;

public class OffLine implements Status {

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getName() {
        return "Offline";
    }

}
