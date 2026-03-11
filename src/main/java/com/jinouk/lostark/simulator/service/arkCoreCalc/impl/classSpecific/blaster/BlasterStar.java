package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlasterStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블래스터";
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


            if ("시 오브 파이어".equals(name)) {
                calcSeaOfFire(effectsMap, point, grade);
            } else if ("타임 온 타겟".equals(name)) {
                calcTimeOnTarget(effectsMap, point, grade);
            } else if ("초토화".equals(name)) {
                calcScorchedEarth(effectsMap, point, grade);
            } else if ("아이언 샤워".equals(name)) {
                calcIronShower(effectsMap, point, grade);
            } else if ("웰던맨".equals(name)) {
                calcWellDoneMan(effectsMap, point, grade);
            } else if ("오토 락온".equals(name)) {
                calcAutoLockOn(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //시 오브 파이어
    //진욱쿤 찬스(포격 스킬 피증? 피증?)
    private void calcSeaOfFire(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 1.63); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 1.86); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.09); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 1.40); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 1.63); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 1.86); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.09); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", 12.00); break;
            }
        }
    }

    //타임 온 타겟
    private void calcTimeOnTarget(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 8.00); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 23.00); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 23.45); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 23.90); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 24.35); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 8.00); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 26.00); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 26.45); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 26.90); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 27.35); mergeEffect(effectsMap, "A.C.T 스킬 피증", 15.00); break;
            }
        }
    }

    //초토화
    private void calcScorchedEarth(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 16.43); break;
                case 19: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 16.86); break;
                case 20: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 17.29); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 3.00); break;
                case 14: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 19.00); break;
                case 18: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 19.43); break;
                case 19: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 19.86); break;
                case 20: mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 20.29); break;
            }
        }
    }

    //아이언 샤워
    private void calcIronShower(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포화 공격 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "포화 공격 스킬 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "포화 공격 스킬 피증", 27.00); break;
                case 18: mergeEffect(effectsMap, "포화 공격 스킬 피증", 28.00); break;
                case 19: mergeEffect(effectsMap, "포화 공격 스킬 피증", 29.00); break;
                case 20: mergeEffect(effectsMap, "포화 공격 스킬 피증", 30.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포화 공격 스킬 피증", 7.00); break;
                case 14: mergeEffect(effectsMap, "포화 공격 스킬 피증", 17.00); break;
                case 17: mergeEffect(effectsMap, "포화 공격 스킬 피증", 32.00); break;
                case 18: mergeEffect(effectsMap, "포화 공격 스킬 피증", 33.00); break;
                case 19: mergeEffect(effectsMap, "포화 공격 스킬 피증", 34.00); break;
                case 20: mergeEffect(effectsMap, "포화 공격 스킬 피증", 35.00); break;
            }
        }
    }

    //웰던맨
    private void calcWellDoneMan(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 120.00); break;
                case 18: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 1.20); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 120.00); break;
                case 19: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 2.40); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 120.00); break;
                case 20: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 3.60); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 120.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 14: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 120.00); break;
                case 18: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 1.20); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 140.00); break;
                case 19: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 2.40); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 140.00); break;
                case 20: mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 3.60); mergeEffect(effectsMap, "네이팜탄 스킬 연쇄 폭발 트라이포드 피증", 140.00); break;
            }
        }
    }

    //오토 락온
    private void calcAutoLockOn(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 90.00); break;
                case 18: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.70); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 90.00); break;
                case 19: mergeEffect(effectsMap, "고압열탄 스킬 피증", 6.40); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 90.00); break;
                case 20: mergeEffect(effectsMap, "고압열탄 스킬 피증", 7.10); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 90.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); break;
                case 14: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 100.00); break;
                case 18: mergeEffect(effectsMap, "고압열탄 스킬 피증", 5.70); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 100.00); break;
                case 19: mergeEffect(effectsMap, "고압열탄 스킬 피증", 6.40); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 100.00); break;
                case 20: mergeEffect(effectsMap, "고압열탄 스킬 피증", 7.10); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 15.00); mergeEffect(effectsMap, "고압열탄 스킬 신속 포격 트라이포드 피증", 100.00); break;
            }
        }
    }
}
