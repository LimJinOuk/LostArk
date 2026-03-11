package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.wildSoul;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WildSoulSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "환수사";
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


            if ("변신술사!".equals(name)) {
                calcShapeshifter(effectsMap, point, grade);
            } else if ("곰이 될 운명!".equals(name)) {
                calcDestinedToBeBear(effectsMap, point, grade);
            } else if ("여우가 될 운명!".equals(name)) {
                calcDestinedToBeFox(effectsMap, point, grade);
            } else if ("무한 각성".equals(name)) {
                calcInfiniteAwakening(effectsMap, point, grade);
            } else if ("곰 주먹".equals(name)) {
                calcBearFist(effectsMap, point, grade);
            } else if ("까마귀의 왕".equals(name)) {
                calcKingOfCrows(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //변신술사!
    private void calcShapeshifter(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break; // 쿨감은 X
                case 18: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.63); break;
                case 19: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.76); break;
                case 20: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.89); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break; // 쿨감은 X
                case 18: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.63); break;
                case 19: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.76); break;
                case 20: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.89); break;
            }
        }
    }

    //곰이 될 운명!
    private void calcDestinedToBeBear(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 18.00); break; // 4.0 + 14.0
                case 18: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 18.00); mergeEffect(effectsMap, "곰 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 18.00); mergeEffect(effectsMap, "곰 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 18.00); mergeEffect(effectsMap, "곰 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 19.50); break; // 4.0 + 14.0
                case 18: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 19.50); mergeEffect(effectsMap, "곰 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 19.50); mergeEffect(effectsMap, "곰 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 19.50); mergeEffect(effectsMap, "곰 스킬 피증", 0.60); break;
            }
        }
    }

    //여우가 될 운명!
    private void calcDestinedToBeFox(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 10.00); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 10.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 10.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 10.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break; // 기운 획득은 X
                case 17: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 12.00); break; // 3.0 + 7.0
                case 18: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 12.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 12.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 12.00); mergeEffect(effectsMap, "여우 스킬 피증", 0.60); break;
            }
        }
    }

    //무한 각성
    //환수 각성 상태
    private void calcInfiniteAwakening(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 1.50); break; // 환수 각성 상태 조건
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 1.50); break; // 기운 회복은 X
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 4.50); break; // 1.5 + 3.0
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 4.50); mergeEffect(effectsMap, "적주피", 0.13); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 4.50); mergeEffect(effectsMap, "적주피", 0.26); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 4.50); mergeEffect(effectsMap, "적주피", 0.39); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 1.50); break; // 환수 각성 상태 조건
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 1.50); break; // 기운 회복은 X
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.50); break; // 1.5 + 3.0
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.50); mergeEffect(effectsMap, "적주피", 0.13); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.50); mergeEffect(effectsMap, "적주피", 0.26); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", -3.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 5.50); mergeEffect(effectsMap, "적주피", 0.39); break;
            }
        }
    }

    //곰 주먹
    private void calcBearFist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 14.00); mergeEffect(effectsMap, "방깎", 12.00); break; // 6.0 + 8.0 (방깎 제외)
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 24.00); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 24.35); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 24.70); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 25.05); mergeEffect(effectsMap, "방깎", 12.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 14.00); mergeEffect(effectsMap, "방깎", 12.00); break; // 6.0 + 8.0 (방깎 제외)
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 27.00); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 27.35); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 27.70); mergeEffect(effectsMap, "방깎", 12.00); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 28.05); mergeEffect(effectsMap, "방깎", 12.00); break;
            }
        }
    }

    //까마귀의 왕
    private void calcKingOfCrows(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 50.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 50.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 50.50); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 50.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 51.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 50.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 51.50); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 50.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 50.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 55.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 55.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 55.00); break;
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 55.50); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 55.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 55.00); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 56.00); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 55.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 55.00); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "마구 쪼기 스킬 피증", 56.50); mergeEffect(effectsMap, "까마귀 대소동 스킬 피증", 55.00); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 55.00); break;
            }
        }
    }
}
