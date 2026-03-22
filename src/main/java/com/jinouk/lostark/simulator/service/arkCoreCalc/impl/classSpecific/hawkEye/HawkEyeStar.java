package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.hawkEye;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HawkEyeStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "호크아이";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 별 코어";
    }


    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        validateItems(requestDto);

        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;


            if ("HSU-04 자동 제어 스코프".equals(name)) {
                calcHsu04AutoControlScope(effectsMap, point, grade);
            } else if ("HSU-17 일렉트릭 노바".equals(name)) {
                calcHsu17ElectricNova(effectsMap, point, grade);
            } else if ("HSU-31 블록버스터".equals(name)) {
                calcHsu31Blockbuster(effectsMap, point, grade);
            } else if ("HSU-06 레이저사이트".equals(name)) {
                calcHsu06LaserSight(effectsMap, point, grade);
            } else if ("HSU-57 근력 보조 장갑".equals(name)) {
                calcHsu57PowerAssistGlove(effectsMap, point, grade);
            } else if ("HSU-22 사지 안정기".equals(name)) {
                calcHsu22LimbStabilizer(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //HSU-04 자동 제어 스코프
    private void calcHsu04AutoControlScope(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가만 있음
                case 14: mergeEffect(effectsMap, "스나이프 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "스나이프 스킬 피증", 15.00); break; // 8.0 + 7.0
                case 18: mergeEffect(effectsMap, "스나이프 스킬 피증", 15.60); break;
                case 19: mergeEffect(effectsMap, "스나이프 스킬 피증", 16.20); break;
                case 20: mergeEffect(effectsMap, "스나이프 스킬 피증", 16.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가만 있음
                case 14: mergeEffect(effectsMap, "스나이프 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.00); break; // 8.0 + 7.0
                case 18: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.60); break;
                case 19: mergeEffect(effectsMap, "스나이프 스킬 피증", 19.20); break;
                case 20: mergeEffect(effectsMap, "스나이프 스킬 피증", 19.80); break;
            }
        }
    }

    //HSU-17 일렉트릭 노바
    private void calcHsu17ElectricNova(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); break;
                case 17: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 60.00); break;
                case 18: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 9.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 60.00); break;
                case 19: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 10.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 60.00); break;
                case 20: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 11.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 60.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); break;
                case 17: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 8.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 70.00); break;
                case 18: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 9.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 70.00); break;
                case 19: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 10.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 70.00); break;
                case 20: mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 11.00); mergeEffect(effectsMap, "애로우 샤워 스킬 전기 세례 트라이포드 피증", 180.00); mergeEffect(effectsMap, "애로우 샤워 스킬 꿰뚫는 화살 트라이포드 피증", 70.00); break;
            }
        }
    }

    //HSU-31 블록버스터
    private void calcHsu31Blockbuster(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 10.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 30.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 100.00); break; // 10.0 + 20.0
                case 18: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 30.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 105.00); break;
                case 19: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 30.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 110.00); break;
                case 20: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 30.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 115.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 10.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 40.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 100.00); break; // 10.0 + 20.0
                case 18: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 40.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 105.00); break;
                case 19: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 40.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 110.00); break;
                case 20: mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 40.00); mergeEffect(effectsMap, "아토믹 애로우 스킬 피증", 115.00); break;
            }
        }
    }

    //HSU-06 레이저사이트
    private void calcHsu06LaserSight(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스나이프 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "스나이프 스킬 피증", 6.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 20.00); break; // 6.0 + 12.0
                case 18: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 21.40); break;
                case 19: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 22.80); break;
                case 20: mergeEffect(effectsMap, "스나이프 스킬 피증", 18.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 24.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "스나이프 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "스나이프 스킬 피증", 6.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "스나이프 스킬 피증", 22.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 20.00); break; // 6.0 + 12.0
                case 18: mergeEffect(effectsMap, "스나이프 스킬 피증", 22.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 21.40); break;
                case 19: mergeEffect(effectsMap, "스나이프 스킬 피증", 22.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 22.80); break;
                case 20: mergeEffect(effectsMap, "스나이프 스킬 피증", 22.00); mergeEffect(effectsMap, "호크 샷 스킬 피증", 24.20); break;
            }
        }
    }

    //HSU-57 근력 보조 장갑
    private void calcHsu57PowerAssistGlove(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차징 샷 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.00); break; // 7.0 + 100.0
                case 17: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.00); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.60); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "차징 샷 스킬 피증", 108.20); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "차징 샷 스킬 피증", 108.80); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 10.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차징 샷 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.00); break; // 7.0 + 100.0
                case 17: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.00); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "차징 샷 스킬 피증", 107.60); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "차징 샷 스킬 피증", 108.20); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "차징 샷 스킬 피증", 108.80); mergeEffect(effectsMap, "차징 샷 스킬 정조준 트라이포드 피증", 15.00); break;
            }
        }
    }

    //HSU-22 사지 안정기
    private void calcHsu22LimbStabilizer(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가만 있음
                case 14: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 156.00); break; // 16.0 + 140.0
                case 18: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 156.80); break;
                case 19: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 157.60); break;
                case 20: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 158.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가만 있음
                case 14: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 166.00); break; // 16.0 + 140.0
                case 18: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 166.80); break;
                case 19: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 167.60); break;
                case 20: mergeEffect(effectsMap, "래피드 샷 스킬 피증", 168.40); break;
            }
        }
    }
}
