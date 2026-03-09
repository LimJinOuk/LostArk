package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.slayer;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SlayerSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "슬레이어";
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


            if ("단두대".equals(name)) {
                calcGuillotine(effectsMap, point, grade);
            } else if ("분노압축".equals(name)) {
                calcRageCompression(effectsMap, point, grade);
            } else if ("격노폭발".equals(name)) {
                calcFuryExplosion(effectsMap, point, grade);
            } else if ("차오르는 분노".equals(name)) {
                calcRisingRage(effectsMap, point, grade);
            } else if ("예측불가".equals(name)) {
                calcUnpredictable(effectsMap, point, grade);
            } else if ("회오리".equals(name)) {
                calcWhirlwind(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //단두대
    //진욱쿤(폭주 상태 -> 피증(폭주 상태 제거))
    private void calcGuillotine(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); break; // 쿨초 제외
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 14.00); break; // 쿨초 제외
                case 18: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 14.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 14.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 14.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 14.00); break; // 쿨초 제외
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 18.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.00); break; // 쿨초 제외
                case 18: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 18.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 18.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 18.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.00); break;
            }
        }
    }

    //분노압축
    private void calcRageCompression(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); break;
                case 14: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); mergeEffect(effectsMap, "차지 스킬 치피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "차지 스킬 적주피", 15.00); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break; // 기본 3.0 + 압축 효과 12.0
                case 18: mergeEffect(effectsMap, "차지 스킬 적주피", 15.30); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "차지 스킬 적주피", 15.60); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "차지 스킬 적주피", 15.90); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); break;
                case 14: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); mergeEffect(effectsMap, "차지 스킬 치피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "차지 스킬 적주피", 18.00); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break; // 기본 3.0 + 압축 효과 12.0
                case 18: mergeEffect(effectsMap, "차지 스킬 적주피", 18.30); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "차지 스킬 적주피", 18.60); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "차지 스킬 적주피", 18.90); mergeEffect(effectsMap, "차지 스킬 치피증", 40.00); break;
            }
        }
    }

    //격노폭발
    private void calcFuryExplosion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 25.00); break; // 쿨초 제외, 최대 피증 기준
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 50.00); break; // 게이지 획득량 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 50.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 25.00); break; // 쿨초 제외, 최대 피증 기준
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 55.00); break; // 게이지 획득량 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 55.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 55.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", -40.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 55.00); break;
            }
        }
    }

    //차오르는 분노
    private void calcRisingRage(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 36.00); mergeEffect(effectsMap, "치피증", 12.00); break; // 기존 8.0 + (14.0 * 2중첩)
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 36.30); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 36.60); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 36.90); mergeEffect(effectsMap, "치피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 40.00); mergeEffect(effectsMap, "치피증", 12.00); break; // 기존 8.0 + (14.0 * 2중첩)
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 40.30); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 40.60); mergeEffect(effectsMap, "치피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 40.90); mergeEffect(effectsMap, "치피증", 12.00); break;
            }
        }
    }

    //예측불가
    //진욱쿤(선택한 스킬 피증? -> 피증)
    private void calcUnpredictable(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 쿨초, 마나 회복 제외
                case 17: mergeEffect(effectsMap, "적주피", 3.50); mergeEffect(effectsMap, "피증", 7.00); break; // 기존 1.5 + 신규 2.0
                case 18: mergeEffect(effectsMap, "적주피", 3.70); mergeEffect(effectsMap, "피증", 7.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 3.90); mergeEffect(effectsMap, "피증", 7.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "피증", 7.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 쿨초, 마나 회복 제외
                case 17: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "피증", 7.00); break; // 기존 1.5 + 신규 2.0
                case 18: mergeEffect(effectsMap, "적주피", 4.70); mergeEffect(effectsMap, "피증", 7.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.90); mergeEffect(effectsMap, "피증", 7.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.10); mergeEffect(effectsMap, "피증", 7.00); break;
            }
        }
    }

    //회오리
    private void calcWhirlwind(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 70.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break; // 기존 20.0 + 신규 50.0
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 70.40); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 70.80); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 71.20); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 72.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break; // 기존 20.0 + 신규 50.0
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 72.40); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 72.80); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 73.20); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 100.00); break;
            }
        }
    }
}
