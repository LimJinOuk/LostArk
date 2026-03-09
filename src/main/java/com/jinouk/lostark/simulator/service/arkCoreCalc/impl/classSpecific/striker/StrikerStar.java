package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.striker;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StrikerStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "스트라이커";
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


            if ("뇌호극권".equals(name)) {
                calcThunderTigerUltimateFist(effectsMap, point, grade);
            } else if ("쌍극광폭진".equals(name)) {
                calcDualUltimateBerserkArray(effectsMap, point, grade);
            } else if ("섬호뇌격".equals(name)) {
                calcFlashTigerThunderStrike(effectsMap, point, grade);
            } else if ("신왕화신".equals(name)) {
                calcGodKingIncarnation(effectsMap, point, grade);
            } else if ("초극뇌연격".equals(name)) {
                calcHyperUltimateThunderCombo(effectsMap, point, grade);
            } else if ("파극권".equals(name)) {
                calcBreakingUltimateFist(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //뇌호극권
    private void calcThunderTigerUltimateFist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 면역, 차지 속도 제외 (상속 없음)
                case 14:  mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00);mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 7.00); break; // 시속 제외
                case 17: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); break; // 28+3 / 7+3 / 신규 3
                case 18: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 10.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 면역, 차지 속도 제외 (상속 없음)
                case 14:  mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00);mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 7.00); break; // 시속 제외
                case 17: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 5.00); break; // 28+3 / 7+3 / 신규 3
                case 18: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.17); break;
                case 19: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.34); break;
                case 20: mergeEffect(effectsMap, "오의 : 호왕출현 스킬 강인함 트라이포드 피증", 28.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 5.00); mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 12.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.51); break;
            }
        }
    }

    //쌍극광폭진
    private void calcDualUltimateBerserkArray(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); break;
                case 14: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 80.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 80.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.45); break;
                case 19: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 80.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.90); break;
                case 20: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 80.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.35); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); break;
                case 14: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 92.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 92.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.45); break;
                case 19: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 92.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 0.90); break;
                case 20: mergeEffect(effectsMap, "광폭진 스킬 피증", 25.00); mergeEffect(effectsMap, "광폭진 스킬 강직함 트라이포드 피증", 92.00); mergeEffect(effectsMap, "오의 : 폭쇄진 스킬 집중 폭발 트라이포드 피증", 10.00); mergeEffect(effectsMap, "오의 스킬 치피증", 1.35); break;
            }
        }
    }

    //섬호뇌격
    private void calcFlashTigerThunderStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break; // 거리 증가, 관통 제외 (상속 없음)
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break; // 시속 제외
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break; // 백어택 피증 -> 스킬 피증
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.28); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.56); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 7.84); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break; // 거리 증가, 관통 제외 (상속 없음)
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break; // 시속 제외
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.50); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break; // 백어택 피증 -> 스킬 피증
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 9.98); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 10.26); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 10.54); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 치피증", 8.00); break;
            }
        }
    }

    //신왕화신
    private void calcGodKingIncarnation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 16.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); break; // 6 + 10
                case 18: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 16.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.22); break;
                case 19: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 16.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.44); break;
                case 20: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 16.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.66); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 6.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 19.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); break; // 6 + 10
                case 18: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 19.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.22); break;
                case 19: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 19.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.44); break;
                case 20: mergeEffect(effectsMap, "오의 : 풍신초래 스킬 피증", 19.00); mergeEffect(effectsMap, "오의 : 호왕출현 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 스킬 피증", 0.66); break;
            }
        }
    }

    //초극뇌연격
    private void calcHyperUltimateThunderCombo(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); break; // 3 + 5
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 7.00); mergeEffect(effectsMap, "치피증", 0.52); break;
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 7.00); mergeEffect(effectsMap, "치피증", 1.04); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 7.00); mergeEffect(effectsMap, "치피증", 1.56); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); break; // 3 + 5
                case 17: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 9.00); break;
                case 18: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 9.00); mergeEffect(effectsMap, "치피증", 0.52); break;
                case 19: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 9.00); mergeEffect(effectsMap, "치피증", 1.04); break;
                case 20: mergeEffect(effectsMap, "오의 : 뇌호격 스킬 피증", 8.00); mergeEffect(effectsMap, "오의 : 뇌호격 스킬 연속 차기 트라이포드 피증", 9.00); mergeEffect(effectsMap, "치피증", 1.56); break;
            }
        }
    }

    //파극권
    private void calcBreakingUltimateFist(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); break;
                case 17: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.25); break;
                case 19: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.50); break;
                case 20: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 35.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.75); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); break;
                case 17: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 45.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.25); break;
                case 19: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 45.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.50); break;
                case 20: mergeEffect(effectsMap, "방천격 스킬 피증", 5.00); mergeEffect(effectsMap, "격호각 스킬 넓은 타격 트라이포드 피증", 85.00); mergeEffect(effectsMap, "섬열란아 스킬 피증", 45.00); mergeEffect(effectsMap, "치명타 시 피해량 증가", 0.75); break;
            }
        }
    }
}
