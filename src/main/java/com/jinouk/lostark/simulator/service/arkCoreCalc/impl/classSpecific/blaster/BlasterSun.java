package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blaster;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlasterSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블래스터";
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

            if ("폭격".equals(name)) {
                calcBombardment(effectsMap, point, grade);
            } else if ("슛 앤 스쿳".equals(name)) {
                calcShootAndScoot(effectsMap, point, grade);
            } else if ("포화 전차".equals(name)) {
                calcSaturationTank(effectsMap, point, grade);
            } else if ("탄약 수집가".equals(name)) {
                calcAmmoCollector(effectsMap, point, grade);
            } else if ("데몬 파이어".equals(name)) {
                calcDemonFire(effectsMap, point, grade);
            } else if ("점핑맨".equals(name)) {
                calcJumpingMan(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //폭격
    //진욱쿤 찬스(포격 스킬 피증? 피증?)
    private void calcBombardment(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 9.10); break; // 2.1 + 운명(7.0)
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 14.10); break; // 2.1 + 운명(12.0)
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 14.33); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 14.56); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 14.79); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 9.10); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 15.60); break; // 2.1 + 운명(13.5)
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 15.83); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 16.06); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 16.29); break;
            }
        }
    }

    //슛 앤 스쿳
    //진욱쿤 찬스(포격 스킬 피증? 피증? && A.C.T?)
    private void calcShootAndScoot(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 40.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.00); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 56.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.00); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 56.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.45); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 56.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.90); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 56.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 141.35); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 40.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.00); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 60.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.00); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 60.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.45); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 60.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 140.90); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "A.C.T 스킬 피증", 60.00); mergeEffect(effectsMap, "포격: 곡사포 스킬 피증", 141.35); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", -90.00); mergeEffect(effectsMap, "포격: 에너지 포 스킬 피증", -90.00);break;
            }
        }
    }

    //포화 전차
    //진욱쿤 찬스(포격 스킬 피증? 피증?)
    private void calcSaturationTank(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 20.00); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 20.43); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 20.86); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 21.29); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); break;
                case 14: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 17: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 23.00); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 18: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 23.43); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 19: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 23.86); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
                case 20: mergeEffect(effectsMap, "포격 스킬 피증", 2.10); mergeEffect(effectsMap, "포격: 집중포화 스킬 피증", 24.29); mergeEffect(effectsMap, "포격: 에너지 포", -30.00); mergeEffect(effectsMap, "방깎", -12.00); break;
            }
        }
    }

    //탄약 수집가
    private void calcAmmoCollector(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "치적", 5.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 10.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "치적", 5.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "치적", 5.00); mergeEffect(effectsMap, "포화 공격 스킬 피증", 15.00); break;
            }
        }
    }

    //데몬 파이어
    private void calcDemonFire(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.66); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 19: mergeEffect(effectsMap, "피증", 1.82); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
                case 20: mergeEffect(effectsMap, "피증", 1.98); mergeEffect(effectsMap, "네이팜탄 스킬 피증", 10.00); mergeEffect(effectsMap, "화염방사기 스킬 피증", 10.00); break;
            }
        }
    }

    //점핑맨
    private void calcJumpingMan(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "고압열탄 스킬 피증", 35.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "피증", 0.16); mergeEffect(effectsMap, "고압열탄 스킬 피증", 35.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 35.00); break;
                case 19: mergeEffect(effectsMap, "피증", 0.32); mergeEffect(effectsMap, "고압열탄 스킬 피증", 35.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 35.00); break;
                case 20: mergeEffect(effectsMap, "피증", 0.48); mergeEffect(effectsMap, "고압열탄 스킬 피증", 35.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 35.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: break;
                case 14: break;
                case 17: mergeEffect(effectsMap, "고압열탄 스킬 피증", 38.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 38.00); break;
                case 18: mergeEffect(effectsMap, "피증", 0.16); mergeEffect(effectsMap, "고압열탄 스킬 피증", 38.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 38.00); break;
                case 19: mergeEffect(effectsMap, "피증", 0.32); mergeEffect(effectsMap, "고압열탄 스킬 피증", 38.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 38.00); break;
                case 20: mergeEffect(effectsMap, "피증", 0.48); mergeEffect(effectsMap, "고압열탄 스킬 피증", 38.00); mergeEffect(effectsMap, "다연장로켓포 스킬 피증", 38.00); break;
            }
        }
    }
}
