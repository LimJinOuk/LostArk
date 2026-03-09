package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.reaper;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReaperMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "리퍼";
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


            if ("페르소나".equals(name)) {
                calcPersona(effectsMap, point, grade);
            } else if ("나이트메어".equals(name)) {
                calcNightmare(effectsMap, point, grade);
            } else if ("더블 코어".equals(name)) {
                calcDoubleCore(effectsMap, point, grade);
            } else if ("치명적 악몽".equals(name)) {
                calcDeadlyNightmare(effectsMap, point, grade);
            } else if ("라스트 스피어".equals(name)) {
                calcLastSpear(effectsMap, point, grade);
            } else if ("출혈독".equals(name)) {
                calcBleedingPoison(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //페르소나
    private void calcPersona(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break; // 페르소나 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 1.77); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 1.94); mergeEffect(effectsMap, "적주피", 3.50); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 2.11); mergeEffect(effectsMap, "적주피", 3.50); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break; // 페르소나 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "적주피", 4.30); break;
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 1.77); mergeEffect(effectsMap, "적주피", 4.30); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 1.94); mergeEffect(effectsMap, "적주피", 4.30); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 2.11); mergeEffect(effectsMap, "적주피", 4.30); break;
            }        }
    }

    //나이트메어
    private void calcNightmare(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); break; // 급습 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 3.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 3.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "적주피", 3.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "적주피", 3.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.60); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.60); break; // 급습 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.10); mergeEffect(effectsMap, "나이트메어 스킬 피증", 66.00); mergeEffect(effectsMap, "급습 스킬 피증", 0.51); break;
            }
        }
    }

    //더블 코어
    private void calcDoubleCore(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break; // 라스트 그래피티 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 20.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 1.77); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 1.94); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 2.11); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); break; // 라스트 그래피티 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "급습 스킬 피증", 1.60); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 24.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "급습 스킬 피증", 1.77); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "급습 스킬 피증", 1.94); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "급습 스킬 피증", 2.11); mergeEffect(effectsMap, "라스트 그래피티 스킬 피증", 24.00); break;
            }
        }
    }

    //치명적 악몽
    private void calcDeadlyNightmare(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 페이탈 스텝 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 4.50); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 4.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 페이탈 스텝 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 5.50); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.30); break;
                case 19: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 5.50); mergeEffect(effectsMap, "급습 스킬 피증", 0.90); break;
            }
        }
    }

    //라스트 스피어
    private void calcLastSpear(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 레이지 스피어 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.30); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.60); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 7.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 레이지 스피어 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 8.50); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 8.80); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 9.10); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "급습 스킬 피증", 9.40); break;
            }
        }
    }

    //출혈독
    //진욱쿤(과다 출혈 피해량? -> 과다 출혈 상태 피증)
    private void calcBleedingPoison(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 단검 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 2.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 단검 스킬 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "적주피", 2.50); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.66); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.82); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.98); break;
            }
        }
    }
}
