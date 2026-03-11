package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.berserker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BerserkerSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "버서커";
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


            if ("콤비네이션".equals(name)) {
                calcCombination(effectsMap, point, grade);
            } else if ("오버 파워".equals(name)) {
                calcOverPower(effectsMap, point, grade);
            } else if ("파워 코어".equals(name)) {
                calcPowerCore(effectsMap, point, grade);
            } else if ("다크 파워".equals(name)) {
                calcDarkPower(effectsMap, point, grade);
            } else if ("파워드라이브".equals(name)) {
                calcPowerDrive(effectsMap, point, grade);
            } else if ("홀드 엣지".equals(name)) {
                calcHoldEdge(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //콤비네이션
    private void calcCombination(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 17: mergeEffect(effectsMap, "피증", 18.00); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 18: mergeEffect(effectsMap, "피증", 18.40); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 19: mergeEffect(effectsMap, "피증", 18.80); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00);  break;
                case 20: mergeEffect(effectsMap, "피증", 19.20); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00);  break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 17: mergeEffect(effectsMap, "피증", 20.00); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 18: mergeEffect(effectsMap, "피증", 20.40); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 19: mergeEffect(effectsMap, "피증", 20.80); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
                case 20: mergeEffect(effectsMap, "피증", 21.20); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", -30.00); break;
            }
        }
    }

    //오버 파워
    private void calcOverPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 5.10); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 5.27); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.44); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.61); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.10); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.27); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.44); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.61); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
            }
        }
    }

    //파워 코어
    private void calcPowerCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 3.50); break;
                case 18: mergeEffect(effectsMap, "피증", 3.65); break;
                case 19: mergeEffect(effectsMap, "피증", 3.80); break;
                case 20: mergeEffect(effectsMap, "피증", 3.95); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 4.50); break;
                case 18: mergeEffect(effectsMap, "피증", 4.65); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); break;
                case 20: mergeEffect(effectsMap, "피증", 4.95); break;
            }
        }
    }

    //다크 파워
    private void calcDarkPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 55.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 85.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 86.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 88.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 89.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 55.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 92.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 93.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 95.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 96.50); break;
            }
        }
    }

    //파워드라이브
    private void calcPowerDrive(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 39.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 39.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 39.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 39.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.00); break;
            }
        }
    }

    //홀드 엣지
    private void calcHoldEdge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "공증", 24.00); break;
                case 17: mergeEffect(effectsMap, "피증", 21.00); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 18: mergeEffect(effectsMap, "피증", 21.40); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 19: mergeEffect(effectsMap, "피증", 21.80); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 20: mergeEffect(effectsMap, "피증", 22.20); mergeEffect(effectsMap, "공증", 24.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "공증", 24.00); break;
                case 17: mergeEffect(effectsMap, "피증", 24.00); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 18: mergeEffect(effectsMap, "피증", 24.40); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 19: mergeEffect(effectsMap, "피증", 24.80); mergeEffect(effectsMap, "공증", 24.00);  break;
                case 20: mergeEffect(effectsMap, "피증", 25.20); mergeEffect(effectsMap, "공증", 24.00);  break;
            }
        }
    }
}
