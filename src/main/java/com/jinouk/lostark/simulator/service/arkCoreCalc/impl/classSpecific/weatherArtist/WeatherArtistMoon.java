package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.weatherArtist;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherArtistMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기상술사";
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


            if ("우산의 춤".equals(name)) {
                calcUmbrellaDance(effectsMap, point, grade);
            } else if ("상승기류".equals(name)) {
                calcUpdraft(effectsMap, point, grade);
            } else if ("쾌속".equals(name)) {
                calcHighSpeed(effectsMap, point, grade);
            } else if ("비바람이 치던 바다".equals(name)) {
                calcStormySea(effectsMap, point, grade);
            } else if ("가랑비".equals(name)) {
                calcDrizzle(effectsMap, point, grade);
            } else if ("뜨거운 햇볕".equals(name)) {
                calcScorchingSun(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //우산의 춤
    private void calcUmbrellaDance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 8.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "우산 스킬 피증", 2.20); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 8.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "우산 스킬 피증", 2.40); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 8.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "우산 스킬 피증", 2.60); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 8.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 12.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "우산 스킬 피증", 2.20); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 12.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "우산 스킬 피증", 2.40); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 12.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "우산 스킬 피증", 2.60); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 12.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 12.00); break;
            }
        }
    }

    //상승기류
    //기류 보호막
    private void calcUpdraft(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "치명타 시 피해량 증가", 6.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "치명타 시 피해량 증가", 6.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치명타 시 피해량 증가", 6.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "치명타 시 피해량 증가", 6.00); break;
            }
        }
    }

    //쾌속
    private void calcHighSpeed(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break; // 0% 증가이므로 수치 변화 없음
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 9.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 9.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 11.00); break; // 0% 증가이므로 수치 변화 없음
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 11.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 12.50); break;
            }
        }
    }

    //비바람이 치던 바다
    //여우비 상태
    private void calcStormySea(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "기상 스킬 피증", 3.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "기상 스킬 피증", 3.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "기상 스킬 피증", 3.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "기상 스킬 피증", 3.50); break;
            }
        }
    }

    //가랑비
    private void calcDrizzle(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 57.00); break; // 12.0 + 45.0
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 58.20); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 59.40); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 60.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 67.00); break; // 12.0 + 45.0
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 68.20); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 69.40); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 70.60); break;
            }
        }
    }

    //뜨거운 햇볕
    private void calcScorchingSun(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break; // 0% 증가이므로 상속
                case 18: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 1.00); break;
                case 19: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 2.00); mergeEffect(effectsMap, "싹슬바람 스킬 피증", 2.00); break; // 0% 증가이므로 상속
                case 18: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 3.00); mergeEffect(effectsMap, "싹슬바람 스킬 피증", 2.00); break; // 0% 증
                case 19: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); mergeEffect(effectsMap, "싹슬바람 스킬 피증", 2.00); break; // 0% 증
                case 20: mergeEffect(effectsMap, "기상 스킬 피증", 1.50); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 5.00); mergeEffect(effectsMap, "싹슬바람 스킬 피증", 2.00); break; // 0% 증
            }
        }
    }
}
