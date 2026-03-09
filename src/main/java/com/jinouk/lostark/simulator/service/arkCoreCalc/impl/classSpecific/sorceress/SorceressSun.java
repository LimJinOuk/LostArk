package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.sorceress;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SorceressSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "소서리스";
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


            if ("마력의 촉매".equals(name)) {
                calcManaCatalyst(effectsMap, point, grade);
            } else if ("불완전 연소".equals(name)) {
                calcIncompleteCombustion(effectsMap, point, grade);
            } else if ("종말의 시작".equals(name)) {
                calcBeginningOfEnd(effectsMap, point, grade);
            } else if ("편향".equals(name)) {
                calcDeflection(effectsMap, point, grade);
            } else if ("순환".equals(name)) {
                calcCirculation(effectsMap, point, grade);
            } else if ("응축".equals(name)) {
                calcCondensation(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //마력의 촉매
    //진욱쿤(마력 방출 중.., 각성기 제외)
    private void calcManaCatalyst(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break; // 쿨감 제외
                case 18: mergeEffect(effectsMap, "적주피", 2.25); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.75); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 2.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break; // 쿨감 제외
                case 18: mergeEffect(effectsMap, "적주피", 2.25); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.75); mergeEffect(effectsMap, "각성기 제외 스킬 피증", 7.50); break;
            }
        }
    }

    //불완전 연소
    //진욱쿤(캐스팅 조작 스킬 피증)
    private void calcIncompleteCombustion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 125.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 125.00); mergeEffect(effectsMap, "천벌 스킬 피증", 125.00); break;
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 145.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.20); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 145.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.40); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 145.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.60); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 145.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 125.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 125.00); mergeEffect(effectsMap, "천벌 스킬 피증", 125.00); break;
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.00); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 148.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.20); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 148.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.40); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 148.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 2.60); mergeEffect(effectsMap, "치적", 10.00); mergeEffect(effectsMap, "종말의 날 스킬 피증", 148.00); mergeEffect(effectsMap, "익스플로전 스킬 피증", 145.00); mergeEffect(effectsMap, "천벌 스킬 피증", 145.00); break;
            }
        }
    }

    //종말의 시작
    private void calcBeginningOfEnd(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break; // 초기화, 쿨증 제외
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 10.00); break;
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.40); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 10.00); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.80); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 10.00); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 5.20); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break;
                case 14: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); break; // 초기화, 쿨증 제외
                case 17: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.00); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 14.00); break;
                case 18: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.40); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 14.00); break;
                case 19: mergeEffect(effectsMap, "종말의 날 스킬 피증", 4.80); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 14.00); break;
                case 20: mergeEffect(effectsMap, "종말의 날 스킬 피증", 5.20); mergeEffect(effectsMap, "종말의 날 스킬 치명타 시 피해량 증가", 14.00); break;
            }
        }
    }

    //편향
    //진욱쿤(일반 조작, 지점 조작)
    private void calcDeflection(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.50); break;
                case 17: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "피증", 12.00); break; // 기본 1.5 + 편향 효과 12.0
                case 18: mergeEffect(effectsMap, "일반 조작 스킬 피증", 13.66); mergeEffect(effectsMap, "지점 조작 스킬 피증", 13.66); mergeEffect(effectsMap, "피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "일반 조작 스킬 피증", 13.82); mergeEffect(effectsMap, "지점 조작 스킬 피증", 13.82); mergeEffect(effectsMap, "피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "일반 조작 스킬 피증", 13.98); mergeEffect(effectsMap, "지점 조작 스킬 피증", 13.98); mergeEffect(effectsMap, "피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "일반 조작 스킬 피증", 1.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.50); break;
                case 17: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.50); mergeEffect(effectsMap, "피증", 13.00); break; // 기본 1.5 + 편향 효과 12.0
                case 18: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.66); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.66); mergeEffect(effectsMap, "피증", 13.00); break;
                case 19: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.82); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.82); mergeEffect(effectsMap, "피증", 13.00); break;
                case 20: mergeEffect(effectsMap, "일반 조작 스킬 피증", 8.98); mergeEffect(effectsMap, "지점 조작 스킬 피증", 8.98); mergeEffect(effectsMap, "피증", 13.00); break;
            }
        }
    }

    //순환
    //진욱쿤(캐스팅 조작 스킬)
    private void calcCirculation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.00); break; // 기존 7.0 + 주문 효과 30.0 (속도 제외)
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.00); mergeEffect(effectsMap, "피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.60); mergeEffect(effectsMap, "피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 38.20); mergeEffect(effectsMap, "피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 38.80); mergeEffect(effectsMap, "피증", 12.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.00); break; // 기존 7.0 + 주문 효과 30.0 (속도 제외)
                case 17: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.00); mergeEffect(effectsMap, "피증", 14.50); break;
                case 18: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 37.60); mergeEffect(effectsMap, "피증", 14.50); break;
                case 19: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 38.20); mergeEffect(effectsMap, "피증", 14.50); break;
                case 20: mergeEffect(effectsMap, "캐스팅 조작 스킬 피증", 38.80); mergeEffect(effectsMap, "피증", 14.50); break;
            }
        }
    }

    //응축
    //진욱쿤(번개 스킬 피증, 냉기 스킬 피증)
    private void calcCondensation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 45.00); break; // 속도 제외
                case 17: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 72.00); break;
                case 18: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 72.40); break;
                case 19: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 72.80); break;
                case 20: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 73.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); break;
                case 14: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 45.00); break; // 속도 제외
                case 17: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 79.00); break;
                case 18: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 79.40); break;
                case 19: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 79.80); break;
                case 20: mergeEffect(effectsMap, "번개 스킬 피증", 2.20); mergeEffect(effectsMap, "냉기 스킬 피증", 2.20); mergeEffect(effectsMap, "피증", 90.20); break;
            }
        }
    }
}
