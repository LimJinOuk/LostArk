package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.sorceress;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SorceressMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소서리스";
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

            if ("점화의 문장".equals(name)) {
                calcIgnitionEmblem(effectsMap, point, grade);
            } else if ("연소 가속".equals(name)) {
                calcCombustionAcceleration(effectsMap, point, grade);
            } else if ("반복된 종말".equals(name)) {
                calcRepeatedApocalypse(effectsMap, point, grade);
            } else if ("직류".equals(name)) {
                calcDirectCurrent(effectsMap, point, grade);
            } else if ("교류".equals(name)) {
                calcAlternatingCurrent(effectsMap, point, grade);
            } else if ("와류".equals(name)) {
                calcEddyCurrent(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //점화의 문장
    //진욱쿤(마력 방출 중)
    private void calcIgnitionEmblem(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); break; // 기존 2.0 + 신규 4.5
                case 18: mergeEffect(effectsMap, "적주피", 6.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 7.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.25); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 7.50); break; // 기존 2.0 + 신규 4.5
                case 18: mergeEffect(effectsMap, "적주피", 7.75); break;
                case 19: mergeEffect(effectsMap, "적주피", 8.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 8.25); break;
            }
        }
    }

    //연소 가속
    //진욱쿤(캐스팅 조작)
    private void calcCombustionAcceleration(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break; // 쿨감 제외
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break; // 쿨감 제외
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.20); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.40); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.60); break;
            }
        }
    }

    //반복된 종말
    private void calcRepeatedApocalypse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break; // 추가 피증 0%
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.40); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.80); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 5.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 7.00); break; // 추가 피증 0%
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 7.40); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 7.80); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 8.20); break;
            }
        }
    }

    //직류
    //진욱쿤(일반 조작 스킬? 지점 조작 스킬?)
    private void calcDirectCurrent(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50);break;
                case 14: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); break; // 아이스 애로우 피증 0%
                case 18: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.66); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.66); break;
                case 19: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.82); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.82); break;
                case 20: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.98); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50);break;
                case 14: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 8.00); break; // 아이스 애로우 피증 0%
                case 18: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.66); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.66); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.82); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.82); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.98); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.98); mergeEffect(effectsMap, "아이스 애로우 스킬 피증", 8.00); break;
            }
        }
    }

    //교류
    //진욱쿤(캐스팅 조작 스킬 피증?)
    private void calcAlternatingCurrent(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break; // 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break; // 일반 스킬 피증 0%
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.60); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 8.20); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 8.80); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break; // 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); mergeEffect(effectsMap, "피증", 2.00); break; // 일반 스킬 피증 0%
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.60); mergeEffect(effectsMap, "피증", 2.00); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 8.20); mergeEffect(effectsMap, "피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 8.80); mergeEffect(effectsMap, "피증", 2.00); break;
            }
        }
    }

    //와류
    private void calcEddyCurrent(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 17: mergeEffect(effectsMap, "번개 스킬 피증", 7.20); mergeEffect(effectsMap, "냉기 스킬 피증", 7.20); break;
                case 18: mergeEffect(effectsMap, "번개 스킬 피증", 7.20); mergeEffect(effectsMap, "냉기 스킬 피증", 7.20); mergeEffect(effectsMap, "피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "번개 스킬 피증", 7.20); mergeEffect(effectsMap, "냉기 스킬 피증", 7.20); mergeEffect(effectsMap, "피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "번개 스킬 피증", 7.20); mergeEffect(effectsMap, "냉기 스킬 피증", 7.20); mergeEffect(effectsMap, "피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 17: mergeEffect(effectsMap, "번개 스킬 피증", 8.20); mergeEffect(effectsMap, "냉기 스킬 피증", 8.20); break;
                case 18: mergeEffect(effectsMap, "번개 스킬 피증", 8.20); mergeEffect(effectsMap, "냉기 스킬 피증", 8.20); mergeEffect(effectsMap, "피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "번개 스킬 피증", 8.20); mergeEffect(effectsMap, "냉기 스킬 피증", 8.20); mergeEffect(effectsMap, "피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "번개 스킬 피증", 8.20); mergeEffect(effectsMap, "냉기 스킬 피증", 8.20); mergeEffect(effectsMap, "피증", 1.20); break;
            }
        }
    }
}
