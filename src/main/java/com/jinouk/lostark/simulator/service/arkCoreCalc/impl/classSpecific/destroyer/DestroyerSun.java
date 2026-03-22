package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.destroyer;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DestroyerSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "디스트로이어";
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


            if ("특이점".equals(name)) {
                calcSingularity(effectsMap, point, grade);
            } else if ("차원 붕괴".equals(name)) {
                calcDimensionalCollapse(effectsMap, point, grade);
            } else if ("어스 웨이브".equals(name)) {
                calcEarthWave(effectsMap, point, grade);
            } else if ("중력 역전".equals(name)) {
                calcGravityInversion(effectsMap, point, grade);
            } else if ("중력 파괴".equals(name)) {
                calcGravityDestruction(effectsMap, point, grade);
            } else if ("그라비티 코어".equals(name)) {
                calcGravityCore(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //특이점
    //진욱쿤 찬스(헤드 어택 -> 피증)
    private void calcSingularity(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); break;
                case 17: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break; // 1.8 + 0.2
                case 19: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.20); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.40); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); break;
                case 14: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); break;
                case 17: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 1.80); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.00); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 15.00); break; // 1.8 + 0.2
                case 19: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.20); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 2.40); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 15.00); break;
            }
        }
    }

    //차원 붕괴
    private void calcDimensionalCollapse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 7.60); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", -22.40); break; // 1.6 - 30.0
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", -22.24); break; // -28.4 + 0.16
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", -22.08); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", -21.92); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 7.60); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", -17.40); break; // 1.6 - 30.0
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", -17.24); break; // -28.4 + 0.16
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", -17.08); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", -16.92); break;
            }
        }
    }

    //어스 웨이브
    //진욱쿤 찬스(일반 조작으로 사용 시 -> 해방 스킬 피증/ 14포 -> 해방 스킬 1.55 피증)
    private void calcEarthWave(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 67.50); break; // 2.5 + 65.0
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 67.50); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 68.20); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 30.00); break; // 67.5 + 0.7
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 68.90); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 69.60); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 67.50); break; // 2.5 + 65.0
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 67.50); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 68.20); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 35.00); break; // 67.5 + 0.7
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 68.90); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 35.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", -30.00); mergeEffect(effectsMap, "해방 스킬(일반 조작) 피증", 69.60); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 35.00); break;
            }
        }
    }

    //중력 역전
    //진욱쿤 찬스(중력 가중영역 기본 공격의... -> 중수 치피증)
    private void calcGravityInversion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 9.00); break; // 공격 속도 제외
                case 17: mergeEffect(effectsMap, "치피증", 9.00); break; // 게이지 회복 및 피증 0% 제외
                case 18: mergeEffect(effectsMap, "치피증", 10.00); break; // 9.0 + 1.0
                case 19: mergeEffect(effectsMap, "치피증", 11.00); break;
                case 20: mergeEffect(effectsMap, "치피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 9.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 9.00); break; // 공격 속도 제외
                case 17: mergeEffect(effectsMap, "치피증", 10.00); break; // 게이지 회복 및 피증 0% 제외
                case 18: mergeEffect(effectsMap, "치피증", 11.00); break; // 9.0 + 1.0
                case 19: mergeEffect(effectsMap, "치피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "치피증", 13.00); break;
            }
        }
    }

    //중력 파괴
    private void calcGravityDestruction(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break; // 재사용 대기시간 초기화 제외
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 3.80); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break; // 3.5 + 0.3
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 4.10); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 4.40); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break; // 재사용 대기시간 초기화 제외
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 3.80); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break; // 3.5 + 0.3
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 4.10); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 4.40); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
            }
        }
    }

    //그라비티 코어
    //진욱쿤 찬스(마지막 공격 피해량 -> 피증)
    private void calcGravityCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break; // 무력화 감소 및 쿨초 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.40); break; // 45.0 + 0.4
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.80); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 56.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break; // 무력화 감소 및 쿨초 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.40); break; // 45.0 + 0.4
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.80); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 58.20); break;
            }
        }
    }
}
