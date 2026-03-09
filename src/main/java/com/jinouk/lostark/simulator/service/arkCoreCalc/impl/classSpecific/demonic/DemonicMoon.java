package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.demonic;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemonicMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "데모닉";
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


            if ("블러디 데몬".equals(name)) {
                calcBloodyDemon(effectsMap, point, grade);
            } else if ("고어 블리딩".equals(name)) {
                calcGoreBleeding(effectsMap, point, grade);
            } else if ("제노사이드".equals(name)) {
                calcGenocide(effectsMap, point, grade);
            } else if ("트리니티 코어".equals(name)) {
                calcTrinityCore(effectsMap, point, grade);
            } else if ("듀얼 코어".equals(name)) {
                calcDualCore(effectsMap, point, grade);
            } else if ("서브 스톰".equals(name)) {
                calcSubStorm(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //블러디 데몬
    private void calcBloodyDemon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 7.90); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.70); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 8.90); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "악마 스킬 피증", 9.10); break;
            }
        }
    }

    //고어 블리딩
    private void calcGoreBleeding(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", 2.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 45.00); break;
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", 2.20); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 45.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", 2.40); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 45.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "악마 스킬 피증", 1.80); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 54.00); break;
                case 18: mergeEffect(effectsMap, "악마 스킬 피증", 2.00); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 54.00); break;
                case 19: mergeEffect(effectsMap, "악마 스킬 피증", 2.20); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 54.00); break;
                case 20: mergeEffect(effectsMap, "악마 스킬 피증", 2.40); mergeEffect(effectsMap, "블러드 피어싱 스킬 피증", 54.00); break;
            }
        }
    }

    //제노사이드
    private void calcGenocide(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 18.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블러드 제노사이드 스킬 피증", 21.00); mergeEffect(effectsMap, "악마 스킬 피증", 0.60); break;
            }
        }
    }

    //트리니티 코어
    private void calcTrinityCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 9.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 9.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); break;
                case 19: mergeEffect(effectsMap, "피증", 9.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); break;
                case 20: mergeEffect(effectsMap, "피증", 10.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 10.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 10.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); break;
                case 19: mergeEffect(effectsMap, "피증", 10.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); break;
                case 20: mergeEffect(effectsMap, "피증", 11.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); break;
            }
        }
    }

    //듀얼 코어
    private void calcDualCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 23.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 23.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 23.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 23.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "잠식 스킬 피증", 1.50); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.70); mergeEffect(effectsMap, "잠식 스킬 피증", 1.70); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 27.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.90); mergeEffect(effectsMap, "잠식 스킬 피증", 1.90); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 27.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "잠식 스킬 피증", 2.10); mergeEffect(effectsMap, "스톰 그라인딩 스킬 피증", 27.00); break;
            }
        }
    }

    //서브 스톰
    private void calcSubStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 14: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 17: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 52.00); break;
                case 18: mergeEffect(effectsMap, "피증", -29.80); mergeEffect(effectsMap, "잠식 스킬 피증", 52.20); break;
                case 19: mergeEffect(effectsMap, "피증", -29.60); mergeEffect(effectsMap, "잠식 스킬 피증", 52.40); break;
                case 20: mergeEffect(effectsMap, "피증", -29.40); mergeEffect(effectsMap, "잠식 스킬 피증", 52.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 14: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 46.00); break;
                case 17: mergeEffect(effectsMap, "피증", -30.00); mergeEffect(effectsMap, "잠식 스킬 피증", 53.00); break;
                case 18: mergeEffect(effectsMap, "피증", -29.80); mergeEffect(effectsMap, "잠식 스킬 피증", 53.20); break;
                case 19: mergeEffect(effectsMap, "피증", -29.60); mergeEffect(effectsMap, "잠식 스킬 피증", 53.40); break;
                case 20: mergeEffect(effectsMap, "피증", -29.40); mergeEffect(effectsMap, "잠식 스킬 피증", 53.60); break;
            }
        }
    }
}
