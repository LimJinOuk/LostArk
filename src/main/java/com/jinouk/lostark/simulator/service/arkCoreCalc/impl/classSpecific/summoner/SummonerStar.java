package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.summoner;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SummonerStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "서머너";
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


            if ("증폭 공명".equals(name)) {
                calcAmplifyResonance(effectsMap, point, grade);
            } else if ("명령 각성".equals(name)) {
                calcCommandAwakening(effectsMap, point, grade);
            } else if ("전술 명령".equals(name)) {
                calcTacticalCommand(effectsMap, point, grade);
            } else if ("힘의 균형".equals(name)) {
                calcBalanceOfPower(effectsMap, point, grade);
            } else if ("창세의 힘".equals(name)) {
                calcPowerOfGenesis(effectsMap, point, grade);
            } else if ("정령 인도자".equals(name)) {
                calcSpiritGuide(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //증폭 공명
    private void calcAmplifyResonance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); break;
                case 14: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 24.00); mergeEffect(effectsMap, "피증", 0.16); break;
                case 19: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 24.00); mergeEffect(effectsMap, "피증", 0.32); break;
                case 20: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 24.00); mergeEffect(effectsMap, "피증", 0.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); break;
                case 14: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 0.16); break;
                case 19: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 0.32); break;
                case 20: mergeEffect(effectsMap, "소환 스킬 피증", 1.10); mergeEffect(effectsMap, "윙드 스피릿 스킬 피증", 17.00); mergeEffect(effectsMap, "마력의 질주 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 0.48); break;
            }
        }
    }

    //명령 각성
    private void calcCommandAwakening(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); break;
                case 14: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 30.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 30.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 30.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 4.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); break;
                case 14: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 42.00); break;
                case 18: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 42.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 1.50); break;
                case 19: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 42.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "슈르디 스킬 마나 회복 트라이포드 피증", 55.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 트포 명령 피증", 17.00); mergeEffect(effectsMap, "마리린 스킬 돌진 명령 트라이포드 명령 피증", 42.00); mergeEffect(effectsMap, "엘씨드 스킬 피증", 4.50); break;
            }
        }
    }

    //전술 명령
    private void calcTacticalCommand(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00);  mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 125.00); break;
                case 18: mergeEffect(effectsMap, "마리린 스킬 피증", 3.30); mergeEffect(effectsMap, "파우루 스킬 피증", 3.30); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 125.00); break;
                case 19: mergeEffect(effectsMap, "마리린 스킬 피증", 3.60); mergeEffect(effectsMap, "파우루 스킬 피증", 3.60); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 125.00); break;
                case 20: mergeEffect(effectsMap, "마리린 스킬 피증", 3.90); mergeEffect(effectsMap, "파우루 스킬 피증", 3.90); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 125.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "마리린 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00);  mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 135.00); break;
                case 18: mergeEffect(effectsMap, "마리린 스킬 피증", 3.30); mergeEffect(effectsMap, "파우루 스킬 피증", 3.30); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 135.00); break;
                case 19: mergeEffect(effectsMap, "마리린 스킬 피증", 3.60); mergeEffect(effectsMap, "파우루 스킬 피증", 3.60); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 135.00); break;
                case 20: mergeEffect(effectsMap, "마리린 스킬 피증", 3.90); mergeEffect(effectsMap, "파우루 스킬 피증", 3.90); mergeEffect(effectsMap, "파우루 스킬 푸른 불꽃 파우루 트라이포드 피증", 12.00);  mergeEffect(effectsMap, "파우루 스킬 피증", 3.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 무력화 스킬 피증", -90.00); mergeEffect(effectsMap, "마리린 스킬 무력화 명령 트라이포드 피증", 135.00); break;
            }
        }
    }

    //힘의 균형
    private void calcBalanceOfPower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 4.00); mergeEffect(effectsMap, "아키르 스킬 피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.40); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 4.00); mergeEffect(effectsMap, "아키르 스킬 피증", 4.00); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.60); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 4.00); mergeEffect(effectsMap, "아키르 스킬 피증", 4.00); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.80); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 4.00); mergeEffect(effectsMap, "아키르 스킬 피증", 4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); break;
                case 17: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.20); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 6.00); mergeEffect(effectsMap, "아키르 스킬 피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.40); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 6.00); mergeEffect(effectsMap, "아키르 스킬 피증", 6.00); break;
                case 19: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.60); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 6.00); mergeEffect(effectsMap, "아키르 스킬 피증", 6.00); break;
                case 20: mergeEffect(effectsMap, "고대의 정령 스킬 피증", 2.80); mergeEffect(effectsMap, "대지 붕괴 스킬 피증", 27.00); mergeEffect(effectsMap, "피닉스 스킬 피증", 6.00); mergeEffect(effectsMap, "아키르 스킬 피증", 6.00); break;
            }
        }
    }

    //창세의 힘
    private void calcPowerOfGenesis(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 42.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 42.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 42.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 42.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 46.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 46.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 46.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "고대의 창 스킬 재빠른 시전 트라이포드 피증", 36.00); mergeEffect(effectsMap, "고대의 창 스킬 응축된 힘 트라이포드 피증", 46.00); mergeEffect(effectsMap, "캐스팅 스킬 피증", 1.20); break;
            }
        }
    }

    //정령 인도자
    private void calcSpiritGuide(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); break;
                case 14: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 18.00); mergeEffect(effectsMap, "아키르 스킬 피증", 1.30); break;
                case 19: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 18.00); mergeEffect(effectsMap, "아키르 스킬 피증", 2.60); break;
                case 20: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 18.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); break;
                case 14: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 26.00); break;
                case 18: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 26.00); mergeEffect(effectsMap, "아키르 스킬 피증", 1.30); break;
                case 19: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 26.00); mergeEffect(effectsMap, "아키르 스킬 피증", 2.60); break;
                case 20: mergeEffect(effectsMap, "오쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "알리마지 스킬 피증", 16.00); mergeEffect(effectsMap, "자히아&리게아스 스킬 피증", 26.00); mergeEffect(effectsMap, "아키르 스킬 피증", 3.90); break;
            }
        }
    }
}
