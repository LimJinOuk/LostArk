package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulEater;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulEaterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소울이터";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 달 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;


            if ("이계의 힘".equals(name)) {
                calcOtherworldlyPower(effectsMap, point, grade);
            } else if ("영속자".equals(name)) {
                calcEternalOne(effectsMap, point, grade);
            } else if ("소울 코어".equals(name)) {
                calcSoulCore(effectsMap, point, grade);
            } else if ("크레센트".equals(name)) {
                calcCrescent(effectsMap, point, grade);
            } else if ("광월야".equals(name)) {
                calcMoonlightRequiem(effectsMap, point, grade);
            } else if ("강탈자".equals(name)) {
                calcUsurper(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //이계의 힘
    //진욱쿤(사신화 상태)
    private void calcOtherworldlyPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break; // 마나 소모 제외
                case 17: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break; // 마나 소모 제외
                case 18: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 2.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break; // 마나 소모 제외
                case 17: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 3.00); break; // 마나 소모 제외
                case 18: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 3.20); break;
                case 19: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 3.40); break;
                case 20: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 3.60); break;
            }
        }
    }

    //영속자
    private void calcEternalOne(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break; // 사용 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "사신화 상태 적주피", 4.80); break; // 기존 1.8 + 신규 3.0 (마나 소모 제외)
                case 18: mergeEffect(effectsMap, "사신화 상태 적주피", 4.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "사신화 상태 적주피", 4.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "사신화 상태 적주피", 4.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "사신화 상태 적주피", 1.80); break; // 사용 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "사신화 상태 적주피", 6.00); break; // 기존 1.8 + 신규 3.0 (마나 소모 제외)
                case 18: mergeEffect(effectsMap, "사신화 상태 적주피", 6.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "사신화 상태 적주피", 6.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "사신화 상태 적주피", 6.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
    }

    //소울 코어
    private void calcSoulCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "망자 스킬 피증", 9.00); break; // 기존 3.0 + 신규 6.0 (시전 속도 제외)
                case 18: mergeEffect(effectsMap, "망자 스킬 피증", 9.60); break;
                case 19: mergeEffect(effectsMap, "망자 스킬 피증", 10.20); break;
                case 20: mergeEffect(effectsMap, "망자 스킬 피증", 10.80); break;            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "망자 스킬 피증", 12.00); break; // 기존 3.0 + 신규 6.0 (시전 속도 제외)
                case 18: mergeEffect(effectsMap, "망자 스킬 피증", 12.60); break;
                case 19: mergeEffect(effectsMap, "망자 스킬 피증", 13.20); break;
                case 20: mergeEffect(effectsMap, "망자 스킬 피증", 13.80); break;
            }
        }
    }

    //크레센트
    private void calcCrescent(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 1.70); mergeEffect(effectsMap, "사신 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 6.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 1.90); mergeEffect(effectsMap, "사신 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피", 6.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 2.10); mergeEffect(effectsMap, "사신 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 6.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 7.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 1.70); mergeEffect(effectsMap, "사신 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 7.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 1.90); mergeEffect(effectsMap, "사신 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피", 7.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 2.10); mergeEffect(effectsMap, "사신 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 7.00); break;
            }
        }
    }

    //광월야
    private void calcMoonlightRequiem(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "사신 스킬 피증", 22.00); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break; // 기존 2.0 + 신규 20.0
                case 18: mergeEffect(effectsMap, "사신 스킬 피증", 22.30); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
                case 19: mergeEffect(effectsMap, "사신 스킬 피증", 22.60); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
                case 20: mergeEffect(effectsMap, "사신 스킬 피증", 22.90); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "사신 스킬 피증", 24.00); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break; // 기존 2.0 + 신규 20.0
                case 18: mergeEffect(effectsMap, "사신 스킬 피증", 24.30); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
                case 19: mergeEffect(effectsMap, "사신 스킬 피증", 24.60); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
                case 20: mergeEffect(effectsMap, "사신 스킬 피증", 24.90); mergeEffect(effectsMap, "살귀 스킬 피증", -20.00); break;
            }
        }
    }

    //강탈자
    private void calcUsurper(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 6.00); break; // 기존 3.0 + 신규 3.0 (시전 속도 제외)
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 6.30); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 6.60); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 6.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 8.00); break; // 기존 3.0 + 신규 3.0 (시전 속도 제외)
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 8.30); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 8.60); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 8.90); break;
            }
        }
    }
}
