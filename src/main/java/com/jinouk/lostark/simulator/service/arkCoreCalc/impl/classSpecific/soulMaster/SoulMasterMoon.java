package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulMasterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기공사";
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


            if ("금강진체".equals(name)) {
                calcIndestructibleBody(effectsMap, point, grade);
            } else if ("열파전조".equals(name)) {
                calcHeatwaveOmen(effectsMap, point, grade);
            } else if ("회기진천공".equals(name)) {
                calcHeavenlyQiReturn(effectsMap, point, grade);
            } else if ("귀환결".equals(name)) {
                calcReturnFormula(effectsMap, point, grade);
            } else if ("소주천".equals(name)) {
                calcMicrocosmicOrbit(effectsMap, point, grade);
            } else if ("순섬보".equals(name)) {
                calcFlashStep(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //금강진체
    private void calcIndestructibleBody(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 운명 발동 제외
                case 17: mergeEffect(effectsMap, "적주피", 4.50); break; // 1.5 + 3.0 (공속 제외)
                case 18: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 운명 발동 제외
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break; // 1.5 + 3.0 (공속 제외)
                case 18: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
    }

    //열파전조
    private void calcHeatwaveOmen(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 80.00); break; // 경면/재감 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 80.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 80.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 80.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 100.00); break; // 경면/재감 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 100.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 100.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "무공탄 스킬 피증", 100.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }

    //회기진천공
    private void calcHeavenlyQiReturn(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "번천장 스킬 피증", 18.00); break; // 1.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "번천장 스킬 피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "번천장 스킬 피증", 18.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 21.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "번천장 스킬 피증", 21.00); break; // 1.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "번천장 스킬 피증", 21.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "번천장 스킬 피증", 21.00); break;
            }
        }
    }

    //귀환결
    private void calcReturnFormula(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 4.50); break; // 1.5 + 3.0
                case 18: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break; // 1.5 + 3.0
                case 18: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
    }

    //소주천
    //운기조식 상태
    private void calcMicrocosmicOrbit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 70.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 70.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 70.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 70.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 75.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 75.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 75.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 75.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }

    //순섬보
    private void calcFlashStep(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 19.00); break; // 일반 상태 조건부 적주피
                case 14: mergeEffect(effectsMap, "적주피", 19.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 30.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 30.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 30.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 30.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 19.00); break; // 일반 상태 조건부 적주피
                case 14: mergeEffect(effectsMap, "적주피", 19.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 35.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 19.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
    }
}
