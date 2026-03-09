package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.summoner;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SummonerMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "서머너";
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


            if ("결속 증폭".equals(name)) {
                calcBondAmplify(effectsMap, point, grade);
            } else if ("폭주 집중".equals(name)) {
                calcBerserkConcentration(effectsMap, point, grade);
            } else if ("강풍 진화".equals(name)) {
                calcGaleEvolution(effectsMap, point, grade);
            } else if ("힘의 집중".equals(name)) {
                calcPowerFocus(effectsMap, point, grade);
            } else if ("오쉬의 지원".equals(name)) {
                calcOshSupport(effectsMap, point, grade);
            } else if ("정령의 고리".equals(name)) {
                calcSpiritRing(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //결속 증폭
    private void calcBondAmplify(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소환 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "소환 스킬 피증", 1.70); break;
                case 17: mergeEffect(effectsMap, "소환 스킬 피증", 5.50); break; // 1.7 + 3.8
                case 18: mergeEffect(effectsMap, "소환 스킬 피증", 5.68); break; // 5.5 + 0.18
                case 19: mergeEffect(effectsMap, "소환 스킬 피증", 5.86); break;
                case 20: mergeEffect(effectsMap, "소환 스킬 피증", 6.04); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소환 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "소환 스킬 피증", 1.70); break;
                case 17: mergeEffect(effectsMap, "소환 스킬 피증", 6.50); break; // 1.7 + 3.8
                case 18: mergeEffect(effectsMap, "소환 스킬 피증", 6.68); break; // 5.5 + 0.18
                case 19: mergeEffect(effectsMap, "소환 스킬 피증", 6.86); break;
                case 20: mergeEffect(effectsMap, "소환 스킬 피증", 7.04); break;
            }
        }
    }

    //폭주 집중
    private void calcBerserkConcentration(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 3.40); break; // 획득량 감소 제외
                case 18: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 3.40); mergeEffect(effectsMap, "슈르디 스킬 피증", 3.00); break;
                case 19: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 3.40); mergeEffect(effectsMap, "슈르디 스킬 피증", 6.00); break;
                case 20: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 3.40); mergeEffect(effectsMap, "슈르디 스킬 피증", 9.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 4.30); break; // 획득량 감소 제외
                case 18: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 4.30); mergeEffect(effectsMap, "슈르디 스킬 피증", 3.00); break;
                case 19: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 4.30); mergeEffect(effectsMap, "슈르디 스킬 피증", 6.00); break;
                case 20: mergeEffect(effectsMap, "엘씨드 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 4.30); mergeEffect(effectsMap, "슈르디 스킬 피증", 9.00); break;
            }
        }
    }

    //강풍 진화
    private void calcGaleEvolution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "파우루 스킬 피증", 10.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 30.00); break; // 9.0 + 1.0
                case 19: mergeEffect(effectsMap, "파우루 스킬 피증", 11.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "파우루 스킬 피증", 12.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "파우루 스킬 피증", 9.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "파우루 스킬 피증", 10.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 40.00); break; // 9.0 + 1.0
                case 19: mergeEffect(effectsMap, "파우루 스킬 피증", 11.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "파우루 스킬 피증", 12.00); mergeEffect(effectsMap, "쏜살 바람새 스킬 피증", 40.00); break;
            }
        }
    }

    //힘의 집중
    private void calcPowerFocus(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 10.00); break; // 면역 제외
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 10.70); mergeEffect(effectsMap, "아키르 스킬 피증", 10.70); break; // 10.0 + 0.7
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 11.40); mergeEffect(effectsMap, "아키르 스킬 피증", 11.40); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 12.10); mergeEffect(effectsMap, "아키르 스킬 피증", 12.10); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 12.00); mergeEffect(effectsMap, "아키르 스킬 피증", 12.00); break; // 면역 제외
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 12.70); mergeEffect(effectsMap, "아키르 스킬 피증", 12.70); break; // 10.0 + 0.7
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 13.40); mergeEffect(effectsMap, "아키르 스킬 피증", 13.40); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 14.10); mergeEffect(effectsMap, "아키르 스킬 피증", 14.10); break;
            }
        }
    }

    //오쉬의 지원
    private void calcOshSupport(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 72.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 85.00); break; // 72 -> 85 변경 반영
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 85.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 85.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 85.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 72.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 89.00); break; // 72 -> 85 변경 반영
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 89.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 89.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "적주피", 89.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
    }

    //정령의 고리
    private void calcSpiritRing(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 10.00); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 1.30); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 2.60); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 12.00); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 12.00); mergeEffect(effectsMap, "아키르 스킬 피증", 1.30); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 12.00); mergeEffect(effectsMap, "아키르 스킬 피증", 2.60); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 12.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.90); break;
            }
        }
    }
}
