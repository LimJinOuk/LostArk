package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.warLord;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WarLordSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "워로드";
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


            if ("전술 제어".equals(name)) {
                calcTacticalControl(effectsMap, point, grade);
            } else if ("창술".equals(name)) {
                calcSpearmanship(effectsMap, point, grade);
            } else if ("종전".equals(name)) {
                calcWarTermination(effectsMap, point, grade);
            } else if ("방패 연계".equals(name)) {
                calcShieldCombo(effectsMap, point, grade);
            } else if ("연속 돌진".equals(name)) {
                calcConsecutiveCharge(effectsMap, point, grade);
            } else if ("천둥".equals(name)) {
                calcThunder(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //전술 제어
    private void calcTacticalControl(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 5.60); break; // 1.6 + 4.0
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 5.60); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 7.50); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 5.75); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 7.50); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 5.90); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 7.50); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 6.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 7.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 5.60); break; // 1.6 + 4.0
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 5.60); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 11.00); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 5.75); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 11.00); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 5.90); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 11.00); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 6.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 피증", 11.00); break;
            }
        }
    }

    //창술
    private void calcSpearmanship(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 13.00); break;
                case 14: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 13.00); break; // 재사용 대기시간 감소는 X
                case 17: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 39.00); break; // 13.0 + 26.0
                case 18: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 39.38); break;
                case 19: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 39.76); break;
                case 20: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 40.14); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 13.00); break;
                case 14: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 13.00); break; // 재사용 대기시간 감소는 X
                case 17: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 41.00); break; // 13.0 + 26.0
                case 18: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 41.38); break;
                case 19: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 41.76); break;
                case 20: mergeEffect(effectsMap, "스피어 샷 스킬 피증", 42.14); break;
            }
        }
    }

    //종전
    private void calcWarTermination(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break; // 감소는 -로 표시
                case 17: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 15.50); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break; // 7.0 + 8.5
                case 18: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 15.95); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
                case 19: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 16.40); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
                case 20: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 16.85); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break; // 감소는 -로 표시
                case 17: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 17.50); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break; // 7.0 + 8.5
                case 18: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 17.95); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
                case 19: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 18.40); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
                case 20: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 18.85); mergeEffect(effectsMap, "랜스 스킬 피증", -4.00); break;
            }
        }
    }

    //방패 연계
    private void calcShieldCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break; // 재사용 대기시간 감소는 X
                case 17: mergeEffect(effectsMap, "피증", 3.50); break; // 1.5 + 2.0
                case 18: mergeEffect(effectsMap, "피증", 3.65); break;
                case 19: mergeEffect(effectsMap, "피증", 3.80); break;
                case 20: mergeEffect(effectsMap, "피증", 3.95); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break; // 재사용 대기시간 감소는 X
                case 17: mergeEffect(effectsMap, "피증", 4.50); break; // 1.5 + 2.0
                case 18: mergeEffect(effectsMap, "피증", 4.65); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); break;
                case 20: mergeEffect(effectsMap, "피증", 4.95); break;
            }
        }
    }

    //연속 돌진
    private void calcConsecutiveCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break; // 재사용 대기시간 관련은 X
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 13.50); break; // 6.0 + 7.5
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 14.05); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 14.60); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 15.15); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break; // 재사용 대기시간 관련은 X
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 16.50); break; // 6.0 + 7.5
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 17.05); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 17.60); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 18.15); break;
            }
        }
    }

    //천둥
    private void calcThunder(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); break; // 중첩은 최대값(10중첩 * 2.0)
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 4.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 4.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 4.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); break; // 중첩은 최대값(10중첩 * 2.0)
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 6.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 6.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 6.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 20.00); mergeEffect(effectsMap, "치적", 6.00); break;
            }
        }
    }
}
