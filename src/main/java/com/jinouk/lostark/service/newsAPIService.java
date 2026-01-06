package com.jinouk.lostark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class newsAPIService {

    private final WebClient lostArkWebClient;

    //로스트아크의 공지, 상점, 점검, 이벤트 조회
    public Mono<String> getNewsNotices() {
        return lostArkWebClient
                .get()
                .uri("/news/notices")
                .retrieve()
                .bodyToMono(String.class);
    }

    //로스트아크에서 현재 진행중인 이벤트 조회
    public Mono<String> getNewsEvents() {
        return lostArkWebClient
                .get()
                .uri("/news/events")
                .retrieve()
                .bodyToMono(String.class);
    }

    //Returns a list of alarm items (용도를 모르겠음 -_- )
    public Mono<String> getNewsAlarms() {
        return lostArkWebClient
                .get()
                .uri("/news/alarms")
                .retrieve()
                .bodyToMono(String.class);
    }
}
