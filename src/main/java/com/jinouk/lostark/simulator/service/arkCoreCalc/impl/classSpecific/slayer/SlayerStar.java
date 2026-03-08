package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.slayer;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SlayerStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "슬레이어";
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


            if ("처형".equals(name)) {
                calcExecution(effectsMap, point, grade);
            } else if ("분쇄".equals(name)) {
                calcPulverize(effectsMap, point, grade);
            } else if ("신중한 강타".equals(name)) {
                calcDeliberateStrike(effectsMap, point, grade);
            } else if ("즉결 처형".equals(name)) {
                calcSummaryExecution(effectsMap, point, grade);
            } else if ("마무리 일격".equals(name)) {
                calcFinishingBlow(effectsMap, point, grade);
            } else if ("파괴의 바람".equals(name)) {
                calcWindOfDestruction(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //처형
    private void calcExecution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 마나 소모, 쿨감 제외
                case 14: break; // 마나 소모, 초기화 제외
                case 17: mergeEffect(effectsMap, "길로틴 스킬 치피", 25.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스킬 치피", 25.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "길로틴 스킬 치피", 25.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "길로틴 스킬 치피", 25.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 마나 소모, 쿨감 제외
                case 14: break; // 마나 소모, 초기화 제외
                case 17: mergeEffect(effectsMap, "길로틴 스킬 치피", 28.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스킬 치피", 28.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.60); break;
                case 19: mergeEffect(effectsMap, "길로틴 스킬 치피", 28.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.20); break;
                case 20: mergeEffect(effectsMap, "길로틴 스킬 치피", 28.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.80); break;
            }
        }
    }

    //분쇄
    private void calcPulverize(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); break; // 쿨증, 연계 속도 제외
                case 17: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.40); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.80); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.20); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 1.20); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); break; // 쿨증, 연계 속도 제외
                case 17: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 15.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.40); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 15.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 0.80); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "길로틴 스킬 응축된 일격 트라이포드 피증", 48.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 차지 강화 트라이포드 피증", 15.00); mergeEffect(effectsMap, "길로틴 스킬 피증", 1.20); mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 1.20); break;
            }
        }
    }

    //신중한 강타
    private void calcDeliberateStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); break; // 기존 3.0 + 신규 20.0 (쿨증 제외)
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.30); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.60); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.90); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); break; // 기존 3.0 + 신규 20.0 (쿨증 제외)
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.30); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.60); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.90); mergeEffect(effectsMap, "브루탈 임팩트 스킬 치피증", 20.00); break;
            }
        }
    }

    //즉결 처형
    private void calcSummaryExecution(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 5.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 19.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break; // 기본 피증 5.0 + 신규 14.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 19.30); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 19.60); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 19.90); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 5.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break; // 기본 피증 5.0 + 신규 14.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.30); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.60); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.90); mergeEffect(effectsMap, "브루탈 임팩트 스킬 즉결 처형 트라이포드 피증", 8.00); break;
            }
        }
    }

    //마무리 일격
    private void calcFinishingBlow(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.00); break; // 쿨증 제외
                case 17: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.00); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 30.00); break; // 쿨증 제외
                case 18: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 30.50); break;
                case 19: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 31.00); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 31.00); break;
                case 20: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 31.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 31.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전 속도 제외
                case 14: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.00); break; // 쿨증 제외
                case 17: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.00); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 40.00); break; // 쿨증 제외
                case 18: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 30.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 40.50); break;
                case 19: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 31.00); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 41.00); break;
                case 20: mergeEffect(effectsMap, "페이탈 소드 스킬 피증", 31.50); mergeEffect(effectsMap, "볼케이노 이럽션 스킬 피증", 41.50); break;
            }
        }
    }

    //파괴의 바람
    private void calcWindOfDestruction(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 시전/이동 속도 제외
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 20.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 20.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 20.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 시전/이동 속도 제외
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 25.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 25.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 지속력 강화 트라이포드 피증", 10.00); mergeEffect(effectsMap, "허리케인 소드 스킬 치피증", 25.00); mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 1.20); break;
            }
        }
    }
}
