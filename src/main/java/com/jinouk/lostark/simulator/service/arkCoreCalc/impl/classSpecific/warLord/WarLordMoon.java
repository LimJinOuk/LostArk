package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.warLord;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WarLordMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "워로드";
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


            if ("방어 전술".equals(name)) {
                calcDefensiveTactics(effectsMap, point, grade);
            } else if ("스트라이크 포인트".equals(name)) {
                calcStrikePoint(effectsMap, point, grade);
            } else if ("랜스 차지".equals(name)) {
                calcLanceCharge(effectsMap, point, grade);
            } else if ("방패술".equals(name)) {
                calcShieldMastery(effectsMap, point, grade);
            } else if ("함성 돌진".equals(name)) {
                calcShoutingCharge(effectsMap, point, grade);
            } else if ("번개폭풍".equals(name)) {
                calcLightningStorm(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //방어 전술
    private void calcDefensiveTactics(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 1.75); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 1.90); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 2.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 50.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 1.60); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 60.00); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 1.75); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 60.00); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 1.90); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 60.00); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 2.05); mergeEffect(effectsMap, "버스트 캐넌 스킬 치피증", 60.00); break;
            }
        }
    }

    //스트라이크 포인트
    private void calcStrikePoint(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 70.00); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 1.65); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 70.00); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 1.80); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 70.00); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 1.95); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 70.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "랜스 스킬 피증", 1.50); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 72.00); break;
                case 18: mergeEffect(effectsMap, "랜스 스킬 피증", 1.65); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 72.00); break;
                case 19: mergeEffect(effectsMap, "랜스 스킬 피증", 1.80); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 72.00); break;
                case 20: mergeEffect(effectsMap, "랜스 스킬 피증", 1.95); mergeEffect(effectsMap, "피증", -80.00); mergeEffect(effectsMap, "스피어 샷 스킬 피증", 72.00); break;
            }
        }
    }

    //랜스 차지
    private void calcLanceCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 19.50); break;
                case 18: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 19.95); break;
                case 19: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 20.40); break;
                case 20: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 20.85); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 21.50); break;
                case 18: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 21.95); break;
                case 19: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 22.40); break;
                case 20: mergeEffect(effectsMap, "차지 스팅거 스킬 피증", 22.85); break;
            }
        }
    }

    //방패술
    private void calcShieldMastery(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.15); break;
                case 19: mergeEffect(effectsMap, "피증", 4.30); break;
                case 20: mergeEffect(effectsMap, "피증", 4.45); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "피증", 5.15); break;
                case 19: mergeEffect(effectsMap, "피증", 5.30); break;
                case 20: mergeEffect(effectsMap, "피증", 5.45); break;
            }
        }
    }

    //함성 돌진
    private void calcShoutingCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 14.50); break;
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 15.05); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 15.60); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 16.15); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 17.50); break;
                case 18: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 18.05); break;
                case 19: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 18.60); break;
                case 20: mergeEffect(effectsMap, "방패 돌진 스킬 피증", 19.15); break;
            }
        }
    }

    //번개폭풍
    private void calcLightningStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 19.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 19.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 19.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 19.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); mergeEffect(effectsMap, "가디언의 낙뢰 스킬 피증", 24.00); break;
            }
        }
    }
}
