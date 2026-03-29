package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosMoon extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "공용";
    }

    @Override
    public String getArkGridCoreName() {
        return "혼돈의 달 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("불타는 일격".equals(name)) {
                calcFire(effectsMap, point, grade);
            } else if ("흡수의 일격".equals(name)) {
                calcAbsorb(effectsMap, point, grade);
            } else if ("부수는 일격".equals(name)) {
                calcBreak(effectsMap, point, grade);
            } else if ("낙인의 흔적".equals(name)) {
                calcStigma(effectsMap, point, grade);
            } else if ("강철의 흔적".equals(name)) {
                calcSteel(effectsMap, point, grade);
            } else if ("치명적인 흔적".equals(name)) {
                calcFatal(effectsMap, point, grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);
        return new ArkGridResponseDto(effectsMap);
    }

    // 불타는 일격
    private void calcFire(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.5); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.98); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.5); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); break;
            }
        }
    }

    // 흡수의 일격
    private void calcAbsorb(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.5); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.98); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "적주피", 0.5); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.5); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); break;
            }
        }
    }

    // 부수는 일격
    private void calcBreak(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "치적", 0.65); break;
                case 17: mergeEffect(effectsMap, "치적", 2.5); break;
                case 18: mergeEffect(effectsMap, "치적", 2.66); break;
                case 19: mergeEffect(effectsMap, "치적", 2.82); break;
                case 20: mergeEffect(effectsMap, "치적", 2.98); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "치적", 0.65); break;
                case 17: mergeEffect(effectsMap, "치적", 1.95); break;
                case 18: mergeEffect(effectsMap, "치적", 2.16); break;
                case 19: mergeEffect(effectsMap, "치적", 2.47); break;
                case 20: mergeEffect(effectsMap, "치적", 2.58); break;
            }
        }
    }

    // 낙인의 흔적
    private void calcStigma(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 0.1); break;
                case 17: mergeEffect(effectsMap, "적주피", 0.5); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 0.1); break;
                case 17: mergeEffect(effectsMap, "적주피", 0.3); break;
            }
        }
    }

    // 강철의 흔적
    private void calcSteel(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "방깎", 0.2); break;
                case 17: mergeEffect(effectsMap, "방깎", 1.0); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "방깎", 0.2); break;
                case 17: mergeEffect(effectsMap, "방깎", 0.6); break;
            }
        }
    }

    // 치명적인 흔적
    private void calcFatal(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치피증", 0.3); break;
                case 17: mergeEffect(effectsMap, "치피증", 1.5); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치피증", 0.3); break;
                case 17: mergeEffect(effectsMap, "치피증", 0.9); break;
            }
        }
    }
}