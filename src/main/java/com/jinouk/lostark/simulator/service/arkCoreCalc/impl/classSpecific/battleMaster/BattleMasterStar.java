package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.battleMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BattleMasterStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "배틀마스터";
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


            if ("극선풍각".equals(name)) {
                calcGeukseonpungak(effectsMap, point, grade);
            } else if ("파천격".equals(name)) {
                calcPacheongyeog(effectsMap, point, grade);
            } else if ("용류 강화".equals(name)) {
                calcDragonEnhance(effectsMap, point, grade);
            } else if ("창풍극의".equals(name)) {
                calcChangpunggeuk(effectsMap, point, grade);
            } else if ("폭룡천상".equals(name)) {
                calcPoglyongcheonsang(effectsMap, point, grade);
            } else if ("패황권".equals(name)) {
                calcEmpireFist(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //극선풍각
    private void calcGeukseonpungak(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00); break; // 3.0 + 4.0
                case 18: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.16); break;
                case 19: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.32); break;
                case 20: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00); break; // 3.0 + 4.0
                case 18: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.16); break;
                case 19: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.32); break;
                case 20: mergeEffect(effectsMap, "피증", 7.00); mergeEffect(effectsMap, "초풍각 스킬 재빠른 발놀림 트라이포드 피증", 35.00); mergeEffect(effectsMap, "선풍용류각 스킬 선풍 트라이포드 피증", 25.00);  mergeEffect(effectsMap, "피증", 0.48); break;
            }
        }
    }

    //파천격
    private void calcPacheongyeog(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.20); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 10.00); mergeEffect(effectsMap, "치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 10.00); mergeEffect(effectsMap, "치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 10.00); mergeEffect(effectsMap, "치피증", 1.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.20); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 14.00); mergeEffect(effectsMap, "치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 14.00); mergeEffect(effectsMap, "치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "섬열란아 스킬 치피증", 25.00); mergeEffect(effectsMap, "방천격 스킬 피증", 14.00); mergeEffect(effectsMap, "치피증", 1.50); break;
            }
        }
    }

    //용류 강화
    private void calcDragonEnhance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.00); break;
                case 14: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 10.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 7.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.00); break;
                case 14: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 15.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 15.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.00); mergeEffect(effectsMap, "방천격 스킬 정의로운 빛 트라이포드 방천격 피증", 17.00); mergeEffect(effectsMap, "선풍용류각 스킬 피증", 15.00); mergeEffect(effectsMap, "선풍용류각 스킬 치피증", 7.50); break;
            }
        }
    }

    //창풍극의
    private void calcChangpunggeuk(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 17.00); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 18.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 21.00); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 22.00); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 23.00); break;
            }
        }
    }

    //폭룡천상
    private void calcPoglyongcheonsang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 20.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 1.00); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 20.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 20.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 3.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 23.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 23.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 1.00); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 23.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.05); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 23.00); mergeEffect(effectsMap, "오의 : 화룡천상 스킬 치피증", 3.00); break;
            }
        }
    }

    //패황권
    private void calcEmpireFist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 7.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 7.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 7.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 치적", 10.00); mergeEffect(effectsMap, "오의 : 나선경 스킬 피증", 15.00); mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        }
    }
}
