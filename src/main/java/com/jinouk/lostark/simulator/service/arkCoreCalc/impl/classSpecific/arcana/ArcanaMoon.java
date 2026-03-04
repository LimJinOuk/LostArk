package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.arcana;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArcanaMoon extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "아르카나";
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


            if ("엣지 콤보".equals(name)) {
                calcEdgeCombo(effectsMap, point, grade);
            } else if ("체인 드로우".equals(name)) {
                calcChainDraw(effectsMap, point, grade);
            } else if("루인 풀셋".equals(name)) {
                calcRuin(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    private void calcEdgeCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap,"피증",5.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",5.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",5.00); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",5.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap,"피증",6.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",6.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",6.00); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",6.00); break;
            }
        }
    }
    private void calcChainDraw(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); break;
                case 17: mergeEffect(effectsMap,"피증",1.60); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",1.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",1.90); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",2.05); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); break;
                case 17: mergeEffect(effectsMap,"피증",1.60); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",1.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",1.90); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",2.05); break;
            }
        }
    }
    private void calcRuin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.80); break;
                case 14: mergeEffect(effectsMap, "피증", 2.80); break;
                case 17: mergeEffect(effectsMap,"피증",1.60); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",1.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",1.90); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",2.05); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); break;
                case 17: mergeEffect(effectsMap,"피증",1.60); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap,"피증",1.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap,"피증",1.90); break;
                case 120: mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap,"피증",2.05); break;
            }
        }
    }
}
