package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.inFighter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InFighterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "인파이터";
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


            if ("충격 폭주".equals(name)) {
                calcImpactBerserk(effectsMap, point, grade);
            } else if ("충격파".equals(name)) {
                calcShockwave(effectsMap, point, grade);
            } else if ("충격 억제".equals(name)) {
                calcImpactSuppression(effectsMap, point, grade);
            } else if ("대지 붕괴".equals(name)) {
                calcEarthCollapse(effectsMap, point, grade);
            } else if ("반복 도약".equals(name)) {
                calcRepeatedLeap(effectsMap, point, grade);
            } else if ("투지 억제".equals(name)) {
                calcWillSuppression(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //충격 폭주
    //진욱쿤(14포 충격을 모두 소모하는 스킬의... -> 충격 스킬 피증)
    private void calcImpactBerserk(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 9.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); break; // 공속 10% 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 9.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 9.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 9.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 10.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); break; // 공속 10% 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 10.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 10.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 10.50); mergeEffect(effectsMap, "충격 모두 소모 스킬 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 치적", 5.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        }
    }

    //충격파
    private void calcShockwave(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 100.00); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 145.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); break; // 연환 치적 100% 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 145.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break; // 14, 17 조건부 효과 유지
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 145.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00);  mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50);  mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 145.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 100.00); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 148.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); break; // 연환 치적 100% 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 148.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break; // 14, 17 조건부 효과 유지
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 148.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00);  mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 1.50);  mergeEffect(effectsMap, "죽음의 선고 피증", -50.00); mergeEffect(effectsMap, "적주피", 148.00); mergeEffect(effectsMap, "연환파신권 스킬 치적", 100.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        }
    }

    //충격 억제
    private void calcImpactSuppression(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", -10.00); break; // 투지발산 시 쿨초 초기화 포함
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 7.50); mergeEffect(effectsMap, "적주피", -10.00); break; // 공이속 증가 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 7.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.30); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 7.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 7.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", -10.00); break; // 투지발산 시 쿨초 초기화 포함
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", 8.50); mergeEffect(effectsMap, "적주피", -10.00); break; // 공이속 증가 포함
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", 8.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.30); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", 8.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", 8.50); mergeEffect(effectsMap, "적주피", -10.00); mergeEffect(effectsMap, "충격 스킬 치명타 적중 시 적주피", 0.90); break;
            }
        }
    }

    //대지 붕괴
    private void calcEarthCollapse(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); break; // 최대 3중첩
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 40.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 40.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 40.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 40.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 40.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 40.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 40.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 40.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 40.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 40.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 40.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); break; // 최대 3중첩
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 45.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 45.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 45.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 45.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 45.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 45.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 45.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 45.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 24.00); mergeEffect(effectsMap, "난타연권 스킬 피증", 45.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 45.00); mergeEffect(effectsMap, "폭렬권 스킬 피증", 45.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        }
    }

    //반복 도약
    private void calcRepeatedLeap(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 15.00); break; // 쿨감 0.5초 포함
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 75.00); break; // 15.0 + 60.0 (운명: 강림)
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 75.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 75.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 75.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 15.00); break; // 쿨감 0.5초 포함
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 87.00); break; // 15.0 + 60.0 (운명: 강림)
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 87.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 87.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); mergeEffect(effectsMap, "용의 강림 스킬 피증", 87.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        }
    }

    //투지 억제
    private void calcWillSuppression(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 6.50); break; // 1.5 + 5.0 (비투지발산 시)
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 6.50); mergeEffect(effectsMap, "적주피", 7.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 6.70); mergeEffect(effectsMap, "적주피", 7.00); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 6.90); mergeEffect(effectsMap, "적주피", 7.00); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 7.10); mergeEffect(effectsMap, "적주피", 7.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기력 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "기력 스킬 피증", 6.50); break; // 1.5 + 5.0 (비투지발산 시)
                case 17: mergeEffect(effectsMap, "기력 스킬 피증", 6.50); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 18: mergeEffect(effectsMap, "기력 스킬 피증", 6.70); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 19: mergeEffect(effectsMap, "기력 스킬 피증", 6.90); mergeEffect(effectsMap, "적주피", 8.00); break;
                case 20: mergeEffect(effectsMap, "기력 스킬 피증", 7.10); mergeEffect(effectsMap, "적주피", 8.00); break;
            }
        }
    }
}
