package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.breaker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BreakerMoon extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "브레이커";
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


            if ("권왕태세".equals(name)) {
                calcKwonwangTaese(effectsMap, point, grade);
            } else if ("진 파천섬광".equals(name)) {
                calcJinPacheonSeomgwang(effectsMap, point, grade);
            } else if ("충격 충전".equals(name)) {
                calcShockCharge(effectsMap, point, grade);
            } else if ("개 파천섬광".equals(name)) {
                calcGaePacheonSeomgwang(effectsMap, point, grade);
            } else if ("수라결".equals(name)) {
                calcSuragyeol(effectsMap, point, grade);
            } else if ("종횡무진".equals(name)) {
                calcJonghoengMujin(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //권왕태세
    //진욱쿤 찬스(권왕태세 상태 적주피 -> 적주피)
    private void calcKwonwangTaese(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "권왕십이식 : 낙화 스킬 피증", 15.00); break;
            }
        }
    }

    //진 파천섬광
    //진욱쿤 찬스(충격 스킬 피증)
    private void calcJinPacheonSeomgwang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 17.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.40); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 17.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.80); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 17.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 4.20); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 17.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.00); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 20.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.40); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 20.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 3.80); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 20.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 4.20); mergeEffect(effectsMap, "피증", -10.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 20.00); break;
            }
        }
    }

    //충격 충전
    //진욱쿤 찬스(충격 스킬 피증)
    private void calcShockCharge(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", -8.00); break; // 1.5 - 9.5
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", -7.80); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", -7.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", -7.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "충격 스킬 피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "충격 스킬 피증", -5.00); break; // 1.5 - 6.5
                case 18: mergeEffect(effectsMap, "충격 스킬 피증", -4.80); break;
                case 19: mergeEffect(effectsMap, "충격 스킬 피증", -4.60); break;
                case 20: mergeEffect(effectsMap, "충격 스킬 피증", -4.40); break;
            }
        }
    }

    //개 파천섬광
    private void calcGaePacheonSeomgwang(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 25.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 25.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 25.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 25.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.00); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 32.00); break;
                case 18: mergeEffect(effectsMap, "파천섬광 스킬 피증", 8.70); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 32.00); break;
                case 19: mergeEffect(effectsMap, "파천섬광 스킬 피증", 9.40); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 32.00); break;
                case 20: mergeEffect(effectsMap, "파천섬광 스킬 피증", 10.10); mergeEffect(effectsMap, "파천섬광 스킬 치명타 시 피해량 증가", 32.00); break;
            }
        }
    }

    //수라결
    private void calcSuragyeol(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "피증", 13.30); break;
                case 19: mergeEffect(effectsMap, "피증", 13.60); break;
                case 20: mergeEffect(effectsMap, "피증", 13.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "피증", 3.00); break;
                case 17: mergeEffect(effectsMap, "피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 15.30); break;
                case 19: mergeEffect(effectsMap, "피증", 15.60); break;
                case 20: mergeEffect(effectsMap, "피증", 15.90); break;
            }
        }
    }

    //종횡무진
    //진욱쿤 찬스(기력 스킬 피증)
    private void calcJonghoengMujin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "피증", 8.00); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "피증", 8.90); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "피증", 9.80); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "피증", 10.70); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "피증", 8.00); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "피증", 8.90); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 36.00); break;
                case 19: mergeEffect(effectsMap, "피증", 9.80); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 36.00); break;
                case 20: mergeEffect(effectsMap, "피증", 10.70); mergeEffect(effectsMap, "징벌의 파도 스킬 피증", 36.00); break;
            }
        }
    }
}
