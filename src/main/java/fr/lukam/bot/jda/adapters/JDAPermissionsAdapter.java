package fr.lukam.bot.jda.adapters;

import fr.lukam.bot.api.entities.interfaces.server.Permission;
import fr.lukam.bot.api.utils.PermissionAdapter;
import fr.lukam.bot.jda.model.entities.server.permissions.*;
import fr.lukam.bot.jda.model.entities.server.permissions.manage.*;
import fr.lukam.bot.jda.model.entities.server.permissions.members.BanMember;
import fr.lukam.bot.jda.model.entities.server.permissions.members.ChangeNickname;
import fr.lukam.bot.jda.model.entities.server.permissions.members.KickMember;
import fr.lukam.bot.jda.model.entities.server.permissions.text.*;
import fr.lukam.bot.jda.model.entities.server.permissions.voice.*;

public class JDAPermissionsAdapter implements PermissionAdapter {
    
    @Override
    public Permission fromPermissionName(String permissionName) {

        switch (permissionName) {

            case "Create instant invite":
                return new CreateInvite();

            case "Kick member":
                return new KickMember();

            case "Ban member":
                return new BanMember();

            case "Administrator":
                return new Administrator();

            case "Manage channels":
                return new ManageChannel();

            case "Manage server":
                return new ManageServer();

            case "Message add reaction":
                return new MessageAddReaction();

            case "View logs":
                return new ViewLogs();

            case "View channels":
                return new ViewChannels();

            case "Read messages":
                return new ReadMessages();

            case "Write messages":
                return new WriteMessages();

            case "Manage messages":
                return new ManageMessages();

            case "Read history":
                return new ReadHistory();

            case "Mention everyone":
                return new MentionEveryone();

            case "use external emote":
                return new ExternalEmote();

            case "Stream":
                return new Stream();

            case "Voice connect":
                return new VoiceConnect();

            case "Voice speak":
                return new VoiceSpeak();

            case "Mute others":
                return new MuteOthers();

            case "Disconnect others":
                return new DisconnectOthers();

            case "Move others":
                return new MoveOthers();

            case "Change nickname":
                return new ChangeNickname();

            case "Manage nicknames":
                return new ManageNickname();

            case "Manage roles":
                return new ManageRoles();

            case "Manage permissions":
                return new ManagePermissions();

            case "Unknown":

            case "Manage webhooks":

            case "Use voice activity":

            case "Attach files":

            case "Embed links":

            case "Send TTS messages":

            case "Priority speaker":

            default:
                return new Unknown();
        }
        
    }
    
}
