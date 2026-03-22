package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulEater;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulEaterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소울이터";
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


            if ("이계의 지배자".equals(name)) {
                calcOtherworldOverlord(effectsMap, point, grade);
            } else if ("수확의 밤".equals(name)) {
                calcHarvestNight(effectsMap, point, grade);
            } else if ("빙의".equals(name)) {
                calcPossession(effectsMap, point, grade);
            } else if ("그믐의 지배자".equals(name)) {
                calcDarkMoonMaster(effectsMap, point, grade);
            } else if ("사신의 힘".equals(name)) {
                calcGrimReaperPower(effectsMap, point, grade);
            } else if ("잠식된 경계".equals(name)) {
                calcEncroachedBoundary(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //이계의 지배자
    private void calcOtherworldOverlord(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 7.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 7.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 7.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 20.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 12.00); mergeEffect(effectsMap, "소울 시너스 스킬 이계의 지배자 트라이포드 피증", 7.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 이계의 지배자 트라이포드 피증", 5.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
    }

    //수확의 밤
    private void calcHarvestNight(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 1.20); break;
                case 18: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "소울 시너스 스킬 피증", 8.00); mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "적주피", 1.20); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
    }

    //빙의
    private void calcPossession(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); break;
                case 17: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "망자 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "망자 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "망자 스킬 피증", 1.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); break;
                case 17: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "망자 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "망자 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "아스타로스 스킬 피증", 20.00); mergeEffect(effectsMap, "글러트니 스킬 빙의 트라이포드 피증", 180.00); mergeEffect(effectsMap, "아스타로스 스킬 빙의 트라이포드 피증", 50.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "망자 스킬 피증", 1.80); break;
            }
        }
    }

    //그믐의 지배자
    private void calcDarkMoonMaster(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 7.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 7.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 7.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.20); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 7.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 7.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.40); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 7.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 7.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.60); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 10.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 10.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.20); mergeEffect(effectsMap, "사신 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 10.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.40); mergeEffect(effectsMap, "사신 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "베스티지 스킬 피증", 8.00); mergeEffect(effectsMap, "러스트 네일 스킬 피증", 8.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 5.00); mergeEffect(effectsMap, "하베스트 스킬 피증", 5.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 10.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.60); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
            }
        }
    }

    //사신의 힘
    private void calcGrimReaperPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 13.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 13.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 13.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 17.00); break;
                case 18: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 17.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 17.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "베스티지 스킬 피증", 10.00); mergeEffect(effectsMap, "길로틴 스윙 스킬 피증", 8.00); mergeEffect(effectsMap, "소울 시너스 스킬 피증", 17.00); mergeEffect(effectsMap, "사신 스킬 피증", 0.90); break;
            }
        }
    }

    //잠식된 경계
    private void calcEncroachedBoundary(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 15.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 15.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 15.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 24.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 24.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "하베스트 스킬 피증", 8.00); mergeEffect(effectsMap, "리탈 스피닝 스킬 피증", 10.00); mergeEffect(effectsMap, "영혼 참수 스킬 피증", 24.00); mergeEffect(effectsMap, "살귀 스킬 피증", 0.90); break;
            }
        }
    }
}
