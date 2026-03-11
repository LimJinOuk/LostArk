package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.berserker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BerserkerMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "버서커";
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


            if ("피의 순환".equals(name)) {
                calcBloodCirculation(effectsMap, point, grade);
            } else if ("오버 버스트".equals(name)) {
                calcOverBurst(effectsMap, point, grade);
            } else if ("브레이크 대시".equals(name)) {
                calcBreakDash(effectsMap, point, grade);
            } else if ("어둠의 격류".equals(name)) {
                calcDarkTorrent(effectsMap, point, grade);
            } else if ("래피드 슬래쉬".equals(name)) {
                calcRapidSlash(effectsMap, point, grade);
            } else if ("사이클론 슬래쉬".equals(name)) {
                calcCycloneSlash(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //피의 순환
    private void calcBloodCirculation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "피증", 4.00); break;
                case 18: mergeEffect(effectsMap, "피증", 4.40); break;
                case 19: mergeEffect(effectsMap, "피증", 4.80); break;
                case 20: mergeEffect(effectsMap, "피증", 5.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "피증", 4.00); break;
                case 17: mergeEffect(effectsMap, "피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "피증", 6.40); break;
                case 19: mergeEffect(effectsMap, "피증", 6.80); break;
                case 20: mergeEffect(effectsMap, "피증", 7.20); break;
            }
        }
    }

    //오버 버스트
    private void calcOverBurst(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.77); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.94); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.11); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 30.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.60); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.77); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.94); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.11); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.00); break;
            }
        }
    }

    //브레이크 대시
    private void calcBreakDash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", 2.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.65); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", 2.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", 2.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.95); mergeEffect(effectsMap, "블러디 러쉬 스킬 피증", 2.00); break;
            }
        }
    }

    //어둠의 격류
    private void calcDarkTorrent(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 80.00); break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 80.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 130.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 131.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 133.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 134.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 80.00); break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 80.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 136.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 137.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 139.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 140.50); break;
            }
        }
    }

    //래피드 슬래쉬
    private void calcRapidSlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 2.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 5.00); break;
                case 17: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "더블 슬래쉬 스킬 피증", 13.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 2.40); break;
            }
        }
    }

    //사이클론 슬래쉬
    private void calcCycloneSlash(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.40); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.80); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "홀딩 스킬 피증", 7.20); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.00); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.40); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "홀딩 스킬 피증", 6.80); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "홀딩 스킬 피증", 7.20); mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 20.00); break;
            }
        }
    }
}
