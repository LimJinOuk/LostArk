package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.summoner;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SummonerSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "서머너";
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

            if ("정령 결속".equals(name)) {
                calcSpiritBond(effectsMap, point, grade);
            } else if ("강화 폭주".equals(name)) {
                calcEnhancedBerserk(effectsMap, point, grade);
            } else if ("기초 훈련".equals(name)) {
                calcBasicTraining(effectsMap, point, grade);
            } else if ("힘의 계승".equals(name)) {
                calcSuccessionOfPower(effectsMap, point, grade);
            } else if ("고대의 유산".equals(name)) {
                calcAncientLegacy(effectsMap, point, grade);
            } else if ("힘의 순환".equals(name)) {
                calcPowerCirculation(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //정령 결속
    private void calcSpiritBond(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 6.50); break;
                case 17: mergeEffect(effectsMap, "피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "피증", 10.16); break;
                case 19: mergeEffect(effectsMap, "피증", 10.32); break;
                case 20: mergeEffect(effectsMap, "피증", 10.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 6.50); break;
                case 17: mergeEffect(effectsMap, "피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "피증", 11.16); break;
                case 19: mergeEffect(effectsMap, "피증", 11.32); break;
                case 20: mergeEffect(effectsMap, "피증", 11.48); break;
            }
        }
    }

    //강화 폭주
    private void calcEnhancedBerserk(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); break;
                case 14: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 47.00); break;
                case 18: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 47.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 47.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 47.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 4.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); break;
                case 14: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 47.00); break;
                case 18: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 50.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 50.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "슈르디 스킬 피증", 35.00); mergeEffect(effectsMap, "소환 스킬 피증", 50.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 4.50); break;
            }
        }
    }

    //기초 훈련
    //명령 스킬..
    private void calcBasicTraining(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "마리린 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "마리린 스킬 피증", 20.00); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "마리린 스킬 피증", 20.00); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "마리린 스킬 피증", 20.60); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "마리린 스킬 피증", 21.20); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "마리린 스킬 피증", 21.80); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "마리린 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "마리린 스킬 피증", 20.00); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "마리린 스킬 피증", 20.00); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "마리린 스킬 피증", 20.60); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "마리린 스킬 피증", 21.20); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "마리린 스킬 피증", 21.80); mergeEffect(effectsMap, "이그나 스킬 피증", 15.00); mergeEffect(effectsMap, "파우루 스킬 피증", 15.00); break;
            }
        }
    }

    //힘의 계승
    private void calcSuccessionOfPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 32.00); break;
                case 18: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 32.60); break;
                case 19: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 33.20); break;
                case 20: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 33.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 36.60); break;
                case 19: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 37.20); break;
                case 20: mergeEffect(effectsMap, "피닉스 스킬 피증", 3.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", 37.80); break;
            }
        }
    }

    //고대의 유산
    private void calcAncientLegacy(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 45.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 45.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 45.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 49.00); break;
                case 18: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 49.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 49.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 6.00); mergeEffect(effectsMap, "고대의 창 스킬 피증", 49.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
    }

    //힘의 순환
    private void calcPowerCirculation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 35.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 20.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 26.30); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 27.60); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 28.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 100.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 35.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 20.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 10.00); mergeEffect(effectsMap, "아키르 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 110.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 110.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 36.30); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 110.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 37.60); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 3.00); mergeEffect(effectsMap, "오쉬 스킬 피증", 110.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 45.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 30.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 20.00); mergeEffect(effectsMap, "아키르 스킬 피증", 38.90); break;
            }
        }
    }
}
