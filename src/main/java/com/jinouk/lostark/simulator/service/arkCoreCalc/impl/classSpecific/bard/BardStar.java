package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.bard;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BardStar extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "바드";
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

            if ("음파 강화".equals(name)) {
                calcSonicReinforcement(effectsMap, point, grade);
            } else if ("사운드 블리츠".equals(name)) {
                calcSoundBlitz(effectsMap, point, grade);
            } else if ("듀얼 쇼크".equals(name)) {
                calcDualShock(effectsMap,point,grade);
            } else if ("풍요의 바람".equals(name)) {
                calcWindOfAbundance(effectsMap,point,grade);
            } else if ("사운드 플러드".equals(name)) {
                calcSoundFlood(effectsMap, point, grade);
            } else if("벅샷 가속".equals(name)) {
                calcBuckshot(effectsMap,point,grade);
            }
        });


        logEffects(getArkGridCoreName(), effectsMap);
        return new ArkGridResponseDto(effectsMap);
    }

    //음파 강화
    //진욱쿤 질문(17포가 피증 or 음파 진동 스킬 피증)
    private void calcSonicReinforcement(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "음파 진동 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.00); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.60); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "음파 진동 스킬 피증", 16.20); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "음파 진동 스킬 피증", 16.80); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 15.00); break;
            }
        } else if ("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "음파 진동 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.00); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "음파 진동 스킬 피증", 15.60); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "음파 진동 스킬 피증", 16.20); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "음파 진동 스킬 피증", 16.80); mergeEffect(effectsMap, "율동의 하프 스킬 날렵한 연사 피증", 20.00); break;
            }
        }
    }

    //사운드 블리츠
    private void calcSoundBlitz(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 11.20); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 12.40); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 35.00); break;
                case 20: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 13.60); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 35.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 10.00); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 11.20); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 12.40); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "사운드 홀릭 스킬 피증", 13.60); mergeEffect(effectsMap, "사운드 홀릭 스킬 집중 포화 피증", 40.00); break;
            }
        }
    }

    //듀얼 쇼크
    private void calcDualShock(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.90); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 11.80); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 12.70); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.00); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 10.90); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 11.80); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "사운드 쇼크 스킬 피증", 12.70); mergeEffect(effectsMap, "사운드 쇼크 스킬 연사 피증", 40.00); break;
            }
        }
    }

    //풍요의 바람
    //진욱쿤 질문(세레나데 게이지 해야 됨?)
    private void calcWindOfAbundance(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        }
    }

    //사운드 플러드
    //진욱쿤 질문(세레나데 게이지 해야 됨?)
    private void calcSoundFlood(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        }
    }

    //벅샷 가속
    //진욱쿤 질문(세레나데 게이지 해야 됨?)
    private void calcBuckshot(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        } else if("고대".equals(grade)) {
            switch (point) {
                case 10: break;
                case 14: break;
                case 17: break;
                case 18: break;
                case 19: break;
                case 20: break;
            }
        }
    }
}
