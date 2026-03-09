package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.lanceMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LanceMasterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "창술사";
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


            if ("적룡의 기운".equals(name)) {
                calcRedDragonSpirit(effectsMap, point, grade);
            } else if ("적룡연격".equals(name)) {
                calcRedDragonCombo(effectsMap, point, grade);
            } else if ("연가 창식".equals(name)) {
                calcYeonFamilySpearStyle(effectsMap, point, grade);
            } else if ("질풍연격".equals(name)) {
                calcGaleCombo(effectsMap, point, grade);
            } else if ("연가일섬".equals(name)) {
                calcYeonFamilyFlash(effectsMap, point, grade);
            } else if ("맹룡오격".equals(name)) {
                calcFierceDragonFiveStrike(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //적룡의 기운
    private void calcRedDragonSpirit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 2.50); break;
                case 17: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break; // 백어택 강제 적용 포함
                case 18: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 2.70); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 2.90); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 3.10); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 2.50); break;
                case 17: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break; // 백어택 강제 적용 포함
                case 18: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 3.70); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 3.90); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "적룡포 스킬 피증", 10.00); break;
            }
        }
    }

    //적룡연격
    private void calcRedDragonCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); mergeEffect(effectsMap, "적주피", -15.00); break; // 집중 스킬 쿨감 60% 포함
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", -15.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", -14.80); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", -14.60); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", -14.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); mergeEffect(effectsMap, "적주피", -15.00); break; // 집중 스킬 쿨감 60% 포함
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", -15.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", -14.80); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", -14.60); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -15.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", -14.40); break;
            }
        }
    }

    //연가 창식
    private void calcYeonFamilySpearStyle(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); break; // 집중 스킬 치적 -20% 포함
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); break; // 집중 스킬 치적 -20% 포함
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 25.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 25.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "집중 스킬 치적", -20.00); mergeEffect(effectsMap, "집중 스킬 치명타 적중 시 피해량 증가", 20.00); mergeEffect(effectsMap, "난무 스킬 피증", 25.00); break;
            }
        }
    }

    //질풍연격
    private void calcGaleCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.40); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.80); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 3.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.40); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.80); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 3.00); mergeEffect(effectsMap, "맹룡열파 스킬 피증", 15.00); mergeEffect(effectsMap, "반월섬 스킬 피증", 15.00); break;
            }
        }
    }

    //연가일섬
    private void calcYeonFamilyFlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 3.00); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 3.20); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 3.40); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 3.60); mergeEffect(effectsMap, "연가비기 스킬 피증(1회)", 5.00); break;
            }
        }
    }

    //맹룡오격
    //진욱쿤(콤보 타입 스킬?)
    private void calcFierceDragonFiveStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); break; // 아덴 게이지 10% 회복 포함
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); break; // 아덴 게이지 10% 회복 포함
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.20); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.40); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 2.50); mergeEffect(effectsMap, "적주피", 2.60); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 20.00); break;
            }
        }
    }
}
