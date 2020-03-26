package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.repositories.ListenersRepository;
import fr.lukam.bot.jda.model.events.JDAReadyEvent;
import fr.lukam.bot.jda.model.events.category.JDACategoryAddedEvent;
import fr.lukam.bot.jda.model.events.category.JDACategoryRemovedEvent;
import fr.lukam.bot.jda.model.events.channels.text.JDATextChannelAddedEvent;
import fr.lukam.bot.jda.model.events.channels.text.JDATextChannelRemovedEvent;
import fr.lukam.bot.jda.model.events.channels.text.JDATextChannelNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.channels.voice.JDAVoiceChannelAddedEvent;
import fr.lukam.bot.jda.model.events.channels.voice.JDAVoiceChannelRemovedEvent;
import fr.lukam.bot.jda.model.events.channels.voice.JDAVoiceChannelNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.message.actions.JDAPrivateMessageDeletedEvent;
import fr.lukam.bot.jda.model.events.message.actions.JDAPrivateMessageUpdatedEvent;
import fr.lukam.bot.jda.model.events.message.actions.server.JDAServerMessageDeletedEvent;
import fr.lukam.bot.jda.model.events.message.actions.server.JDAServerMessageReceivedEvent;
import fr.lukam.bot.jda.model.events.message.actions.JDAPrivateMessageReceivedEvent;
import fr.lukam.bot.jda.model.events.message.actions.server.JDAServerMessageUpdatedEvent;
import fr.lukam.bot.jda.model.events.message.reactions.JDAPrivateMessageReactionAddedEvent;
import fr.lukam.bot.jda.model.events.message.reactions.JDAPrivateMessageReactionRemovedEvent;
import fr.lukam.bot.jda.model.events.message.reactions.server.JDAServerMessageReactionAddedEvent;
import fr.lukam.bot.jda.model.events.message.reactions.server.JDAServerMessageReactionRemovedEvent;
import fr.lukam.bot.jda.model.events.roles.JDARoleColorUpdatedEvent;
import fr.lukam.bot.jda.model.events.roles.JDARoleAddedEvent;
import fr.lukam.bot.jda.model.events.roles.JDARoleNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.roles.JDARoleRemovedEvent;
import fr.lukam.bot.jda.model.events.server.JDABanEvent;
import fr.lukam.bot.jda.model.events.server.JDAServerNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.server.JDAServerOwnerUpdatedEvent;
import fr.lukam.bot.jda.model.events.server.JDAUnbanEvent;
import fr.lukam.bot.jda.model.events.server.emotes.JDAEmoteAddedEvent;
import fr.lukam.bot.jda.model.events.server.emotes.JDAEmoteNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.server.emotes.JDAEmoteRemovedEvent;
import fr.lukam.bot.jda.model.events.server.member.*;
import fr.lukam.bot.jda.model.events.server.voice.JDAVoiceConnectEvent;
import fr.lukam.bot.jda.model.events.server.voice.JDAVoiceDisconnectEvent;
import fr.lukam.bot.jda.model.events.server.voice.JDAVoiceMoveEvent;
import fr.lukam.bot.jda.model.events.user.JDAUserNameUpdatedEvent;
import fr.lukam.bot.jda.model.events.user.JDAUserTypingEvent;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.message.guild.*;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.*;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class DeltiBotJDAListener extends ListenerAdapter {

    private ListenersRepository listenersRepository;

    public DeltiBotJDAListener(ListenersRepository listenersRepository) {
        this.listenersRepository = listenersRepository;
    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onReady(new JDAReadyEvent(event)));
    }

    @Override
    public void onUserUpdateName(@Nonnull UserUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onUserUpdateName(new JDAUserNameUpdatedEvent(event)));
    }

    @Override
    public void onUserTyping(@Nonnull UserTypingEvent event) {

        if (event.getGuild() != null) {
            this.listenersRepository.getListeners().forEach(listener -> listener.onMemberTyping(new JDAMemberTypingEvent(event)));
            return;
        }

        this.listenersRepository.getListeners().forEach(listener -> listener.onUserTyping(new JDAUserTypingEvent(event)));
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMessageReceived(new JDAServerMessageReceivedEvent(event)));
    }

    @Override
    public void onGuildMessageUpdate(@Nonnull GuildMessageUpdateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMessageUpdate(new JDAServerMessageUpdatedEvent(event)));
    }

    @Override
    public void onGuildMessageDelete(@Nonnull GuildMessageDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMessageDelete(new JDAServerMessageDeletedEvent(event)));
    }

    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMessageReactionAdd(new JDAServerMessageReactionAddedEvent(event)));
    }

    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMessageReactionRemove(new JDAServerMessageReactionRemovedEvent(event)));
    }

    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageReceived(new JDAPrivateMessageReceivedEvent(event)));
    }

    @Override
    public void onPrivateMessageUpdate(@Nonnull PrivateMessageUpdateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageUpdate(new JDAPrivateMessageUpdatedEvent(event)));
    }

    @Override
    public void onPrivateMessageDelete(@Nonnull PrivateMessageDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageDelete(new JDAPrivateMessageDeletedEvent(event)));
    }

    @Override
    public void onPrivateMessageReactionAdd(@Nonnull PrivateMessageReactionAddEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageReactionAdd(new JDAPrivateMessageReactionAddedEvent(event)));
    }

    @Override
    public void onPrivateMessageReactionRemove(@Nonnull PrivateMessageReactionRemoveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageReactionRemove(new JDAPrivateMessageReactionRemovedEvent(event)));
    }

    @Override
    public void onTextChannelDelete(@Nonnull TextChannelDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onTextChannelDelete(new JDATextChannelRemovedEvent(event)));
    }

    @Override
    public void onTextChannelUpdateName(@Nonnull TextChannelUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onTextChannelUpdateName(new JDATextChannelNameUpdatedEvent(event)));
    }

    @Override
    public void onTextChannelCreate(@Nonnull TextChannelCreateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onTextChannelCreate(new JDATextChannelAddedEvent(event)));
    }

    @Override
    public void onVoiceChannelDelete(@Nonnull VoiceChannelDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onVoiceChannelDelete(new JDAVoiceChannelRemovedEvent(event)));
    }

    @Override
    public void onVoiceChannelUpdateName(@Nonnull VoiceChannelUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onVoiceChannelUpdateName(new JDAVoiceChannelNameUpdatedEvent(event)));
    }

    @Override
    public void onVoiceChannelCreate(@Nonnull VoiceChannelCreateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onVoiceChannelCreate(new JDAVoiceChannelAddedEvent(event)));
    }

    @Override
    public void onCategoryDelete(@Nonnull CategoryDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onCategoryDelete(new JDACategoryRemovedEvent(event)));
    }

    @Override
    public void onCategoryCreate(@Nonnull CategoryCreateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onCategoryCreate(new JDACategoryAddedEvent(event)));
    }

    @Override
    public void onGuildBan(@Nonnull GuildBanEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerBan(new JDABanEvent(event)));
    }

    @Override
    public void onGuildUnban(@Nonnull GuildUnbanEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerUnban(new JDAUnbanEvent(event)));
    }

    @Override
    public void onGuildUpdateOwner(@Nonnull GuildUpdateOwnerEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerUpdateOwner(new JDAServerOwnerUpdatedEvent(event)));
    }

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMemberJoin(new JDAMemberJoinEvent(event)));
    }

    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMemberLeave(new JDAMemberQuitEvent(event)));
    }

    @Override
    public void onGuildMemberRoleAdd(@Nonnull GuildMemberRoleAddEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMemberRoleAdd(new JDAMemberRoleAddedEvent(event)));
    }

    @Override
    public void onGuildMemberRoleRemove(@Nonnull GuildMemberRoleRemoveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMemberRoleRemove(new JDAMemberRoleRemovedEvent(event)));
    }

    @Override
    public void onGuildMemberUpdateNickname(@Nonnull GuildMemberUpdateNicknameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerMemberUpdateNickname(new JDAMemberNickNameUpdatedEvent(event)));
    }

    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerVoiceJoin(new JDAVoiceConnectEvent(event)));
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerVoiceMove(new JDAVoiceMoveEvent(event)));
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerVoiceLeave(new JDAVoiceDisconnectEvent(event)));
    }

    @Override
    public void onRoleCreate(@Nonnull RoleCreateEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onRoleCreate(new JDARoleAddedEvent(event)));
    }

    @Override
    public void onRoleDelete(@Nonnull RoleDeleteEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onRoleDelete(new JDARoleRemovedEvent(event)));
    }

    @Override
    public void onRoleUpdateColor(@Nonnull RoleUpdateColorEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onRoleUpdateColor(new JDARoleColorUpdatedEvent(event)));
    }

    @Override
    public void onRoleUpdateName(@Nonnull RoleUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onRoleUpdateName(new JDARoleNameUpdatedEvent(event)));
    }

    @Override
    public void onEmoteAdded(@Nonnull EmoteAddedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onEmoteAdded(new JDAEmoteAddedEvent(event)));
    }

    @Override
    public void onEmoteRemoved(@Nonnull EmoteRemovedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onEmoteRemoved(new JDAEmoteRemovedEvent(event)));
    }

    @Override
    public void onEmoteUpdateName(@Nonnull EmoteUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onEmoteUpdateName(new JDAEmoteNameUpdatedEvent(event)));
    }

    @Override
    public void onGuildUpdateName(@Nonnull GuildUpdateNameEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onServerUpdateName(new JDAServerNameUpdatedEvent(event)));
    }

}
