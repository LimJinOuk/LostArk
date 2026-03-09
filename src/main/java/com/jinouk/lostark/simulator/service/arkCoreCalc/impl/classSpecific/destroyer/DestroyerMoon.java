package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.destroyer;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DestroyerMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "디스트로이어";
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

            if ("완벽한 제어".equals(name)) {
                calcPerfectControl(effectsMap, point, grade);
            } else if ("중력 강화".equals(name)) {
                calcGravityReinforce(effectsMap, point, grade);
            } else if ("중력 질주".equals(name)) {
                calcGravityDash(effectsMap, point, grade);
            } else if ("사건의 지평선".equals(name)) {
                calcEventHorizon(effectsMap, point, grade);
            } else if ("중력 순환".equals(name)) {
                calcGravityCirculation(effectsMap, point, grade);
            } else if ("몰아치는 중력".equals(name)) {
                calcRushingGravity(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //완벽한 제어
    private void calcPerfectControl(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 1.66); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.00); break;
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 1.82); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 1.98); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 9.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 1.50); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 1.66); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 1.82); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 1.98); mergeEffect(effectsMap, "퍼펙트 스윙 스킬 피증", 12.00 ); break;
            }
        }
    }

    //중력 강화
    private void calcGravityReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 5.20); break; // 1.6 + 3.6
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 5.36); break; // 5.2 + 0.16
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 5.52); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 5.68); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 6.10); break; // 1.6 + 3.6
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 6.26); break; // 5.2 + 0.16
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 6.42); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 6.58); break;
            }
        }
    }

    //중력 질주
    private void calcGravityDash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 8.50); break; // 2.5 + 6.0
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 9.20); break; // 8.5 + 0.7
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 9.90); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 10.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 10.50); break; // 2.5 + 6.0
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 11.20); break; // 8.5 + 0.7
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 11.90); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 12.60); break;
            }
        }
    }

    //사건의 지평선
    //진욱쿤 찬스(10포 -> 중수 스킬 피증, 17포 -> 적주피)
    private void calcEventHorizon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 8.00); break;
                case 18: mergeEffect(effectsMap, "중력 가중영역 피증", 2.80); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 8.00); break; // 2.5 + 0.3
                case 19: mergeEffect(effectsMap, "중력 가중영역 피증", 3.10); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 8.00); break;
                case 20: mergeEffect(effectsMap, "중력 가중영역 피증", 3.40); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); break;
                case 17: mergeEffect(effectsMap, "중력 가중영역 피증", 2.50); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 9.00); break;
                case 18: mergeEffect(effectsMap, "중력 가중영역 피증", 2.80); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 9.00); break; // 2.5 + 0.3
                case 19: mergeEffect(effectsMap, "중력 가중영역 피증", 3.10); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 9.00); break;
                case 20: mergeEffect(effectsMap, "중력 가중영역 피증", 3.40); mergeEffect(effectsMap, "헤드 어택 스킬 적주피", 9.00); break;
            }
        }
    }

    //중력 순환
    private void calcGravityCirculation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 3.80); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 4.10); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 4.40); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 24.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 24.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 14: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); break;
                case 17: mergeEffect(effectsMap, "해방 스킬 피증", 3.50); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "해방 스킬 피증", 3.80); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
                case 19: mergeEffect(effectsMap, "해방 스킬 피증", 4.10); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
                case 20: mergeEffect(effectsMap, "해방 스킬 피증", 4.40); mergeEffect(effectsMap, "사이즈믹 해머 스킬 피증", 27.00); mergeEffect(effectsMap, "어스 웨이브 스킬 피증", 27.00); break;
            }
        }
    }

    //몰아치는 중력
    //진욱쿤 찬스(볼텍스 그라비티 스킬 피증)
    private void calcRushingGravity(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break; // 이동기 초기화 및 게이지 소모량 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.40); break;
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 55.80); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 56.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break;
                case 14: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 45.00); break; // 이동기 초기화 및 게이지 소모량 제외
                case 17: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.00); break;
                case 18: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.40); break;
                case 19: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 57.80); break;
                case 20: mergeEffect(effectsMap, "볼텍스 그라비티 스킬 피증", 58.20); break;
            }
        }
    }
}
