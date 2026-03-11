package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.artist;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "도화가";
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


            if ("조화의 완성".equals(name)) {
                calcHarmony(effectsMap, point, grade);
            } else if ("명필".equals(name)) {
                calcFineHand(effectsMap, point, grade);
            } else if ("정월 대보름".equals(name)) {
                calcJeongwol(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //조화의 완성
    private void calcHarmony(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 10.50);
                    break; // 6.0 + 4.5
                case 18:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 10.90);
                    break; // 10.5 + 0.4
                case 19:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 11.30);
                    break; // 10.9 + 0.4
                case 20:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 11.70);
                    break; // 11.3 + 0.4
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00);
                    break;
                case 14:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00);
                    break;
                case 17:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.00);
                    break; // 6.0 + 7.0
                case 18:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.40);
                    break; // 13.0 + 0.4
                case 19:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 13.80);
                    break; // 13.4 + 0.4
                case 20:
                    mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 14.20);
                    break; // 13.8 + 0.4
            }
        }
    }

    //명필
    private void calcFineHand(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    break;
                case 14:
                    break;
                case 17:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 36.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 36.65);
                    break; // 36.0 + 0.65
                case 19:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 37.30);
                    break; // 36.65 + 0.65
                case 20:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 37.95);
                    break; // 37.30 + 0.65
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    break;
                case 14:
                    break;
                case 17:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 39.00);
                    break;
                case 18:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 39.65);
                    break; // 36.0 + 0.65
                case 19:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 40.30);
                    break; // 36.65 + 0.65
                case 20:
                    mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 40.95);
                    break; // 37.30 + 0.65
            }
        }
    }

    //정월 대보름
    private void calcJeongwol(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10:
                    break;
                case 14:
                    break;
                case 17:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 3.50);
                    break;
                case 18:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 3.65);
                    break; // 3.50 + 0.15
                case 19:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 3.80);
                    break; // 3.65 + 0.15
                case 20:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 3.95);
                    break; // 3.80 + 0.15
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10:
                    break;
                case 14:
                    break;
                case 17:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 5.50);
                    break;
                case 18:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 5.65);
                    break; // 3.50 + 0.15
                case 19:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 5.80);
                    break; // 3.65 + 0.15
                case 20:
                    mergeEffect(effectsMap, "묵법 스킬 피증", 5.95);
                    break; // 3.80 + 0.15
            }
        }
    }
}
