package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.guardianKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GuardianKnightMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "가디언나이트";
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


            if ("노바 플레임".equals(name)) {
                calcNovaFlame(effectsMap, point, grade);
            } else if ("리버레이션".equals(name)) {
                calcLiberation(effectsMap, point, grade);
            } else if ("복수귀".equals(name)) {
                calcAvenger(effectsMap, point, grade);
            } else if ("위압".equals(name)) {
                calcOverpower(effectsMap, point, grade);
            } else if ("플러리쉬".equals(name)) {
                calcFlourish(effectsMap, point, grade);
            } else if ("도미넌트".equals(name)) {
                calcDominant(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //노바 플레임
    //진욱쿤 찬스(화신 상태 -> 적주피)
    private void calcNovaFlame(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); break; // 1.5 + 5.0
                case 18: mergeEffect(effectsMap, "적주피", 6.73); break; // 6.5 + 0.23
                case 19: mergeEffect(effectsMap, "적주피", 6.96); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.19); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 8.00); break; // 1.5 + 5.0
                case 18: mergeEffect(effectsMap, "적주피", 8.23); break; // 6.5 + 0.23
                case 19: mergeEffect(effectsMap, "적주피", 8.46); break;
                case 20: mergeEffect(effectsMap, "적주피", 8.69); break;
            }
        }
    }

    //리버레이션
    private void calcLiberation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "발현 스킬 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "발현 스킬 피증", 8.32); break;
                case 19: mergeEffect(effectsMap, "발현 스킬 피증", 8.64); break;
                case 20: mergeEffect(effectsMap, "발현 스킬 피증", 8.96); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "발현 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "발현 스킬 피증", 10.32); break;
                case 19: mergeEffect(effectsMap, "발현 스킬 피증", 10.64); break;
                case 20: mergeEffect(effectsMap, "발현 스킬 피증", 10.96); break;
            }
        }
    }

    //복수귀
    private void calcAvenger(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.23); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.46); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 100.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.69); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.23); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.46); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "리벤지 스피어 스킬 피증", 114.00); mergeEffect(effectsMap, "화신 스킬 피증", 0.69); break;
            }
        }
    }

    //위압
    //진욱쿤 찬스(피증)
    private void calcOverpower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.20); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.40); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.60); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 40.00); break;;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 46.00); break;
                case 18: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.20); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 46.00); break;
                case 19: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.40); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 46.00); break;
                case 20: mergeEffect(effectsMap, "차지 조작 스킬 피증", 2.60); mergeEffect(effectsMap, "임페일 쇼크 스킬 피증", 46.00); break;
            }
        }
    }

    //플러리쉬
    private void calcFlourish(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 10.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 12.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.66); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 12.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.82); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 12.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.98); mergeEffect(effectsMap, "길로틴 스핀 스킬 피증", 10.00); mergeEffect(effectsMap, "프렌지 스윕 스킬 피증", 12.50); break;
            }
        }
    }

    //도미넌트
    //(초월 상태 적주피 -> 적주피)
    private void calcDominant(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break; // 1.5 + 4.0
                case 18: mergeEffect(effectsMap, "적주피", 5.66); break; // 5.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 5.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 7.00); break; // 1.5 + 4.0
                case 18: mergeEffect(effectsMap, "적주피", 7.16); break; // 5.5 + 0.16
                case 19: mergeEffect(effectsMap, "적주피", 7.32); break;
                case 20: mergeEffect(effectsMap, "적주피", 7.48); break;
            }
        }
    }
}
