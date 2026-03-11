package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.inFighter;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InFighterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "인파이터";
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


            if ("오브 폭발".equals(name)) {
                calcOrbExplosion(effectsMap, point, grade);
            } else if ("지면 분쇄".equals(name)) {
                calcGroundCrush(effectsMap, point, grade);
            } else if ("역발산".equals(name)) {
                calcMountainMover(effectsMap, point, grade);
            } else if ("대지 파괴".equals(name)) {
                calcEarthDestruction(effectsMap, point, grade);
            } else if ("흑룡의 도약".equals(name)) {
                calcBlackDragonLeap(effectsMap, point, grade);
            } else if ("연격".equals(name)) {
                calcComboAttack(effectsMap, point, grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //오브 폭발
    private void calcOrbExplosion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 9.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 10.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 10.00); mergeEffect(effectsMap, "충격 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "풍신권 스킬 피증", 8.00); mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 8.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 10.00); mergeEffect(effectsMap, "충격 스킬 치피증", 1.20); break;
            }
        }
    }

    //지면 분쇄
    private void calcGroundCrush(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); break; // 시전 속도 30% 포함
                case 17: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 8.00); break;
                case 18: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 8.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.60); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); break; // 시전 속도 30% 포함
                case 17: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "연환파신권 강인함 트라이포드 피증", 10.00); mergeEffect(effectsMap, "연환파신권 끝나지 않는 분노 트라이포드 피증", 6.00); mergeEffect(effectsMap, "연환파신권 흔들리는 지대 트라이포드 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.60); break;
            }
        }
    }

    //역발산
    private void calcMountainMover(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); break; // 재감 페널티 포함
                case 14: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 12.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); break; // 재감 페널티 포함
                case 14: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); break;
                case 17: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 16.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 16.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "죽음의 선고 스킬 피증", 18.00); mergeEffect(effectsMap, "풍신권 스킬 피증", 12.00); mergeEffect(effectsMap, "파쇄격 스킬 피증", 16.00); mergeEffect(effectsMap, "충격 스킬 피증", 0.60); break;
            }
        }
    }

    //대지 파괴
    private void calcEarthDestruction(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); break;
                case 17: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 9.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 9.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 9.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.60); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); break;
                case 17: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 13.00); break;
                case 18: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 13.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.20); break;
                case 19: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 13.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.40); break;
                case 20: mergeEffect(effectsMap, "난타연권 스킬 피증", 7.00); mergeEffect(effectsMap, "철포난격 스킬 피증", 11.00); mergeEffect(effectsMap, "대지 가르기 스킬 피증", 13.00); mergeEffect(effectsMap, "기력 스킬 피증", 0.60); break;
            }
        }
    }

    //흑룡의 도약
    private void calcBlackDragonLeap(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); break;
                case 14: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); break;
                case 17: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 32.00); break;
                case 18: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 32.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 32.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 32.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); break;
                case 14: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); break;
                case 17: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 36.00); break;
                case 18: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 36.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.30); break;
                case 19: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 36.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.60); break;
                case 20: mergeEffect(effectsMap, "용의 강림 스킬 탁월한 기동성 트라이포드 피증", 60.00); mergeEffect(effectsMap, "용의 강림 스킬 넓은 타격 트라이포드 피증", 80.00); mergeEffect(effectsMap, "용의 강림 스킬 흑룡의 강림 트라이포드 피증", 36.00); mergeEffect(effectsMap, "기력 스킬 치명타 시 피해량 증가", 0.90); break;
            }
        }
    }

    //연격
    private void calcComboAttack(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); break;
                case 14: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 스킬 트라이포드 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 스킬 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 54.00); break;
                case 18: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 스킬 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 54.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 스킬 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 54.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "폭렬권 위빙 스킬 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 스킬 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 54.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); break;
                case 14: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 트라이포드 피증", 100.00); break;
                case 17: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 63.00); break;
                case 18: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 63.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.40); break;
                case 19: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 63.00); mergeEffect(effectsMap, "기력 스킬 치피증", 0.80); break;
                case 20: mergeEffect(effectsMap, "폭렬권 스킬 위빙 트라이포드 피증", 25.00); mergeEffect(effectsMap, "철포난격 스킬 넓은 타격 트라이포드 피증", 100.00); mergeEffect(effectsMap, "난타연권 스킬 빈틈포착 트라이포드 피증", 63.00); mergeEffect(effectsMap, "기력 스킬 치피증", 1.20); break;
            }
        }
    }
}
