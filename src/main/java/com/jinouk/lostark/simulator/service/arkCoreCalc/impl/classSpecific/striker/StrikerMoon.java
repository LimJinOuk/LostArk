package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.striker;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StrikerMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스트라이커";
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


            if ("천뢰포효".equals(name)) {
                calcHeavenlyThunderRoar(effectsMap, point, grade);
            } else if ("호뢰진".equals(name)) {
                calcTigerThunderFormation(effectsMap, point, grade);
            } else if ("벽뢰호각".equals(name)) {
                calcBlueThunderTigerStrike(effectsMap, point, grade);
            } else if ("풍뢰보".equals(name)) {
                calcWindThunderStep(effectsMap, point, grade);
            } else if ("뇌호파천".equals(name)) {
                calcThunderTigerSkyBreaker(effectsMap, point, grade);
            } else if ("파한오의".equals(name)) {
                calcChillBreakingUltimate(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //천뢰포효
    private void calcHeavenlyThunderRoar(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 5.05); break; // 1.55 + 3.5
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 5.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 5.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 5.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.63); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 6.05); break; // 1.55 + 3.5
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 6.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 6.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 6.05); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 0.63); break;
            }
        }
    }

    //호뢰진
    private void calcTigerThunderFormation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 55.00);   // 재감/게이지 제외
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 55.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 55.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 55.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 4.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 68.00);   // 재감/게이지 제외
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 68.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 68.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "광폭진 스킬 적주피", 68.00); mergeEffect(effectsMap, "광폭진 스킬 피증", 4.50); break;
            }
        }
    }

    //벽뢰호각
    private void calcBlueThunderTigerStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 10.50); break; // 2.5 + 8.0
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 10.78); break; // 10.5 + 0.28
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 11.06); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 11.34); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 13.00); break; // 2.5 + 8.0
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 13.28); break; // 10.5 + 0.28
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 13.56); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 13.83); break;
            }
        }
    }

    //풍뢰보
    private void calcWindThunderStep(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.55); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.10); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.65); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.55); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.10); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 2.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.65); break;
            }
        }
    }

    //뇌호파천
    private void calcThunderTigerSkyBreaker(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.63); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.21); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.42); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.63); break;
            }
        }
    }

    //파한오의
    private void calcChillBreakingUltimate(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "피증", 4.80); break; // 1.8 + 3.0 (재감 제외)
                case 18: mergeEffect(effectsMap, "피증", 5.00); break; // 4.8 + 0.2
                case 19: mergeEffect(effectsMap, "피증", 5.20); break;
                case 20: mergeEffect(effectsMap, "피증", 5.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "피증", 5.80); break; // 1.8 + 3.0 (재감 제외)
                case 18: mergeEffect(effectsMap, "피증", 6.00); break; // 4.8 + 0.2
                case 19: mergeEffect(effectsMap, "피증", 6.20); break;
                case 20: mergeEffect(effectsMap, "피증", 6.40); break;
            }
        }
    }
}
