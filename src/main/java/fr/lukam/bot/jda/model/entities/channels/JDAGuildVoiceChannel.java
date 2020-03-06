package fr.lukam.bot.jda.model.entities.channels;

import fr.lukam.bot.jda.model.entities.server.JDAServerMember;
import fr.lukam.bot.api.entities.interfaces.channels.ServerVoiceChannel;
import fr.lukam.bot.api.entities.interfaces.server.ServerMember;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;

import java.util.List;
import java.util.stream.Collectors;

public class JDAGuildVoiceChannel extends JDAGuildChannel implements ServerVoiceChannel {

    private final VoiceChannel voiceChannel;

    public JDAGuildVoiceChannel(VoiceChannel voiceChannel) {
        super(voiceChannel);
        this.voiceChannel = voiceChannel;
    }

    @Override
    public int getUserLimit() {
        return this.voiceChannel.getUserLimit();
    }

    @Override
    public void setUserLimit(int newLimit) {
        this.voiceChannel.getManager().setUserLimit(newLimit).queue();
    }

    @Override
    public List<ServerMember> getConnectedMembers() {
        return this.voiceChannel.getMembers().stream()
                .map(JDAServerMember::new)
                .collect(Collectors.toList());
    }

    @Override
    public void kick(ServerMember member) {
        Guild guild = this.voiceChannel.getGuild();
        Member jdaMember = guild.getMemberById(member.getId());

        if (jdaMember == null) {
            return;
        }

        guild.kickVoiceMember(jdaMember).queue();
    }

}
