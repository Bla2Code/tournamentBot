package com.bla2code.tournamentBot.events;

import com.bla2code.tournamentBot.service.challonge.TournamentServiceInterface;
import discord4j.core.object.entity.Message;
import discord4j.rest.util.Color;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.time.Instant;

public abstract class MessageListener {

    final static String IMAGE_URL = "https://cdn.betterttv.net/emote/55028cd2135896936880fdd7/3x";
    final static String ANY_URL = "https://www.youtube.com/watch?v=5zwY50-necw";

    @Autowired
	public TournamentServiceInterface tournamentService;

    public Mono<Void> processCommand(Message eventMessage) {
        Mono<Void> answer = null;

        System.out.println(eventMessage.getContent());

		if (eventMessage.getContent().equalsIgnoreCase("!ping")) {
				tournamentService.createTournament();
		}

        answer = Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase("!ping"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("Pong!")).then();

        answer = Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase("!t help"))
                .flatMap(Message::getChannel)
                .flatMap(channel ->
                                channel.createEmbed(spec ->
										spec.setColor(Color.RED)
												.setAuthor("setAuthor", ANY_URL, IMAGE_URL)
												.setImage(IMAGE_URL)
												.setTitle("setTitle/setUrl")
												.setUrl(ANY_URL)
												.setDescription("setDescription\n" +
														"big D: is setImage\n" +
														"small D: is setThumbnail\n" +
														"<-- setColor")
												.addField("addField", "inline = true", true)
												.addField("addFIeld", "inline = true", true)
												.addField("addFile", "inline = false", false)
												.setThumbnail(IMAGE_URL)
												.setFooter("setFooter --> setTimestamp", IMAGE_URL)
												.setTimestamp(Instant.now()))
                        /*channel.createMessage("Pong/")*/).then();

        return answer;

    }

}
