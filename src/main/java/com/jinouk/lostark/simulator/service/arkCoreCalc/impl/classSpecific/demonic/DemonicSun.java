package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.demonic;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemonicSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "데모닉";
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


            if ("블러드 매서커".equals(name)) {
                calcBloodMassacre(effectsMap, point, grade);
            } else if ("이터널 블러드".equals(name)) {
                calcEternalBlood(effectsMap, point, grade);
            } else if ("오미너스".equals(name)) {
                calcOminous(effectsMap, point, grade);
            } else if ("서프레서".equals(name)) {
                calcSuppressor(effectsMap, point, grade);
            } else if ("서징 스톰".equals(name)) {
                calcSurgingStorm(effectsMap, point, grade);
            } else if ("매시브 컨슘".equals(name)) {
                calcMassiveConsume(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //블러드 매서커
    private void calcBloodMassacre(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 3.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.90); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 3.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.90); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 9.10); break;
            }
        }
    }

    //이터널 블러드
    private void calcEternalBlood(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); break; // 7.0 * 3중첩
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 48.00); break; // 8.0 * 6중첩
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", 2.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 48.00); break;
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", 2.20); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 48.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", 2.40); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 48.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); break; // 7.0 * 3중첩
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 57.00); break; // 8.0 * 6중첩
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", 2.00); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 57.00); break;
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", 2.20); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 57.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", 2.40); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 57.00); break;
            }
        }
    }

    //오미너스
    private void calcOminous(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", -28.20); break; // 1.8 - 30.0
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", -28.20); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", -28.00); mergeEffect(effectsMap, "적주피", 5.00); break; // -28.2 + 0.2
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", -27.80); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", -27.60); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", -28.20); break; // 1.8 - 30.0
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", -28.20); mergeEffect(effectsMap, "적주피", 6.00); break;
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", -28.00); mergeEffect(effectsMap, "적주피", 6.00); break; // -28.2 + 0.2
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", -27.80); mergeEffect(effectsMap, "적주피", 6.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", -27.60); mergeEffect(effectsMap, "적주피", 6.00); break;
            }
        }
    }

    //서프레서
    private void calcSuppressor(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 98.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 98.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 98.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 98.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 108.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 108.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 108.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "쓰러스트 임팩트 스킬 피증", 108.00); break;
            }
        }
    }

    //서징 스톰
    private void calcSurgingStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 19: mergeEffect(effectsMap, "피증", 4.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 20: mergeEffect(effectsMap, "피증", 5.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 4.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 5.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 18: mergeEffect(effectsMap, "피증", 5.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 19: mergeEffect(effectsMap, "피증", 5.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
                case 20: mergeEffect(effectsMap, "피증", 6.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", -24.00); break;
            }
        }
    }

    //매시브 컨슘
    private void calcMassiveConsume(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 14: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 86.00); break;
                case 17: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 106.00); break;
                case 18: mergeEffect(effectsMap, "피증", -29.80); mergeEffect(effectsMap, "잠식 스킬 피증", 106.20); break;
                case 19: mergeEffect(effectsMap, "피증", -29.60); mergeEffect(effectsMap, "잠식 스킬 피증", 106.40); break;
                case 20: mergeEffect(effectsMap, "피증", -29.40); mergeEffect(effectsMap, "잠식 스킬 피증", 106.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 14: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 86.00); break;
                case 17: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 110.00); break;
                case 18: mergeEffect(effectsMap, "피증", -29.80); mergeEffect(effectsMap, "잠식 스킬 피증", 110.20); break;
                case 19: mergeEffect(effectsMap, "피증", -29.60); mergeEffect(effectsMap, "잠식 스킬 피증", 110.40); break;
                case 20: mergeEffect(effectsMap, "피증", -29.40); mergeEffect(effectsMap, "잠식 스킬 피증", 110.60); break;
            }
        }
    }
}
