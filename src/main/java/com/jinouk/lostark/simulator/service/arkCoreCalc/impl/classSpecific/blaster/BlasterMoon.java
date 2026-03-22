package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blaster;

import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.simulateRun.child.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlasterMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블래스터";
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

            if ("래피드 탱크".equals(name)) {
                calcRapidTank(effectsMap, point, grade);
            } else if ("과열된 포탄".equals(name)) {
                calcOverheatedShell(effectsMap, point, grade);
            } else if ("세이프 존".equals(name)) {
                calcSafeZone(effectsMap, point, grade);
            } else if ("질풍 포병".equals(name)) {
                calcGaleArtillery(effectsMap, point, grade);
            } else if ("무한 연소".equals(name)) {
                calcInfiniteCombustion(effectsMap, point, grade);
            } else if ("도약의 순간".equals(name)) {
                calcMomentOfLeap(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //래피드 탱크
    //진욱쿤 찬스(포격 스킬 피증? 피증?)
    private void calcRapidTank(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 5.10); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 5.33); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 5.56); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 5.79); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 6.60); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 6.83); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 7.06); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 7.29); break;
            }
        }
    }

    //과열된 포탄
    //진욱쿤 찬스(포격 스킬 피증)
    private void calcOverheatedShell(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 15.45); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 15.90); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 16.35); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 18.45); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 18.90); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 19.35); break;
            }
        }
    }

    //세이프 존
    //진욱쿤 찬스(포격 스킬 피증? 피증?)
    private void calcSafeZone(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 15.43); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 15.86); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 16.29); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 18.43); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 18.86); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 19.29); break;
            }
        }
    }

    //질풍 포병
    private void calcGaleArtillery(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 2.50); break;
                case 18: mergeEffect(effectsMap, "피증", 2.66); break;
                case 19: mergeEffect(effectsMap, "피증", 2.82); break;
                case 20: mergeEffect(effectsMap, "피증", 2.98); break;
            }
        }
    }

    //무한 연소
    private void calcInfiniteCombustion(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "적주피", 1.00); break;
            }
        }
    }

    //도약의 순간
    private void calcMomentOfLeap(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "적주피", 1.00); break;
            }
        }
    }
}
