package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.breaker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BreakerSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "브레이커";
    }

    @Override
    public String getArkGridCoreName() {
        return "질서의 해 코어";
    }

    @Override
    public ArkGridResponseDto getArkGrid(ArkGridRequestDto requestDto) {
        Map<String, Double> effectsMap = new HashMap<>();

        requestDto.getArkGridItems().forEach(item -> {
            String name = item.getArkGridName();
            String grade = item.getGrade();
            int point = (item.getArkGridPoint() != null) ? item.getArkGridPoint() : 0;

            if ("진 권왕".equals(name)) {
                calcJinKwonwang(effectsMap, point, grade);
            } else if ("파천경".equals(name)) {
                calcPacheongyeong(effectsMap, point, grade);
            } else if ("충전된 충격".equals(name)) {
                calcChargedShock(effectsMap, point, grade);
            } else if ("파천기".equals(name)) {
                calcPacheongi(effectsMap, point, grade);
            } else if ("수라안".equals(name)) {
                calcSuraan(effectsMap, point, grade);
            } else if ("그림자 주먹".equals(name)) {
                calcShadowFist(effectsMap, point, grade);
            }
        });

        for (Map.Entry<String, Double> entry : effectsMap.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        return new ArkGridResponseDto(effectsMap);
    }
    //진 권왕
    private void calcJinKwonwang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 34.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 34.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 34.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 34.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 42.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 42.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 42.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", 12.00); mergeEffect(effectsMap, "권왕십이식 : 풍랑 스킬 피증", 42.00); break;
            }
        }
    }

    //파천경
    private void calcPacheongyeong(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 18.00); break; // 3.0 + 15.0
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 18.40); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 18.80); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 19.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 21.00); break; // 3.0 + 15.0
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 21.40); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 21.80); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 22.20); break;
            }
        }
    }

    //충전된 충격
    //진욱쿤 찬스(충격 스킬 피증? 피증?)
    private void calcChargedShock(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", -4.50); break; // 1.5 - 6.0
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", -4.00); break; // -4.5 + 0.5
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", -3.80); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", -3.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", -3.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", -4.50); break; // 1.5 - 6.0
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", -3.00); break; // -4.5 + 0.5
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", -2.80); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", -2.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", -2.40); break;
            }
        }
    }

    //파천기
    //진욱쿤 찬스(충격 스킬 피증? 피증?)
    private void calcPacheongi(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "피증", 30.00); break;
            }
        }
    }

    //수라안
    //진욱쿤 찬스(수라결 스킬 피증? 피증?)
    private void calcSuraan(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피증", 7.00); break; // 3.0 + 4.0
                case 17: mergeEffect(effectsMap, "피증", 13.00); break; // 7.0 + 6.0
                case 18: mergeEffect(effectsMap, "피증", 13.30); break;
                case 19: mergeEffect(effectsMap, "피증", 13.60); break;
                case 20: mergeEffect(effectsMap, "피증", 13.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피증", 7.00); break; // 3.0 + 4.0
                case 17: mergeEffect(effectsMap, "피증", 14.50); break; // 7.0 + 6.0
                case 18: mergeEffect(effectsMap, "피증", 14.80); break;
                case 19: mergeEffect(effectsMap, "피증", 15.20); break;
                case 20: mergeEffect(effectsMap, "피증", 15.50); break;
            }
        }
    }

    //그림자 주먹
    //진욱쿤 찬스(기력 스킬 피증? 피증?)
    private void calcShadowFist(Map<String, Double> effectsMap, int point, String grade) {
        if ("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "피증", 8.00); break; // 그림자 공격(고정데미지) 및 쿨감 제외
                case 18: mergeEffect(effectsMap, "피증", 8.90); break;
                case 19: mergeEffect(effectsMap, "피증", 9.80); break;
                case 20: mergeEffect(effectsMap, "피증", 10.70); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "피증", 8.00); break; // 그림자 공격(고정데미지) 및 쿨감 제외
                case 18: mergeEffect(effectsMap, "피증", 8.90); break;
                case 19: mergeEffect(effectsMap, "피증", 9.80); break;
                case 20: mergeEffect(effectsMap, "피증", 10.70); break;
            }
        }
    }
}
