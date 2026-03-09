package com.jinouk.lostark.simulator.service.arkCoreCalc.impl.classSpecific.slayer;

import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridRequestDto;
import com.jinouk.lostark.simulator.dto.arkgrid.ArkGridResponseDto;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.AbstractArkGrid;
import com.jinouk.lostark.simulator.service.arkCoreCalc.core.IArkGrid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SlayerMoon  extends AbstractArkGrid {
    @Override
    public String getClassName() {
        return "슬레이어";
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


            if ("단죄의 칼날".equals(name)) {
                calcBladeOfCondemnation(effectsMap, point, grade);
            } else if ("힘의 응축".equals(name)) {
                calcPowerCondensation(effectsMap, point, grade);
            } else if ("교차된 힘".equals(name)) {
                calcCrossedForces(effectsMap, point, grade);
            } else if ("코어 임팩트".equals(name)) {
                calcCoreImpact(effectsMap, point, grade);
            } else if ("분노 격화".equals(name)) {
                calcRageExacerbation(effectsMap, point, grade);
            } else if ("소용돌이".equals(name)) {
                calcVortex(effectsMap, point, grade);
            }

        });
        logEffects(getArkGridCoreName(), effectsMap);

        return new ArkGridResponseDto(effectsMap);
    }

    //단죄의 칼날
    //진욱쿤(폭주 중?)
    private void calcBladeOfCondemnation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break; // 길로틴 적중 시 운명 발동
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 25.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 25.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 25.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 25.00); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "피증", 1.50); break;
                case 14: mergeEffect(effectsMap, "피증", 1.50); break; // 길로틴 적중 시 운명 발동
                case 17: mergeEffect(effectsMap, "피증", 1.50); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 30.00); break;
                case 18: mergeEffect(effectsMap, "피증", 1.80); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 30.00); break;
                case 19: mergeEffect(effectsMap, "피증", 2.10); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 30.00); break;
                case 20: mergeEffect(effectsMap, "피증", 2.40); mergeEffect(effectsMap, "길로틴 스킬 분노의 일격 트라이포드 피증", 30.00); break;
            }
        }
    }

    //힘의 응축
    //진욱쿤(폭주 상태가 필요한 것인가)
    private void calcPowerCondensation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); break;
                case 14: mergeEffect(effectsMap, "차지 스킬 적주피", 17.00); break; // 폭주 시 운명 발동
                case 17: mergeEffect(effectsMap, "차지 스킬 적주피", 17.00); break;
                case 18: mergeEffect(effectsMap, "차지 스킬 적주피", 17.30); break;
                case 19: mergeEffect(effectsMap, "차지 스킬 적주피", 17.60); break;
                case 20: mergeEffect(effectsMap, "차지 스킬 적주피", 17.90); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "차지 스킬 적주피", 3.00); break;
                case 14: mergeEffect(effectsMap, "차지 스킬 적주피", 19.00); break; // 폭주 시 운명 발동
                case 17: mergeEffect(effectsMap, "차지 스킬 적주피", 17.00); break;
                case 18: mergeEffect(effectsMap, "차지 스킬 적주피", 17.30); break;
                case 19: mergeEffect(effectsMap, "차지 스킬 적주피", 17.60); break;
                case 20: mergeEffect(effectsMap, "차지 스킬 적주피", 17.90); break;
            }
        }
    }

    //교차된 힘
    private void calcCrossedForces(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 6.00); break; // 폭주 시 운명 발동
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.00); break; // 기존 6.0 + 신규 12.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.30); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.60); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 18.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 6.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 6.00); break; // 폭주 시 운명 발동
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 20.00); break; // 기존 6.0 + 신규 12.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 20.30); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 20.60); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 20.90); break;
            }
        }
    }

    //코어 임팩트
    private void calcCoreImpact(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break; // 적중 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.00); break; // 기존 8.0 + 신규 15.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.30); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.60); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 23.90); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break;
                case 14: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 8.00); break; // 적중 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 28.00); break; // 기존 8.0 + 신규 15.0
                case 18: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 28.30); break;
                case 19: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 28.60); break;
                case 20: mergeEffect(effectsMap, "브루탈 임팩트 스킬 피증", 28.90); break;
            }
        }
    }

    //분노 격화
    //진욱쿤(폭주 상태)
    private void calcRageExacerbation(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 사용 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 6.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", 6.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", 6.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", 6.00); break;
            }
        }
        else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "적주피", 1.50); break;
                case 14: mergeEffect(effectsMap, "적주피", 1.50); break; // 사용 횟수 조건 제외
                case 17: mergeEffect(effectsMap, "적주피", 1.50); mergeEffect(effectsMap, "피증", 7.00); break;
                case 18: mergeEffect(effectsMap, "적주피", 1.70); mergeEffect(effectsMap, "피증", 7.00); break;
                case 19: mergeEffect(effectsMap, "적주피", 1.90); mergeEffect(effectsMap, "피증", 7.00); break;
                case 20: mergeEffect(effectsMap, "적주피", 2.10); mergeEffect(effectsMap, "피증", 7.00); break;
            }
        }
    }

    //소용돌이
    private void calcVortex(Map<String, Double> effectsMap, int point, String grade) {
        if("유물".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break; // 허리케인 소드 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break; // 쿨감 제외 / 피증 0%이므로 변화 없음
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.40); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.80); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 21.20); break;
            }
        } else if("고대".equals(grade)) {
            switch (point){
                case 10: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break;
                case 14: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 20.00); break; // 허리케인 소드 사용 시 운명 발동
                case 17: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 22.00); break; // 쿨감 제외 / 피증 0%이므로 변화 없음
                case 18: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 22.40); break;
                case 19: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 22.80); break;
                case 20: mergeEffect(effectsMap, "허리케인 소드 스킬 피증", 23.20); break;
            }
        }
    }
}
