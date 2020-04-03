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

        switch (permissionName.toLowerCase()) {

            case "create instant invite":
                return new CreateInvite();

            case "kick member":
                return new KickMember();

            case "ban member":
                return new BanMember();

            case "administrator":
                return new Administrator();

            case "manage channels":
                return new ManageChannel();

            case "manage server":
                return new ManageServer();

            case "message add reaction":
                return new MessageAddReaction();

            case "view logs":
                return new ViewLogs();

            case "view channels":
                return new ViewChannels();

            case "read messages":
                return new ReadMessages();

            case "write messages":
                return new WriteMessages();

            case "manage messages":
                return new ManageMessages();

            case "read history":
                return new ReadHistory();

            case "mention everyone":
                return new MentionEveryone();

            case "use external emote":
                return new ExternalEmote();

            case "stream":
                return new Stream();

            case "voice connect":
                return new VoiceConnect();

            case "voice speak":
                return new VoiceSpeak();

            case "mute others":
                return new MuteOthers();

            case "disconnect others":
                return new DisconnectOthers();

            case "move others":
                return new MoveOthers();

            case "change nickname":
                return new ChangeNickname();

            case "manage nicknames":
                return new ManageNickname();

            case "manage roles":
                return new ManageRoles();

            case "manage permissions":
                return new ManagePermissions();

            case "unknown":

            case "manage webhooks":

            case "use voice activity":

            case "attach files":

            case "embed links":

            case "send TTS messages":

            case "priority speaker":

            default:
                return new Unknown();
        }
        
    }
    
}
