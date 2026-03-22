package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.weatherArtist;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherArtistSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기상술사";
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


            if ("비연참".equals(name)) {
                calcSwallowSlash(effectsMap, point, grade);
            } else if ("기류 조절".equals(name)) {
                calcAirflowControl(effectsMap, point, grade);
            } else if ("바람의 칼날".equals(name)) {
                calcBladeOfWind(effectsMap, point, grade);
            } else if ("싸라기눈".equals(name)) {
                calcGraupel(effectsMap, point, grade);
            } else if ("마른 하늘에 날벼락".equals(name)) {
                calcBoltFromTheBlue(effectsMap, point, grade);
            } else if ("해와 바람".equals(name)) {
                calcSunAndWind(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //비연참
    private void calcSwallowSlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break; // 0% 증가 및 보호막 생성은 상속
                case 18: mergeEffect(effectsMap, "우산 스킬 피증", 2.20); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 19: mergeEffect(effectsMap, "우산 스킬 피증", 2.40); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "우산 스킬 피증", 2.60); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "우산 스킬 피증", 2.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "우산 스킬 피증", 3.00); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break; // 0% 증가 및 보호막 생성은 상속
                case 18: mergeEffect(effectsMap, "우산 스킬 피증", 3.20); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 19: mergeEffect(effectsMap, "우산 스킬 피증", 3.40); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "우산 스킬 피증", 3.60); mergeEffect(effectsMap, "회오리 걸음 스킬 피증", 5.00); mergeEffect(effectsMap, "몰아치기 스킬 피증", 5.00); mergeEffect(effectsMap, "바람송곳 스킬 피증", 5.00); mergeEffect(effectsMap, "칼바람 스킬 피증", 5.00); break;
            }
        }
    }

    //기류 조절
    //기류 보호막 보유 중
    private void calcAirflowControl(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 11.50); break; // 1.5 + 10.0
                case 17: mergeEffect(effectsMap, "적주피", 16.50); break; // 11.5 + 5.0
                case 18: mergeEffect(effectsMap, "적주피", 16.65); break;
                case 19: mergeEffect(effectsMap, "적주피", 16.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 16.95); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 11.50); break; // 1.5 + 10.0
                case 17: mergeEffect(effectsMap, "적주피", 17.50); break; // 11.5 + 5.0
                case 18: mergeEffect(effectsMap, "적주피", 17.65); break;
                case 19: mergeEffect(effectsMap, "적주피", 17.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 17.95); break;
            }
        }
    }

    //바람의 칼날
    private void calcBladeOfWind(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 33.00); break; // 8.0 + 25.0
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 45.00); break; // 8.0 + 37.0 (25%에서 37%로 변경됨)
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 45.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 46.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 46.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "칼바람 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "칼바람 스킬 피증", 33.00); break; // 8.0 + 25.0
                case 17: mergeEffect(effectsMap, "칼바람 스킬 피증", 48.00); break; // 8.0 + 37.0 (25%에서 37%로 변경됨)
                case 18: mergeEffect(effectsMap, "칼바람 스킬 피증", 48.50); break;
                case 19: mergeEffect(effectsMap, "칼바람 스킬 피증", 49.00); break;
                case 20: mergeEffect(effectsMap, "칼바람 스킬 피증", 49.50); break;
            }
        }
    }

    //싸라기눈
    //여우비 상태
    private void calcGraupel(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 게이지 및 연속 발동은 X
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 1.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 게이지 및 연속 발동은 X
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "기상 스킬 피증", 2.50); break;
            }
        }
    }

    //마른 하늘에 날벼락
    private void calcBoltFromTheBlue(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break; // 낙뢰 피해(수치형) 및 쿨감은 X
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 70.00); break; // 중첩 무시 최대값 35.0
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 71.00); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 72.00); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 73.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); break; // 낙뢰 피해(수치형) 및 쿨감은 X
                case 17: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 90.00); break; // 중첩 무시 최대값 35.0
                case 18: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 91.00); break;
                case 19: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 92.00); break;
                case 20: mergeEffect(effectsMap, "여우비 스킬 피증", 12.00); mergeEffect(effectsMap, "소나기 스킬 피증", 93.00); break;
            }
        }
    }

    //해와 바람
    private void calcSunAndWind(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 4.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 39.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break; // 4.0 + 35.0
                case 17: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 64.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break; // 4.0 + 60.0 (35%에서 60%로 변경됨)
                case 18: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 64.80); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 19: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 65.60); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 20: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 66.40); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 4.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 39.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break; // 4.0 + 35.0
                case 17: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 71.00); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break; // 4.0 + 60.0 (35%에서 60%로 변경됨)
                case 18: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 71.80); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 19: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 72.60); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
                case 20: mergeEffect(effectsMap, "싹쓸바람 스킬 피증", 73.40); mergeEffect(effectsMap, "뙤약볕 스킬 피증", 4.00); break;
            }
        }
    }
}
