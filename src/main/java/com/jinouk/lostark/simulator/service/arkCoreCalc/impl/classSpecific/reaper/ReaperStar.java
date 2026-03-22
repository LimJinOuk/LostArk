package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.reaper;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReaperStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "리퍼";
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


            if ("할루시네이션".equals(name)) {
                calcHallucination(effectsMap, point, grade);
            } else if ("암살자의 그림자".equals(name)) {
                calcAssassinsShadow(effectsMap, point, grade);
            } else if ("데스 루프".equals(name)) {
                calcDeathLoop(effectsMap, point, grade);
            } else if ("급습 악몽".equals(name)) {
                calcRaidNightmare(effectsMap, point, grade);
            } else if ("치명적 연계".equals(name)) {
                calcFatalLink(effectsMap, point, grade);
            } else if ("다가오는 죽음".equals(name)) {
                calcApproachingDeath(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //할루시네이션
    private void calcHallucination(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 2.50); break;
                case 18: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 2.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 2.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 2.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); break;
                case 17: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 5.00); break;
                case 18: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 5.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 5.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 9.00); mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 5.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        }
    }

    //암살자의 그림자
    private void calcAssassinsShadow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "나이트메어 스킬 피증", 33.00); break;
                case 14: mergeEffect(effectsMap, "나이트메어 스킬 피증", 33.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.67); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 19: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.84); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 20: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 2.01); mergeEffect(effectsMap, "적주피", 1.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "나이트메어 스킬 피증", 33.00); break;
                case 14: mergeEffect(effectsMap, "나이트메어 스킬 피증", 33.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.50); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 18: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.67); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 19: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 1.84); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 20: mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 2.01); mergeEffect(effectsMap, "적주피", 2.00); break;
            }
        }
    }

    //데스 루프
    private void calcDeathLoop(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 10.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 10.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 10.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 14.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 14.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 6.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 7.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 유언 트라이포드 피증", 14.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        }
    }

    //급습 악몽
    private void calcRaidNightmare(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 12.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 12.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 12.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 18.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 18.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "댄싱 오브 퓨리 스킬 피증", 12.00); mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 18.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        }
    }

    //치명적 연계
    private void calcFatalLink(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break; // 재사용 대기시간 제외
                case 18: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break;
                case 17: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); break; // 재사용 대기시간 제외
                case 18: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "레이지 스피어 스킬 피증", 6.00); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 7.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        }
    }

    //다가오는 죽음
    //진욱쿤(과다 출혈 피증? -> 과다 출혈 상태 피증)
    private void calcApproachingDeath(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); break; // 경직 면역 제외
                case 14: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 20.00); break; // 경직 면역 제외
                case 17: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 1.16); break;
                case 19: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 1.32); break;
                case 20: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 1.48); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); break; // 경직 면역 제외
                case 14: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 20.00); break; // 경직 면역 제외
                case 17: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 18: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 2.16); break;
                case 19: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 2.32); break;
                case 20: mergeEffect(effectsMap, "단검 스킬 피증", 10.00); mergeEffect(effectsMap, "과다 출혈 피증", 35.00); mergeEffect(effectsMap, "적주피", 2.48); break;
            }
        }
    }
}
