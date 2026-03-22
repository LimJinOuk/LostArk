package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.wildSoul;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WildSoulMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "환수사";
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

            if ("금술".equals(name)) {
                calcForbiddenArt(effectsMap, point, grade);
            } else if ("센 곰".equals(name)) {
                calcMightyBear(effectsMap, point, grade);
            } else if ("센 여우".equals(name)) {
                calcMightyFox(effectsMap, point, grade);
            } else if ("환수 해방".equals(name)) {
                calcPhantomBeastRelease(effectsMap, point, grade);
            } else if ("빙글빙글".equals(name)) {
                calcRoundAndRound(effectsMap, point, grade);
            } else if ("까마귀 내려온다".equals(name)) {
                calcCrowDescending(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //금술
    private void calcForbiddenArt(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "둔갑 스킬 피증", 6.50); break; // 1.5 + 5.0
                case 18: mergeEffect(effectsMap, "둔갑 스킬 피증", 6.63); break;
                case 19: mergeEffect(effectsMap, "둔갑 스킬 피증", 6.76); break;
                case 20: mergeEffect(effectsMap, "둔갑 스킬 피증", 6.89); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "둔갑 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "둔갑 스킬 피증", 9.00); break; // 1.5 + 5.0
                case 18: mergeEffect(effectsMap, "둔갑 스킬 피증", 9.13); break;
                case 19: mergeEffect(effectsMap, "둔갑 스킬 피증", 9.26); break;
                case 20: mergeEffect(effectsMap, "둔갑 스킬 피증", 9.39); break;
            }
        }
    }

    //센 곰
    private void calcMightyBear(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 8.50); break;
                case 18: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 8.70); break;
                case 19: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 8.90); break;
                case 20: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 9.10); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 10.50); break;
                case 18: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 10.70); break;
                case 19: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 10.90); break;
                case 20: mergeEffect(effectsMap, "금술 : 찢 곰 스킬 피증", 4.00); mergeEffect(effectsMap, "곰 스킬 피증", 11.10); break;
            }
        }
    }

    //센 여우
    private void calcMightyFox(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 8.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 8.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 8.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 10.20); break;
                case 19: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 10.40); break;
                case 20: mergeEffect(effectsMap, "금술 : 여우 별 소나기 스킬 피증", 3.00); mergeEffect(effectsMap, "여우 스킬 피증", 10.60); break;
            }
        }
    }

    //환수 해방
    //환수 각성 상태
    private void calcPhantomBeastRelease(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환수 스킬 피증", 2.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.63); mergeEffect(effectsMap, "환수 스킬 피증", 2.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.76); mergeEffect(effectsMap, "환수 스킬 피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.89); mergeEffect(effectsMap, "환수 스킬 피증", 2.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "환수 스킬 피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.63); mergeEffect(effectsMap, "환수 스킬 피증", 3.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.76); mergeEffect(effectsMap, "환수 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.89); mergeEffect(effectsMap, "환수 스킬 피증", 3.00); break;
            }
        }
    }

    //빙글빙글
    private void calcRoundAndRound(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 16.00); break; // 6.0 + 10.0 (보호막 제외)
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 16.35); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 16.70); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 17.05); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 19.00); break; // 6.0 + 10.0 (보호막 제외)
                case 18: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 19.35); break;
                case 19: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 19.70); break;
                case 20: mergeEffect(effectsMap, "빙글빙글 꽝 스킬 피증", 20.05); break;
            }
        }
    }

    //까마귀 내려온다
    private void calcCrowDescending(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break; // 재사용 대기시간 감소는 X
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 7.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); break; // 재사용 대기시간 감소는 X
                case 18: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 2.50); break;
                case 19: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 5.00); break;
                case 20: mergeEffect(effectsMap, "환수 스킬 피증", 1.60); mergeEffect(effectsMap, "까마귀 대행진 스킬 피증", 7.50); break;
            }
        }
    }
}
