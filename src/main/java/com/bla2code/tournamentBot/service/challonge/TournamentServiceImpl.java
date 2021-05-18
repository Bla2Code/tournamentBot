package com.bla2code.tournamentBot.service.challonge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TournamentServiceImpl implements TournamentServiceInterface {

    @Value("${cloud.candy.challonge.url}")
    String url;

    @Value("${cloud.candy.challonge.token}")
    String token;

    public void createTournament() {
        /* Create instance of your API */
//        ChallongeReactiveClient client = WebReactiveFeign
//                        .<ChallongeReactiveClient>builder()
//                        .target(ChallongeReactiveClient.class, url);
//
//        /* Execute nonblocking requests */
//        Mono<ChallongeTournament> challongeTournamentMono = client.getTournaments(token);

//        client.getTournaments(API_KEY);
    }
}
