package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.battleMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BattleMasterMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "배틀마스터";
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


            if ("초강풍각".equals(name)) {
                calcSuperWindAngle(effectsMap, point, grade);
            } else if ("귀원화신".equals(name)) {
                calcGwiwonhwasin(effectsMap, point, grade);
            } else if ("초순환".equals(name)) {
                calcSuperCirculation(effectsMap, point, grade);
            } else if ("패황지도".equals(name)) {
                calcMapOfRuin(effectsMap, point, grade);
            } else if ("화룡진천".equals(name)) {
                calcHwaryongjincheon(effectsMap, point, grade);
            } else if ("심안".equals(name)) {
                calcMindEye(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //초강풍각
    //진욱쿤 찬스(10포 -> 치피증 17포 -> 최대값으로  18포~20포 -> 치명타 시 피해량 증가)
    private void calcSuperWindAngle(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 7.00); break; // 3.0 + 4.0
                case 18: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
                case 19: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
                case 20: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 7.00); break; // 3.0 + 4.0
                case 18: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
                case 19: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
                case 20: mergeEffect(effectsMap, "치피증", 7.00); mergeEffect(effectsMap, "적주피", 28.00); break;
            }
        }
    }

    //귀원화신
    private void calcGwiwonhwasin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60);  break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.76); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00);  break; // 36.0 + 0.65
                case 19: mergeEffect(effectsMap, "피증", 1.92); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00); break; // 36.65 + 0.65
                case 20: mergeEffect(effectsMap, "피증", 2.08); mergeEffect(effectsMap, "방천격 스킬 피증", 15.00);  break; // 37.30 + 0.65
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "피증", 1.60);  break;
                case 17: mergeEffect(effectsMap, "피증", 1.60); mergeEffect(effectsMap, "방천격 스킬 피증", 19.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.76); mergeEffect(effectsMap, "방천격 스킬 피증", 19.00); break; // 36.0 + 0.65
                case 19: mergeEffect(effectsMap, "피증", 1.92); mergeEffect(effectsMap, "방천격 스킬 피증", 19.00); break; // 36.65 + 0.65
                case 20: mergeEffect(effectsMap, "피증", 2.08); mergeEffect(effectsMap, "방천격 스킬 피증", 19.00); break; // 37.30 + 0.65
            }
        }
    }

    //초순환
    private void calcSuperCirculation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.16); break; // 3.50 + 0.15
                case 19: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.32); break; // 3.65 + 0.15
                case 20: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.48); break; // 3.80 + 0.15
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "치피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.16); break; // 3.50 + 0.15
                case 19: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.32); break; // 3.65 + 0.15
                case 20: mergeEffect(effectsMap, "치피증", 3.00); mergeEffect(effectsMap, "피증", 0.48); break; // 3.80 + 0.15
            }
        }
    }

    //패황지도
    private void calcMapOfRuin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break; // 운명 발동 (수치 변화 없음)
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 4.40); mergeEffect(effectsMap, "적주피", -25.0); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 4.80); mergeEffect(effectsMap, "적주피", -25.0); break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.20); mergeEffect(effectsMap, "적주피", -25.0); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break; // 운명 발동 (수치 변화 없음)
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 4.40);mergeEffect(effectsMap, "적주피", -23.0); break;
                case 19: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 4.80);mergeEffect(effectsMap, "적주피", -23.0);break;
                case 20: mergeEffect(effectsMap, "오의 : 창룡패황권 스킬 피증", 5.20); mergeEffect(effectsMap, "적주피", -23.0);break;
            }
        }
    }

    //화룡진천
    private void calcHwaryongjincheon(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 1.95); break;
                case 18: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 2.35); mergeEffect(effectsMap, "적주피", -16.0); break;
                case 19: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 2.75); mergeEffect(effectsMap, "적주피", -16.0); break;
                case 20: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.15); mergeEffect(effectsMap, "적주피", -16.0); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 1.95); break;
                case 18: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 2.35); mergeEffect(effectsMap, "적주피", -13.0); break;
                case 19: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 2.75); mergeEffect(effectsMap, "적주피", -13.0); break;
                case 20: mergeEffect(effectsMap, "오의 : 화룡천상 스킬 피증", 3.15); mergeEffect(effectsMap, "적주피", -13.0); break;
            }
        }
    }

    //심안
    //진욱쿤 찬스(17포: 치명타로 적중 시 적에게 주는 피해 18포~20포: 치명타 피해량이 증가)
    private void calcMindEye(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 4.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 4.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 4.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 4.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 14: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); break;
                case 17: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 5.00); break;
                case 18: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 5.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 5.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "오의 스킬 피증", 1.55); mergeEffect(effectsMap, "오의 스킬 치명타 시 피해량 증가", 5.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.50); break;
            }
        }
    }
}
