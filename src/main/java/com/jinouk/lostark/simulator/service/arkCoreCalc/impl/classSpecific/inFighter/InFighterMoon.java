package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.inFighter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InFighterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "인파이터";
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


            if ("충격 강화".equals(name)) {
                calcImpactReinforce(effectsMap, point, grade);
            } else if ("대지 연타".equals(name)) {
                calcEarthMultiStrike(effectsMap, point, grade);
            } else if ("기력 절약".equals(name)) {
                calcEnergySaving(effectsMap, point, grade);
            } else if ("투지 강화".equals(name)) {
                calcFightingSpiritReinforce(effectsMap, point, grade);
            } else if ("치명적인 도약".equals(name)) {
                calcDeadlyLeap(effectsMap, point, grade);
            } else if ("상시 강화".equals(name)) {
                calcConstantReinforce(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //충격 강화
    private void calcImpactReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "충격 스킬 치피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.70); mergeEffect(effectsMap, "충격 스킬 치피증", 14.00); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.90); mergeEffect(effectsMap, "충격 스킬 치피증", 14.00); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 2.10); mergeEffect(effectsMap, "충격 스킬 치피증", 14.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "충격 스킬 치피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.70); mergeEffect(effectsMap, "충격 스킬 치피증", 18.00); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.90); mergeEffect(effectsMap, "충격 스킬 치피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 2.10); mergeEffect(effectsMap, "충격 스킬 치피증", 18.00); break;
            }
        }
    }

    //대지 연타
    private void calcEarthMultiStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 5.00); break; // 재감 6초 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 5.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 5.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 5.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 9.00); break; // 재감 6초 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "연환파신권 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        }
    }

    //기력 절약
    private void calcEnergySaving(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); break; // 기력 소모 감소 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); break; // 기력 소모 감소 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        }
    }

    //투지 강화
    private void calcFightingSpiritReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 14.50); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 14.70);  break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 14.90);  break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 15.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 16.50); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 16.70);  break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 16.90);  break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 17.10); break;
            }
        }
    }

    //치명적인 도약
    private void calcDeadlyLeap(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 90.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.70); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 90.00); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.90); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 90.00); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 2.10); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 90.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 110.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.70); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 110.00); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.90); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 110.00); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 2.10); mergeEffect(effectsMap, "용의 강림 스킬 치피증", 110.00); break;
            }
        }
    }

    //상시 강화
    private void calcConstantReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 12.50); break; // 1.5 + 11.0 (투지발산 아닐 때)
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 12.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 12.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 12.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 14.50); break; // 1.5 + 11.0 (투지발산 아닐 때)
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 14.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 14.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 14.50); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        }
    }
}
