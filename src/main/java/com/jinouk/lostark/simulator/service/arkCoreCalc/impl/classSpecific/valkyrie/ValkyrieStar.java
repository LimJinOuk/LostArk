package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.valkyrie;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValkyrieStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "발키리";
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


            if ("진정한 종언".equals(name)) {
                calcTrueApocalypse(effectsMap, point, grade);
            } else if ("성휘의 집행".equals(name)) {
                calcAstralExecution(effectsMap, point, grade);
            } else if ("강화된 정의".equals(name)) {
                calcEnhancedJustice(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //진정한 종언
    private void calcTrueApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 5.50); break;
                case 18: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 5.75); break;
                case 19: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 6.00); break;
                case 20: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 6.25); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 7.50); break;
                case 18: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 7.75); break;
                case 19: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 8.00); break;
                case 20: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 3.00); mergeEffect(effectsMap, "종언의 빛 스킬 치명타 시 피해량 증가", 8.25); break;
            }
        }
    }

    //성휘의 집행
    private void calcAstralExecution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 70.00); break;
                case 17: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 115.00); break;
                case 18: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 115.90); break;
                case 19: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 116.80); break;
                case 20: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 117.70); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 70.00); break;
                case 17: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 130.00); break;
                case 18: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 130.90); break;
                case 19: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 131.80); break;
                case 20: mergeEffect(effectsMap, "계시의 집행 스킬 피증", 132.70); break;
            }
        }
    }

    //강화된 정의
    private void calcEnhancedJustice(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); break;
                case 17: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 33.50); break;
                case 18: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 34.10); break;
                case 19: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 34.70); break;
                case 20: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 35.30); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); break;
                case 17: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 38.50); break;
                case 18: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 39.10); break;
                case 19: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 39.70); break;
                case 20: mergeEffect(effectsMap, "계시의 진격 스킬 피증", 150.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 40.30); break;
            }
        }
    }
}
