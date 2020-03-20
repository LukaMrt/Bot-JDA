package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.repositories.ListenersRepository;
import fr.lukam.bot.jda.model.entities.events.JDAReadyEvent;
import fr.lukam.bot.jda.model.entities.events.message.actions.JDAGuildMessageReceived;
import fr.lukam.bot.jda.model.entities.events.message.actions.JDAPrivateMessageReceived;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.GenericCategoryEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.category.update.GenericCategoryUpdateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.GenericStoreChannelEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.GenericStoreChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.GenericTextChannelEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.GenericVoiceChannelEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.GenericEmoteEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.guild.*;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.*;
import net.dv8tion.jda.api.events.message.priv.react.GenericPrivateMessageReactionEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.role.GenericRoleEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
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
    public void onResume(@Nonnull ResumedEvent event) {
        super.onResume(event);
    }

    @Override
    public void onUserUpdateName(@Nonnull UserUpdateNameEvent event) {
        super.onUserUpdateName(event);
    }


    @Override
    public void onUserUpdateOnlineStatus(@Nonnull UserUpdateOnlineStatusEvent event) {
        super.onUserUpdateOnlineStatus(event);
    }
    @Override
    public void onUserTyping(@Nonnull UserTypingEvent event) {
        super.onUserTyping(event);
    }


    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageReceived(new JDAGuildMessageReceived(event)));
    }

    @Override
    public void onGuildMessageUpdate(@Nonnull GuildMessageUpdateEvent event) {
        super.onGuildMessageUpdate(event);
    }

    @Override
    public void onGuildMessageDelete(@Nonnull GuildMessageDeleteEvent event) {
        super.onGuildMessageDelete(event);
    }

    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        super.onGuildMessageReactionAdd(event);
    }

    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {

    }

    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {
        this.listenersRepository.getListeners().forEach(listener -> listener.onPrivateMessageReceived(new JDAPrivateMessageReceived(event)));
    }

    @Override
    public void onPrivateMessageUpdate(@Nonnull PrivateMessageUpdateEvent event) {
        super.onPrivateMessageUpdate(event);
    }

    @Override
    public void onPrivateMessageDelete(@Nonnull PrivateMessageDeleteEvent event) {
        super.onPrivateMessageDelete(event);
    }

    @Override
    public void onPrivateMessageEmbed(@Nonnull PrivateMessageEmbedEvent event) {
        super.onPrivateMessageEmbed(event);
    }

    @Override
    public void onPrivateMessageReactionAdd(@Nonnull PrivateMessageReactionAddEvent event) {
        super.onPrivateMessageReactionAdd(event);
    }

    @Override
    public void onPrivateMessageReactionRemove(@Nonnull PrivateMessageReactionRemoveEvent event) {
        super.onPrivateMessageReactionRemove(event);
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

    }

    @Override
    public void onMessageUpdate(@Nonnull MessageUpdateEvent event) {
        super.onMessageUpdate(event);
    }

    @Override
    public void onMessageDelete(@Nonnull MessageDeleteEvent event) {
        super.onMessageDelete(event);
    }

    @Override
    public void onMessageBulkDelete(@Nonnull MessageBulkDeleteEvent event) {
        super.onMessageBulkDelete(event);
    }

    @Override
    public void onMessageEmbed(@Nonnull MessageEmbedEvent event) {
        super.onMessageEmbed(event);
    }

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);
    }

    @Override
    public void onMessageReactionRemove(@Nonnull MessageReactionRemoveEvent event) {
        super.onMessageReactionRemove(event);
    }

    @Override
    public void onMessageReactionRemoveAll(@Nonnull MessageReactionRemoveAllEvent event) {
        super.onMessageReactionRemoveAll(event);
    }

    @Override
    public void onStoreChannelDelete(@Nonnull StoreChannelDeleteEvent event) {
        super.onStoreChannelDelete(event);
    }

    @Override
    public void onStoreChannelUpdateName(@Nonnull StoreChannelUpdateNameEvent event) {
        super.onStoreChannelUpdateName(event);
    }

    @Override
    public void onStoreChannelUpdatePosition(@Nonnull StoreChannelUpdatePositionEvent event) {
        super.onStoreChannelUpdatePosition(event);
    }

    @Override
    public void onStoreChannelUpdatePermissions(@Nonnull StoreChannelUpdatePermissionsEvent event) {
        super.onStoreChannelUpdatePermissions(event);
    }

    @Override
    public void onStoreChannelCreate(@Nonnull StoreChannelCreateEvent event) {
        super.onStoreChannelCreate(event);
    }

    @Override
    public void onTextChannelDelete(@Nonnull TextChannelDeleteEvent event) {
        super.onTextChannelDelete(event);
    }

    @Override
    public void onTextChannelUpdateName(@Nonnull TextChannelUpdateNameEvent event) {
        super.onTextChannelUpdateName(event);
    }

    @Override
    public void onTextChannelUpdateTopic(@Nonnull TextChannelUpdateTopicEvent event) {
        super.onTextChannelUpdateTopic(event);
    }

    @Override
    public void onTextChannelUpdatePosition(@Nonnull TextChannelUpdatePositionEvent event) {
        super.onTextChannelUpdatePosition(event);
    }

    @Override
    public void onTextChannelUpdatePermissions(@Nonnull TextChannelUpdatePermissionsEvent event) {
        super.onTextChannelUpdatePermissions(event);
    }

    @Override
    public void onTextChannelUpdateNSFW(@Nonnull TextChannelUpdateNSFWEvent event) {
        super.onTextChannelUpdateNSFW(event);
    }

    @Override
    public void onTextChannelUpdateParent(@Nonnull TextChannelUpdateParentEvent event) {
        super.onTextChannelUpdateParent(event);
    }

    @Override
    public void onTextChannelUpdateSlowmode(@Nonnull TextChannelUpdateSlowmodeEvent event) {
        super.onTextChannelUpdateSlowmode(event);
    }

    @Override
    public void onTextChannelCreate(@Nonnull TextChannelCreateEvent event) {
        super.onTextChannelCreate(event);
    }

    @Override
    public void onVoiceChannelDelete(@Nonnull VoiceChannelDeleteEvent event) {
        super.onVoiceChannelDelete(event);
    }

    @Override
    public void onVoiceChannelUpdateName(@Nonnull VoiceChannelUpdateNameEvent event) {
        super.onVoiceChannelUpdateName(event);
    }

    @Override
    public void onVoiceChannelUpdatePosition(@Nonnull VoiceChannelUpdatePositionEvent event) {
        super.onVoiceChannelUpdatePosition(event);
    }

    @Override
    public void onVoiceChannelUpdateUserLimit(@Nonnull VoiceChannelUpdateUserLimitEvent event) {
        super.onVoiceChannelUpdateUserLimit(event);
    }

    @Override
    public void onVoiceChannelUpdateBitrate(@Nonnull VoiceChannelUpdateBitrateEvent event) {
        super.onVoiceChannelUpdateBitrate(event);
    }

    @Override
    public void onVoiceChannelUpdatePermissions(@Nonnull VoiceChannelUpdatePermissionsEvent event) {
        super.onVoiceChannelUpdatePermissions(event);
    }

    @Override
    public void onVoiceChannelUpdateParent(@Nonnull VoiceChannelUpdateParentEvent event) {
        super.onVoiceChannelUpdateParent(event);
    }

    @Override
    public void onVoiceChannelCreate(@Nonnull VoiceChannelCreateEvent event) {
        super.onVoiceChannelCreate(event);
    }

    @Override
    public void onCategoryDelete(@Nonnull CategoryDeleteEvent event) {
        super.onCategoryDelete(event);
    }

    @Override
    public void onCategoryUpdateName(@Nonnull CategoryUpdateNameEvent event) {
        super.onCategoryUpdateName(event);
    }

    @Override
    public void onCategoryUpdatePosition(@Nonnull CategoryUpdatePositionEvent event) {
        super.onCategoryUpdatePosition(event);
    }

    @Override
    public void onCategoryUpdatePermissions(@Nonnull CategoryUpdatePermissionsEvent event) {
        super.onCategoryUpdatePermissions(event);
    }

    @Override
    public void onCategoryCreate(@Nonnull CategoryCreateEvent event) {
        super.onCategoryCreate(event);
    }

    @Override
    public void onPrivateChannelCreate(@Nonnull PrivateChannelCreateEvent event) {
        super.onPrivateChannelCreate(event);
    }

    @Override
    public void onPrivateChannelDelete(@Nonnull PrivateChannelDeleteEvent event) {
        super.onPrivateChannelDelete(event);
    }

    @Override
    public void onGuildReady(@Nonnull GuildReadyEvent event) {
        super.onGuildReady(event);
    }

    @Override
    public void onGuildJoin(@Nonnull GuildJoinEvent event) {
        super.onGuildJoin(event);
    }

    @Override
    public void onGuildLeave(@Nonnull GuildLeaveEvent event) {
        super.onGuildLeave(event);
    }

    @Override
    public void onGuildAvailable(@Nonnull GuildAvailableEvent event) {
        super.onGuildAvailable(event);
    }

    @Override
    public void onGuildUnavailable(@Nonnull GuildUnavailableEvent event) {
        super.onGuildUnavailable(event);
    }

    @Override
    public void onUnavailableGuildJoined(@Nonnull UnavailableGuildJoinedEvent event) {
        super.onUnavailableGuildJoined(event);
    }

    @Override
    public void onUnavailableGuildLeave(@Nonnull UnavailableGuildLeaveEvent event) {
        super.onUnavailableGuildLeave(event);
    }

    @Override
    public void onGuildBan(@Nonnull GuildBanEvent event) {
        super.onGuildBan(event);
    }

    @Override
    public void onGuildUnban(@Nonnull GuildUnbanEvent event) {
        super.onGuildUnban(event);
    }

    @Override
    public void onGuildUpdateAfkChannel(@Nonnull GuildUpdateAfkChannelEvent event) {
        super.onGuildUpdateAfkChannel(event);
    }

    @Override
    public void onGuildUpdateSystemChannel(@Nonnull GuildUpdateSystemChannelEvent event) {
        super.onGuildUpdateSystemChannel(event);
    }

    @Override
    public void onGuildUpdateAfkTimeout(@Nonnull GuildUpdateAfkTimeoutEvent event) {
        super.onGuildUpdateAfkTimeout(event);
    }

    @Override
    public void onGuildUpdateExplicitContentLevel(@Nonnull GuildUpdateExplicitContentLevelEvent event) {
        super.onGuildUpdateExplicitContentLevel(event);
    }

    @Override
    public void onGuildUpdateIcon(@Nonnull GuildUpdateIconEvent event) {
        super.onGuildUpdateIcon(event);
    }

    @Override
    public void onGuildUpdateMFALevel(@Nonnull GuildUpdateMFALevelEvent event) {
        super.onGuildUpdateMFALevel(event);
    }

    @Override
    public void onGuildUpdateName(@Nonnull GuildUpdateNameEvent event) {
        super.onGuildUpdateName(event);
    }

    @Override
    public void onGuildUpdateNotificationLevel(@Nonnull GuildUpdateNotificationLevelEvent event) {
        super.onGuildUpdateNotificationLevel(event);
    }

    @Override
    public void onGuildUpdateOwner(@Nonnull GuildUpdateOwnerEvent event) {
        super.onGuildUpdateOwner(event);
    }

    @Override
    public void onGuildUpdateRegion(@Nonnull GuildUpdateRegionEvent event) {
        super.onGuildUpdateRegion(event);
    }

    @Override
    public void onGuildUpdateSplash(@Nonnull GuildUpdateSplashEvent event) {
        super.onGuildUpdateSplash(event);
    }

    @Override
    public void onGuildUpdateVerificationLevel(@Nonnull GuildUpdateVerificationLevelEvent event) {
        super.onGuildUpdateVerificationLevel(event);
    }

    @Override
    public void onGuildUpdateFeatures(@Nonnull GuildUpdateFeaturesEvent event) {
        super.onGuildUpdateFeatures(event);
    }

    @Override
    public void onGuildUpdateVanityCode(@Nonnull GuildUpdateVanityCodeEvent event) {
        super.onGuildUpdateVanityCode(event);
    }

    @Override
    public void onGuildUpdateBanner(@Nonnull GuildUpdateBannerEvent event) {
        super.onGuildUpdateBanner(event);
    }

    @Override
    public void onGuildUpdateDescription(@Nonnull GuildUpdateDescriptionEvent event) {
        super.onGuildUpdateDescription(event);
    }

    @Override
    public void onGuildUpdateBoostTier(@Nonnull GuildUpdateBoostTierEvent event) {
        super.onGuildUpdateBoostTier(event);
    }

    @Override
    public void onGuildUpdateBoostCount(@Nonnull GuildUpdateBoostCountEvent event) {
        super.onGuildUpdateBoostCount(event);
    }

    @Override
    public void onGuildUpdateMaxMembers(@Nonnull GuildUpdateMaxMembersEvent event) {
        super.onGuildUpdateMaxMembers(event);
    }

    @Override
    public void onGuildUpdateMaxPresences(@Nonnull GuildUpdateMaxPresencesEvent event) {
        super.onGuildUpdateMaxPresences(event);
    }

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
    }

    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event) {
        super.onGuildMemberLeave(event);
    }

    @Override
    public void onGuildMemberRoleAdd(@Nonnull GuildMemberRoleAddEvent event) {
        super.onGuildMemberRoleAdd(event);
    }

    @Override
    public void onGuildMemberRoleRemove(@Nonnull GuildMemberRoleRemoveEvent event) {
        super.onGuildMemberRoleRemove(event);
    }

    @Override
    public void onGuildMemberUpdateNickname(@Nonnull GuildMemberUpdateNicknameEvent event) {
        super.onGuildMemberUpdateNickname(event);
    }

    @Override
    public void onGuildMemberUpdateBoostTime(@Nonnull GuildMemberUpdateBoostTimeEvent event) {
        super.onGuildMemberUpdateBoostTime(event);
    }

    @Override
    public void onGuildVoiceUpdate(@Nonnull GuildVoiceUpdateEvent event) {
        super.onGuildVoiceUpdate(event);
    }

    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        super.onGuildVoiceJoin(event);
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {
        super.onGuildVoiceMove(event);
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        super.onGuildVoiceLeave(event);
    }

    @Override
    public void onGuildVoiceMute(@Nonnull GuildVoiceMuteEvent event) {
        super.onGuildVoiceMute(event);
    }

    @Override
    public void onGuildVoiceDeafen(@Nonnull GuildVoiceDeafenEvent event) {
        super.onGuildVoiceDeafen(event);
    }

    @Override
    public void onGuildVoiceGuildMute(@Nonnull GuildVoiceGuildMuteEvent event) {
        super.onGuildVoiceGuildMute(event);
    }

    @Override
    public void onGuildVoiceGuildDeafen(@Nonnull GuildVoiceGuildDeafenEvent event) {
        super.onGuildVoiceGuildDeafen(event);
    }

    @Override
    public void onGuildVoiceSelfMute(@Nonnull GuildVoiceSelfMuteEvent event) {
        super.onGuildVoiceSelfMute(event);
    }

    @Override
    public void onGuildVoiceSelfDeafen(@Nonnull GuildVoiceSelfDeafenEvent event) {
        super.onGuildVoiceSelfDeafen(event);
    }

    @Override
    public void onGuildVoiceSuppress(@Nonnull GuildVoiceSuppressEvent event) {
        super.onGuildVoiceSuppress(event);
    }

    @Override
    public void onRoleCreate(@Nonnull RoleCreateEvent event) {
        super.onRoleCreate(event);
    }

    @Override
    public void onRoleDelete(@Nonnull RoleDeleteEvent event) {
        super.onRoleDelete(event);
    }

    @Override
    public void onRoleUpdateColor(@Nonnull RoleUpdateColorEvent event) {
        super.onRoleUpdateColor(event);
    }

    @Override
    public void onRoleUpdateHoisted(@Nonnull RoleUpdateHoistedEvent event) {
        super.onRoleUpdateHoisted(event);
    }

    @Override
    public void onRoleUpdateMentionable(@Nonnull RoleUpdateMentionableEvent event) {
        super.onRoleUpdateMentionable(event);
    }

    @Override
    public void onRoleUpdateName(@Nonnull RoleUpdateNameEvent event) {
        super.onRoleUpdateName(event);
    }

    @Override
    public void onRoleUpdatePermissions(@Nonnull RoleUpdatePermissionsEvent event) {
        super.onRoleUpdatePermissions(event);
    }

    @Override
    public void onRoleUpdatePosition(@Nonnull RoleUpdatePositionEvent event) {
        super.onRoleUpdatePosition(event);
    }

    @Override
    public void onEmoteAdded(@Nonnull EmoteAddedEvent event) {
        super.onEmoteAdded(event);
    }

    @Override
    public void onEmoteRemoved(@Nonnull EmoteRemovedEvent event) {
        super.onEmoteRemoved(event);
    }

    @Override
    public void onEmoteUpdateName(@Nonnull EmoteUpdateNameEvent event) {
        super.onEmoteUpdateName(event);
    }

    @Override
    public void onEmoteUpdateRoles(@Nonnull EmoteUpdateRolesEvent event) {
        super.onEmoteUpdateRoles(event);
    }

    @Override
    public void onHttpRequest(@Nonnull HttpRequestEvent event) {
        super.onHttpRequest(event);
    }

    @Override
    public void onGenericMessage(@Nonnull GenericMessageEvent event) {
        super.onGenericMessage(event);
    }

    @Override
    public void onGenericMessageReaction(@Nonnull GenericMessageReactionEvent event) {
        super.onGenericMessageReaction(event);
    }

    @Override
    public void onGenericGuildMessage(@Nonnull GenericGuildMessageEvent event) {
        super.onGenericGuildMessage(event);
    }

    @Override
    public void onGenericGuildMessageReaction(@Nonnull GenericGuildMessageReactionEvent event) {
        super.onGenericGuildMessageReaction(event);
    }

    @Override
    public void onGenericPrivateMessage(@Nonnull GenericPrivateMessageEvent event) {
        super.onGenericPrivateMessage(event);
    }

    @Override
    public void onGenericPrivateMessageReaction(@Nonnull GenericPrivateMessageReactionEvent event) {
        super.onGenericPrivateMessageReaction(event);
    }

    @Override
    public void onGenericUser(@Nonnull GenericUserEvent event) {
        super.onGenericUser(event);
    }

    @Override
    public void onGenericUserPresence(@Nonnull GenericUserPresenceEvent event) {
        super.onGenericUserPresence(event);
    }

    @Override
    public void onGenericSelfUpdate(@Nonnull GenericSelfUpdateEvent event) {
        super.onGenericSelfUpdate(event);
    }

    @Override
    public void onGenericStoreChannel(@Nonnull GenericStoreChannelEvent event) {
        super.onGenericStoreChannel(event);
    }

    @Override
    public void onGenericStoreChannelUpdate(@Nonnull GenericStoreChannelUpdateEvent event) {
        super.onGenericStoreChannelUpdate(event);
    }

    @Override
    public void onGenericTextChannel(@Nonnull GenericTextChannelEvent event) {
        super.onGenericTextChannel(event);
    }

    @Override
    public void onGenericTextChannelUpdate(@Nonnull GenericTextChannelUpdateEvent event) {
        super.onGenericTextChannelUpdate(event);
    }

    @Override
    public void onGenericVoiceChannel(@Nonnull GenericVoiceChannelEvent event) {
        super.onGenericVoiceChannel(event);
    }

    @Override
    public void onGenericVoiceChannelUpdate(@Nonnull GenericVoiceChannelUpdateEvent event) {
        super.onGenericVoiceChannelUpdate(event);
    }

    @Override
    public void onGenericCategory(@Nonnull GenericCategoryEvent event) {
        super.onGenericCategory(event);
    }

    @Override
    public void onGenericCategoryUpdate(@Nonnull GenericCategoryUpdateEvent event) {
        super.onGenericCategoryUpdate(event);
    }

    @Override
    public void onGenericGuild(@Nonnull GenericGuildEvent event) {
        super.onGenericGuild(event);
    }

    @Override
    public void onGenericGuildUpdate(@Nonnull GenericGuildUpdateEvent event) {
        super.onGenericGuildUpdate(event);
    }

    @Override
    public void onGenericGuildMember(@Nonnull GenericGuildMemberEvent event) {
        super.onGenericGuildMember(event);
    }

    @Override
    public void onGenericGuildMemberUpdate(@Nonnull GenericGuildMemberUpdateEvent event) {
        super.onGenericGuildMemberUpdate(event);
    }

    @Override
    public void onGenericGuildVoice(@Nonnull GenericGuildVoiceEvent event) {
        super.onGenericGuildVoice(event);
    }

    @Override
    public void onGenericRole(@Nonnull GenericRoleEvent event) {
        super.onGenericRole(event);
    }

    @Override
    public void onGenericRoleUpdate(@Nonnull GenericRoleUpdateEvent event) {
        super.onGenericRoleUpdate(event);
    }

    @Override
    public void onGenericEmote(@Nonnull GenericEmoteEvent event) {
        super.onGenericEmote(event);
    }

    @Override
    public void onGenericEmoteUpdate(@Nonnull GenericEmoteUpdateEvent event) {
        super.onGenericEmoteUpdate(event);
    }
}
