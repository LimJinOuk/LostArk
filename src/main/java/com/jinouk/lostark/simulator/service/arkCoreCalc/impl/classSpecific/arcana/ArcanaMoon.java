package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.arcana;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArcanaMoon extends AbstractArkGrid {

    @Override
    public String getClassName() {
        return "아르카나";
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


            if ("엣지 콤보".equals(name)) {
                calcEdgeCombo(effectsMap, point, grade);
            } else if ("체인 드로우".equals(name)) {
                calcChainDraw(effectsMap, point, grade);
            } else if("루인 풀셋".equals(name)) {
                calcRuin(effectsMap,point,grade);
            } else if("황제의 심장".equals(name)) {
                calcHeart(effectsMap,point,grade);
            } else if("스택 홀드".equals(name)) {
                calcStackHold(effectsMap,point,grade);
            } else if("다크 메이트".equals(name)) {
                calcDarkMate(effectsMap,point,grade);
            }
        });

        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    // 엣지 콤보
    private void calcEdgeCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 14: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 17: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap,"루인 스킬 피증",5.00); break;
                case 18: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.20); mergeEffect(effectsMap,"루인 스킬 피증",5.00); break;
                case 19: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.40); mergeEffect(effectsMap,"루인 스킬 피증",5.00); break;
                case 20: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.60); mergeEffect(effectsMap,"루인 스킬 피증",5.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 14: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); break;
                case 17: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.00); mergeEffect(effectsMap,"루인 스킬 피증",6.00); break;
                case 18: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.20); mergeEffect(effectsMap,"루인 스킬 피증",6.00); break;
                case 19: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.40); mergeEffect(effectsMap,"루인 스킬 피증",6.00); break;
                case 20: mergeEffect(effectsMap, "치명타 시 피해량 증가", 2.60); mergeEffect(effectsMap,"루인 스킬 피증",6.00); break;
            }
        }
    }

    //체인 드로우
    private void calcChainDraw(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap,"루인 스킬 피증",1.60); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 1.75); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 1.9); break;
                case 20: mergeEffect(effectsMap,"루인 스킬 피증",2.05); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 1.60); break;
                case 17: mergeEffect(effectsMap,"루인 스킬 피증",1.60); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 1.75); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 1.9); break;
                case 20: mergeEffect(effectsMap,"루인 스킬 피증",2.05); break;
            }
        }
    }

    //루인 풀셋
    private void calcRuin(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 17: mergeEffect(effectsMap,"루인 스킬 피증",3.50); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 3.10); mergeEffect(effectsMap,"피증",3.50); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 3.40); mergeEffect(effectsMap,"피증",3.50); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 3.70); mergeEffect(effectsMap,"피증",3.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 14: mergeEffect(effectsMap, "루인 스킬 피증", 2.80); break;
                case 17: mergeEffect(effectsMap,"루인 스킬 피증",3.50); break;
                case 18: mergeEffect(effectsMap, "루인 스킬 피증", 3.10); mergeEffect(effectsMap,"피증",4.50); break;
                case 19: mergeEffect(effectsMap, "루인 스킬 피증", 3.40); mergeEffect(effectsMap,"피증",4.50); break;
                case 20: mergeEffect(effectsMap, "루인 스킬 피증", 3.70); mergeEffect(effectsMap,"피증",4.50); break;
            }
        }
    }


    //황제의 심장
    private void calcHeart(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap,"황제 카드 피증",15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap,"황제 카드 피증",15.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap,"황제 카드 피증",15.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap,"황제 카드 피증",15.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap,"황제 카드 피증",20.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap,"황제 카드 피증",20.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap,"황제 카드 피증",20.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap,"황제 카드 피증",20.00); break;
            }
        }
    }

    //스택 홀드
    private void calcStackHold(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "피증", 1.70); break;
                case 17: mergeEffect(effectsMap,"피증",5.50); break;
                case 18: mergeEffect(effectsMap,"피증",5.66); break;
                case 19: mergeEffect(effectsMap,"피증",5.82); break;
                case 20: mergeEffect(effectsMap,"피증",5.98); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "피증", 1.70); break;
                case 14: mergeEffect(effectsMap, "피증", 1.70); break;
                case 17: mergeEffect(effectsMap,"피증",6.70); break;
                case 18: mergeEffect(effectsMap,"피증",6.86); break;
                case 19: mergeEffect(effectsMap,"피증",7.02); break;
                case 20: mergeEffect(effectsMap,"피증",7.18); break;
            }
        }
    }

    //다크 메이트
    private void calcDarkMate(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00);  mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",20.00); break;
                case 18: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.80); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",20.00); break;
                case 19: mergeEffect(effectsMap, "체크메이트 스킬 피증", 13.60); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",20.00); break;
                case 20: mergeEffect(effectsMap, "체크메이트 스킬 피증", 14.40); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",20.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); break;
                case 14: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.00);  mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",25.00); break;
                case 18: mergeEffect(effectsMap, "체크메이트 스킬 피증", 12.80); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",25.00); break;
                case 19: mergeEffect(effectsMap, "체크메이트 스킬 피증", 13.60); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",25.00); break;
                case 20: mergeEffect(effectsMap, "체크메이트 스킬 피증", 14.40); mergeEffect(effectsMap,"다크 리저렉션 스킬 피증",25.00); break;
            }
        }
    }
}
