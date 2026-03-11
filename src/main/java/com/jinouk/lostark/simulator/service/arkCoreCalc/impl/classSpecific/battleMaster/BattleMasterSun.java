package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.battleMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BattleMasterSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "배틀마스터";
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


            if ("연격강타".equals(name)) {
                calcStrikeAfterStrike(effectsMap, point, grade);
            } else if ("극의귀원".equals(name)) {
                calcGeuguigwiwon(effectsMap, point, grade);
            } else if ("삼문 개방".equals(name)) {
                calcOpenThreeDoor(effectsMap, point, grade);
            } else if ("패황불패".equals(name)) {
                calcNoDefeat(effectsMap, point, grade);
            } else if ("화룡순환".equals(name)) {
                calcHwalyongsunhwan(effectsMap, point, grade);
            } else if ("오기강체".equals(name)) {
                calcOgigangche(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //연격강타
    private void calcStrikeAfterStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치적", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치적", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 1.30); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 7.00); mergeEffect(effectsMap, "치적", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 2.60); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 7.00); mergeEffect(effectsMap, "치적", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 3.90); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 7.00); mergeEffect(effectsMap, "치적", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치적", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "치적", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 1.30); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "치적", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 2.60); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "치적", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "초풍각 스킬 피증", 3.90); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "치적", 20.00); break;
            }
        }
    }

    //극의귀원
    //진욱쿤 찬스(운명 발동 우야노: 14포 -> 방천격 스킬 피증 17포 -> 적주피)
    private void calcGeuguigwiwon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.80); mergeEffect(effectsMap, "적주피", 15.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 16.60); mergeEffect(effectsMap, "적주피", 15.00);  break;
                case 20: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 17.40); mergeEffect(effectsMap, "적주피", 15.00);  break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.80); mergeEffect(effectsMap, "적주피", 16.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 16.60); mergeEffect(effectsMap, "적주피", 16.00);  break;
                case 20: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 17.40); mergeEffect(effectsMap, "적주피", 16.00);  break;
            }
        }
    }

    //삼문 개방
    private void calcOpenThreeDoor(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "적주피", 3.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.76); mergeEffect(effectsMap, "적주피", 3.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.92); mergeEffect(effectsMap, "적주피", 3.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.08); mergeEffect(effectsMap, "적주피", 3.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.76); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.92); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.08); mergeEffect(effectsMap, "적주피", 4.00); break;
            }
        }
    }

    //패황불패
    private void calcNoDefeat(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 3.50); mergeEffect(effectsMap, "치적", 20.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 13.50); mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 13.50); mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 13.50); mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 13.50); mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 3.50);  mergeEffect(effectsMap, "치적", 20.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 15.50);  mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 15.50);  mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 15.50);  mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 15.50);  mergeEffect(effectsMap, "치적", 20.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        }
    }

    //화룡순환
    //진욱쿤 찬스(14포)
    private void calcHwalyongsunhwan(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 0.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.72); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 0.00); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.89); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 0.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 2.06); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 0.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.72); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.00); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.89); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 2.06); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.00); break;
            }
        }
    }

    //오기강체
    //진욱쿤 찬스(14포 17포)
    private void calcOgigangche(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 12.17); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 12.34); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 12.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 7.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 14.17); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 14.34); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 14.51); break;
            }
        }
    }
}
