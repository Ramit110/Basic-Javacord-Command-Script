package com.javacord.bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args){

        DiscordApi api = new DiscordApiBuilder().setToken(Secrets.BotID).login().join();

        api.addMessageCreateListener(
                event ->
                        event.getChannel().sendMessage(
                                new CommandParser(
                                        event.getMessage().getContent().toLowerCase().split("\n")
                                ).runCommand()
                        )
        );

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}
