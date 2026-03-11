package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.holyKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HolyKnightSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "홀리나이트";
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


            if ("신의 권능".equals(name)) {
                calcDivinePower(effectsMap, point, grade);
            } else if ("성스러운 일격".equals(name)) {
                calcHolyStrike(effectsMap, point, grade);
            } else if ("심판 예고".equals(name)) {
                calcJudgmentHerald(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //신의 권능
    private void calcDivinePower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break; // 재사용 대기시간 초기화 중첩 획득
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 35.00); break; // 10.0 + 25.0
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 36.00); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 37.00); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 38.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 10.00); break; // 재사용 대기시간 초기화 중첩 획득
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 40.50); break; // 10.0 + 25.0
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 41.50); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 42.50); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 43.50); break;
            }
        }
    }

    //성스러운 일격
    private void calcHolyStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "신성검 스킬 피증", 17.00); break;
                case 14: mergeEffect(effectsMap, "신성검 스킬 피증", 52.00); break; // 17.0 + 35.0
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 99.00); break; // 17.0 + 82.0 (피증량 변경 반영)
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 99.80); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 100.60); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 101.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "신성검 스킬 피증", 17.00); break;
                case 14: mergeEffect(effectsMap, "신성검 스킬 피증", 52.00); break; // 17.0 + 35.0
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 104.00); break; // 17.0 + 82.0 (피증량 변경 반영)
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 104.80); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 105.60); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 106.40); break;
            }
        }
    }

    //심판 예고
    private void calcJudgmentHerald(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break; // 연속 발동 및 초기화 효과
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 18.00); break; // 10.0 + 8.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 18.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 19.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 19.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 10.00); break; // 연속 발동 및 초기화 효과
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 22.00); break; // 10.0 + 8.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 22.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 23.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 23.80); break;
            }
        }
    }
}
