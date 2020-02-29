package fr.lukam.bot.jda.model.entities.channels;

import fr.lukam.bot.jda.adapters.ChannelTypeAdapter;
import fr.lukam.bot.jda.model.entities.server.JDAInvite;
import fr.lukam.bot_api.entities.interfaces.channels.ChannelType;
import fr.lukam.bot_api.entities.interfaces.channels.ServerChannel;
import fr.lukam.bot_api.entities.interfaces.server.Invite;
import net.dv8tion.jda.api.entities.GuildChannel;

public class JDAGuildChannel implements ServerChannel {

    private final GuildChannel guildChannel;

    public JDAGuildChannel(GuildChannel guildChannel) {
        this.guildChannel = guildChannel;
    }

    @Override
    public Invite createInvite() {
        return new JDAInvite(this.guildChannel.createInvite().complete());
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public String getId() {
        return this.guildChannel.getId();
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelTypeAdapter.fromJDAChannelType(this.guildChannel.getType());
    }

    @Override
    public String getName() {
        return this.guildChannel.getName();
    }

}
