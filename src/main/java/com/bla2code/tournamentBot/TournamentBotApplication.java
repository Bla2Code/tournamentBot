package com.bla2code.tournamentBot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class TournamentBotApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TournamentBotApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

//		final String token = "Nzk3NTU1ODE2NDI1MTkzNTAz.X_oLvA.IhoS-xfDjNu4ZNN0Naot8C-pSfE";
//		final DiscordClient client = DiscordClient.create(token);
//		final GatewayDiscordClient gateway = client.login().block();
//
//		gateway.on(MessageCreateEvent.class).subscribe(event -> {
//			final Message message = event.getMessage();
//			if ("!ping".equals(message.getContent())) {
//				final MessageChannel channel = message.getChannel().block();
//				channel.createMessage("Pong!").block();
//			}
//		});
//
//		gateway.onDisconnect().block();
	}

}
