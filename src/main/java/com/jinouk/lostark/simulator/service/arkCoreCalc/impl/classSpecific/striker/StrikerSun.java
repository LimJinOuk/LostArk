package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.striker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StrikerSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스트라이커";
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


            if ("호령".equals(name)) {
                calcCommandingRoar(effectsMap, point, grade);
            } else if ("광폭".equals(name)) {
                calcBerserk(effectsMap, point, grade);
            } else if ("뇌호".equals(name)) {
                calcThunderTiger(effectsMap, point, grade);
            } else if ("광파섬".equals(name)) {
                calcLightWaveFlash(effectsMap, point, grade);
            } else if ("산군".equals(name)) {
                calcMountainLord(effectsMap, point, grade);
            } else if ("외공".equals(name)) {
                calcExternalMartialArts(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //호령
    private void calcCommandingRoar(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 6.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.00); break; // 1.55 + 5.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 6.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.45); break; // 13.0 + 0.45
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 6.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.90); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 6.55); mergeEffect(effectsMap, "오의 스킬 치피증", 14.35); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.00); break; // 1.55 + 5.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.45); break; // 13.0 + 0.45
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); mergeEffect(effectsMap, "오의 스킬 치피증", 13.90); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); mergeEffect(effectsMap, "오의 스킬 치피증", 14.35); break;
            }
        }
    }

    //광폭
    private void calcBerserk(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); break; // 공속 제외
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 90.00); break; // 30.0 * 3중첩, 재감 제외
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 90.00); mergeEffect(effectsMap, "피증", 1.20); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 90.00); mergeEffect(effectsMap, "피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 90.00); mergeEffect(effectsMap, "피증", 3.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); break; // 공속 제외
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 105.00); break; // 30.0 * 3중첩, 재감 제외
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 105.00); mergeEffect(effectsMap, "피증", 1.20); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 105.00); mergeEffect(effectsMap, "피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 피증", 10.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 105.00); mergeEffect(effectsMap, "피증", 3.60); break;
            }
        }
    }

    //뇌호
    private void calcThunderTiger(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 27.00); break; // 버블 증가/초기화 제외
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 27.00); break;// 초기화/마나/버블 제외
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 35.00); break; // 27.0 + 8.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 35.28); break; // 35.0 + 0.28
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 35.56); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 35.84); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 27.00); break; // 버블 증가/초기화 제외
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 27.00); break;// 초기화/마나/버블 제외
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 37.50); break; // 27.0 + 8.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 37.78); break; // 35.0 + 0.28
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 38.06); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", -8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 38.34); break;
            }
        }
    }

    //광파섬
    private void calcLightWaveFlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 11.00); break; // 2.0 + 9.0 (속도 제외)
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 14.00); break; // 2.0 + 12.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 14.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.26); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 14.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.52); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 14.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.78); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 11.00); break; // 2.0 + 9.0 (속도 제외)
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 15.00); break; // 2.0 + 12.0
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.26); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.52); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.78); break;
            }
        }
    }

    //산군
    //(오의: 뇌호격을 제외한..)
    private void calcMountainLord(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 100.00); mergeEffect(effectsMap, "피증", 30.00); break; // 재감 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 110.00); mergeEffect(effectsMap, "피증", 30.00); break; // 20 -> 30 변경 반영
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 110.00); mergeEffect(effectsMap, "피증", 30.00); break; // 1.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 110.00); mergeEffect(effectsMap, "피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 110.00); mergeEffect(effectsMap, "피증", 30.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 100.00); mergeEffect(effectsMap, "피증", 30.00); break; // 재감 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 112.00); mergeEffect(effectsMap, "피증", 30.00); break; // 20 -> 30 변경 반영
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 112.00); mergeEffect(effectsMap, "피증", 30.00); break; // 1.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 112.00); mergeEffect(effectsMap, "피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "오의 스킬 피증", -80.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 112.00); mergeEffect(effectsMap, "피증", 30.00); break;
            }
        }
    }

    //외공
    private void calcExternalMartialArts(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); break; // 1.8 + 45.0 (마나 제외)
                case 17: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 18: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "치피증", 1.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); break; // 1.8 + 45.0 (마나 제외)
                case 17: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 4.50); break;
                case 18: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 46.80); mergeEffect(effectsMap, "오의 스킬 피증", -45.00); mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "치피증", 1.50); break;
            }
        }
    }
}
