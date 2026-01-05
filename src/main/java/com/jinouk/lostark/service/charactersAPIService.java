package com.jinouk.lostark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class charactersAPIService {

    private final WebClient lostArkWebClient;

    //사용자가 소유한 모든 캐릭터 목록 조회
    public Mono<String> getCharacterSiblings() {
        //이름은 나중에 입력값으로 바꿀 것.
        String name = "치킨버거사주세요";
        return lostArkWebClient
                .get()
                .uri("/characters/{name}/siblings", name)
                .retrieve()
                .bodyToMono(String.class);
    }
}
