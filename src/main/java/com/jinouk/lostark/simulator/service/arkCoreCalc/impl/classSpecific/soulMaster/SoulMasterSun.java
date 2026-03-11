package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulMasterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기공사";
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


            if ("기강결".equals(name)) {
                calcQiFortificationFormula(effectsMap, point, grade);
            } else if ("기류탄화".equals(name)) {
                calcQiFlowTransformation(effectsMap, point, grade);
            } else if ("맹공".equals(name)) {
                calcOnslaught(effectsMap, point, grade);
            } else if ("임독양맥 타통".equals(name)) {
                calcEightMeridiansBreakthrough(effectsMap, point, grade);
            } else if ("대회전".equals(name)) {
                calcGreatRotation(effectsMap, point, grade);
            } else if ("적수공권".equals(name)) {
                calcEmptyHandedMastery(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //기강결
    private void calcQiFortificationFormula(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0 (운명 효과 합산)
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 40.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 40.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 40.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0 (운명 효과 합산)
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 45.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 45.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "난화격 스킬 피증", 45.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }

    //기류탄화
    private void calcQiFlowTransformation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 30.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 45.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break; // 30 + 15
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 45.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 45.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 45.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 30.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 48.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break; // 30 + 15
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 48.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 48.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "난화격 스킬 피증", -30.00); mergeEffect(effectsMap, "벽력장 스킬 피증", -30.00); mergeEffect(effectsMap, "환영격 스킬 피증", -30.00); mergeEffect(effectsMap, "무공탄 스킬 피증", 30.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 30.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 48.00); mergeEffect(effectsMap, "여래신장 스킬 피증", 30.00); mergeEffect(effectsMap, "기공장 스킬 피증", 30.00); break;
            }
        }
    }

    //맹공
    private void calcOnslaught(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); break; // 5% * 7중첩 = 35%
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); break; // 5% * 7중첩 = 35%
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "번천장 스킬 피증", 35.00); mergeEffect(effectsMap, "피증", 4.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }

    //임독양맥 타통
    private void calcEightMeridiansBreakthrough(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0
                case 17: mergeEffect(effectsMap, "적주피", 9.50); break; // 1.5 + 8.0 (공속 제외)
                case 18: mergeEffect(effectsMap, "적주피", 9.50); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 9.50); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 9.50); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0
                case 17: mergeEffect(effectsMap, "적주피", 10.50); break; // 1.5 + 8.0 (공속 제외)
                case 18: mergeEffect(effectsMap, "적주피", 10.50); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "적주피", 10.50); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "적주피", 10.50); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }

    //대회전
    private void calcGreatRotation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); break; // 60 + 95
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 95.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 95.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 95.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); break; // 60 + 95
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 100.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 100.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환영격 스킬 피증", 20.00); mergeEffect(effectsMap, "섭물진기 스킬 피증", 60.00); mergeEffect(effectsMap, "운기조식 상태 섭물진기 스킬 피증", 100.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
    }

    //적수공권
    private void calcEmptyHandedMastery(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 19.00); break;
                case 14: mergeEffect(effectsMap, "적주피", -61.00); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 100.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 100.00); break; // 적주피 19 - 80 = -61 (속도/흡수 제외)
                case 17: mergeEffect(effectsMap, "적주피", -61.00); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 112.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 112.00); mergeEffect(effectsMap, "난화격 스킬 피증", 12.00); break; // 100 + 12
                case 18: mergeEffect(effectsMap, "적주피", -60.84); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 112.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 112.00); mergeEffect(effectsMap, "난화격 스킬 피증", 12.00); break; // -61 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", -60.68); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 112.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 112.00); mergeEffect(effectsMap, "난화격 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "적주피", -60.52); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 112.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 112.00); mergeEffect(effectsMap, "난화격 스킬 피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 19.00); break;
                case 14: mergeEffect(effectsMap, "적주피", -61.00); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 100.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 100.00); break; // 적주피 19 - 80 = -61 (속도/흡수 제외)
                case 17: mergeEffect(effectsMap, "적주피", -61.00); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 115.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 115.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); break; // 100 + 12
                case 18: mergeEffect(effectsMap, "적주피", -60.84); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 115.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 115.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); break; // -61 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", -60.68); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 115.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 115.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "적주피", -60.52); mergeEffect(effectsMap, "공증", 55.60); mergeEffect(effectsMap, "회선격추 스킬 피증", 115.00); mergeEffect(effectsMap, "파쇄장 스킬 피증", 115.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); break;
            }
        }
    }
}
