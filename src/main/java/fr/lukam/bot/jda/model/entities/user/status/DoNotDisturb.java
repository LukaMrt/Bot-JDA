package fr.lukam.bot.jda.model.entities.user.status;

import fr.lukam.bot_api.entities.interfaces.user.Status;

import java.awt.*;

public class DoNotDisturb implements Status {

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getName() {
        return "Do not disturb";
    }

}