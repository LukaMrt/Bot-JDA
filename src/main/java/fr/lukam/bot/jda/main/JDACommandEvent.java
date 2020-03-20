package fr.lukam.bot.jda.main;

import fr.lukam.bot.api.entities.interfaces.channels.TextChannel;
import fr.lukam.bot.api.entities.interfaces.events.CommandEvent;
import fr.lukam.bot.api.entities.interfaces.message.Message;
import fr.lukam.bot.api.entities.interfaces.server.Server;
import fr.lukam.bot.api.entities.interfaces.user.User;
import fr.lukam.bot.api.repositories.InfosRepository;

public class JDACommandEvent implements CommandEvent {

    private final InfosRepository infosRepository;
    private final Message message;
    private final TextChannel textChannel;
    private final Server server;

    public JDACommandEvent(InfosRepository infosRepository, Message message, TextChannel textChannel, Server server) {
        this.infosRepository = infosRepository;
        this.message = message;
        this.textChannel = textChannel;
        this.server = server;
    }

    @Override
    public char getPrefix() {
        return infosRepository.getString("prefix").charAt(0);
    }

    @Override
    public String[] getArgs() {
        return this.message.getContent().split(" ");
    }

    @Override
    public User getUser() {
        return message.getAuthor();
    }

    @Override
    public TextChannel getChannel() {
        return this.textChannel;
    }

    @Override
    public Server getServer() {
        return this.server;
    }

    @Override
    public void reply(Message message) {
        this.textChannel.sendMessage(message);
    }

    @Override
    public void replyInDm(Message embed) {
        message.getAuthor().sendMessage(message);
    }

    @Override
    public boolean isOwner() {
        return false;
    }

}
