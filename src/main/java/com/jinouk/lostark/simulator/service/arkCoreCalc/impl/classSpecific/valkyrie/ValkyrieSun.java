package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.valkyrie;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValkyrieSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "발키리";
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


            if ("종언".equals(name)) {
                calcApocalypse(effectsMap, point, grade);
            } else if ("기원".equals(name)) {
                calcGenesis(effectsMap, point, grade);
            } else if ("속삭이는 검".equals(name)) {
                calcWhisperingSword(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //종언
    private void calcApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 11.25); break;
                case 19: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 11.50); break;
                case 20: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 11.75); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 14.25); break;
                case 19: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 14.50); break;
                case 20: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 14.75); break;
            }
        }
    }

    //기원
    private void calcGenesis(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "성휘 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "성휘 스킬 피증", 21.00); break;
                case 17: mergeEffect(effectsMap, "성휘 스킬 피증", 49.50); break;
                case 18: mergeEffect(effectsMap, "성휘 스킬 피증", 49.80); break;
                case 19: mergeEffect(effectsMap, "성휘 스킬 피증", 50.10); break;
                case 20: mergeEffect(effectsMap, "성휘 스킬 피증", 50.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "성휘 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "성휘 스킬 피증", 21.00); break;
                case 17: mergeEffect(effectsMap, "성휘 스킬 피증", 58.50); break;
                case 18: mergeEffect(effectsMap, "성휘 스킬 피증", 58.80); break;
                case 19: mergeEffect(effectsMap, "성휘 스킬 피증", 59.10); break;
                case 20: mergeEffect(effectsMap, "성휘 스킬 피증", 59.40); break;
            }
        }
    }

    //속삭이는 검
    private void calcWhisperingSword(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 33.50); break;
                case 18: mergeEffect(effectsMap, "정의 스킬 피증", 10.45); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 33.50); break;
                case 19: mergeEffect(effectsMap, "정의 스킬 피증", 10.90); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 33.50); break;
                case 20: mergeEffect(effectsMap, "정의 스킬 피증", 11.35); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 33.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "정의 스킬 피증", 10.00); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 38.50); break;
                case 18: mergeEffect(effectsMap, "정의 스킬 피증", 10.45); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 38.50); break;
                case 19: mergeEffect(effectsMap, "정의 스킬 피증", 10.90); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 38.50); break;
                case 20: mergeEffect(effectsMap, "정의 스킬 피증", 11.35); mergeEffect(effectsMap, "단죄의 속삭임 스킬 피증", 38.50); break;
            }
        }
    }
}
