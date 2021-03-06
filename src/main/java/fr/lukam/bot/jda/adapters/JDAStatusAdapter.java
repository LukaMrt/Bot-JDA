package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.api.entities.interfaces.user.Status;
import fr.lukam.bot.api.utils.StatusAdapter;
import fr.lukam.bot.jda.model.entities.user.status.Online;
import fr.lukam.bot.jda.model.entities.user.status.Idle;
import fr.lukam.bot.jda.model.entities.user.status.DoNotDisturb;
import fr.lukam.bot.jda.model.entities.user.status.Invisible;
import fr.lukam.bot.jda.model.entities.user.status.OffLine;
import fr.lukam.bot.jda.model.entities.user.status.Unknown;

public class JDAStatusAdapter implements StatusAdapter {

    @Override
    public Status fromStatusName(String statusName) {

        switch (statusName.toLowerCase()) {

            case "online":
                return new Online();

            case "idle":
                return new Idle();

            case "do not disturb":
                return new DoNotDisturb();

            case "invisible":
                return new Invisible();

            case "offline":
                return new OffLine();

            default:
                return new Unknown();
        }

    }

}
