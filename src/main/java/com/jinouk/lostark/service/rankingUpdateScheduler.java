package com.jinouk.lostark.service;

import com.jinouk.lostark.repository.rankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Component
@RequiredArgsConstructor
public class rankingUpdateScheduler {

    private final rankingRepository repository;
    private final rankingUpdateService rankingUpdateService;

    // 매일 아침 6시 실행
    @Scheduled(cron = "0 0 6 * * *")
    public void runDailyCharacterUpdate() {
        List<String> allNames = repository.findAllNames();

        Flux.fromIterable(allNames)
                .concatMap(name ->
                        rankingUpdateService.processCharacterUpdate(name)
                                .delayElement(Duration.ofMillis(3000))
                                .doOnSuccess(res -> System.out.println("업데이트 성공: " + name))
                                .doOnError(e -> System.err.println("업데이트 실패: " + name + ": " + e.getMessage()))
                                .onErrorResume(e -> Mono.empty())
                )
                .subscribe();
    }
}
