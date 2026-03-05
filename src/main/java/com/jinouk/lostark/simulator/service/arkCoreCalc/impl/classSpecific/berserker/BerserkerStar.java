package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.berserker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BerserkerStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "버서커";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 별 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("분쇄 폭풍".equals(name)) {
                calcCrushingStorm(effectsMap, point, grade);
            } else if ("오버플로우".equals(name)) {
                calcOverflow(effectsMap, point, grade);
            } else if ("브레이크 아웃".equals(name)) {
                calcBreakOut(effectsMap, point, grade);
            } else if ("광란".equals(name)) {
                calcMadness(effectsMap, point, grade);
            } else if ("연참".equals(name)) {
                calcYeoncham(effectsMap, point, grade);
            } else if ("지옥 뒤집기".equals(name)) {
                calcHellFlip(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //분쇄 폭풍
    private void calcCrushingStorm(Map<String, Double> effectsMap, int point, String grade) {
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

    //오버플로우
    private void calcOverflow(Map<String, Double> effectsMap, int point, String grade) {
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

    //브레이크 아웃
    private void calcBreakOut(Map<String, Double> effectsMap, int point, String grade) {
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

    //광란
    private void calcMadness(Map<String, Double> effectsMap, int point, String grade) {
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

    //연참
    private void calcYeoncham(Map<String, Double> effectsMap, int point, String grade) {
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

    //지옥 뒤집기
    private void calcHellFlip(Map<String, Double> effectsMap, int point, String grade) {
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
