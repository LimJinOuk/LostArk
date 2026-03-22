package com.jinouk.lostark.simulator.service.arkCoreCalc;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArkGridService {

    private final List<IArkGrid> arkGrids;

    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        Map<String, Double> combinedEffects = new HashMap<>();

        List<IArkGrid> matchedServices = arkGrids.stream()
                .filter(service -> isSupportedClass(service, requestDto.getClassName()))
                .filter(service -> hasMatchingCoreName(service, requestDto))
                .toList();

        if (matchedServices.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 클래스입니다: " + requestDto.getClassName());
        }

        for (IArkGrid service : matchedServices) {
            ArkGridResponseDto response = service.getArkGrid(requestDto);
            response.getEffects().forEach((key, value) ->
                    combinedEffects.merge(key, value, Double::sum));
        }
        return new ArkGridResponseDto(combinedEffects);
    }

    private boolean isSupportedClass(IArkGrid service, String className) {
        return "공용".equals(service.getClassName()) || service.getClassName().equals(className);
    }

    private boolean hasMatchingCoreName(IArkGrid service, ArkGridRequestDto requestDto) {
        if (requestDto.getArkGridItems() == null) return false;
        return requestDto.getArkGridItems().stream()
                .anyMatch(item -> item.getArkGridCoreName().equals(service.getArkGridCoreName()));
    }
}