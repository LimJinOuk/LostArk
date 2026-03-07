package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.bard;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BardSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "바드";
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

            if ("불굴의 세레나데".equals(name)) {
                calcIndomitableSerenade(effectsMap, point, grade);
            } else if ("템페스트 리프레인".equals(name)) {
                calcTempestRefrain(effectsMap, point, grade);
            } else if ("쇼크 루프".equals(name)) {
                calcShockLoop(effectsMap,point,grade);
            }
        });


        logEffects(getArkGridCoreName(), effectsMap);
        return new ArkGridResponseDto(effectsMap);
    }

    //불굴의 세레나데
    private void calcIndomitableSerenade(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break; // 1.5 + 2.5
                case 17: mergeEffect(effectsMap, "피증", 4.50); break; // 1.5 + 4.5
                case 18: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.80); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break; // 1.5 + 2.5
                case 17: mergeEffect(effectsMap, "피증", 6.00); break; // 1.5 + 4.5
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "음파 진동 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "음파 진동 스킬 피증", 1.80); break;
            }
        }
    }

    //템페스트 리프레인
    //진욱쿤 질문(2 버블? 14포 17포)
    private void calcTempestRefrain(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.00); break; // 3.0 + 28.0
                case 17: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.00); mergeEffect(effectsMap, "피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.24); mergeEffect(effectsMap, "피증", 22.00); break;
                case 19: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.48); mergeEffect(effectsMap, "피증", 22.00); break;
                case 20: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.72); mergeEffect(effectsMap, "피증", 22.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "템페스트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.00); break; // 3.0 + 28.0
                case 17: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.00); mergeEffect(effectsMap, "피증", 26.00); break;
                case 18: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.24); mergeEffect(effectsMap, "피증", 26.00); break;
                case 19: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.48); mergeEffect(effectsMap, "피증", 26.00); break;
                case 20: mergeEffect(effectsMap, "템페스트 스킬 피증", 31.72); mergeEffect(effectsMap, "피증", 26.00); break;
            }
        }
    }

    //쇼크 루프
    //진욱쿤 질문(17포)
    private void calcShockLoop(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 30.00); break;
                case 14: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 50.00); break; // 30.0 + 10.0 (쇼크 루프 효과)
                case 18: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 50.90); break;
                case 19: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 51.80); break;
                case 20: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 52.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 30.00); break;
                case 14: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 70.00); break; // 30.0 + 10.0 (쇼크 루프 효과)
                case 18: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 70.90); break;
                case 19: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 71.80); break;
                case 20: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 72.70); break;
            }
        }
    }
}
