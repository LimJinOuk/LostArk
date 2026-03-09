package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.devilHunter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DevilHunterMoon  extends AbstractArkGrid {
    public String getClassName() {
        return "데빌헌터";
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


            if ("산탄강화".equals(name)) {
                calcBuckshotReinforce(effectsMap, point, grade);
            } else if ("무결점 조준".equals(name)) {
                calcFlawlessAim(effectsMap, point, grade);
            } else if ("광란의 해결사".equals(name)) {
                calcFranticSolver(effectsMap, point, grade);
            } else if ("하늘의 지배자".equals(name)) {
                calcRulerOfSky(effectsMap, point, grade);
            } else if ("긴박한 해결사".equals(name)) {
                calcUrgentSolver(effectsMap, point, grade);
            } else if ("이터널 리볼버".equals(name)) {
                calcEternalRevolver(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //산탄강화
    private void calcBuckshotReinforce(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 5.20); break; // 1.7 + 3.5
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 5.40); break; // 5.2 + 0.2
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 5.60); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 5.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 6.20); break; // 1.7 + 3.5
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 6.40); break; // 5.2 + 0.2
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 6.60); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 6.80); break;
            }
        }
    }

    //무결점 조준
    private void calcFlawlessAim(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 6.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.75); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 6.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break; // 2.5 + 0.25
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 6.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 3.25); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 6.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "라이플 스킬 피증", 2.50); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 8.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "라이플 스킬 피증", 2.75); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 8.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break; // 2.5 + 0.25
                case 19: mergeEffect(effectsMap, "라이플 스킬 피증", 3.00); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 8.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "라이플 스킬 피증", 3.25); mergeEffect(effectsMap, "라이플 스킬 치명타 시 피해량 증가", 8.50); mergeEffect(effectsMap, "심판의 날 스킬 드래곤 브레스 트라이포드 피증", 10.00); break;
            }
        }
    }

    //광란의 해결사
    private void calcFranticSolver(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 12.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 12.60); break; // 12.0 + 0.6
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 13.20); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 13.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 15.00); break; // 시전 속도 제외
                case 18: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 15.60); break; // 12.0 + 0.6
                case 19: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 16.20); break;
                case 20: mergeEffect(effectsMap, "샷건 스킬 피증", 1.70); mergeEffect(effectsMap, "샷건의 지배자 스킬 피증", 16.80); break;
            }
        }
    }

    //하늘의 지배자
    //진욱쿤 찬스(핸드건)
    private void calcRulerOfSky(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "데스페라도 스킬 피증", 21.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.76); mergeEffect(effectsMap, "데스페라도 스킬 피증", 21.00); break; // 1.6 + 0.16
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.92); mergeEffect(effectsMap, "데스페라도 스킬 피증", 21.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 2.08); mergeEffect(effectsMap, "데스페라도 스킬 피증", 21.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "데스페라도 스킬 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.76); mergeEffect(effectsMap, "데스페라도 스킬 피증", 27.00); break; // 1.6 + 0.16
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.92); mergeEffect(effectsMap, "데스페라도 스킬 피증", 27.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 2.08); mergeEffect(effectsMap, "데스페라도 스킬 피증", 27.00); break;
            }
        }
    }

    //긴박한 해결사
    private void calcUrgentSolver(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 쿨감 및 피증 0% 제외
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 0.50); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 1.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 쿨감 및 피증 0% 제외
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 적주피", 1.00); mergeEffect(effectsMap, "비밀 병기 스킬 적주피", 0.50); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 적주피", 1.00); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 1.00); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "비밀 병기 스킬 적주피", 1.00); mergeEffect(effectsMap, "비밀 병기 스킬 피증", 1.50);break;
            }
        }
    }

    //이터널 리볼버
    private void calcEternalRevolver(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 2.40); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); break; // 운명 발동 조건 제외
                case 17: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); break;
                case 18: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 0.80); break;
                case 19: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 1.60); break;
                case 20: mergeEffect(effectsMap, "핸드건 스킬 피증", 1.60); mergeEffect(effectsMap, "나선의 추적자 치명타 시 피해량 증가", 95.00); mergeEffect(effectsMap, "나선의 추적자 스킬 피증", 2.40); break;
            }
        }
    }
}
