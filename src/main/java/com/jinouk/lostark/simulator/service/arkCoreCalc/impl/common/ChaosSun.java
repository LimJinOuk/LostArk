package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosSun extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "공용";
    }

    @Override
    public String getArkGridCoreName() {
        return "혼돈의 해 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("현란한 공격".equals(name)) {
                calcDazzling(effectsMap, point, grade);
            } else if ("안정적인 공격".equals(name)) {
                calcStable(effectsMap, point, grade);
            } else if ("재빠른 공격".equals(name)) {
                calcSwift(effectsMap, point, grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    // 현란한 공격
    private void calcDazzling(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치피증", 0.55); break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); mergeEffect(effectsMap, "치피증", 0.55); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.0); mergeEffect(effectsMap, "치피증", 1.65); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.16); mergeEffect(effectsMap, "치피증", 1.65); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.32); mergeEffect(effectsMap, "치피증", 1.65); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.48); mergeEffect(effectsMap, "치피증", 1.65); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치피증", 0.55); break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); mergeEffect(effectsMap, "치피증", 0.55); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.5); mergeEffect(effectsMap, "치피증", 1.1); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "치피증", 1.1); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "치피증", 1.1); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "치피증", 1.1); break;
            }
        }
    }

    // 안정적인 공격
    private void calcStable(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "추피", 0.7); break;
                case 17: mergeEffect(effectsMap, "추피", 3.5); break;
                case 18: mergeEffect(effectsMap, "추피", 3.73); break;
                case 19: mergeEffect(effectsMap, "추피", 3.96); break;
                case 20: mergeEffect(effectsMap, "추피", 4.19); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "추피", 0.7); break;
                case 17: mergeEffect(effectsMap, "추피", 2.1); break;
                case 18: mergeEffect(effectsMap, "추피", 2.33); break;
                case 19: mergeEffect(effectsMap, "추피", 2.56); break;
                case 20: mergeEffect(effectsMap, "추피", 2.79); break;
            }
        }
    }

    // 재빠른 공격
    private void calcSwift(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "치피증", 1.4); break;
                case 17: mergeEffect(effectsMap, "치피증", 7.0); break;
                case 18: mergeEffect(effectsMap, "치피증", 7.45); break;
                case 19: mergeEffect(effectsMap, "치피증", 7.9); break;
                case 20: mergeEffect(effectsMap, "치피증", 8.35); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "치피증", 1.4); break;
                case 17: mergeEffect(effectsMap, "치피증", 4.2); break;
                case 18: mergeEffect(effectsMap, "치피증", 4.65); break;
                case 19: mergeEffect(effectsMap, "치피증", 5.1); break;
                case 20: mergeEffect(effectsMap, "치피증", 5.55); break;
            }
        }
    }
}