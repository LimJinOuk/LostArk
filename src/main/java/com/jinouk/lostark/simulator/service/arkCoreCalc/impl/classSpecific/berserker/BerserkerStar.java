package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.berserker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BerserkerStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "버서커";
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

            if ("분쇄 폭풍".equals(name)) {
                calcCrushingStorm(effectsMap, point, grade);
            } else if ("오버플로우".equals(name)) {
                calcOverflow(effectsMap, point, grade);
            } else if ("브레이크 아웃".equals(name)) {
                calcBreakOut(effectsMap, point, grade);
            } else if ("광란".equals(name)) {
                calcMadness(effectsMap, point, grade);
            } else if ("연참".equals(name)) {
                calcYeoncham(effectsMap, point, grade);
            } else if ("지옥 뒤집기".equals(name)) {
                calcHellFlip(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //분쇄 폭풍
    private void calcCrushingStorm(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.00); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.60); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 19.20); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 19.80); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 24.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.00); break;
                case 17: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.00); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 18.60); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 27.00); break;
                case 19: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 19.20); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 27.00); break;
                case 20: mergeEffect(effectsMap, "파워 브레이크 스킬 피증", 19.80); mergeEffect(effectsMap, "파워 브레이크 스킬 소용돌이 트라이포드 피증", 27.00); break;
            }
        }
    }

    //오버플로우
    private void calcOverflow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 35.80); break;
                case 19: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 36.60); break;
                case 20: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 37.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); break;
                case 14: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 45.80); break;
                case 19: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 46.60); break;
                case 20: mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 47.40); break;
            }
        }
    }

    //브레이크 아웃
    private void calcBreakOut(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 31.60); break;
                case 19: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 33.20); break;
                case 20: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 34.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 36.60); break;
                case 19: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 38.20); break;
                case 20: mergeEffect(effectsMap, "헬 블레이드 스킬 피증", 39.80); break;
            }
        }
    }

    //광란
    private void calcMadness(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 21.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 23.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 24.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); break;
                case 17: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 31.50); break;
                case 19: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 33.00); break;
                case 20: mergeEffect(effectsMap, "다크 러쉬 스킬 치피증", 35.00); mergeEffect(effectsMap, "다크 러쉬 스킬 피증", 34.50); break;
            }
        }
    }

    //연참
    private void calcYeoncham(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); break;
                case 17: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 12.80); break;
                case 19: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 13.60); break;
                case 20: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 14.40); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); break;
                case 17: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 15.80); break;
                case 19: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 16.60); break;
                case 20: mergeEffect(effectsMap, "더블 슬래쉬 스킬 전진 베기 트라이포드 피증", 110.00); mergeEffect(effectsMap, "오버드라이브 스킬 치적", 10.00); mergeEffect(effectsMap, "오버드라이브 스킬 피증", 17.40); break;
            }
        }
    }

    //지옥 뒤집기
    private void calcHellFlip(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.00); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.80); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "휠윈드 스킬 피증", 11.60); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "휠윈드 스킬 피증", 12.40); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.00); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "휠윈드 스킬 피증", 10.80); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 36.00); break;
                case 19: mergeEffect(effectsMap, "휠윈드 스킬 피증", 11.60); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 36.00); break;
                case 20: mergeEffect(effectsMap, "휠윈드 스킬 피증", 12.40); mergeEffect(effectsMap, "헬 블레이드 스킬 대지 뒤집기 트라이포드 피증", 36.00); break;
            }
        }
    }
}
