package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.soulMaster;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SoulMasterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "기공사";
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


            if ("천화난무".equals(name)) {
                calcHeavenlyFlowerDance(effectsMap, point, grade);
            } else if ("진혼섬포".equals(name)) {
                calcSoulBurstFlash(effectsMap, point, grade);
            } else if ("번천귀류".equals(name)) {
                calcHeavenlyFlippingFlow(effectsMap, point, grade);
            } else if ("벽파장공".equals(name)) {
                calcBlueWavePalm(effectsMap, point, grade);
            } else if ("운기폭".equals(name)) {
                calcQiExplosion(effectsMap, point, grade);
            } else if ("쌍파연격".equals(name)) {
                calcDualWaveCombo(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //천화난무
    private void calcHeavenlyFlowerDance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "환영격 스킬 피증", 15.00); mergeEffect(effectsMap, "풍뢰일광포 스킬 피증", 10.00); mergeEffect(effectsMap, "난화격 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
    }

    //진혼섬포
    private void calcSoulBurstFlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 80.00); break; // 재감/시속 제외
                case 18: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 84.00); break; // 재감/시속 제외
                case 18: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 84.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 84.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "기공장 스킬 피증", 10.00); mergeEffect(effectsMap, "섬열파 스킬 피증", 5.00); mergeEffect(effectsMap, "섬열파 스킬 혼신의 포격 트라이포드 피증", 84.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
    }

    //번천귀류
    private void calcHeavenlyFlippingFlow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 8.00); break; // 면역 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 20.00); break; // 8.0 + 12.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 20.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 20.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 20.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 8.00); break; // 면역 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 23.00); break; // 8.0 + 12.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 23.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.20); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 23.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.40); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "번천장 스킬 피증", 23.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.60); break;
            }
        }
    }

    //벽파장공
    private void calcBlueWavePalm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 15.00); break; // 시속 제외
                case 18: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 15.00);
                    mergeEffect(effectsMap, "적주피", 0.32);
                    break;
                case 20: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 21.00); break; // 시속 제외
                case 18: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 21.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 21.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "낙영장 스킬 피증", 8.00); mergeEffect(effectsMap, "난화격 스킬 피증", 8.00); mergeEffect(effectsMap, "벽력장 스킬 피증", 21.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
    }

    //운기폭
    private void calcQiExplosion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환영격 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); break; // 10.0 + 15.0, 시속 제외
                case 17: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 165.00); break; // 재감 제외
                case 18: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 165.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 165.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 165.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환영격 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); break; // 10.0 + 15.0, 시속 제외
                case 17: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 180.00); break; // 재감 제외
                case 18: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 180.00); mergeEffect(effectsMap, "적주피", 0.16); break;
                case 19: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 180.00); mergeEffect(effectsMap, "적주피", 0.32); break;
                case 20: mergeEffect(effectsMap, "환영격 스킬 피증", 25.00); mergeEffect(effectsMap, "섭물진기 스킬 강인함 트라이포드 피증", 180.00); mergeEffect(effectsMap, "적주피", 0.48); break;
            }
        }
    }

    //쌍파연격
    private void calcDualWaveCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); break; // 재감 제외
                case 17: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 25.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 25.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 25.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); break;
                case 14: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); break; // 재감 제외
                case 17: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 31.00); break;
                case 18: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 31.00); mergeEffect(effectsMap, "치피증", 0.42); break;
                case 19: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 31.00); mergeEffect(effectsMap, "치피증", 0.84); break;
                case 20: mergeEffect(effectsMap, "파쇄장 스킬 피증", 15.00); mergeEffect(effectsMap, "파쇄장 스킬 피할 수 없는 일격 트라이포드 피증", 220.00); mergeEffect(effectsMap, "회선격추 스킬 피증", 31.00); mergeEffect(effectsMap, "치피증", 1.26); break;
            }
        }
    }
}
