package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.reaper;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReaperSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "리퍼";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 해 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;


            if ("달의 향기".equals(name)) {
                calcScentOfMoon(effectsMap, point, grade);
            } else if ("달의 악몽".equals(name)) {
                calcLunarNightmare(effectsMap, point, grade);
            } else if ("두 개의 달".equals(name)) {
                calcTwinMoons(effectsMap, point, grade);
            } else if ("갈증의 악몽".equals(name)) {
                calcThirstingNightmare(effectsMap, point, grade);
            } else if ("치명적인 발걸음".equals(name)) {
                calcDeadlyFootstep(effectsMap, point, grade);
            } else if ("피의 갈증".equals(name)) {
                calcBloodThirst(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //달의 향기
    private void calcScentOfMoon(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "적주피", 7.50); break; // 백어택 적주피 3.0 + 운명 적주피 4.5
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 5.10); mergeEffect(effectsMap, "적주피", 7.50); break; // 기존 급습 1.6 + 운명 급습 3.5 / 쿨감 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 5.27); mergeEffect(effectsMap, "적주피", 7.50); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 5.44); mergeEffect(effectsMap, "적주피", 7.50); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 5.61); mergeEffect(effectsMap, "적주피", 7.50); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "적주피", 7.50); break; // 백어택 적주피 3.0 + 운명 적주피 4.5
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 5.90); mergeEffect(effectsMap, "적주피", 7.50); break; // 기존 급습 1.6 + 운명 급습 3.5 / 쿨감 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 6.07); mergeEffect(effectsMap, "적주피", 7.50); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 6.24); mergeEffect(effectsMap, "적주피", 7.50); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 6.41); mergeEffect(effectsMap, "적주피", 7.50); break;
            }
        }
    }

    //달의 악몽
    //진욱쿤(나이트메어 스킬의 내려찍는 공격 피해량이 200.0% 증가 -> 나이트 메어 스킬 피증 200?)
    private void calcLunarNightmare(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 200.00); mergeEffect(effectsMap, "치적", 30.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 200.00); mergeEffect(effectsMap, "치적", 30.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "나이트메어 스킬 피증", 500.00); mergeEffect(effectsMap, "치적", 30.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        }
    }

    //두 개의 달
    private void calcTwinMoons(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 7.10); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break; // 기존 급습 1.6 + 운명 급습 5.5
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 7.27); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 7.44); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 7.61); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 7.90); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break; // 기존 급습 1.6 + 운명 급습 5.5
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 8.07); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 8.24); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 8.41); mergeEffect(effectsMap, "라스트 그래피티 스킬 치적", 10.00); break;
            }
        }
    }

    //갈증의 악몽
    private void calcThirstingNightmare(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 기존 적주피 1.5 + 운명 적주피 5.0
                case 17: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 6.50); break; // 기존 적주피 6.5 + 운명 적주피 5.0
                case 18: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 6.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.10); break;
                case 20: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.40); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 기존 적주피 1.5 + 운명 적주피 5.0
                case 17: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 8.50); break; // 기존 적주피 6.5 + 운명 적주피 5.0
                case 18: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 8.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 9.10); break;
                case 20: mergeEffect(effectsMap, "적주피", 11.50); mergeEffect(effectsMap, "급습 스킬 피증", 9.40); break;
            }
        }
    }

    //치명적인 발걸음
    private void calcDeadlyFootstep(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 14.00); break; // 기존 급습 10.0 + 신규 급습 4.0 / 쿨감 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 14.30); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 14.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 14.90); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 15.50); break; // 기존 급습 10.0 + 신규 급습 4.0 / 쿨감 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 15.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 16.10); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 16.40); break;
            }
        }
    }

    //피의 갈증
    //진욱쿤(과다 출혈 피증? 17포)
    private void calcBloodThirst(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 75.00); break; // 유지시간 갱신 및 쿨감 제외
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 105.00); break; // 혈액폭발(고정 피해)은 '피증' 범주가 아니므로 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 105.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 105.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 105.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); break; // 쿨증 제외
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 75.00); break; // 유지시간 갱신 및 쿨감 제외
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 120.00); break; // 혈액폭발(고정 피해)은 '피증' 범주가 아니므로 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 120.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 120.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 30.00); mergeEffect(effectsMap, "과다 출혈 피증", 120.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
    }
}