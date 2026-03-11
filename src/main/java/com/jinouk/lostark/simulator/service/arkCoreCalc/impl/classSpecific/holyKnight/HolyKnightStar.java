package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.holyKnight;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HolyKnightStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "홀리나이트";
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


            if ("참하는 검".equals(name)) {
                calcDecapitatingSword(effectsMap, point, grade);
            } else if ("신성한 검".equals(name)) {
                calcSacredSword(effectsMap, point, grade);
            } else if ("꿰뚫는 검".equals(name)) {
                calcPiercingSword(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //참하는 검
    private void calcDecapitatingSword(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가 및 마나 소모 감소
                case 14: break; // 스택 충전 기능 추가
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 19.00); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 21.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가 및 마나 소모 감소
                case 14: break; // 스택 충전 기능 추가
                case 17: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 22.00); break;
                case 18: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 23.00); break;
                case 19: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "섬광 베기 스킬 피증", 25.00); break;
            }
        }
    }

    //신성한 검
    private void calcSacredSword(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "신성검 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", -8.50); break; // 공격 타입 백 어택 변경 포함
                case 14: mergeEffect(effectsMap, "신성검 스킬 피증", 29.00); mergeEffect(effectsMap, "적주피", -8.50); break; // 15.0 + 14.0
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 29.00); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 29.80); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 30.60); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 31.40); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 30.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "신성검 스킬 피증", 15.00); mergeEffect(effectsMap, "적주피", -8.50); break; // 공격 타입 백 어택 변경 포함
                case 14: mergeEffect(effectsMap, "신성검 스킬 피증", 29.00); mergeEffect(effectsMap, "적주피", -8.50); break; // 15.0 + 14.0
                case 17: mergeEffect(effectsMap, "신성검 스킬 피증", 29.00); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "신성검 스킬 피증", 29.80); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "신성검 스킬 피증", 30.60); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 35.00); break;
                case 20: mergeEffect(effectsMap, "신성검 스킬 피증", 31.40); mergeEffect(effectsMap, "적주피", -8.50); mergeEffect(effectsMap, "신성검 스킬 응축된 기운 트라이포드 피증", 35.00); break;
            }
        }
    }

    //꿰뚫는 검
    private void calcPiercingSword(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 14.00); break;
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 34.00); break; // 14.0 + 20.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 34.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 35.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 35.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 증가
                case 14: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 14.00); break;
                case 17: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 38.00); break; // 14.0 + 20.0
                case 18: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 38.60); break;
                case 19: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 39.20); break;
                case 20: mergeEffect(effectsMap, "심판의 칼날 스킬 피증", 39.80); break;
            }
        }
    }
}
