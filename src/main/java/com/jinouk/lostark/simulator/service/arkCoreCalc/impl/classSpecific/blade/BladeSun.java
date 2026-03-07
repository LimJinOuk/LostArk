package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.blade;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BladeSun  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "블레이드";
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


            if ("블레이드 버스트".equals(name)) {
                calcBladeBurst(effectsMap, point, grade);
            } else if ("소드 리셋".equals(name)) {
                calcSwordReset(effectsMap, point, grade);
            } else if ("블레이드 러시".equals(name)) {
                calcBladeRush(effectsMap, point, grade);
            } else if ("아츠 마스터".equals(name)) {
                calcArtsMaster(effectsMap, point, grade);
            } else if ("집중의 일격".equals(name)) {
                calcFocusedStrike(effectsMap, point, grade);
            } else if ("일섬".equals(name)) {
                calcIlseom(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //블레이드 버스트
    //진욱쿤 찬스(블레이드 버스트 피증? 피증?)
    private void calcBladeBurst(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "피증", 2.50); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 17: mergeEffect(effectsMap, "피증", 8.50); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 18: mergeEffect(effectsMap, "피증", 8.75); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 19: mergeEffect(effectsMap, "피증", 9.00); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "피증", 9.25); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.50); break;
                case 14: mergeEffect(effectsMap, "피증", 2.50); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 17: mergeEffect(effectsMap, "피증", 9.50); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 18: mergeEffect(effectsMap, "피증", 9.75); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 19: mergeEffect(effectsMap, "피증", 10.00); mergeEffect(effectsMap, "적주피", 5.00); break;
                case 20: mergeEffect(effectsMap, "피증", 10.25); mergeEffect(effectsMap, "적주피", 5.00); break;
            }
        }
    }

    //소드 리셋
    private void calcSwordReset(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 15.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.65); mergeEffect(effectsMap, "피증", 15.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.80); mergeEffect(effectsMap, "피증", 15.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.95); mergeEffect(effectsMap, "피증", 15.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 15.00); break;
                case 17: mergeEffect(effectsMap, "적주피", 2.50); mergeEffect(effectsMap, "피증", 15.00);  mergeEffect(effectsMap, "서프라이즈 어택 스킬 피증", 1.00); mergeEffect(effectsMap, "스핀 커터 스킬 피증", 1.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 1.00); mergeEffect(effectsMap, "데스 슬래쉬 스킬 피증", 1.00);break;
                case 18: mergeEffect(effectsMap, "적주피", 2.65); mergeEffect(effectsMap, "피증", 15.00);  mergeEffect(effectsMap, "서프라이즈 어택 스킬 피증", 1.00); mergeEffect(effectsMap, "스핀 커터 스킬 피증", 1.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 1.00); mergeEffect(effectsMap, "데스 슬래쉬 스킬 피증", 1.00);break;
                case 19: mergeEffect(effectsMap, "적주피", 2.80); mergeEffect(effectsMap, "피증", 15.00);  mergeEffect(effectsMap, "서프라이즈 어택 스킬 피증", 1.00); mergeEffect(effectsMap, "스핀 커터 스킬 피증", 1.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 1.00); mergeEffect(effectsMap, "데스 슬래쉬 스킬 피증", 1.00);break;
                case 20: mergeEffect(effectsMap, "적주피", 2.95); mergeEffect(effectsMap, "피증", 15.00);  mergeEffect(effectsMap, "서프라이즈 어택 스킬 피증", 1.00); mergeEffect(effectsMap, "스핀 커터 스킬 피증", 1.00); mergeEffect(effectsMap, "윈드 컷 스킬 피증", 1.00); mergeEffect(effectsMap, "블레이드 댄스 스킬 피증", 1.00); mergeEffect(effectsMap, "데스 슬래쉬 스킬 피증", 1.00);break;
            }
        }
    }

    //블레이드 러시
    private void calcBladeRush(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 35.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 35.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 36.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 36.80); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 45.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 45.60); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 46.20); break;
                case 20: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "블리츠 러시 스킬 피증", 46.80); break;
            }
        }
    }

    //아츠 마스터
    private void calcArtsMaster(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point) {
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 12.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 12.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 12.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.65); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 12.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 12.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 12.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.80); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 12.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 12.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 12.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.95); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 12.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 12.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 12.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 6.50); break;
                case 17: mergeEffect(effectsMap, "적주피", 6.50); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 16.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 16.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 6.65); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 16.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 16.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 6.80); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 16.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 16.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 6.95); mergeEffect(effectsMap, "트윈 쉐도우 스킬 피증", 16.00); mergeEffect(effectsMap, "터닝 슬래쉬 스킬 피증", 16.00); mergeEffect(effectsMap, "데스 센텐스 스킬 피증", 16.00); break;
            }
        }
    }

    //집중의 일격
    //진욱쿤 찬스(차지 타입 스킬)
    private void calcFocusedStrike(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "차지 타입 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "차지 타입 스킬 피증", 23.50); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "차지 타입 스킬 피증", 23.50); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "차지 타입 스킬 피증", 23.50); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "차지 타입 스킬 피증", 23.50); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "차지 타입 스킬 피증", 16.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "차지 타입 스킬 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "차지 타입 스킬 피증", 25.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "차지 타입 스킬 피증", 25.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "차지 타입 스킬 피증", 25.00); break;
            }
        }
    }

    //일섬
    private void calcIlseom(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 2.00); break;
                case 14: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); break;
                case 17: mergeEffect(effectsMap, "피증", 2.00); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 18: mergeEffect(effectsMap, "피증", 2.20); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); mergeEffect(effectsMap, "적주피", 1.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.60); mergeEffect(effectsMap, "페이탈 웨이브 스킬 피증", 40.00); mergeEffect(effectsMap, "적주피", 1.00); break;
            }
        }
    }
}
