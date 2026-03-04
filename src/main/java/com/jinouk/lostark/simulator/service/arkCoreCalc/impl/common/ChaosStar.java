package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.common;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaosStar extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "공용";
    }

    @Override
    public String getArkGridCoreName() {
        return "혼돈의 별 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("공격".equals(name)) {
                calcAttack(effectsMap, point, grade);
            } else if ("무기".equals(name)) {
                calcWeapon(effectsMap, point, grade);
            } else if ("속도".equals(name)) {
                calcSpeed(effectsMap, point, grade);
            } else if ("생명".equals(name)) {
                calcLife(effectsMap, point, grade);
            } else if ("방어".equals(name)) {
                calcDefend(effectsMap, point, grade);
            } else if ("구원".equals(name)) {
                calcRescue(effectsMap, point, grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    // 공격 코어
    private void calcAttack(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공격력", 900.0); break;
                case 14: mergeEffect(effectsMap, "공퍼력", 0.55); break;
                case 17: mergeEffect(effectsMap, "공퍼력", 2.2); mergeEffect(effectsMap, "공격력", 3600.0); break;
                case 18: mergeEffect(effectsMap, "공퍼력", 2.36); mergeEffect(effectsMap, "공격력", 3600.0); break;
                case 19: mergeEffect(effectsMap, "공퍼력", 2.52); mergeEffect(effectsMap, "공격력", 3600.0); break;
                case 20: mergeEffect(effectsMap, "공퍼력", 2.68);mergeEffect(effectsMap, "공격력", 3600.0); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공격력", 900.0); break;
                case 14: mergeEffect(effectsMap, "공퍼력", 0.55); break;
                case 17: mergeEffect(effectsMap, "공퍼력", 1.65); mergeEffect(effectsMap, "공격력", 2700.0); break;
                case 18: mergeEffect(effectsMap, "공퍼력", 1.81); mergeEffect(effectsMap, "공격력", 2700.0); break;
                case 19: mergeEffect(effectsMap, "공퍼력", 1.97); mergeEffect(effectsMap, "공격력", 2700.0); break;
                case 20: mergeEffect(effectsMap, "공퍼력", 2.13); mergeEffect(effectsMap, "공격력", 2700.0); break;
            }
        }
    }

    // 무기 코어
    private void calcWeapon(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "무공", 1300.0); break;
                case 14: mergeEffect(effectsMap, "무공퍼", 0.75); break;
                case 17: mergeEffect(effectsMap, "무공퍼", 3.0); mergeEffect(effectsMap, "무공", 5200.0); break;
                case 18: mergeEffect(effectsMap, "무공퍼", 5.25); mergeEffect(effectsMap, "무공", 5200.0); break;
                case 19: mergeEffect(effectsMap, "무공퍼", 7.5); mergeEffect(effectsMap, "무공", 5200.0); break;
                case 20: mergeEffect(effectsMap, "무공퍼", 9.75); mergeEffect(effectsMap, "무공", 5200.0); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "무공", 1300.0); break;
                case 14: mergeEffect(effectsMap, "무공퍼", 0.75); break;
                case 17: mergeEffect(effectsMap, "무공퍼", 2.25); mergeEffect(effectsMap, "무공", 3900.0); break;
                case 18: mergeEffect(effectsMap, "무공퍼", 4.5); mergeEffect(effectsMap, "무공", 3900.0); break;
                case 19: mergeEffect(effectsMap, "무공퍼", 6.75); mergeEffect(effectsMap, "무공", 3900.0); break;
                case 20: mergeEffect(effectsMap, "무공퍼", 9.5); mergeEffect(effectsMap, "무공", 3900.0); break;
            }
        }
    }

    // 속도 코어
    private void calcSpeed(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공속", 0.9); break;
                case 14: mergeEffect(effectsMap, "공속", 0.9);  mergeEffect(effectsMap, "이속", 0.9); break;
                case 17: mergeEffect(effectsMap, "공속", 3.6); mergeEffect(effectsMap, "이속", 3.6); break;
                case 18: mergeEffect(effectsMap, "공속", 3.9); mergeEffect(effectsMap, "이속", 3.9); break;
                case 19: mergeEffect(effectsMap, "공속", 4.2); mergeEffect(effectsMap, "이속", 4.); break;
                case 20: mergeEffect(effectsMap, "공속", 4.5); mergeEffect(effectsMap, "이속", 4.5); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공속", 0.9); break;
                case 14: mergeEffect(effectsMap, "공속", 0.9); mergeEffect(effectsMap, "이속", 0.9); break;
                case 17: mergeEffect(effectsMap, "공속", 2.7); mergeEffect(effectsMap, "이속", 2.7); break;
                case 18: mergeEffect(effectsMap, "공속", 3.0); mergeEffect(effectsMap, "이속", 3.0); break;
                case 19: mergeEffect(effectsMap, "공속", 3.3); mergeEffect(effectsMap, "이속", 3.3); break;
                case 20: mergeEffect(effectsMap, "공속", 3.6); mergeEffect(effectsMap, "이속", 3.6); break;
            }
        }
    }

    // 생명 코어
    private void calcLife(Map<String, Double> effectsMap, int point, String grade) {
    }

    // 방어 코어
    private void calcDefend(Map<String, Double> effectsMap, int point, String grade) {
    }

    // 구원 코어
    private void calcRescue(Map<String, Double> effectsMap, int point, String grade) {
    }
}