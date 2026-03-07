package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.artist;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistSun extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "도화가";
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

            if ("파죽지세".equals(name)) {
                calcOnARoll(effectsMap, point, grade);
            } else if ("일필휘지".equals(name)) {
                calcDashing(effectsMap, point, grade);
            } else if("묵법화".equals(name)) {
                calcMuck(effectsMap,point,grade);
            }
        });
        logEffects(getArkGridCoreName(), effectsMap);
        return new ArkGridResponseDto(effectsMap);
    }

    //파죽지세
    private void calcOnARoll(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 25.50); break;
                case 18: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 25.90); break;
                case 19: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 26.30); break;
                case 20: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 26.70); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 6.00); break;
                case 17: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 28.50); break;
                case 18: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 28.90); break;
                case 19: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 29.30); break;
                case 20: mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", 29.70); break;
            }
        }
    }

    //일필휘지
    //진욱쿤 찬스(14포 17포)
    private void calcDashing(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", -57.00); break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", -57.00);  mergeEffect(effectsMap, "치피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.65); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", -57.00); mergeEffect(effectsMap, "치피증", 10.00);break;
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 11.30); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", -57.00); mergeEffect(effectsMap, "치피증", 10.00);break;
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 11.95); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피증", -57.00); mergeEffect(effectsMap, "치피증", 10.00);break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피감", 57.00); break;
                case 17: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.00); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피감", 57.00); mergeEffect(effectsMap, "치피증", 15.00);break;
                case 18: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 10.65); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피감", 57.00); mergeEffect(effectsMap, "치피증", 15.00);break;
                case 19: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 11.30); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피감", 57.00); mergeEffect(effectsMap, "치피증", 15.00);break;
                case 20: mergeEffect(effectsMap, "필법 : 한획긋기 스킬 피증", 11.95); mergeEffect(effectsMap, "묵법 : 파죽 스킬 피감", 57.00); mergeEffect(effectsMap, "치피증", 15.00);break;
            }
        }
    }

    //묵법화
    //진욱쿤 찬스(14포 방어력 감소)
    private void calcMuck(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "묵법 스킬 피증", 5.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 17: mergeEffect(effectsMap, "묵법 스킬 피증", 25.00);  mergeEffect(effectsMap, "방깎", -12.00); break;
                case 18: mergeEffect(effectsMap, "묵법 스킬 피증", 25.15);  mergeEffect(effectsMap, "방깎", -12.00);break;
                case 19: mergeEffect(effectsMap, "묵법 스킬 피증", 25.30);  mergeEffect(effectsMap, "방깎", -12.00); break;
                case 20: mergeEffect(effectsMap, "묵법 스킬 피증", 25.45);  mergeEffect(effectsMap, "방깎", -12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "묵법 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "묵법 스킬 피증", 5.00);  mergeEffect(effectsMap, "방깎", -12.00);break;
                case 17: mergeEffect(effectsMap, "묵법 스킬 피증", 35.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 18: mergeEffect(effectsMap, "묵법 스킬 피증", 35.15); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 19: mergeEffect(effectsMap, "묵법 스킬 피증", 35.30); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 20: mergeEffect(effectsMap, "묵법 스킬 피증", 35.45);  mergeEffect(effectsMap, "방깎", -12.00);break;
            }
        }
    }
}
