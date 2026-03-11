package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blade;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BladeMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블레이드";
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


            if ("버스트 코어".equals(name)) {
                calcBurstCore(effectsMap, point, grade);
            } else if ("데스티니 코어".equals(name)) {
                calcDestinyCore(effectsMap, point, grade);
            } else if ("데스 블리츠".equals(name)) {
                calcDeathBliz(effectsMap, point, grade);
            } else if ("아츠 코어".equals(name)) {
                calcArtsCore(effectsMap, point, grade);
            } else if ("리차지".equals(name)) {
                calcRecharge(effectsMap, point, grade);
            } else if ("블레이드 웨이브".equals(name)) {
                calcBladeWave(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //버스트 코어
    private void calcBurstCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "피증", 2.50); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 18: mergeEffect(effectsMap, "피증", 2.75); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 19: mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 20: mergeEffect(effectsMap, "피증", 3.25); mergeEffect(effectsMap, "적주피", 3.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "피증", 2.50); mergeEffect(effectsMap, "적주피", 4.50); break;
                case 18: mergeEffect(effectsMap, "피증", 2.75); mergeEffect(effectsMap, "적주피", 4.50); break;
                case 19: mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "적주피", 4.50); break;
                case 20: mergeEffect(effectsMap, "피증", 3.25); mergeEffect(effectsMap, "적주피", 4.50); break;
            }
        }
    }

    //데스티니 코어
    private void calcDestinyCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 4.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 4.65); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.95); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 5.65); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.95); break;
            }
        }
    }

    //데스 블리츠
    private void calcDeathBliz(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 20.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 21.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 21.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 25.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 26.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 26.80); break;
            }
        }
    }

    //아츠 코어
    private void calcArtsCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "피증", 4.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "피증", 4.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "피증", 4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "피증", 5.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "피증", 5.00); break;
            }
        }
    }

    //리차지
    //진욱쿤 찬스(차지 타입 -> 피증)
    private void calcRecharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); break;
            }
        }
    }

    //블레이드 웨이브
    private void calcBladeWave(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 16.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 20.00); break;
            }
        }
    }
}
