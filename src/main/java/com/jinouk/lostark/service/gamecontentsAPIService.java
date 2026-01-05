package com.jinouk.lostark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class gamecontentsAPIService {

    private final WebClient lostarkWebClient;

    //텍스트만 있어서 정확하진 않지만 로스트아크 일정을 캘린더 형식으로 보여주기 위한 데이터로 예상
    public Mono<String> getGamecontentsCalendar() {
        return lostarkWebClient
                .get()
                .uri("/gamecontents/calendar")
                .retrieve()
                .bodyToMono(String.class);
    }
}
