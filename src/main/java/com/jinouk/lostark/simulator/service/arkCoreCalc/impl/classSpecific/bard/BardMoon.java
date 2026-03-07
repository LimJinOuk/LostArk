package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.bard;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BardMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "바드";
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

            if ("기원의 세레나데".equals(name)) {
                calcOriginSerenade(effectsMap, point, grade);
            } else if ("세컨드 임팩트".equals(name)) {
                calcSecondImpact(effectsMap, point, grade);
            } else if ("조화의 연주".equals(name)) {
                calcPerfomanceHarmony(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //기원의 세레나데
    private void calcOriginSerenade(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 26.50); break;
                case 18: mergeEffect(effectsMap, "피증", 26.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "피증", 26.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "피증", 26.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.80); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 36.50); break;
                case 18: mergeEffect(effectsMap, "피증", 36.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "피증", 36.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "피증", 36.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.80); break;
            }
        }
    }

    //세컨드 임팩트
    private void calcSecondImpact(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "템페스트 스킬 피증", 10.00); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "템페스트 스킬 피증", 10.24); break; // 10.0 + 0.24
                case 19: mergeEffect(effectsMap, "템페스트 스킬 피증", 10.48); break; // 10.24 + 0.24
                case 20: mergeEffect(effectsMap, "템페스트 스킬 피증", 10.72); break; // 10.48 + 0.24
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "템페스트 스킬 피증", 12.50); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "템페스트 스킬 피증", 12.74); break; // 10.0 + 0.24
                case 19: mergeEffect(effectsMap, "템페스트 스킬 피증", 12.98); break; // 10.24 + 0.24
                case 20: mergeEffect(effectsMap, "템페스트 스킬 피증", 13.22); break; // 10.48 + 0.24
            }
        }
    }

    //조화의 연주
    private void calcPerfomanceHarmony(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "피증", 17.00); break;
                case 18: mergeEffect(effectsMap, "피증", 17.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 0.90); break;
                case 19: mergeEffect(effectsMap, "피증", 17.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 1.80); break;
                case 20: mergeEffect(effectsMap, "피증", 17.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 2.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "피증", 20.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 0.90); break;
                case 19: mergeEffect(effectsMap, "피증", 20.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 1.80); break;
                case 20: mergeEffect(effectsMap, "피증", 20.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 2.70); break;
            }
        }
    }
}
