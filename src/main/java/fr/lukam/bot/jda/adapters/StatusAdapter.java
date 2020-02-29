package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.jda.model.entities.user.status.*;
import fr.lukam.bot_api.entities.interfaces.user.Status;
import net.dv8tion.jda.api.OnlineStatus;

public class StatusAdapter {

    public static Status fromJDAStatus(OnlineStatus onlineStatus) {

        switch (onlineStatus) {

            case ONLINE:
                return new Online();

            case IDLE:
                return new Idle();

            case DO_NOT_DISTURB:
                return new DoNotDisturb();

            case INVISIBLE:
                return new Invisible();

            case OFFLINE:
                return new OffLine();

            case UNKNOWN:
                return new Unknown();

            default:
                throw new IllegalStateException("Unexpected status: " + onlineStatus);
        }

    }

}
