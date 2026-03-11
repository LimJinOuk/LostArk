package com.jinouk.lostark.simulator.service.arkCoreCalc.core;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public abstract class AbstractArkGrid implements IArkGrid {

    // 공통적으로 사용하는 효과 합산 로직
    protected void mergeEffect(Map<String, Double> effectsMap, String key, Double value) {
        if (value == null || value == 0) return;
        effectsMap.merge(key, value, Double::sum);
    }

    // 결과 로그 출력 공통화
    protected void logEffects(String coreName, Map<String, Double> effectsMap) {

        effectsMap.forEach((key, value) ->
                log.info("[{}] {}: {}", coreName, key, value)
        );
    }

    // 기본적인 null 체크 및 리스트 방어 코드
    protected void validateItems(ArkGridRequestDto requestDto) {
        if (requestDto.getArkGridItems() == null) {
            throw new IllegalArgumentException("아크 그리드 아이템 리스트가 비어 있습니다.");
        }
    }
}
