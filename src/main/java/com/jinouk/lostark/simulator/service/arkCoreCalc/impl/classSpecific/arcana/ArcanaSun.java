package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.arcana;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArcanaSun extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "아르카나";
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


            if ("엣지 오브 메이트".equals(name)) {
                calcEdgeOfMate(effectsMap, point, grade);
            } else if ("인피니티 덱".equals(name)) {
                calcInfinite(effectsMap, point, grade);
            } else if ("루인 서브셋".equals(name)) {
                calcRuinSubset(effectsMap,point,grade);
            } else if ("하이 템포".equals(name)) {
                calcHighTempo(effectsMap,point,grade);
            } else if ("노말 인핸스".equals(name)) {
                calcNormalEnhance(effectsMap, point, grade);
            } else if("임팩트 메이트".equals(name)) {
                calcImpactMate(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //엣지 오브 메이트
    private void calcEdgeOfMate(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 14: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap, "루인 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap, "루인 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.20); mergeEffect(effectsMap, "루인 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.40); mergeEffect(effectsMap, "루인 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.60); mergeEffect(effectsMap, "루인 스킬 피증", 10.00); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                    case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                    case 14: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap, "루인 스킬 피증", 8.00); break;
                    case 17: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap, "루인 스킬 피증", 11.00); break;
                    case 18: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.20); mergeEffect(effectsMap, "루인 스킬 피증", 11.00); break;
                    case 19: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.40); mergeEffect(effectsMap, "루인 스킬 피증", 11.00); break;
                    case 20: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.60); mergeEffect(effectsMap, "루인 스킬 피증", 11.00); break;
            }
        }
    }

    //인피니티 덱
    private void calcInfinite(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "루인 스킬 피증", 3.60); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 3.75); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 3.90); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 4.05); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap, "루인 스킬 피증", 4.60); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 4.75); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 4.90); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 5.05); break;
            }
        }
    }

    //루인 서브셋
    private void calcRuinSubset(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 17: mergeEffect(effectsMap, "루인 스킬 피증", 9.80); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 10.10); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 10.40); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 10.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 17: mergeEffect(effectsMap, "루인 스킬 피증", 11.80); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 12.10); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 12.40); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 12.70); break;
            }
        }
    }

    //하이 템포
    private void calcHighTempo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "피증", 6.00); break; // 2.00 + 4.00
                case 18: mergeEffect(effectsMap, "피증", 6.20); break; // 6.00 + 0.20
                case 19: mergeEffect(effectsMap, "피증", 6.40); break; // 6.20 + 0.20
                case 20: mergeEffect(effectsMap, "피증", 6.60); break; // 6.40 + 0.20
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break; // 쿨감 제외
                case 17: mergeEffect(effectsMap, "피증", 7.00); break; // 2.00 + 4.00
                case 18: mergeEffect(effectsMap, "피증", 7.20); break; // 6.00 + 0.20
                case 19: mergeEffect(effectsMap, "피증", 7.40); break; // 6.20 + 0.20
                case 20: mergeEffect(effectsMap, "피증", 7.60); break; // 6.40 + 0.20
            }
        }
    }

    //노말 인핸스
    private void calcNormalEnhance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "피증", 1.70); break; // 쿨감 제외, 피증 유지
                case 17: mergeEffect(effectsMap, "피증", 5.50); break; // 1.70 + 3.80
                case 18: mergeEffect(effectsMap, "피증", 5.66); break; // 5.50 + 0.16
                case 19: mergeEffect(effectsMap, "피증", 5.82); break; // 5.66 + 0.16
                case 20: mergeEffect(effectsMap, "피증", 5.98); break; // 5.82 + 0.16
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "피증", 1.70); break; // 쿨감 제외, 피증 유지
                case 17: mergeEffect(effectsMap, "피증", 6.70); break; // 1.70 + 3.80
                case 18: mergeEffect(effectsMap, "피증", 6.86); break; // 5.50 + 0.16
                case 19: mergeEffect(effectsMap, "피증", 7.02); break; // 5.66 + 0.16
                case 20: mergeEffect(effectsMap, "피증", 7.18); break; // 5.82 + 0.16
            }
        }
    }

    //임팩트 메이트
    private void calcImpactMate(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00);break;
                case 14: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 10.00); break;
                case 17: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 15.00); break;
                case 18: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.80); mergeEffect(effectsMap, "적주피", 15.00); break;
                case 19: mergeEffect(effectsMap, "체크메이트 스킬 피증", 13.60); mergeEffect(effectsMap, "적주피", 15.00); break;
                case 20: mergeEffect(effectsMap, "체크메이트 스킬 피증", 14.40);mergeEffect(effectsMap, "적주피", 15.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00);break;
                case 14: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 10.00); break;
                case 17: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); mergeEffect(effectsMap, "적주피", 17.00); break;
                case 18: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.80); mergeEffect(effectsMap, "적주피", 17.00); break;
                case 19: mergeEffect(effectsMap, "체크메이트 스킬 피증", 13.60); mergeEffect(effectsMap, "적주피", 17.00); break;
                case 20: mergeEffect(effectsMap, "체크메이트 스킬 피증", 14.40);mergeEffect(effectsMap, "적주피", 17.00); break;
            }
        }
    }
}
