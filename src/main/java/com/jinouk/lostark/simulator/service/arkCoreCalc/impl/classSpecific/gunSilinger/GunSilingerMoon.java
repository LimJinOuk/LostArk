package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.gunSilinger;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GunSilingerMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "건슬링어";
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


            if ("제너럴리스트".equals(name)) {
                calcGeneralist(effectsMap, point, grade);
            } else if ("체인지 암즈".equals(name)) {
                calcChangeArms(effectsMap, point, grade);
            } else if ("방패 조준".equals(name)) {
                calcShieldAim(effectsMap, point, grade);
            } else if ("철갑파쇄탄".equals(name)) {
                calcArmorPiercingShell(effectsMap, point, grade);
            } else if ("불릿 무빙".equals(name)) {
                calcBulletMoving(effectsMap, point, grade);
            } else if ("건법".equals(name)) {
                calcGunKata(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //제너럴리스트
    private void calcGeneralist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "핸드건 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 스킬 피증", 4.00); mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "핸드건 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 스킬 피증", 4.00); mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "핸드건 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 스킬 피증", 4.00); mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "핸드건 스킬 피증", 5.00); mergeEffect(effectsMap, "샷건 스킬 피증", 4.00); mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "핸드건 스킬 피증", 6.00); mergeEffect(effectsMap, "샷건 스킬 피증", 5.00); mergeEffect(effectsMap, "라이플 스킬 피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "핸드건 스킬 피증", 6.00); mergeEffect(effectsMap, "샷건 스킬 피증", 5.00); mergeEffect(effectsMap, "라이플 스킬 피증", 4.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "핸드건 스킬 피증", 6.00); mergeEffect(effectsMap, "샷건 스킬 피증", 5.00); mergeEffect(effectsMap, "라이플 스킬 피증", 4.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "핸드건 스킬 피증", 6.00); mergeEffect(effectsMap, "샷건 스킬 피증", 5.00); mergeEffect(effectsMap, "라이플 스킬 피증", 4.00); break;
            }
        }
    }

    //체인지 암즈
    private void calcChangeArms(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 13.30); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 13.50); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 13.70); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 13.90); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 14.80); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 15.00); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 15.20); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 15.40); mergeEffect(effectsMap, "라이플 스킬 피증", -10.0); break;
            }
        }
    }

    //방패 조준
    private void calcShieldAim(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 25.60); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 26.20); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 26.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 29.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 29.60); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 30.20); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 30.80); break;
            }
        }
    }

    //철갑파쇄탄
    private void calcArmorPiercingShell(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 5.80); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 5.98); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 6.16); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 6.34); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 6.80); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 6.98); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 7.16); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 7.34); break;
            }
        }
    }

    //불릿 무빙
    private void calcBulletMoving(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 25.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 26.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 26.80); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 34.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 34.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 35.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 35.80); break;
            }
        }
    }

    //건법
    private void calcGunKata(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 34.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 34.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 35.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 35.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 39.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 39.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 40.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 40.80); break;
            }
        }
    }
}
