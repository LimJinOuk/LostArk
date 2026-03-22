package com.jinouk.lostark.service;

import com.jinouk.lostark.simulator.dto.simulateRun.child.skillsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class armoriesAPIService {

    //캐릭터 전체 정보 조희
    public Mono<String> getArmoriesCharacter(String name) {
        return loawebclient
                .get()
                .uri("/armories/characters/{name}", name)
                .retrieve()
                .bodyToMono(String.class);
    }

    private final WebClient loawebclient;

    //캐릭터의 스킬과 스킬에 장착한 룬 정보 조회
    public Mono<List<skillsResponse>> getArmoriesCharacterCombatSkills(String name) {
        return loawebclient
                .get()
                .uri("/armories/characters/{name}/combat-skills", name)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<skillsResponse>>() {});

    }

}
