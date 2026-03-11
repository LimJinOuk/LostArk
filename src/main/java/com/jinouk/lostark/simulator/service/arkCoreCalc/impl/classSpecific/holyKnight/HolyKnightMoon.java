package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.holyKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HolyKnightMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "홀리나이트";
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


            if ("징벌의 시간".equals(name)) {
                calcPunishmentTime(effectsMap, point, grade);
            } else if ("천상의 검".equals(name)) {
                calcCelestialSword(effectsMap, point, grade);
            } else if ("심판의 시간".equals(name)) {
                calcJudgmentTime(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //징벌의 시간
    private void calcPunishmentTime(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 30.00); break; // 10.0 + 20.0
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 31.00); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 32.00); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 33.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 34.00); break; // 10.0 + 20.0
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 36.00); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 37.00); break;
            }
        }
    }

    //천상의 검
    private void calcCelestialSword(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기시간 감소 효과
                case 14: break;
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 35.80); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 36.60); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 37.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 재사용 대기시간 감소 효과
                case 14: break;
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 40.80); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 41.60); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 42.40); break;
            }
        }
    }

    //심판의 시간
    private void calcJudgmentTime(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 34.00); break; // 10.0 + 24.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 34.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 35.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 35.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 38.00); break; // 10.0 + 24.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 38.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 39.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 39.80); break;
            }
        }
    }
}
