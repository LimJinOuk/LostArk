package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.lanceMaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LanceMasterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "창술사";
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


            if ("일점 집중".equals(name)) {
                calcSinglePointFocus(effectsMap, point, grade);
            } else if ("집중 강화".equals(name)) {
                calcFocusReinforce(effectsMap, point, grade);
            } else if ("청룡기".equals(name)) {
                calcAzureDragonEnergy(effectsMap, point, grade);
            } else if ("맹룡의 기운".equals(name)) {
                calcFierceDragonSpirit(effectsMap, point, grade);
            } else if ("비기승화".equals(name)) {
                calcSecretArtSublimation(effectsMap, point, grade);
            } else if ("연환 타격".equals(name)) {
                calcChainStrike(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //일점 집중
    private void calcSinglePointFocus(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break; // 연가심공 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 17.00); break;
                case 18: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 17.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 17.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 17.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); break; // 연가심공 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "집중 스킬 피증", 1.80); mergeEffect(effectsMap, "적룡포 스킬 피증", 20.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }

    //집중 강화
    //진욱쿤(17포 무력화? -> x)
    private void calcFocusReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); break; // 무력화 20% / 마나 소모 30% 감소 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 11.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 12.00); break; // 무력화 20% / 마나 소모 30% 감소 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", -20.00); mergeEffect(effectsMap, "집중 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }

    //청룡기
    private void calcAzureDragonEnergy(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 청룡진 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 피증", 7.00); break; // 난무 시전 속도 10% 증가 포함
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "집중 스킬 피증", 7.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "집중 스킬 피증", 7.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "집중 스킬 피증", 7.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 청룡진 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "집중 스킬 피증", 9.00); break; // 난무 시전 속도 10% 증가 포함
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "집중 스킬 피증", 9.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "집중 스킬 피증", 9.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "집중 스킬 피증", 9.00); break;
            }
        }
    }

    //맹룡의 기운
    private void calcFierceDragonSpirit(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 연가비기 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.00); break; // 난무 마나 소모 15% 감소 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 5.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 연가비기 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.00); break; // 난무 마나 소모 15% 감소 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 6.60); break;
            }
        }
    }

    //비기승화
    private void calcSecretArtSublimation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 최후의 판단 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 최후의 판단 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 18.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 18.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "연가비기 스킬 피증", 18.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }

    //연환 타격
    //진욱쿤(콤보 타입? -> x)
    private void calcChainStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 스킬 4회 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 10.00); break; // 난무 시전 속도 15% 증가 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 10.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); break; // 스킬 4회 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 12.00); break; // 난무 시전 속도 15% 증가 포함
                case 18: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.20); break;
                case 19: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.40); break;
                case 20: mergeEffect(effectsMap, "난무 스킬 피증", 1.50); mergeEffect(effectsMap, "콤보 타입 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 0.60); break;
            }
        }
    }
}
