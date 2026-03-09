package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.destroyer;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DestroyerStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "디스트로이어";
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


            if ("끊어진 사슬".equals(name)) {
                calcBrokenChain(effectsMap, point, grade);
            } else if ("몰아치는 해방".equals(name)) {
                calcRushingLiberation(effectsMap, point, grade);
            } else if ("무모한 한방".equals(name)) {
                calcRecklessStrike(effectsMap, point, grade);
            } else if ("붕괴".equals(name)) {
                calcCollapse(effectsMap, point, grade);
            } else if ("바위 칼날".equals(name)) {
                calcRockBlade(effectsMap, point, grade);
            } else if ("대지 부수기".equals(name)) {
                calcEarthSmash(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //끊어진 사슬
    private void calcBrokenChain(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 8.64); break;
                case 19: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.28); break;
                case 20: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.92); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 11.64); break;
                case 19: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.28); break;
                case 20: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 10.00); mergeEffect(effectsMap, "풀 스윙 스킬 피증", 7.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.92); break;
            }
        }
    }

    //몰아치는 해방
    //진욱쿤 질문(중력 해방 모드 시.. -> 해방 스킬 피증)
    private void calcRushingLiberation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 및 마나 소모량 제외
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 5.60); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 5.85); break; // 3.6 + 0.25
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 6.10); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 6.35); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 및 마나 소모량 제외
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 7.25); break; // 3.6 + 0.25
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 7.50); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 7.75); break;
            }
        }
    }

    //무모한 한방
    private void calcRecklessStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 25.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 25.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 25.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 1.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 30.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 30.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 4.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 학살의 시간 트라이포드 피증", 35.00); mergeEffect(effectsMap, "어스 웨이브 스킬 무모한 한방 트라이포드 피증", 30.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 1.50); break;
            }
        }
    }

    //붕괴
    //진욱쿤 질문(10포 방어력을 무시한다 -> 방깎/ 중력 가중영역 기본 공격의... -> 중수 스킬 치피증)
    private void calcCollapse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "치피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 4.30); break; // 4.0 + 0.3
                case 19: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 4.60); break;
                case 20: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 4.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "치피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 6.30); break; // 4.0 + 0.3
                case 19: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 6.60); break;
                case 20: mergeEffect(effectsMap, "치피증", 9.00); mergeEffect(effectsMap, "피증", 6.90); break;
            }
        }
    }

    //바위 칼날
    private void calcRockBlade(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 12.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 12.30); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 12.30); break; // 12.0 + 0.3
                case 19: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 12.60); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 12.60); break;
                case 20: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 12.90); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 12.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 14.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 14.30); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 14.30); break; // 12.0 + 0.3
                case 19: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 14.60); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 14.60); break;
                case 20: mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 14.90); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 14.90); break;
            }
        }
    }

    //대지 부수기
    private void calcEarthSmash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 6.30); break; // 6.0 + 0.3
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 6.60); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 6.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); break; // 시전 속도 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 7.30); break; // 6.0 + 0.3
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 7.60); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 치피증", 45.00); mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 7.90); break;
            }
        }
    }
}
