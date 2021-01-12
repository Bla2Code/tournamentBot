package com.bla2code.tournamentBot.events;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {
	
	public Mono<Void> processCommand(Message eventMessage) {

		System.out.println(eventMessage.getContent());

		Mono<Void> answer = Mono.just(eventMessage)
           .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
           .filter(message -> message.getContent().equalsIgnoreCase("!ping"))
           		   .flatMap(Message::getChannel)
           		   .flatMap(channel -> 
           		   		channel.createMessage("Pong!")).then();

		return answer;

    }

}
