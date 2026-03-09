package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.valkyrie;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValkyrieMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "발키리";
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


            if ("종언의 기사".equals(name)) {
                calcKnightOfApocalypse(effectsMap, point, grade);
            } else if ("빛의 안식".equals(name)) {
                calcRestInLight(effectsMap, point, grade);
            } else if ("눈부신 정의".equals(name)) {
                calcDazzlingJustice(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //종언의 기사
    private void calcKnightOfApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 12.25); break;
                case 19: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 12.50); break;
                case 20: mergeEffect(effectsMap, "종언의 빛 스킬 피증", 12.75); break;
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

    //빛의 안식
    private void calcRestInLight(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 12.30); break;
                case 19: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 12.60); break;
                case 20: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 12.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 15.30); break;
                case 19: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 15.60); break;
                case 20: mergeEffect(effectsMap, "안식의 비 스킬 피증", 5.00); mergeEffect(effectsMap, "안식의 재 스킬 피증", 5.00); mergeEffect(effectsMap, "성휘 스킬 피증", 15.90); break;
            }
        }
    }

    //눈부신 정의
    private void calcDazzlingJustice(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); break;
                case 14: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 20.45); break;
                case 19: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 20.90); break;
                case 20: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 21.35); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); break;
                case 14: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 25.45); break;
                case 19: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 25.90); break;
                case 20: mergeEffect(effectsMap, "단죄의 성흔 스킬 피증", 40.00); mergeEffect(effectsMap, "정의 스킬 피증", 26.35); break;
            }
        }
    }
}
