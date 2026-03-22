package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.artist;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistStar extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "도화가";
    }
    @Override
    public String getArkGridCoreName() {
        return "질서의 별 코어";
    }
    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        Map<String, Double> effectsMap = new HashMap<>();

        validateItems(requestDto);

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("끝없는 파죽".equals(name)) {
                calcEndless(effectsMap, point, grade);
            } else if ("재빠른 붓".equals(name)) {
                calcFastBrush(effectsMap, point, grade);
            } else if("쏟아지는 두루미".equals(name)) {
                calcCranes(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);
        return new ArkGridResponseDto(effectsMap);
    }
    //끝없는 파죽
    private void calcEndless(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.40); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.80); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.20); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 50.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 60.00); break;
                case 18: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.40); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 60.00); break;
                case 19: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 5.80); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 60.00); break;
                case 20: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.20); mergeEffect(effectsMap, "묵법 : 파죽 스킬 치피증", 60.00); break;
            }
        }
    }

    //재빠른 붓
    private void calcFastBrush(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.00); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 33.00); break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.65); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 33.00); break;
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 21.30); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 33.00); break;
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 21.95); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 33.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.00); break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.00); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 20.65); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 36.00); break;
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 21.30); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 36.00); break;
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 21.95); mergeEffect(effectsMap, "필법 : 한획긋기 스킬 연속 긋기 트라이포드 피증", 36.00); break;
            }
        }
    }

    //쏟아지는 두루미
    private void calcCranes(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 14.00); break;
                case 18: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 15.30); break;
                case 19: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 16.60); break;
                case 20: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 17.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 17.00); break;
                case 18: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 18.30); break;
                case 19: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 19.60); break;
                case 20: mergeEffect(effectsMap, "묵법 : 달그리기 스킬 먹물 세례 트라이포드 피증", 120.00); mergeEffect(effectsMap, "묵법 : 두루미나래 스킬 피증", 20.90); break;
            }
        }
    }
}
