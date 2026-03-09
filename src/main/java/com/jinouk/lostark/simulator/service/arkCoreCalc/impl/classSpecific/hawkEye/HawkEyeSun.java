package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.hawkEye;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HawkEyeSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "호크아이";
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


            if ("TA-09 피어싱 애로우".equals(name)) {
                calcTa09PiercingArrow(effectsMap, point, grade);
            } else if ("ATB-07 니들레인".equals(name)) {
                calcAtb07NeedleRain(effectsMap, point, grade);
            } else if ("TA-12 버스팅 애로우".equals(name)) {
                calcTa12BurstingArrow(effectsMap, point, grade);
            } else if ("ATB-03 볼트 랩터".equals(name)) {
                calcAtb03BoltRaptor(effectsMap, point, grade);
            } else if ("TA-64 리퍼 볼".equals(name)) {
                calcTa64ReaperBall(effectsMap, point, grade);
            } else if ("ATB-19 스톰리피터".equals(name)) {
                calcAtb19StormRepeater(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //TA-09 피어싱 애로우
    private void calcTa09PiercingArrow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 42.00); break; // 20.0 + 22.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 42.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 43.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 43.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 46.00); break; // 20.0 + 22.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 46.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 47.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "스나이프 스킬 피증", 47.80); break;
            }
        }
    }

    //ATB-07 니들레인
    private void calcAtb07NeedleRain(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 4.00); break; // 데스 레이닝 효과
                case 18: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 4.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 4.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 4.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 3.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 5.00); break; // 데스 레이닝 효과
                case 18: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 5.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 5.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "호크아이 스킬 피증", 5.00); mergeEffect(effectsMap, "애로우 샤워 스킬 피증", 3.00); break;
            }
        }
    }

    //TA-12 버스팅 애로우
    private void calcTa12BurstingArrow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 30.00); break; // 10.0 + 10.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 30.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 1.40); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 30.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 2.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 30.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 4.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 20.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 32.00); break; // 10.0 + 10.0
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 32.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 1.40); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 32.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 2.80); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증(이동 베기, 급소 베기, 블레이드 스톰, 아토믹 애로우, 크레모아 지뢰 제외)", 32.00); mergeEffect(effectsMap, "크레모아 지뢰 스킬 피증", 4.20); break;
            }
        }
    }

    //ATB-03 볼트 랩터
    private void calcAtb03BoltRaptor(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 18: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.60); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.60); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 19: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 11.20); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.20); mergeEffect(effectsMap, "적주피", 4.00); break;
                case 20: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 11.80); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.80); mergeEffect(effectsMap, "적주피", 4.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.00); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.00); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 18: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 10.60); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 10.60); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 19: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 11.20); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.20); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "폭풍의 날개 스킬 피증", 11.80); mergeEffect(effectsMap, "실버호크 기본 공격 피증", 11.80); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        }
    }

    //TA-64 리퍼 볼트
    private void calcTa64ReaperBall(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.00); break; // 20중첩 기준 200%
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.00); break; // 유물 단계 피증 증가 0%
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 201.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 201.80); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.00); break; // 20중첩 기준 200%
                case 17: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.00); break; // 유물 단계 피증 증가 0%
                case 18: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 200.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 201.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "차징 샷 스킬 피증", 201.80); break;
            }
        }
    }

    //ATB-19 스톰리피터
    private void calcAtb19StormRepeater(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 24.00); break; // 10.0 -> 24.0으로 변경
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 24.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 25.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 26.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 30.00); break; // 10.0 -> 24.0으로 변경
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 30.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 31.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "래피드 샷 스킬 피증", 31.40); break;
            }
        }
    }
}
