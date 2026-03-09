package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.hawkEye;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HawkEyeMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "호크아이";
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

            if ("HSU-98 버드 스트라이크".equals(name)) {
                calcHsu98BirdStrike(effectsMap, point, grade);
            } else if ("HSU-21 실버 레인".equals(name)) {
                calcHsu21SilverRain(effectsMap, point, grade);
            } else if ("HSU-13 특제 고폭약".equals(name)) {
                calcHsu13SpecialExplosive(effectsMap, point, grade);
            } else if ("HSU-99 버드 스톰".equals(name)) {
                calcHsu99BirdStorm(effectsMap, point, grade);
            } else if ("HSU-08 고강도 케이블".equals(name)) {
                calcHsu08HighTensionCable(effectsMap, point, grade);
            } else if ("HSU-37 연사 보조기".equals(name)) {
                calcHsu37RapidFireAssist(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //HSU-98 버드 스트라이
    private void calcHsu98BirdStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 피증", 28.00); break; // 3.0 + 4.0
                case 18: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 피증", 28.00); mergeEffect(effectsMap, "치명타 적중 시 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 피증", 28.00); mergeEffect(effectsMap, "치명타 적중 시 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 피증", 28.00); mergeEffect(effectsMap, "치명타 적중 시 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.00); break; // 6.0 + 7.0
                case 18: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.40); break; // 13.0 + 0.4
                case 19: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.80); break; // 13.4 + 0.4
                case 20: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 14.20); break; // 13.8 + 0.4
            }
        }
    }

    //HSU-21 실버 레인
    private void calcHsu21SilverRain(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 28.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 29.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 31.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 34.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 36.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 37.00); break;
            }
        }
    }

    //HSU-13 특제 고폭약
    private void calcHsu13SpecialExplosive(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 3.50); break; // 1.5 + 2.0
                case 18: mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 1.40); break;
                case 19: mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 2.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 4.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 4.50); break; // 1.5 + 2.0
                case 18: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 1.40); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 2.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "크레모아 지뢰 스킬 적주피", 4.20); break;
            }
        }
    }

    //HSU-99 버드 스톰
    private void calcHsu99BirdStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 34.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break; // 10.0 + 24.0
                case 18: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 34.60); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.60); break;
                case 19: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 35.20); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.20); break;
                case 20: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 35.80); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 14: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 40.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break; // 10.0 + 24.0
                case 18: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 40.60); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.60); break;
                case 19: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 41.20); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.20); break;
                case 20: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 41.80); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.80); break;
            }
        }
    }

    //HSU-08 고강도 케이블
    private void calcHsu08HighTensionCable(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 10.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 11.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 11.80); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 15.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 16.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 16.80); break;
            }
        }
    }

    //HSU-37 연사 보조기
    private void calcHsu37RapidFireAssist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 30.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 31.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 32.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 36.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 37.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 37.40); break;
            }
        }
    }
}
