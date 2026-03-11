package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.gunSilinger;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;

import java.util.HashMap;
import java.util.Map;

public class GunSilingerSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "건슬링어";
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


            if ("티거 미스트리스".equals(name)) {
                calcTigerMistress(effectsMap, point, grade);
            } else if ("연회의 잔향".equals(name)) {
                calcBanquetResonance(effectsMap, point, grade);
            } else if ("트루 에임".equals(name)) {
                calcTrueAim(effectsMap, point, grade);
            } else if ("미드나잇 로즈".equals(name)) {
                calcMidnightRose(effectsMap, point, grade);
            } else if ("무법지대".equals(name)) {
                calcNoMansLand(effectsMap, point, grade);
            } else if ("유단자".equals(name)) {
                calcBlackBelt(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //티거 미스트리스
    private void calcTigerMistress(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.66); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.82); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.98); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 8.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 8.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 10.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 10.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.66); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 10.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 10.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.82); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 10.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 10.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.98); mergeEffect(effectsMap, "포커스 샷 스킬 피증", 10.00); mergeEffect(effectsMap, "절멸의 탄환 스킬 피증", 10.00); mergeEffect(effectsMap, "마탄의 사수 스킬 피증", 10.00); break;
            }
        }
    }

    //연회의 잔향
    private void calcBanquetResonance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 25.80); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break; // 1.8 + 24.0 (최후의 만찬 제외)
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 31.80); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break; // 25.8 + 6.0 (최후의 만찬 제외)
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 32.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 32.20); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 32.40); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 25.80); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break; // 1.8 + 24.0 (최후의 만찬 제외)
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 31.80); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break; // 25.8 + 6.0 (최후의 만찬 제외)
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 32.00); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 32.20); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 32.40); mergeEffect(effectsMap, "최후의 만찬 스킬 피증", -90.00); break;
            }
        }
    }

    //트루 에임
    private void calcTrueAim(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00); break; // 2.3 + 2.5 / 보이드 피어서 1중첩 기준 16%
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 30.00); break; // 보이드 피어서 강화 30%
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 30.60); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 31.20); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 31.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.30); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 16.00); break; // 2.3 + 2.5 / 보이드 피어서 1중첩 기준 16%
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 33.00); break; // 보이드 피어서 강화 30%
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 33.60); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 34.20); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 4.80); mergeEffect(effectsMap, "타겟 다운 스킬 피증", 34.80); break;
            }
        }
    }

    //미드나잇 로즈
    private void calcMidnightRose(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 5.30); break; // 1.8 + 3.5
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 5.30); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 5.48); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 5.66); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 5.84); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 1.80); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 5.30); break; // 1.8 + 3.5
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 5.30); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 5.48); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 13.00); break;
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 5.66); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 13.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 5.84); mergeEffect(effectsMap, "로즈 블로섬 스킬 피증", 13.00); break;
            }
        }
    }

    //무법지대
    private void calcNoMansLand(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 40.00); break; // 절망의 노을 20중첩 시 40%
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 65.00); break; // 40 + 25
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 65.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 66.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 66.80); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 40.00); break; // 절망의 노을 20중첩 시 40%
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 74.00); break; // 40 + 25
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 74.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 75.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레인 오브 불릿 스킬 피증", 75.80); break;
            }
        }
    }

    //유단자
    private void calcBlackBelt(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 85.00); break; // 50 + 35
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 85.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 86.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 86.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 50.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 90.00); break; // 50 + 35
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 90.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 91.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피스키퍼 스킬 피증", 91.80); break;
            }
        }
    }
}
