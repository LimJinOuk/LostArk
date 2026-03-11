package com.jinouk.lostark.apiController;

import com.jinouk.lostark.service.marketsAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor


public class marketsAPI {

    private final marketsAPIService service;

    @GetMapping("/markets")
    public Mono<String> testMarketApi(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "category", required = false, defaultValue = "0") int category,
            @RequestParam(name = "grade", required = false, defaultValue = "") String grade
    ) {
        return service.getMarketData(name, category, grade);
    }
}
