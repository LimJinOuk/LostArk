package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.arcana;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArcanaStar implements IArkGrid {

    @Override
    public String getClassName() {
        return "아르카나";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 별 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("스트림 오브 엣지".equals(name)) {
                calcStreamOfEdge(effectsMap, point, grade);
            } else if ("페이탈 핸드".equals(name)) {
                calcFatalHand(effectsMap, point, grade);
            }
        });

        for (Map.Entry<String, Double> entry : effectsMap.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        return new ArkGridResponseDto(effectsMap);
    }

    // --- 스트림 오브 엣지 계산 로직 ---
    private void calcStreamOfEdge(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공속증", 8.0); break;
                case 14: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.0); break;
                case 17: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.0); mergeEffect(effectsMap, "치피증", 2.2); break;
                case 18: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.8); mergeEffect(effectsMap, "치피증", 2.2); break;
                case 19: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 9.6); mergeEffect(effectsMap, "치피증", 2.2); break;
                case 20: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 10.4); mergeEffect(effectsMap, "치피증", 2.2); break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "공속증", 8.0); break;
                case 14: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.0); break;
                case 17: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.0); mergeEffect(effectsMap, "치피증", 1.6); break;
                case 18: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 8.8); mergeEffect(effectsMap, "치피증", 1.6); break;
                case 19: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 9.6); mergeEffect(effectsMap, "치피증", 1.6); break;
                case 20: mergeEffect(effectsMap, "공속증", 8.0); mergeEffect(effectsMap, "피증", 10.4); mergeEffect(effectsMap, "치피증", 1.6); break;
            }
        }
    }

    // --- 페이탈 핸드 계산 로직 ---
    private void calcFatalHand(Map<String, Double> effectsMap, int point, String grade) {
        if ("고대".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "치피증", 20.0); break;
                case 17: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 12.0);  break;
                case 18: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 13.15);  break;
                case 19: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 13.30); break;
                case 20: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 13.45);  break;
            }
        } else if ("유물".equals(grade)) {
            switch (point) {
                case 14: mergeEffect(effectsMap, "치피증", 20.0); break;
                case 17: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 12.0);  break;
                case 18: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 12.15);  break;
                case 19: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 12.30); break;
                case 20: mergeEffect(effectsMap, "치피증", 20.0); mergeEffect(effectsMap, "피증", 12.45);  break;
            }
        }
    }

    private void mergeEffect(Map<String, Double> effectsMap, String key, Double value) {
        effectsMap.put(key, effectsMap.getOrDefault(key, 0.0) + value);
    }
}