package com.jinouk.lostark.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class marketsAPIService {

    private final WebClient loawebclient;

    // marketAPIService.java
    public Mono<String> getMarketData(String itemName, int categoryCode, String grade) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("Sort", "GRADE");
        requestBody.put("CategoryCode", categoryCode);
        requestBody.put("ItemTier", 0);
        requestBody.put("ItemGrade", grade);
        requestBody.put("ItemName", itemName);
        requestBody.put("PageNo", 1);
        requestBody.put("SortCondition", "ASC");

        return loawebclient
                .post()
                .uri("/markets/items")
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
}
