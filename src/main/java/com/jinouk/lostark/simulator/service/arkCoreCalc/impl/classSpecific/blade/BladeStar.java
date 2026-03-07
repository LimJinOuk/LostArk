package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blade;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BladeStar  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블레이드";
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


            if ("일격".equals(name)) {
                calcSingleStrike(effectsMap, point, grade);
            } else if ("쾌도난마".equals(name)) {
                calcGwaedonamma(effectsMap, point, grade);
            } else if ("얼음과 불의 검".equals(name)) {
                calcSwordOfIceAndFire(effectsMap, point, grade);
            } else if ("기본기".equals(name)) {
                calcBasicSkill(effectsMap, point, grade);
            } else if ("잠깐의 기다림".equals(name)) {
                calcBriefWait(effectsMap, point, grade);
            } else if ("죽음의 검기".equals(name)) {
                calcDeathSwordEnergy(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //일격
    //진욱쿤 찬스(블레이드 버스트 피증 or 피증)
    private void calcSingleStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "피증", 3.25); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 3.50); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 3.75); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 1.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
                case 17: mergeEffect(effectsMap, "피증", 3.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 18: mergeEffect(effectsMap, "피증", 3.25); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 19: mergeEffect(effectsMap, "피증", 3.50); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 2.00); break;
                case 20: mergeEffect(effectsMap, "피증", 3.75); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); mergeEffect(effectsMap, "적주피", 2.00);break; // 13.8 + 0.4
            }
        }
    }

    //쾌도난마
    private void calcGwaedonamma(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 2.15); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 2.30); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.45); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 3.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 3.15); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 3.30); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 3.45); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 25.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 50.00); break;
            }
        }
    }

    //얼음과 불의 검
    private void calcSwordOfIceAndFire(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 110.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.60); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 110.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 9.20); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 110.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 9.80); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 110.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 120.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.60); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 120.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 9.20); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 120.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 9.80); mergeEffect(effectsMap, "블리츠 러시 스킬 올라운드 트라이포드 피증", 120.00); break;
            }
        }
    }

    //기본기
    private void calcBasicSkill(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.15); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.30); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.45); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.00); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.15); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.30); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.45); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 15.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 30.00); break;
            }
        }
    }

    //잠깐의 기다림
    private void calcBriefWait(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "피증", 0.20); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "피증", 0.40); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "피증", 0.60); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 12.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); break;
                case 17: mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 18.00); break;
                case 18: mergeEffect(effectsMap, "피증", 0.20); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 18.00); break;
                case 19: mergeEffect(effectsMap, "피증", 0.40); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 18.00); break;
                case 20: mergeEffect(effectsMap, "피증", 0.60); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 8.00); mergeEffect(effectsMap, "보이드 스트라이크 스킬 오버 슬래쉬 트라이포드 피증", 10.00); mergeEffect(effectsMap, "소울 앱소버 스킬 반 가르기 트라이포드 피증", 18.00); break;
            }
        }
    }

    //죽음의 검기
    private void calcDeathSwordEnergy(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.00); break;
                case 17: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 20.00); break;
                case 18: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 20.00); break;
                case 19: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 23.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 20.00); break;
                case 20: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 23.80); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 20.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.00); break;
                case 17: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 24.00); break;
                case 18: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 22.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 24.00); break;
                case 19: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 23.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 24.00); break;
                case 20: mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 23.80); mergeEffect(effectsMap, "페이탈 웨이브 스킬 데스 웨이브 트라이포드 피증", 24.00); break;
            }
        }
    }
}
