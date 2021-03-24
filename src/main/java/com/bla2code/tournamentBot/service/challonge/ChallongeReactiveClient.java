package com.bla2code.tournamentBot.service.challonge;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Документация и детали <a href="https://github.com/Playtika/feign-reactive">feign-reactive</a>.
 * Варианты реализации Json Query:
 * <ol>
 * <li>
 *     RequestParam типа Map со значением вида Map.of("{}","").
 *     Обрезка хвоста вида "%7D=" в перехватчике.
 *     Реализован данный вариант.
 * </li>
 * <li>
 *     Параметр с известным имением, например "-".
 *     Обрезка префикса вида "?-=%7B" в перехватчике.
 * </li>
 * </ol>
 */

@Headers({ "Accept: application/json" })
public interface ChallongeReactiveClient {

    @RequestLine("GET /tournaments")
    Mono<ChallongeTournament> getTournaments(@Param("api_key") String key);

}