package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulEater;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulEaterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소울이터";
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

            if ("아더 디멘션".equals(name)) {
                calcOtherDimension(effectsMap, point, grade);
            } else if ("래피드 데스".equals(name)) {
                calcRapidDeath(effectsMap, point, grade);
            } else if ("망자의 발걸음".equals(name)) {
                calcDeadMansStep(effectsMap, point, grade);
            } else if ("다크 문".equals(name)) {
                calcDarkMoon(effectsMap, point, grade);
            } else if ("사신의 부름".equals(name)) {
                calcReapersCall(effectsMap, point, grade);
            } else if ("살귀의 밤".equals(name)) {
                calcNightOfCarnage(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //아더 디멘션
    private void calcOtherDimension(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.80); break; // 피해량 감소/재감 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.80); break; // 사신 스킬 피증 0% 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.80); break; // 피해량 감소/재감 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.00); break; // 사신 스킬 피증 0% 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.60); break;
            }
        }
    }

    //래피드 데스
    private void calcRapidDeath(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 7.80); break; // 1.8% + 6.0% (운명 발동 시 적주피 합산)
                case 17: mergeEffect(effectsMap, "적주피", 7.80); break; // 사신 스킬 피증 0% 및 빙의 게이지 제외
                case 18: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 7.80); break; // 1.8% + 6.0% (운명 발동 시 적주피 합산)
                case 17: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.80); mergeEffect(effectsMap, "사신 스킬 피증", 1.60); break;
            }
        }
    }

    //망자의 발걸음
    private void calcDeadMansStep(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break; // 재감 및 이동 속도 제외
                case 17: mergeEffect(effectsMap, "망자 스킬 피증", 73.00); break; // 3% + 망자의 발걸음 효과 70% 합산
                case 18: mergeEffect(effectsMap, "망자 스킬 피증", 73.60); break;
                case 19: mergeEffect(effectsMap, "망자 스킬 피증", 74.20); break;
                case 20: mergeEffect(effectsMap, "망자 스킬 피증", 74.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "망자 스킬 피증", 3.00); break; // 재감 및 이동 속도 제외
                case 17: mergeEffect(effectsMap, "망자 스킬 피증", 83.00); break; // 3% + 망자의 발걸음 효과 70% 합산
                case 18: mergeEffect(effectsMap, "망자 스킬 피증", 83.60); break;
                case 19: mergeEffect(effectsMap, "망자 스킬 피증", 84.20); break;
                case 20: mergeEffect(effectsMap, "망자 스킬 피증", 84.80); break;
            }
        }
    }

    //다크 문
    private void calcDarkMoon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.50); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); break; // 기본 2.5% + 100% 증가분(2.5%) = 5.0%
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 1.70); mergeEffect(effectsMap, "사신 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 1.90); mergeEffect(effectsMap, "사신 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 2.10); mergeEffect(effectsMap, "사신 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.50); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", 1.50); mergeEffect(effectsMap, "사신 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); break; // 기본 2.5% + 100% 증가분(2.5%) = 5.0%
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", 1.70); mergeEffect(effectsMap, "사신 스킬 피증", 1.70); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", 1.90); mergeEffect(effectsMap, "사신 스킬 피증", 1.90); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", 2.10); mergeEffect(effectsMap, "사신 스킬 피증", 2.10); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        }
    }

    //사신의 부름
    private void calcReapersCall(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break; // 영혼석 획득 제외
                case 17: mergeEffect(effectsMap, "사신 스킬 피증", 14.00); break; // 2% + 12% (사신의 부름 효과) 합산
                case 18: mergeEffect(effectsMap, "사신 스킬 피증", 14.30); break;
                case 19: mergeEffect(effectsMap, "사신 스킬 피증", 14.60); break;
                case 20: mergeEffect(effectsMap, "사신 스킬 피증", 14.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "사신 스킬 피증", 2.00); break; // 영혼석 획득 제외
                case 17: mergeEffect(effectsMap, "사신 스킬 피증", 16.00); break; // 2% + 12% (사신의 부름 효과) 합산
                case 18: mergeEffect(effectsMap, "사신 스킬 피증", 16.30); break;
                case 19: mergeEffect(effectsMap, "사신 스킬 피증", 16.60); break;
                case 20: mergeEffect(effectsMap, "사신 스킬 피증", 16.90); break;
            }
        }
    }

    //살귀의 밤
    private void calcNightOfCarnage(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", -12.00); mergeEffect(effectsMap, "적주피", 8.00); break; // 재감 제외 및 살귀 피증 감소 수치 미반영(중첩 최대값 원칙)
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", -11.70); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", -11.40); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", -11.10); mergeEffect(effectsMap, "적주피", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "살귀 스킬 피증", 3.00); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 17: mergeEffect(effectsMap, "살귀 스킬 피증", -10.00); mergeEffect(effectsMap, "적주피", 8.00); break; // 재감 제외 및 살귀 피증 감소 수치 미반영(중첩 최대값 원칙)
                case 18: mergeEffect(effectsMap, "살귀 스킬 피증", -9.70); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 19: mergeEffect(effectsMap, "살귀 스킬 피증", -9.40); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 20: mergeEffect(effectsMap, "살귀 스킬 피증", -9.10); mergeEffect(effectsMap, "적주피", 8.00); break;
            }
        }
    }
}
