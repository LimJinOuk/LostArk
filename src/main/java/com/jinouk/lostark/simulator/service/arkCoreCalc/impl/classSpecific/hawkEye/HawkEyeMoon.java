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

    //
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

    //
    private void calcHsu21SilverRain(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 36.65); break; // 36.0 + 0.65
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 37.30); break; // 36.65 + 0.65
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 37.95); break; // 37.30 + 0.65
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 39.00); break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 39.65); break; // 36.0 + 0.65
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 40.30); break; // 36.65 + 0.65
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 40.95); break; // 37.30 + 0.65
            }
        }
    }

    //
    private void calcHsu13SpecialExplosive(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "묵법 스킬 피증", 3.50); break;
                case 18: mergeEffect(effectsMap, "묵법 스킬 피증", 3.65); break; // 3.50 + 0.15
                case 19: mergeEffect(effectsMap, "묵법 스킬 피증", 3.80); break; // 3.65 + 0.15
                case 20: mergeEffect(effectsMap, "묵법 스킬 피증", 3.95); break; // 3.80 + 0.15
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "묵법 스킬 피증", 5.50); break;
                case 18: mergeEffect(effectsMap, "묵법 스킬 피증", 5.65); break; // 3.50 + 0.15
                case 19: mergeEffect(effectsMap, "묵법 스킬 피증", 5.80); break; // 3.65 + 0.15
                case 20: mergeEffect(effectsMap, "묵법 스킬 피증", 5.95); break; // 3.80 + 0.15
            }
        }
    }

    //
    private void calcHsu99BirdStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break; // 운명 발동 (수치 변화 없음)
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "아공강", 5.60); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "아공강", 5.60); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "아공강", 5.60); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "아공강", 5.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break; // 운명 발동 (수치 변화 없음)
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "아공강", 8.50); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "아공강", 8.50); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "아공강", 8.50); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "아공강", 8.50); break;
            }
        }
    }

    //
    private void calcHsu08HighTensionCable(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 27.00); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 27.00); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 27.00); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 27.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 40.00); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 40.00); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 40.00); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "묵법 : 미르 새김 스킬 아피강", 40.00); break;
            }
        }
    }

    //
    private void calcHsu37RapidFireAssist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 6.50); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 6.50); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 6.50); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 6.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 14: mergeEffect(effectsMap, "아피강", 1.50); break;
                case 17: mergeEffect(effectsMap, "아피강", 1.50); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 18: mergeEffect(effectsMap, "아피강", 1.67); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 19: mergeEffect(effectsMap, "아피강", 1.84); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
                case 20: mergeEffect(effectsMap, "아피강", 2.01); mergeEffect(effectsMap, "저무는 달 스킬 아피강", 10.00); break;
            }
        }
    }
}
